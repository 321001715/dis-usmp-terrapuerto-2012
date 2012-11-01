package pe.plazanorte.sisterra.seguridad;

import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.util.Constantes;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDAO;
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
			
			Usuario uu = new Usuario();
			uu.setUsuario(request.getParameter("usuario").toUpperCase());
			uu.setClave(request.getParameter("password"));
			uu.setIdTipUsuario(Integer.parseInt(request.getParameter("esc")));
			MySqlSeguridadDAO du = new MySqlSeguridadDAO();
			int idPerfil= Integer.parseInt(request.getParameter("esc"));
			perfil=du.busPerfil(idPerfil);
			
			if (du.validarUser(uu)) {

				session.setAttribute("BUsuario", uu);
				uu = (Usuario) session.getAttribute("BUsuario");
				session.setAttribute("BPerfil", perfil);
				
				if(idPerfil==20){
					Cliente cliente =new Cliente();
				cliente = du.buscarCliente(uu.getId());
					
					session.setAttribute("BCliente", cliente);	
					
					
					
				}else
				{
					Usuario usuario=du.buscarUsuario(uu.getUsuario());
					
					proveedor= du.buscarProvedor(usuario.getId());
					
					session.setAttribute("BProveedor", proveedor);	

					
					 
				}
				
				getServletContext().getRequestDispatcher("/presentacion.jsp").forward(request, response);
			
			
			
			} else {
				getServletContext().getRequestDispatcher("/homeLogin.jsp")
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
		String tipo = request.getParameter("tipo");
		
		if(tipo.equalsIgnoreCase(Constantes.CERRAR_SESION)) {
			try {
				HttpSession session = request.getSession();
				session.removeAttribute("BUsuario");
				Perfil perfil = (Perfil)session.getAttribute("BPerfil");
					
				//Obteniendo el tipo de perfil
				long idPerfil = perfil.getId();
				
				//Eliminando los objetos de la sesion
				session.removeAttribute("BPerfil");
				session.removeAttribute("BUsuario");
				
				//Evaluando el tipo de perfil y eliminando segun el perfil
				if(idPerfil==20){				
					session.removeAttribute("BCliente");					
				}else{				
					session.removeAttribute("BProveedor");					 
				}
				//Redireccion a home
				getServletContext().getRequestDispatcher("/homeLogin.jsp").forward(request, response);				
			} catch (Exception e) {
				System.out.println("HA OCURRIDO UN ERROR MIENTRAS SE CERRABA LA SESION");
			}			
		}
		
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
