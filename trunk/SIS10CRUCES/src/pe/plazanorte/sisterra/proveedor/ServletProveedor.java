package pe.plazanorte.sisterra.proveedor;

import java.io.IOException;

import java.sql.Timestamp;
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

import org.apache.catalina.connector.Request;

import pe.plazanorte.sisterra.clasificacion.ServiceClasificacion;
import pe.plazanorte.sisterra.consultas.ServiceConsultas;
import pe.plazanorte.sisterra.entidades.Clasificacion;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.seguridad.ServiceSeguridad;
import pe.plazanorte.sisterra.util.Constantes;

/**
 * Servlet implementation class ServletEmpresa
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServiceProveedor service = new ServiceProveedor();

		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurriï¿½ un error.";
		
		RequestDispatcher rd = null;

		// *****************************INICIO MANTENER PROVEEDOR*****************************//

		if (tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_PROVEEDOR)) {

			try {
				Vector<Proveedor> proveedores = new Vector<Proveedor>();
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);
				String destino = request.getParameter("destino");
				if (destino == null) {
					rd = getServletContext().getRequestDispatcher(
							"/listar_proveedores.jsp");
				} else if (Integer.parseInt(destino) == Constantes.MANTENER_PROVEEDOR) {
					rd = getServletContext().getRequestDispatcher(
							"/mantener_proveedor.jsp");
				} else if (Integer.parseInt(destino) == Constantes.ELIMINAR_PROVEEDOR) {
					rd = getServletContext().getRequestDispatcher(
							"/eliminar_proveedor.jsp");
				}

				request.setAttribute("proveedores", proveedores);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_PROVEEDOR)) {
			Proveedor proveedor = new Proveedor();
			int destino = Integer.parseInt(request.getParameter("destino"));
			try {
				proveedor.setIdProveedor(Integer.parseInt(request
						.getParameter("idProveedor")));
				proveedor = service.consultarProveedor(proveedor);
				request.setAttribute("proveedor", proveedor);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino == Constantes.MODIFICAR_PROVEEDOR) {
				rd = getServletContext().getRequestDispatcher(
						"/modificar_proveedor.jsp");
			}
		} else if (tipo.equalsIgnoreCase("eliminar")) {
			/*
			 * Proveedor proveedor = new Proveedor(); int destino =
			 * Integer.parseInt(request.getParameter("destino")); try {
			 * proveedor
			 * .setIdProveedor(Integer.parseInt(request.getParameter("idProveedor"
			 * ))); boolean respuesta = service.eliminarProveedor(proveedor);
			 * if(respuesta){ request.setAttribute("proveedor", proveedor);
			 * mensaje = "Proveedor deshabilitado."; }else {mensaje =
			 * "Ocurriï¿½ un error."; } } catch (Exception e) {
			 * e.printStackTrace(); }
			 * 
			 * if(destino == Constantes.MODIFICAR_PROVEEDOR){ rd =
			 * getServletContext
			 * ().getRequestDispatcher("/modificar_proveedor.jsp"); }
			 */
		}

		// *****************************FIN MANTENER PROVEEDOR*****************************//

		// *****************************INICIO GESTIONAR VEHICULO*****************************//

		if (tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_VEHICULO)) {

			try {
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
				vehiculos = service.listarVehiculos(uu);
				request.setAttribute("vehiculos", vehiculos);
				String destino = request.getParameter("destino");
				if (destino == null) {
					rd = getServletContext().getRequestDispatcher(
							"/listar_vehiculos.jsp");
				} else if (Integer.parseInt(destino) == Constantes.GESTIONAR_VEHICULO) {
					rd = getServletContext().getRequestDispatcher(
							"/gestion_vehiculos.jsp");
				} else if (Integer.parseInt(destino) == Constantes.ELIMINAR_PROVEEDOR) {
					rd = getServletContext().getRequestDispatcher(
							"/eliminar_proveedor.jsp");
				}

				request.setAttribute("proveedores", vehiculos);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VEHICULO)) {
			Vehiculo vehiculo = new Vehiculo();
			int destino = Integer.parseInt(request.getParameter("destino"));
			try {
				vehiculo.setIdProveedor(Integer.parseInt(request.getParameter("idVehiculo")));
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				vehiculo = service.consultarVehiculo(vehiculo,uu);
				request.setAttribute("vehiculo", vehiculo);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino == Constantes.MODIFICAR_VEHICULO) {
				rd = getServletContext().getRequestDispatcher(
						"/modificar_vehiculo.jsp");
			}
		} else if (tipo.equalsIgnoreCase("eliminar")) {

		}

		// *****************************FIN GESTIONAR VEHICULO*****************************//

		// ****************************INICIO GESTIONAR RUTA*****************************//

		if (tipo.equalsIgnoreCase("listar_ruta")) {

			try {

				Vector<Ruta> ruta = new Vector<Ruta>();
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				ruta = service.listarRuta(uu);
				request.setAttribute("ruta", ruta);
				String destino = request.getParameter("destino");
				if (destino == null) {
					rd = getServletContext().getRequestDispatcher(
							"/mantener_ruta.jsp");
				} else if (destino == "xxxx") {
					rd = getServletContext().getRequestDispatcher(
							"/mantener_ruta.jsp");
				} else if (Integer.parseInt(destino) == Constantes.ELIMINAR_PROVEEDOR) {
					rd = getServletContext().getRequestDispatcher(
							"/eliminar_proveedor.jsp");
				}

				request.setAttribute("ruta", ruta);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase("consultar_ruta")) {
			Ruta ruta = new Ruta();
			String destino = request.getParameter("destino");
			try {
				ruta.setId(Integer.parseInt(request.getParameter("id")));
				System.out.println((request.getParameter("id")));
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				ruta = service.consultarRuta(ruta,uu);

				request.setAttribute("ruta", ruta);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (destino.equalsIgnoreCase("modificar_ruta")) {
				rd = getServletContext().getRequestDispatcher(
						"/modificar_ruta.jsp");

			}
			
			// ****************************FIN GESTIONAR RUTA*****************************//
			
			// *****************************INICIO GESTIONAR VIAJE *****************************//
			
		}else if (tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_VIAJE)) {

	/*	long idViaje;
		if (request.getParameter("codViaje").length() != 0)
			idViaje = Long.parseLong(request.getParameter("codViaje"));
		else
			idViaje = 0;
			String numViaje = request.getParameter("numViaje");
			String nomViaje = request.getParameter("nomViaje");
			Long idRuta = Long.parseLong(request.getParameter("idRuta"));
			
			int precio = Integer.parseInt(request.getParameter("precio"));
			Long idClasificacion = Long.parseLong(request.getParameter("idClasificacion"));
			int dniChofer = Integer.parseInt(request.getParameter("dniChofer"));
			String servicio = request.getParameter("servicio");
			
			String fecSalida_string = request.getParameter("fecSalida");
			String fecLlegada_string = request.getParameter("fecLlegada");
			String horSalida = request.getParameter("horSalida");
			String horLlegada = request.getParameter("horLlegada");
			
			Date fecSalida;
			Date fecLlegada;
			
			DateFormat formatoFecha_salida = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
			String fecSalida_string_x = formatoFecha_salida.format(fecSalida_string);
			try {
				fecSalida = formatoFecha_salida.parse(fecSalida_string_x);
			} catch (Exception e) {
				throw new RuntimeException("No se pudo actualizar.");
			}
			
			DateFormat formatoFecha_llegada = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
			String fecLlegada_string_x = formatoFecha_llegada.format(fecLlegada_string);
			try {
				fecLlegada = formatoFecha_llegada.parse(fecLlegada_string_x);
			} catch (Exception e) {
				throw new RuntimeException("No se pudo actualizar.");
			}
			
			Viaje viaje = new Viaje();
			viaje.setId(idViaje);
			viaje.setNumViaje(numViaje);
			viaje.setNomViaje(nomViaje);
			viaje.setIdRuta(idRuta);
			viaje.setPrecio(precio);
			viaje.setIdClasificacion(idClasificacion);
			viaje.setDniChofer(dniChofer);
			viaje.setServicio(servicio);
			viaje.setFecSalida(fecSalida);
			viaje.setFecLlegada(fecLlegada);
			viaje.setHorSalida(horSalida);
			viaje.setHorLlegada(horLlegada);

			Vector<Viaje> vec = null;*/
		try {
			Vector<Viaje> viaje = new Vector<Viaje>();
			HttpSession session = request.getSession(true);
			Proveedor proveedor = (Proveedor) session.getAttribute("BProveedor");
			viaje = service.listarViaje(proveedor);
			request.setAttribute("viaje", viaje);
			rd = getServletContext().getRequestDispatcher(
					"/mantener_viaje.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tipo.equalsIgnoreCase("listar_viajes")) {
			rd = getServletContext().getRequestDispatcher(
				"/mantener_viaje.jsp");
		}
		
	}else if(tipo.equalsIgnoreCase(Constantes.ACCION_PREPARAR_REGISTRO_VIAJE)){
		ServiceProveedor serviceProveedor = new ServiceProveedor();
		ServiceClasificacion serviceClasificacion = new ServiceClasificacion();
		String destino = request.getParameter("destino");
		Proveedor proveedor = new Proveedor();
		proveedor.setIdProveedor(24); //INGRESANDO ID DE PROVEEDOR QUE DEBERÍA SER DE LA SESIÓN
		try {
			Vector<Ruta> listaRutas = serviceProveedor.listarRuta(proveedor);
			Vector<Vehiculo> listaVehiculos = serviceProveedor.listarVehiculos(proveedor);
			Vector<Clasificacion> listaClasificaciones = serviceClasificacion.listarClasificaciones();
			//Vector<Chofer> listaChoferes = serviceClasificacion.listarClasificaciones();
			
			request.setAttribute("listaRutas", listaRutas);
			request.setAttribute("listaVehiculos", listaVehiculos);
			request.setAttribute("listaClasificaciones", listaClasificaciones);
			
			if(destino.equalsIgnoreCase(Constantes.REGISTRAR_VIAJE));
				rd = getServletContext().getRequestDispatcher("/registrar_viaje.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VIAJE)) {
		String destino = request.getParameter("destino");
		ServiceConsultas serviceConsultas = new ServiceConsultas();
		int idViaje = Integer.parseInt(request.getParameter("idViaje"));
		
		serviceConsultas.consultarViaje(idViaje);
		
		if(destino.equalsIgnoreCase(Constantes.MODIFICAR_VIAJE))
			rd = getServletContext().getRequestDispatcher("/registrar_viaje.jsp");
	}
	
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurrio un error.";

		ServiceProveedor service = new ServiceProveedor();
		ServiceSeguridad serviceUsuario = new ServiceSeguridad();

		RequestDispatcher rd = null;

		// *****************************INICIO MANTENER PROVEEDOR*****************************//

		if (tipo.equalsIgnoreCase(Constantes.ACCION_REGISTRAR_PROVEEDOR)) {

			String ruc = request.getParameter("ruc");
			String razonSocial = request.getParameter("razon_social");
			String razonComercial = request.getParameter("razon_comercial");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String direccion = request.getParameter("direccion");
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			ServiceSeguridad servicSeguridad = new ServiceSeguridad();
			boolean retorno = false;
			
			try {
				Proveedor proveedor = new Proveedor();
				proveedor.setRuc(ruc);
				proveedor.setRazSocial(razonSocial);
				proveedor.setRazCom(razonComercial);
				proveedor.setTel(telefono);
				proveedor.setDireccion(direccion);
				proveedor.setIdUsuario(idUsuario);
				
				Usuario usuario = new Usuario();
				usuario.setId(idUsuario);
				
				if(serviceUsuario.consultarUsuario(usuario) != null){
					retorno = service.agregarProveedor(proveedor);
					//usuario.setRelacion(Constantes.RELACION_PROVEEDOR_USUARIO);
					serviceUsuario.modificarUsuario(usuario);
				}			

				if (retorno)
					mensaje = "Proveedor agregado con exito.";
				else
					mensaje = "Error, no se pudo registrar el proveedor.";

				Vector<Proveedor> proveedores = new Vector<Proveedor>();
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);

				Vector<Usuario> usuarios = new Vector<Usuario>();
				usuarios = servicSeguridad.listarUsuarios();
				request.setAttribute("usuarios", usuarios);

				Vector<Usuario> usuariosProveedores = new Vector<Usuario>();
				usuarios = servicSeguridad.listarUsuariosProveedores();
				request.setAttribute("usuariosProveedores", usuariosProveedores);

				rd = getServletContext().getRequestDispatcher(
						"/mantener_proveedor.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_MODIFICAR_PROVEEDOR)) {

			long codigo = Long.parseLong(request.getParameter("codigo"));
			String ruc = request.getParameter("ruc");
			String razonSocial = request.getParameter("razon_social");
			String razonComercial = request.getParameter("razon_comercial");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String estado = request.getParameter("estado");
			String direccion = request.getParameter("direccion");
			// int idUsuario =
			// Integer.parseInt(request.getParameter("idUsuario"));

			try {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(codigo);
				proveedor.setRuc(ruc);
				proveedor.setRazSocial(razonSocial);
				proveedor.setRazCom(razonComercial);
				proveedor.setEstado(estado);
				proveedor.setTel(telefono);
				proveedor.setDireccion(direccion);
				// proveedor.setIdUsuario(idUsuario);

				boolean retorno = service.modificarProveedor(proveedor);

				if (retorno)
					mensaje = "Proveedor modificado con ï¿½xito.";
				else
					mensaje = "Error, no se pudo modificar el proveedor.";

				Vector<Proveedor> proveedores = new Vector<Proveedor>();
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);

				rd = getServletContext().getRequestDispatcher(
						"/mantener_proveedor.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase("eliminar")) {

			/*
			 * try { Proveedor proveedor = new Proveedor();
			 * proveedor.setIdProveedor
			 * (Integer.parseInt(request.getParameter("id")));
			 * 
			 * service.eliminarProveedor(proveedor);
			 * 
			 * rd = getServletContext().getRequestDispatcher("/index.jsp");
			 * 
			 * } catch (Exception e) { e.printStackTrace(); }
			 */

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_PROVEEDOR)) {

			Proveedor proveedor = new Proveedor();

			try {
				// VALIDAR EL INGRESO DE STRING
				int id = Integer.parseInt(request.getParameter("idProveedor"));
				proveedor.setIdProveedor(id);
				proveedor = service.consultarProveedor(proveedor);
				if (proveedor == null)
					mensaje = "No se encontraron resultados para su consulta. [Proveedor cod."
							+ id + "]";
				else
					mensaje = "";
				request.setAttribute("proveedor", proveedor);

				rd = getServletContext().getRequestDispatcher(
						"/modificar_proveedor.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_PROVEEDOR)) {

			try {
				Vector<Proveedor> proveedores = new Vector<Proveedor>();
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);
				rd = getServletContext().getRequestDispatcher(
						"/listar_proveedores.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_FILTRO_PROVEEDOR)) {
			int destino = Integer.parseInt(request.getParameter("destino"));
			String ruc = request.getParameter("ruc");
			String razSocial = request.getParameter("razSocial");
			Vector<Proveedor> proveedores = null;
			try {
				proveedores = service.buscarProveedores(ruc, razSocial);
				request.setAttribute("proveedores", proveedores);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino == Constantes.MANTENER_PROVEEDOR) {
				rd = getServletContext().getRequestDispatcher(
						"/mantener_proveedor.jsp");
			}
		}

		// *****************************FIN MANTENER PROVEEDOR*****************************//

		// *****************************INICIO GESTIONAR VEHICULO*****************************//

		if (tipo.equalsIgnoreCase(Constantes.ACCION_REGISTRAR_VEHICULO)) {
			HttpSession session = request.getSession(true);
			String marca = request.getParameter("marca");
			String codigoVehiculo = request.getParameter("codVehiculo");
			String modelo = request.getParameter("modelo");
			String placa = request.getParameter("placa");
			int numPiso = Integer.parseInt(request.getParameter("numPiso"));
			int numAsientos = Integer.parseInt(request
					.getParameter("numAsientos"));
			String obs = request.getParameter("obs");
			Proveedor proveedor = (Proveedor) session
					.getAttribute("BProveedor");
			long idProveedor = proveedor.getIdProveedor();
			String asientosPorPiso = request.getParameter("asientosPorPiso");

			String estado = request.getParameter("estado");

			try {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setCodVehiculo(codigoVehiculo);
				vehiculo.setMarca(marca);
				vehiculo.setModelo(modelo);
				vehiculo.setPlaca(placa);
				vehiculo.setNumPiso(numPiso);
				vehiculo.setNumAsientos(numAsientos);
				vehiculo.setIdProveedor(idProveedor);
				vehiculo.setAsientosPorPiso(asientosPorPiso);

				vehiculo.setEstado(estado);
				vehiculo.setObs(obs);

				boolean retorno = service.agregarVehiculo(vehiculo);

				if (retorno)
					mensaje = "Vehï¿½culo agregado con ï¿½xito.";
				else
					mensaje = "Error, no se pudo registrar el vehï¿½culo.";
				
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
				vehiculos = service.listarVehiculos(uu);
				request.setAttribute("vehiculos", vehiculos);

				rd = getServletContext().getRequestDispatcher(
						"/gestion_vehiculos.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_MODIFICAR_VEHICULO)) {

			long idVehiculo = Long.parseLong(request
					.getParameter("codVehiculo"));
			String estado = request.getParameter("estado");
			String obs = request.getParameter("obs");
			String asientoNoDisponible = formatoAsientosNoDisponibles(request
					.getParameterValues("asientosNoDisponibles"));

			try {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setIdVehiculo(idVehiculo);
				vehiculo.setObs(obs);
				vehiculo.setEstado(estado);
				vehiculo.setAsientosNoDisponibles(asientoNoDisponible);

				boolean retorno = service.modificarVehiculo(vehiculo);

				if (retorno)
					mensaje = "Vehï¿½culo modificado con ï¿½xito.";
				else
					mensaje = "Error, no se pudo modificar el vehï¿½culo.";

				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
				vehiculos = service.listarVehiculos(uu);
				request.setAttribute("vehiculos", vehiculos);

				rd = getServletContext().getRequestDispatcher(
						"/gestion_vehiculos.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VEHICULO)) {

			Vehiculo vehiculo = new Vehiculo();

			try {
				int id = Integer.parseInt(request.getParameter("idVehiculo"));
				vehiculo.setIdVehiculo(id);
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				vehiculo = service.consultarVehiculo(vehiculo,uu);
				if (vehiculo == null)
					mensaje = "No se encontraron resultados para su consulta. [Vehiculo cod."
							+ id + "]";
				else
					mensaje = "";
				request.setAttribute("proveedor", vehiculo);

				rd = getServletContext().getRequestDispatcher(
						"/modificar_vehiculo.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_VEHICULO)) {

			try {
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
				vehiculos = service.listarVehiculos(uu);
				request.setAttribute("vehiculos", vehiculos);
				rd = getServletContext().getRequestDispatcher(
						"/listar_vehiculos.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_FILTRO_VEHICULO)) {
			int destino = Integer.parseInt(request.getParameter("destino"));
			long idVehiculo;
			if (request.getParameter("idVehiculo").length() != 0)
				idVehiculo = Long.parseLong(request.getParameter("idVehiculo"));
			else
				idVehiculo = 0;
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String placa = request.getParameter("placa");

			Vehiculo vehiculo = new Vehiculo();

			vehiculo.setIdVehiculo(idVehiculo);
			vehiculo.setMarca(marca);
			vehiculo.setModelo(modelo);
			vehiculo.setPlaca(placa);

			Vector<Vehiculo> vehiculos = null;
			try {
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				vehiculos = service.buscarVehiculo(vehiculo,uu);
				request.setAttribute("vehiculos", vehiculos);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino == Constantes.GESTIONAR_VEHICULO) {
				rd = getServletContext().getRequestDispatcher(
						"/gestion_vehiculos.jsp");
			}
		}

		// *****************************FIN GESTIONAR VEHICULO*****************************//

		// *****************************INICIO GESTIONAR RUTA*****************************//

		if (tipo.equalsIgnoreCase("registrarRuta")) {

			String nomRuta = request.getParameter("nomRuta");
			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");
			int km = Integer.parseInt(request.getParameter("km"));
			int duracion = Integer.parseInt(request.getParameter("duracion"));

			try {
				Ruta ruta = new Ruta();

				ruta.setNomRuta(nomRuta);
				ruta.setOrigen(origen);
				ruta.setDestino(destino);
				ruta.setKm(km);
				ruta.setDuracion(duracion);
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				System.out.println(uu.getRazSocial());
				boolean retorno = service.registrarRuta(ruta, uu);

				if (retorno)
					mensaje = "Ruta registrada con exito";
				else
					mensaje = "Error, no se pudo registrar la ruta.";

				Vector<Ruta> ruta1 = new Vector<Ruta>();
				ruta1 = service.listarRuta(uu);
				request.setAttribute("ruta", ruta1);

				rd = getServletContext().getRequestDispatcher(
						"/mantener_ruta.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_MODIFICAR_RUTA)) {

			String nomRuta = request.getParameter("nomRuta");
			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");
			int km = Integer.parseInt(request.getParameter("km"));
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			String estado=request.getParameter("estado");
			long idruta=Long.parseLong(request.getParameter("codRuta"));
			try {
				Ruta ruta = new Ruta();
				ruta.setNomRuta(nomRuta);
				ruta.setOrigen(origen);
				ruta.setDestino(destino);
				ruta.setKm(km);
				ruta.setDuracion(duracion);
				ruta.setEstado(estado);
				ruta.setId(idruta);
				boolean retorno = service.modificarRuta(ruta);
				
				if (retorno)
					mensaje = "Clasificacion modificado con ï¿½xito.";
				else
					mensaje = "Error, no se pudo modificar la clasificacion.";
				
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				Vector<Ruta> rutas = new Vector<Ruta>();
				rutas=service.listarRuta(uu);
				request.setAttribute("ruta", rutas);
				rd = getServletContext().getRequestDispatcher(
						"/mantener_ruta.jsp");

				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (tipo.equalsIgnoreCase("listar_rutas")) {

			long idVehiculo;
			if (request.getParameter("codRuta").length() != 0)
				idVehiculo = Long.parseLong(request.getParameter("codRuta"));
			else
				idVehiculo = 0;
			String origen = request.getParameter("origen");
			String destino = request.getParameter("destino");
			String nomRuta = request.getParameter("nomRuta");

			Ruta ruta = new Ruta();

			ruta.setId(idVehiculo);
			ruta.setDestino(destino);
			ruta.setOrigen(origen);
			ruta.setNomRuta(nomRuta);

			Vector<Ruta> vec = null;
			try {
				HttpSession session = request.getSession(true);
				Proveedor uu = (Proveedor) session.getAttribute("BProveedor");
				vec = service.buscarRuta(ruta,uu);
				request.setAttribute("ruta", vec);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (tipo.equalsIgnoreCase("listar_rutas")) {

				rd = getServletContext().getRequestDispatcher(
						"/mantener_ruta.jsp");
			}

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_PROVEEDOR)) {

		} else if (tipo.equalsIgnoreCase(Constantes.ACCION_FILTRO_RUTA)) {

		}
		
		// *****************************FIN GESTIONAR RUTA*****************************//
		
		//******************************INICIO GESTIONAR VIAJE******************************//
		
		if(tipo.equalsIgnoreCase(Constantes.ACCION_REGISTRAR_VIAJE)) {			
			
			String nombre = request.getParameter("nombre");
			String fecSalida = request.getParameter("fecSalida");
			String fecLlegada = request.getParameter("fecLlegada");
			String horSalida = request.getParameter("horSalida");
			String horLlegada = request.getParameter("horLegada");
			double precio = Double.parseDouble(request.getParameter("precio"));
			int idRuta = Integer.parseInt(request.getParameter("idRuta"));
			String servicio = request.getParameter("servicio");
			int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
			int idChofer = Integer.parseInt(request.getParameter("idChofer"));
			int idClasificacion = Integer.parseInt(request.getParameter("idClasificacion"));
			
			try {
				
				Viaje viaje = new Viaje();
				viaje.setNomViaje(nombre);
				viaje.setFecSalida(fecSalida);
				viaje.setFecLlegada(fecLlegada);
				viaje.setHorSalida(horSalida);
				viaje.setHorLlegada(horLlegada);
				viaje.setPrecio(precio);
				viaje.setIdRuta(idRuta);
				viaje.setServicio(servicio);
				viaje.setIdVehiculo(idVehiculo);
				viaje.setIdClasificacion(idClasificacion);
				viaje.setIdChofer(idChofer);
				
				boolean retorno = service.registrarViaje(viaje);				
				
				if (retorno)
					mensaje = "Viaje agregado con exito.";
				else
					mensaje = "Error, no se pudo registrar el viaje.";			
				
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(24);
				Vector<Viaje> listaViajes = service.listarViaje(proveedor);
				request.setAttribute("viaje", listaViajes);
				rd = getServletContext().getRequestDispatcher("/mantener_viaje.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_MODIFICAR_VIAJE)) {
			long idViaje = Long.parseLong(request.getParameter("idViaje"));
			String nombre = request.getParameter("nombre");
			String fecSalida = request.getParameter("fecSalida");
			String fecLlegada = request.getParameter("fecLlegada");
			String horSalida = request.getParameter("horSalida");
			String horLlegada = request.getParameter("horLegada");
			double precio = Double.parseDouble(request.getParameter("precio"));
			int idRuta = Integer.parseInt(request.getParameter("idRuta"));
			String servicio = request.getParameter("servicio");
			int idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
			int idChofer = Integer.parseInt(request.getParameter("idChofer"));
			int idClasificacion = Integer.parseInt(request.getParameter("idClasificacion"));
			
			try {
				
				Viaje viaje = new Viaje();
				viaje.setId(idViaje);
				viaje.setNomViaje(nombre);
				viaje.setFecSalida(fecSalida);
				viaje.setFecLlegada(fecLlegada);
				viaje.setHorSalida(horSalida);
				viaje.setHorLlegada(horLlegada);
				viaje.setPrecio(precio);
				viaje.setIdRuta(idRuta);
				viaje.setServicio(servicio);
				viaje.setIdVehiculo(idVehiculo);
				viaje.setIdClasificacion(idClasificacion);
				viaje.setIdChofer(idChofer);
				
				boolean retorno = service.modificarViaje(viaje);				
				
				if (retorno)
					mensaje = "Viaje agregado con exito.";
				else
					mensaje = "Error, no se pudo registrar el viaje.";			
				
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(24);
				Vector<Viaje> listaViajes = service.listarViaje(proveedor);
				request.setAttribute("viaje", listaViajes);
				rd = getServletContext().getRequestDispatcher("/mantener_viaje.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//******************************FIN GESTIONAR VIAJE******************************//
		
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);
	}	
	
	public String formatoAsientosNoDisponibles(String[] asientosNoDisponibles) {
		String AsientosNoDisponiblesConFormato = "";
		for (int i = 0; i < asientosNoDisponibles.length; i++) {
			AsientosNoDisponiblesConFormato += asientosNoDisponibles[i] + "&";
		}

		return AsientosNoDisponiblesConFormato;
	}

	
}
