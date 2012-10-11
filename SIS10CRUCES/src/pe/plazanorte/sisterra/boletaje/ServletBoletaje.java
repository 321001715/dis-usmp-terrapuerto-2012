package pe.plazanorte.sisterra.boletaje;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.plazanorte.sisterra.entidades.Asiento;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.seguridad.ServiceSeguridad;
import pe.plazanorte.sisterra.util.Constantes;
import sun.print.resources.serviceui;

/**
 * Servlet implementation class ServletBoletaje
 */
@WebServlet("/ServletBoletaje")
public class ServletBoletaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBoletaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceBoletaje service = new ServiceBoletaje();
		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurrio un error";
		RequestDispatcher rd = null;
		
		//********************************INICIO SELECCIONAR ASIENTO**********************************//	
		if(tipo.equals(Constantes.ACCION_SELECCIONAR_ASIENTO)){
			int id= Integer.parseInt(request.getParameter("idViaje"));
			Viaje unviaje=new Viaje();
			Ruta unaruta= new Ruta();
			Vehiculo carro=new Vehiculo();
			Vector<Asiento> asientos=new Vector<Asiento>();
			System.out.print("hasta aqui");
			try {
				
				unviaje=service.consultarViajeCliente(id);
				
				unaruta=service.consultarRuta(unviaje.getIdRuta());
				carro=service.consultarVehiculo(unviaje.getIdVehiculo());
				asientos=service.consultarAsientos(unviaje.getIdVehiculo());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print(unviaje.getCodViaje());

			request.setAttribute("unviaje", unviaje);
			request.setAttribute("unaruta", unaruta);
			request.setAttribute("carro", carro);
			request.setAttribute("asientos", asientos);
			rd = getServletContext().getRequestDispatcher("/seleccionar_asiento.jsp");

		}else if (tipo.equals(Constantes.ACCION_LISTAR_RESERVA)) {
			System.out.println("entro");
			HttpSession session = request.getSession(true);
			Usuario usuario = (Usuario) session.getAttribute("BUsuario");
			Vector<Reserva> reservas= new Vector<Reserva>();
			
			reservas= service.listarReservas(usuario.getId());
			
		System.out.println("tamaño: "+reservas.size());
			request.setAttribute("reservas", reservas);
			rd = getServletContext().getRequestDispatcher(
			"/listar_reservas.jsp");
			
		}else if (tipo.equals(Constantes.ACCION_PREPARAR_LISTAR_BOLETO)) {
			HttpSession session = request.getSession(true);
			Usuario usuario = (Usuario) session.getAttribute("BUsuario");
			
			String destino = request.getParameter("destino");
			if (destino.equals(Constantes.CONFIRMAR_RESERVA)) {
				Vector<Boleto> boletos = new Vector<Boleto>();
				boletos = service.listarBoletos(usuario.getId());
				Vector<Pasajero> pasajeros = new Vector<Pasajero>();
				Pasajero pasajero = new Pasajero();
				Vector<Viaje> viajes=new Vector<Viaje>();
				
				Viaje viaje= new Viaje();
				
				for (int i = 0; i < boletos.size(); i++) {
					pasajero = service.buscarPasajero(boletos.get(i)
							.getIdPasajero());
					viaje = service.buscarViaje(boletos.get(i).getIdViaje());
					
					viajes.add(viaje);
					pasajeros.add(pasajero);
				}

				request.setAttribute("boletos", boletos);
				request.setAttribute("pasajeros", pasajeros);
				request.setAttribute("viajes", viajes);
				rd = getServletContext().getRequestDispatcher(
						"/confirmar_reserva.jsp");
			}
		}
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceBoletaje service = new ServiceBoletaje();
		String tipo = request.getParameter("tipo");
		//long codViaje = Long.parseLong(request.getParameter("codViaje"));
		// int nroAsiento = Integer.parseInt(request.getParameter("nroAsiento"));
		String mensaje = "Ocurrio un error";
	
		RequestDispatcher rd = null;
		
		
		
		
		//********************************INICIO RESERVAR BOLETO DE VIAJE**********************************//		
		
		if(tipo.equals(Constantes.ACCION_RESERVAR_BOLETO)){
			Reserva reserva=new Reserva();
			Boleto boleto = new Boleto();
			
			try {
				String codViaje = request.getParameter("codViaje");
				String origen = request.getParameter("origen");
				String destino = request.getParameter("destino");
				String fecsal = request.getParameter("fecSalida");
				String feclle = request.getParameter("fecLlegada");
				double costo = Double.parseDouble(request.getParameter("costo"));
				int duracion = Integer.parseInt(request.getParameter("duracion"));
				int asiento=Integer.parseInt(request.getParameter("asientos"));
				int idViaje=Integer.parseInt(request.getParameter("viaje"));
				System.out.print("VIAJE NUMERO"+idViaje);
				//boleto.setIdViaje(codViaje);
				//boleto.setAsiento(nroAsiento);
				int idUsuario=12;
				
				//Usuario usuario=new Usuario();
				//HttpSession session = request.getSession();
				//usuario=(Usuario)session.getAttribute("BUsuario");
				//System.out.print(usuario.getNombres());
				
				
				//system.out.print(usuario.getNombres());
				reserva=service.generarReserva(idUsuario);
				boolean retorno = service.reservarBoleto(reserva.getId(),idViaje,1,asiento);
				
				boolean estasiento=service.cambiarEstado(idViaje,asiento);
				
				if(retorno&estasiento) {
					mensaje = "Boleto reservado exitosamente.";
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");			
		
		}
		
		//********************************FIN RESERVAR BOLETO DE VIAJE**********************************//

		//********************************INICIO VENDER BOLETO DE VIAJE**********************************//
		
		if(tipo.equals(Constantes.ACCION_VENDER_BOLETO)){
			
			
		}
		
		//********************************FIN VENDER BOLETO DE VIAJE**********************************//
		if(tipo.equals(Constantes.ACCION_CONSULTAR_VIAJE)){
			//session de usuario y cliente
			
			
			//System.out.println("BCliente: "+cliente.getApePat());
			//fin session de usuario y cliente
			
			
				String empresa = request.getParameter("empresa");
				String fecSalida_string = request.getParameter("fecSalida");
				String origen = request.getParameter("origen");
				String destino = request.getParameter("destino");
				//int id=Integer.parseInt(request.getParameter("usuario"));
				//System.out.print(id);
			
				//Date fecSalida;
				
				
				//DateFormat formatoFecha_salida = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				//String fecSalida_string_x = formatoFecha_salida.format(fecSalida_string);
				//try {
				//	fecSalida = formatoFecha_salida.parse(fecSalida_string_x);
				//} catch (Exception e) {
			//		throw new RuntimeException("No se pudo actualizar.");
				//}
				
				Vector<Viaje> viajes=null;
				
				
				try {
					viajes = service.consultarViaje(empresa, origen, destino);
					HttpSession session= request.getSession(true);
					Usuario usuario=(Usuario)session.getAttribute("BUsuario");
					//Cliente cliente=(Cliente)session.getAttribute("BCliente");
					System.out.println("BUsuario: "+usuario.getNombres());
					System.out.print("Recibe Viajes");
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				request.setAttribute("viajes", viajes);	
				rd = getServletContext().getRequestDispatcher("/consultar_viaje.jsp");
		}
		//********************************FIN CONSULTAR VIAJE**********************************//
		
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}
	

}
