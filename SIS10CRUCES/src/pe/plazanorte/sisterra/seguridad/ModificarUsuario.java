package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.HabitacionBean;
import beans.ReservaBean;
import beans.TipoBean;
import beans.UsuarioBean;

import dao.iface.HabitacionDao;
import dao.iface.ReservaDao;
import dao.iface.TipoDao;
import dao.iface.UsuarioDao;
import pe.plazanorte.sisterra.dao.iface.SeguridadDao;
import pe.plazanorte.sisterra.daofactory.DAOFactory;;
import pe.plazanorte.sisterra.entidades.Usuario;

/**
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			DAOFactory mysqlfFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			String origen = request.getParameter("origen");
			
			if(origen.equals("gestion_usuarios")){
				
				SeguridadDao miusuariodao = mysqlfFactory.getSeguridadDao();
				
				Usuario usuario = new Usuario();
				usuario.setId(Integer.parseInt(request.getParameter("txt_id")));
				usuario.setNombre(request.getParameter("txt_nombre"));
				usuario.setApellido(request.getParameter("txt_apellido"));
				usuario.setDocumento(Integer.parseInt(request.getParameter("txt_documento")));
				usuario.setSexo(request.getParameter("txt_sexo"));
				usuario.setFecnac(request.getParameter("txt_fecha"));
				usuario.setTelefono(Integer.parseInt(request.getParameter("txt_telefono")));
				usuario.setCorreo(request.getParameter("txt_correo"));
				usuario.setPais(request.getParameter("txt_pais"));
				usuario.setCiudad(request.getParameter("txt_ciudad"));				
				usuario.setClave(request.getParameter("txt_clave"));
				
				int filas_afectadas = miusuariodao.modificarUsuario(usuario);
				if(filas_afectadas != 1)
					request.setAttribute("mensaje", "Ocurrió un error.");
				else
					request.setAttribute("mensaje", "Actualizacion satisfactoria");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Usuarios?origen=modificar_usuario");
				rd.forward(request, response);
				
			}else if(origen.equals("gestion_habitaciones")){
				
				int id = Integer.parseInt(request.getParameter("id"));
				DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				TipoDao mitipodao = mysqlFactory.getTipoDAO();
				HabitacionDao mihabitaciondao = mysqlFactory.getHabitacionDAO();
				Vector<TipoBean> tipos = mitipodao.listarTipos();
				HabitacionBean habitacion = mihabitaciondao.obtenerHabitacion(id);
				
				request.setAttribute("tipos", tipos);
				request.setAttribute("habitacion", habitacion);
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/modificar_habitacion.jsp");
				rd.forward(request, response);
				
			}else if(origen.equals("consultar_reservas")){
				
				//AQUI SE COMPARTE LA INFORMACION PARA QUE EL USUARIO MODIFIQUE SUS RESERVAS
				
				DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				
				HabitacionDao mihabitaciondao = mysqlFactory.getHabitacionDAO();
				Vector<HabitacionBean> habitaciones = mihabitaciondao.listarHabitaciones();
				
				ReservaDao mireservadao = mysqlFactory.getReservaDAO();
				int usu = Integer.parseInt(request.getParameter("usu"));
				int hab = Integer.parseInt(request.getParameter("hab"));
				ReservaBean reserva = mireservadao.obtenerReserva(usu,hab);

				request.setAttribute("reserva", reserva);	
				request.setAttribute("habitaciones", habitaciones);	
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar.jsp");	
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAOFactory mysqlfFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);	
			String origen = request.getParameter("origen");
			if(origen.equals("modificar_habitacion")){
				HabitacionDao mihabitaciondao = mysqlfFactory.getHabitacionDAO();
				
				HabitacionBean habitacion = new HabitacionBean();
				habitacion.setId_tipo(Integer.parseInt(request.getParameter("sel_tipo")));
				habitacion.setNum_hab(Integer.parseInt(request.getParameter("txt_num_hab")));
				habitacion.setId_habitacion(Integer.parseInt(request.getParameter("txt_id")));
				habitacion.setDescripcion(request.getParameter("txt_descripcion"));
				habitacion.setEstado(request.getParameter("txt_estado"));
				
				int filas_afectadas = mihabitaciondao.modificarHabitacion(habitacion);
				if (filas_afectadas != 1)
					request.setAttribute("mensaje", "Ocurrió un error.");
				else
					request.setAttribute("mensaje",	"Actualizacion satisfactoria");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/tablero.jsp");
				rd.forward(request, response);
				
			}else if(origen.equals("modificar_usuario")){
				UsuarioDao miusuariodao = mysqlfFactory.getUsuarioDAO();

				UsuarioBean usuario = new UsuarioBean();
				usuario.setId(Integer.parseInt(request.getParameter("txt_id")));
				usuario.setNombre(request.getParameter("txt_nombre"));
				usuario.setApellido(request.getParameter("txt_apellido"));
				usuario.setDocumento(Integer.parseInt(request.getParameter("txt_documento")));
				usuario.setSexo(request.getParameter("txt_sexo"));
				usuario.setFecnac(request.getParameter("txt_fecha"));
				usuario.setTelefono(Integer.parseInt(request.getParameter("txt_telefono")));
				usuario.setCorreo(request.getParameter("txt_correo"));
				usuario.setPais(request.getParameter("txt_pais"));
				usuario.setCiudad(request.getParameter("txt_ciudad"));
				usuario.setClave(request.getParameter("txt_clave"));

				int filas_afectadas = miusuariodao.modificarUsuario(usuario);
				if (filas_afectadas != 1)
					request.setAttribute("mensaje", "Ocurrió un error.");
				else
					request.setAttribute("mensaje",	"Actualizacion satisfactoria");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/tablero.jsp");
				rd.forward(request, response);
			}else if(origen.equals("formulario_modificar")){
				
				ReservaDao mireservadao = mysqlfFactory.getReservaDAO();
				ReservaBean nuevo = new ReservaBean();
				nuevo.setIdUsuario(Integer.parseInt(request.getParameter("txt_id")));				
				nuevo.setIdHabitacion(Integer.parseInt(request.getParameter("habitacion")));
				nuevo.setDuracion(request.getParameter("dias"));
				String inicio = request.getParameter("sel_anno")+"-"+request.getParameter("sel_mes")+"-"+request.getParameter("sel_dia");
				nuevo.setFechaInicio(inicio);
				nuevo.setMotivo(request.getParameter("motivo"));
				nuevo.setEstado(request.getParameter("txt_estado"));
				
				String mensaje = mireservadao.modificarReservas(nuevo);
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}

}
