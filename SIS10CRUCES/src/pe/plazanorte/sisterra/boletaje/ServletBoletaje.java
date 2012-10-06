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
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Usuario;
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
		
		//********************************INICIO CONSULTAR VIAJE**********************************//	
		if(tipo.equals(Constantes.ACCION_SELECCIONAR_ASIENTO)){
			int id= Integer.parseInt(request.getParameter("idViaje"));
			Viaje unviaje=new Viaje();
			Ruta unaruta= new Ruta();
			Vector<Asiento> asientos=new Vector<Asiento>();
			System.out.print("hasta aqui");
			try {
				
				unviaje=service.consultarViajeCliente(id);
				
				unaruta=service.consultarRuta(unviaje.getIdRuta());
				
				asientos=service.consultarAsientos(unviaje.getIdVehiculo());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print(unviaje.getCodViaje());

			request.setAttribute("unviaje", unviaje);
			request.setAttribute("unaruta", unaruta);
			request.setAttribute("asientos", asientos);
			rd = getServletContext().getRequestDispatcher("/seleccionar_asiento.jsp");

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
			
			try {
				Boleto boleto = new Boleto();
				//boleto.setIdViaje(codViaje);
				//boleto.setAsiento(nroAsiento);
				boolean retorno = service.reservarBoleto(boleto);
				
				if(retorno) {
					mensaje = "Boleto reservado exitosamente.";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		//********************************FIN RESERVAR BOLETO DE VIAJE**********************************//

		//********************************INICIO VENDER BOLETO DE VIAJE**********************************//
		
		if(tipo.equals(Constantes.ACCION_VENDER_BOLETO)){
			
			
		}
		
		//********************************FIN VENDER BOLETO DE VIAJE**********************************//
		if(tipo.equals(Constantes.ACCION_CONSULTAR_VIAJE)){
			
			
				String empresa = request.getParameter("empresa");
				String fecSalida_string = request.getParameter("fecSalida");
				String origen = request.getParameter("origen");
				String destino = request.getParameter("destino");
				
				
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
