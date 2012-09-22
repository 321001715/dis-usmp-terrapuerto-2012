package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Usuario;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	
			DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			SeguridadDAO miusuariodao = mysqlFactory.getSeguridadDAO();
			
			String origen = request.getParameter("origen");
			
			if(origen.equals("1")){
				
				Vector<Usuario> usuarios = miusuariodao.listarUsuario();
				
				request.setAttribute("usuarios", usuarios);

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/gestion_usuarios.jsp");
				rd.forward(request, response);
			}		

		}  catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
