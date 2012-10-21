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

import pe.plazanorte.sisterra.consultas.ServiceConsultas;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDAO;
import pe.plazanorte.sisterra.entidades.Asiento;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Persona;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.proveedor.ServiceProveedor;
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
			String destino = request.getParameter("destino");
			if(destino.equals(Constantes.CONFIRMAR_RESERVA) ){
				
			HttpSession session = request.getSession(true);
			Usuario usuario = (Usuario) session.getAttribute("BUsuario");
			Vector<Reserva> reservas= new Vector<Reserva>();
			
			reservas= service.listarReservas(usuario.getId());
			
			System.out.println("tamaño: "+reservas.size());
			request.setAttribute("reservas", reservas);
			rd = getServletContext().getRequestDispatcher(
			"/confirmar_reserva.jsp");
			
			}
			
		}else if (tipo.equals(Constantes.ACCION_CONFIRMAR_RESERVA)) {
			String [] idReservas = request.getParameterValues("idReserva");
			
			for (int i = 0; i < idReservas.length; i++) {
				
				service.confirmarReserva(Integer.parseInt(idReservas[i]));	
			}
			
			HttpSession session = request.getSession(true);
			Usuario usuario = (Usuario) session.getAttribute("BUsuario");
			Vector<Reserva> reservas= new Vector<Reserva>();
			
			reservas= service.listarReservas(usuario.getId());
			
			request.setAttribute("reservas", reservas);
			rd = getServletContext().getRequestDispatcher(
			"/confirmar_reserva.jsp");
		}else if (tipo.equals(Constantes.ACCION_ANULAR_RESERVA)) {
			String [] idReservas = request.getParameterValues("idReserva");
			for (int i = 0; i < idReservas.length; i++) {
				
				service.anularReserva(Integer.parseInt(idReservas[i]));	
			}
			HttpSession session = request.getSession(true);
			Usuario usuario = (Usuario) session.getAttribute("BUsuario");
			Vector<Reserva> reservas= new Vector<Reserva>();
			
			reservas= service.listarReservas(usuario.getId());
			
			request.setAttribute("reservas", reservas);
			rd = getServletContext().getRequestDispatcher(
			"/confirmar_reserva.jsp");
		}
		else if (tipo.equals(Constantes.ACCION_PREPARAR_LISTAR_BOLETO)) {
			
			
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
		}else if (tipo.equals(Constantes.ACCION_CONSULTAR_VIAJE)) {
			Vector<Ruta> rutas=null;
						
			try {
					
				rutas = service.listarRutas();				
				request.setAttribute("rutas", rutas);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				rd = getServletContext().getRequestDispatcher("/consultar_viaje.jsp");
		
			
		}
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceBoletaje service = new ServiceBoletaje();
		ServiceSeguridad serviceseguridad=new ServiceSeguridad();
		String tipo = request.getParameter("tipo");
		//long codViaje = Long.parseLong(request.getParameter("codViaje"));
		// int nroAsiento = Integer.parseInt(request.getParameter("nroAsiento"));
		String mensaje = "Ocurrio un error";
	
		RequestDispatcher rd = null;
		
		
		
		
		//********************************INICIO RESERVAR BOLETO DE VIAJE**********************************//		
		
		if(tipo.equals(Constantes.ACCION_SELECCIONAR_ASIENTO)){
			Reserva reserva=new Reserva();
			
			Ruta ruta=new Ruta();
			Viaje viaje=new Viaje();	
			String tipoSubmit = request.getParameter("tipoSubmit");
			try {
				int idRuta=Integer.parseInt(request.getParameter("ruta"));
				String codViaje = request.getParameter("codViaje");
				String origen = request.getParameter("origen");
				String destino = request.getParameter("destino");
				String fecsal = request.getParameter("fecSalida");
				String feclle = request.getParameter("fecLlegada");
				double costo = Double.parseDouble(request.getParameter("costo"));
				int duracion = Integer.parseInt(request.getParameter("duracion"));
				int asiento=Integer.parseInt(request.getParameter("asientos"));
				int piso=Integer.parseInt(request.getParameter("piso"));
				int idViaje=Integer.parseInt(request.getParameter("viaje"));
				System.out.print("VIAJE NUMERO"+idViaje);
				//boleto.setIdViaje(codViaje);
				//boleto.setAsiento(nroAsiento);
				
				
				HttpSession session= request.getSession(true);
				Usuario usuario=(Usuario)session.getAttribute("BUsuario");
				Perfil perfil = (Perfil)session.getAttribute("BPerfil");
				//Usuario usuario=new Usuario();
				//HttpSession session = request.getSession();
				//usuario=(Usuario)session.getAttribute("BUsuario");
				//System.out.print(usuario.getNombres());
				
				
				//system.out.print(usuario.getNombres());
				
				ruta=service.consultarRuta(idRuta);
				viaje=service.consultarViajeCliente(idViaje);
				
				//reserva=service.generarReserva(usuario.getId());
				//boolean retorno = service.reservarBoleto(reserva.getId(),idViaje,asiento);
				
				//boolean estasiento=service.cambiarEstado(idViaje,asiento);
				
				//PREVIO A CENTER VIAJE
				
				//Obtener el tipo de SUBMIT del que proviene
				
				System.out.println("ANTES DEL IF DE DECISION DE ORIGEN DE BOTON: " + tipoSubmit);
				if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_COMPRAR_BOLETO)){							
						
						reserva=service.generarReserva(usuario.getId());
						//boolean retorno = service.reservarBoleto(reserva.getId(),idViaje,asiento,1);
						
						ServiceProveedor serviceProveedor = new ServiceProveedor(); 
						Proveedor proveedor = new Proveedor();
						proveedor.setIdProveedor(ruta.getIdProveedor());
						System.out.println("ID DE PROVEEDOR" + ruta.getIdProveedor());
						String nombreProveedor = serviceProveedor.consultarProveedor(proveedor).getRazCom();
						System.out.println("EL NOMBRE DEL PROVEEDOR ES: " + nombreProveedor);
						boolean estasiento=service.cambiarEstado(idViaje,asiento);
						
						System.out.println("ANTES DEL IF DE ESTAASIENTO: " + estasiento);
						System.out.println("IDRUTA: "+ ruta.getId());
						if(estasiento) {
							request.setAttribute("ruta", ruta);
							request.setAttribute("asiento", asiento);
							request.setAttribute("piso", piso);
							request.setAttribute("viaje", viaje);
							request.setAttribute("idReserva", reserva.getId());							
							request.setAttribute("nombreProveedor", nombreProveedor);
							mensaje = "Boleto reservado exitosamente.";
							rd = getServletContext().getRequestDispatcher("/vender_boleto.jsp");
						}else{
							mensaje = "OCURRIO UN ERROR EN LA RESERVA";
							System.out.println("OCURRIO UN ERROR EN LA RESERVA");						
							System.out.println("ESTA ASIENTO: "+estasiento);
							System.out.println("ID RESERVA: "+reserva.getId());
							rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");
						}								
					
				} else if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_RESERVAR)) {
					
						String busqueda=Constantes.ACCION_BUSQUEDA_NO_REALIZADA;
						request.setAttribute("usuario", usuario);
						request.setAttribute("perfil", perfil);
						request.setAttribute("ruta", ruta);
						request.setAttribute("asiento", asiento);
						request.setAttribute("piso", piso);
						request.setAttribute("viaje", viaje);
						request.setAttribute("busqueda", busqueda);
						rd = getServletContext().getRequestDispatcher("/reservarBoleto.jsp");			
					
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		}
		
		//********************************FIN RESERVAR BOLETO DE VIAJE**********************************//

		//********************************INICIO VENDER BOLETO DE VIAJE**********************************//
		
		if(tipo.equals(Constantes.ACCION_VENDER_BOLETO)){
			
			String destino = request.getParameter("destino");
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			
			//Obteniendo los datos del Pasajero
			int documento = Integer.parseInt(request.getParameter("documento"));
			String apePat = request.getParameter("apePat");
			String apeMat = request.getParameter("apeMat");
			String nombre = request.getParameter("nombre");
			String edad = request.getParameter("edad");
			
			//Almacenando los datos del pasajero en la entidad Pasajero
			Pasajero pasajero = new Pasajero();
			pasajero.setNombres(nombre);
			pasajero.setApellidoMat(apeMat);
			pasajero.setApellidoPat(apePat);
			pasajero.setDni(documento);
			//pasajero.setEdad(edad);
			
			String clave = "";
			String pagoEfectivo = "";
			String nroTarjeta = "";
			String tipoPago = request.getParameter("tipoPago");
			
			
			//Obtenemos el tipo de boton del que proviene
			String tipoSubmit = request.getParameter("tipoSubmit");
			
			if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_VENDER_CONSULTAR_PERSONA)) {


				//String idReserva = request.getParameter("idReserva"); 
				int idViaje = Integer.parseInt(request.getParameter("idViaje")); 				
				String nombreProveedor = request.getParameter("nombreProveedor");				
				int asiento = Integer.parseInt(request.getParameter("asiento"));
				int piso = Integer.parseInt(request.getParameter("piso"));
				
				Viaje viaje = service.consultarViajeCliente(idViaje);
				Ruta ruta = service.consultarRuta(viaje.getIdRuta());
				
				String busqueda = "";
				
				ServiceConsultas serviceConsultas = new ServiceConsultas();
				Persona persona = serviceConsultas.consultarPersona(documento);
				
				if(persona != null) {
					busqueda = Constantes.ACCION_BUSQUEDA_REALIZADA;					
				}else{
					busqueda = Constantes.ACCION_BUSQUEDA_REALIZADA;					
					mensaje = "NO SE ENCONTRÓ LA PERSONA";
				}
				request.setAttribute("idReserva", idReserva);
				request.setAttribute("viaje", viaje);
				request.setAttribute("nombreProveedor", nombreProveedor);
				request.setAttribute("asiento", asiento);
				request.setAttribute("piso", piso);
				request.setAttribute("ruta", ruta);
				request.setAttribute("busqueda", busqueda);
								
				rd = getServletContext().getRequestDispatcher("/vender_boleto.jsp");
				
			}else{
				
				if(tipoPago.equalsIgnoreCase(Constantes.TIPO_PAGO_EFECTIVO)){
					pagoEfectivo = request.getParameter("pagoEfectivo");
				}else if(tipoPago.equalsIgnoreCase(Constantes.TIPO_PAGO_TARJETA)){
					clave = request.getParameter("clave");
					nroTarjeta = request.getParameter("nroTarjeta");				
				}else{
					mensaje = "ERROR AL SELECCIONAR EL TIPO DE PAGO: SERVLET BOLETAJE";
				}				
				try {
					boolean retorno = service.venderBoleto(idReserva, pasajero);
					
					if(retorno) mensaje = "VENTA DE BOLETO EXITOSA";
					else mensaje = "OCURRIO UN ERROR DURANTE LA VENTA DE BOLETO";
					
					rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");	
						
				} catch (Exception e) {
					e.printStackTrace();
				}		
				
			}
			
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_PREPARAR_VENDER_BOLETO)){
			int idViaje = Integer.parseInt(request.getParameter("idViaje"));
			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			double precio = 0;		
			
			try {
				Viaje viaje = service.consultarViajeCliente(idViaje);
				
				precio = viaje.getPrecio();
				
				request.setAttribute("precio", precio);
				request.setAttribute("idReserva", idReserva);
				rd = getServletContext().getRequestDispatcher("/consultar_viaje.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//********************************FIN VENDER BOLETO DE VIAJE**********************************//
		else if(tipo.equals(Constantes.ACCION_CONSULTAR_VIAJE)){
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
				
				Vector<Ruta> rutas=null;
				
				try {
					viajes = service.consultarViaje(empresa, origen, destino);
					rutas=service.listarRutas();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				request.setAttribute("viajes", viajes);	
				request.setAttribute("rutas", rutas);	
				rd = getServletContext().getRequestDispatcher("/consultar_viaje.jsp");
		}
		//********************************FIN CONSULTAR VIAJE**********************************//
		else if(tipo.equals(Constantes.ACCION_RESERVAR)){
			String busqueda=Constantes.ACCION_BUSQUEDA_NO_REALIZADA;
			Reserva reserva=new Reserva();
			Pasajero pasajero=new Pasajero();
			Ruta ruta=new Ruta();
			Viaje viaje=new Viaje();			
			String tipoSubmit = request.getParameter("tipoSubmit");
			try {
				
				long idRuta=Integer.parseInt(request.getParameter("idRuta"));
				int asiento=Integer.parseInt(request.getParameter("asientos"));
				int piso=Integer.parseInt(request.getParameter("piso"));
				int idViaje=Integer.parseInt(request.getParameter("idViaje"));
				String nombre=request.getParameter("txt_nombre");
				String apePat=request.getParameter("txt_apePat");
				String apeMat=request.getParameter("txt_apeMat");				
				
				HttpSession session= request.getSession(true);
				Usuario usuario=(Usuario)session.getAttribute("BUsuario");
				Perfil perfil = (Perfil)session.getAttribute("BPerfil");
			

				ruta=service.consultarRuta(idRuta);
				viaje=service.consultarViajeCliente(idViaje);
				
				
				if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_USUARIO) || 
						tipoSubmit.equalsIgnoreCase(Constantes.ACCION_VENDER_CONSULTAR_PERSONA)){	
					
					int dni=Integer.parseInt(request.getParameter("dni"));
					Persona persona=serviceseguridad.consultarPersona(dni);
					
					
						request.setAttribute("piso", piso);
						request.setAttribute("usuario", usuario);
						request.setAttribute("perfil", perfil);
						request.setAttribute("ruta", ruta);
						request.setAttribute("asiento", asiento);
						
						request.setAttribute("viaje", viaje);
						request.setAttribute("persona", persona);
																
						if(persona!=null){
							busqueda=Constantes.ACCION_BUSQUEDA_REALIZADA;
							request.setAttribute("busqueda", busqueda);							
							if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_USUARIO))
								rd = getServletContext().getRequestDispatcher("/reservarBoleto.jsp");
							if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_VENDER_CONSULTAR_PERSONA))
								rd = getServletContext().getRequestDispatcher("/vender_boleto.jsp");
						}else{
							busqueda=Constantes.ACCION_BUSQUEDA_NO_REALIZADA;
							request.setAttribute("busqueda", busqueda);
							mensaje="NO EXISTE EL REGISTRO";
							if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_USUARIO)) {
								rd = getServletContext().getRequestDispatcher("/reservarBoleto.jsp");
							}
							if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_VENDER_CONSULTAR_PERSONA)) {
								int idReserva = Integer.parseInt(request.getParameter("idReserva"));					
								String nombreProveedor =  request.getParameter("nombreProveedor");
								request.setAttribute("idReserva", idReserva);					
								request.setAttribute("nombreProveedor", nombreProveedor);
								rd = getServletContext().getRequestDispatcher("/vender_boleto.jsp");
							}
						}
				} else if(tipoSubmit.equalsIgnoreCase(Constantes.ACCION_RESERVAR_BOLETO)) {
					mensaje = "Boleto reservado exitosamente.";
					int dnipas=Integer.parseInt(request.getParameter("txt_dni"));
					reserva=service.generarReserva(usuario.getId());
					pasajero=service.generarPasajero(dnipas,nombre,apePat,apeMat);
					boolean retorno = service.reservarBoleto(reserva.getId(),idViaje,asiento,pasajero.getId());
					
					boolean estasiento=service.cambiarEstado(idViaje,asiento);
					if(retorno&estasiento) {
						request.setAttribute("usuario", usuario);
						request.setAttribute("perfil", perfil);
						request.setAttribute("ruta", ruta);
						request.setAttribute("asiento", asiento);
						request.setAttribute("piso", piso);
						request.setAttribute("viaje", viaje);						
						mensaje = "Boleto reservado exitosamente.";
						rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");			
					}else{
						rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");	
					}
				}else {
						mensaje="RESERVA CANCELADA";
						rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				
			}
			
		}	
		
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}
	

}
