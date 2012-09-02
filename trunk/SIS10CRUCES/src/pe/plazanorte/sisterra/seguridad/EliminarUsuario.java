package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import pe.plazanorte.sisterra.dao.iface.SeguridadDao;
import pe.plazanorte.sisterra.daofactory.DAOFactory;;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String origen = request.getParameter("origen");			
			
			if(origen.equals("gestion_usuarios")){
				//ELIMINA USUARIOS
				DAOFactory mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				
				SeguridadDao miusuariodao = mysqlfactory.getSeguridadDao();				
				int filas_afectadas = miusuariodao.eliminarUsuario(Integer.parseInt(request.getParameter("usu")));
				
				if(filas_afectadas != 1) request.setAttribute("mensaje", "Ocurrió un error.");
				else request.setAttribute("mensaje", "Usuario eliminado.");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/tablero.jsp");
				rd.forward(request, response);
				
			}			
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}

}
