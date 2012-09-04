package pe.plazanorte.sisterra.clasificacion;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.entidades.Clasificacion;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.util.Constantes;

@WebServlet("/ServletClasificacion")
public class ServletClasificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletClasificacion() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurrió un error.";
		ServiceClasificacion service = new ServiceClasificacion();

		RequestDispatcher rd = null;
		if (tipo.equalsIgnoreCase("listar")) {
			try {
				Vector<Clasificacion> clasificacion = new Vector<Clasificacion>();
				clasificacion = service.listarClasificaciones();
				request.setAttribute("clasificaciones", clasificacion);
				String destino = request.getParameter("destino");
				if (destino == null) {
					rd = getServletContext().getRequestDispatcher(
							"/listar_clasificaciones.jsp");
				} else if (Integer.parseInt(destino) == Constantes.MANTENER_CLASIFICACION) {
					rd = getServletContext().getRequestDispatcher(
							"/mantener_clasificacion.jsp");
				} else if (Integer.parseInt(destino) == Constantes.ELIMINAR_CLASIFICACION) {
					rd = getServletContext().getRequestDispatcher(
							"/eliminar_clasificacion.jsp");
				}

				request.setAttribute("clasificaciones", clasificacion);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (tipo.equalsIgnoreCase("consultar")) {
			Clasificacion clasificacion = new Clasificacion();
			int destino = Integer.parseInt(request.getParameter("destino"));
			try {
				clasificacion.setId(Integer.parseInt(request
						.getParameter("idClasificacion")));
				clasificacion = service.consultarClasificacion(clasificacion);
				request.setAttribute("clasificacion", clasificacion);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino == Constantes.MODIFICAR_PROVEEDOR) {
				rd = getServletContext().getRequestDispatcher(
						"/modificar_clasificacion.jsp");
			} else if (tipo.equalsIgnoreCase("eliminar")) {
			}
		}
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurrió un error.";
		ServiceClasificacion service = new ServiceClasificacion();
		RequestDispatcher rd = null;

		if (tipo.equalsIgnoreCase("registrar")) {
			String idTipoServicio = request.getParameter("idTipoServicio");
			String descripcion = request.getParameter("descripcion");

			try {
				Clasificacion clasificacion = new Clasificacion();
				clasificacion.setId(Long.parseLong(idTipoServicio));
				clasificacion.setDescripcion(descripcion);

				boolean retorno = service.agregarProveedor(clasificacion);

				if (retorno)
					mensaje = "Clasificacion agregado con éxito.";
				else
					mensaje = "Error, no se pudo registrar la clasificacion.";

				rd = getServletContext().getRequestDispatcher("/index.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase("modificar")) {

			long id = Long.parseLong(request.getParameter("idTipoServicio"));
			String descripcion = request.getParameter("descripcion");

			try {
				Clasificacion clasificacion = new Clasificacion();
				clasificacion.setId(id);
				clasificacion.setDescripcion(descripcion);

				boolean retorno = service.modificarClasificacion(clasificacion);

				if (retorno)
					mensaje = "Clasificacion modificado con éxito.";
				else
					mensaje = "Error, no se pudo modificar la clasificacion.";

				Vector<Clasificacion> clasificaciones = new Vector<Clasificacion>();
				clasificaciones = service.listarClasificaciones();
				request.setAttribute("clasificaciones", clasificaciones);

				rd = getServletContext().getRequestDispatcher(
						"/mantener_clasificacion.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tipo.equalsIgnoreCase("eliminar")) {
		} else if (tipo.equalsIgnoreCase("consultar")) {

			Clasificacion clasificacion= new Clasificacion();

			try {
				// VALIDAR EL INGRESO DE STRING
				int id = Integer.parseInt(request.getParameter("idTipoServicio"));
				clasificacion.setId(id);
				clasificacion= service.consultarClasificacion(clasificacion);
				if (clasificacion== null)
					mensaje = "No se encontraron resultados para su consulta. [Clasificacion cod."+ id + "]";
				else
					mensaje = "";
				
				request.setAttribute("clasificacion", clasificacion);

				rd = getServletContext().getRequestDispatcher(
						"/modificar_clasificacion.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(tipo.equalsIgnoreCase("listar")){
			
			try {								
				Vector<Clasificacion> clasificaciones = new Vector<Clasificacion>();				
				clasificaciones= service.listarClasificaciones();
				request.setAttribute("clasificacion", clasificaciones);
				rd = getServletContext().getRequestDispatcher("/listar_clasificaciones.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(tipo.equalsIgnoreCase("filtro")){
			int destino = Integer.parseInt(request.getParameter("destino"));
			
			String descripcion = request.getParameter("descripcion");
			Vector<Clasificacion> clasificaciones= null;
			try {
				clasificaciones= service.buscarClasificaciones(descripcion);				
				request.setAttribute("clasificaciones", clasificaciones);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MANTENER_PROVEEDOR){
				rd = getServletContext().getRequestDispatcher("/mantener_clasificacion.jsp");
			}
		}				
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}
	}


