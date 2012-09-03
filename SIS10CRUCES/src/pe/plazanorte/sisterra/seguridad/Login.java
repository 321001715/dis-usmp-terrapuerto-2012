package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;

import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Usuario;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {			
			
			if(request.getParameter("txt_usuario").equals("")&&request.getParameter("txt_clave").equals("")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp?error=2");
				rd.forward(request, response);
			}else{
				
				Usuario usu = new Usuario();
				
				usu.setUsuario(request.getParameter("txt_usuario"));
				usu.setClave(request.getParameter("txt_clave"));
				
				DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
				
				SeguridadDAO usudao = mysqlFactory.getSeguridadDAO();		
				
				Usuario usubean = usudao.validarUsuario(usu);
				
				if(usubean != null){
					HttpSession session = request.getSession();
					session.setAttribute("usuario", usubean);
					
					response.sendRedirect("index.jsp");
				}else{
					request.setAttribute("mensaje","usuario y/o clave incorrectos");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
			}			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("usuario");
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}

}
