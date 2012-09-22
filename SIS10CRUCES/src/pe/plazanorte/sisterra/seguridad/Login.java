package pe.plazanorte.sisterra.seguridad;

import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDAO;
import java.net.InetAddress;
import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;

public class Login extends HttpServlet {

	private String msgError;
	InitialContext context = null;
	DataSource pool = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			java.io.IOException {
		HttpSession session = request.getSession(true);
		try {
			Usuario uu = new Usuario();
			uu.setUsuario(request.getParameter("usuario").toUpperCase());
			uu.setClave(request.getParameter("password"));
			uu.setIdTipUsuario(Integer.parseInt(request.getParameter("esc")));
			MySqlSeguridadDAO du = new MySqlSeguridadDAO();
			if (du.validarUser(uu)) {

				session.setAttribute("BUsuario", uu);
				uu = (Usuario) session.getAttribute("BUsuario");
				
			if (uu.getIdTipUsuario()==18) {
				Proveedor proveedor = new Proveedor();
				du.proveedor(proveedor,uu);
				session.setAttribute("BProveedor", proveedor);
				
				getServletContext().getRequestDispatcher("/presentacion.jsp").forward(request, response);
			
			}else getServletContext().getRequestDispatcher("/presentacion.jsp").forward(request, response);
			
			
			
			} else {
				getServletContext().getRequestDispatcher("/login.jsp")
						.forward(request, response);
			}
		} catch (Exception sq) {
			System.out.println("No cerró la conexion " + sq.getCause());
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			java.io.IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			java.io.IOException {
		processRequest(request, response);
	}

	public String getServletInfo() {
		return "Short description";
	}
	
}
