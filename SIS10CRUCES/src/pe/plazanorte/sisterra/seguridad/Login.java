package pe.plazanorte.sisterra.seguridad;

import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Perfil;
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
		Perfil perfil=new Perfil();
		try {
			Proveedor proveedor= new Proveedor();
			Cliente cliente =new Cliente();
			Usuario uu = new Usuario();
			uu.setUsuario(request.getParameter("usuario").toUpperCase());
			uu.setClave(request.getParameter("password"));
			uu.setIdTipUsuario(Integer.parseInt(request.getParameter("esc")));
			MySqlSeguridadDAO du = new MySqlSeguridadDAO();
			String idPerfil= request.getParameter("esc").toString();
			perfil=du.busPerfil(idPerfil);
			
			if (du.validarUser(uu)) {

				session.setAttribute("BUsuario", uu);
				uu = (Usuario) session.getAttribute("BUsuario");
				session.setAttribute("BPerfil", perfil);
				
				if(idPerfil.equals("20")){
					session.setAttribute("BCliente", cliente);	
					
					//debera ir interfaz cliente
					
				}else
				{
					Usuario usuario=du.buscarUsuario(uu.getUsuario());
					proveedor= du.buscarProvedor(usuario.getId());
					session.setAttribute("BProvedor", proveedor);	
					
					//deberia ir a interfaz de no cliente
				}
				
				getServletContext().getRequestDispatcher("/presentacion.jsp").forward(request, response);
			
			
			
			} else {
				getServletContext().getRequestDispatcher("/login.jsp")
						.forward(request, response);
			}
		} catch (Exception sq) {
			System.out.println("No cerr� la conexion " + sq.getCause());
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
