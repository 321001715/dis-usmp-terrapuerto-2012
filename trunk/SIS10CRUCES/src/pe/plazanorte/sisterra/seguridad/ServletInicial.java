/* ServletInicial.java 
   Creado el 09 de septiembre de 2012, 22:53 PM*/

package pe.plazanorte.sisterra.seguridad;

import javax.servlet.*;
import javax.servlet.http.*;
import pe.plazanorte.sisterra.util.ConnectionPool;
import java.sql.*;
import java.util.Vector;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDAO;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.TipoUsuario;

import javax.naming.*;
import javax.sql.*;
import javax.servlet.http.HttpServletRequest;
/**
 * @author  desdfebres   @modificado amarquez
 * @version 1.1
 */
public class ServletInicial extends HttpServlet {
	/** Initializes the servlet.
	*/
	//Connection cc = null;
	InitialContext context = null;
	DataSource jdbcURL = null;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println(".... Inicio del Servlet ServletInicial.java ...");
		/*try {
			context = new InitialContext();
			jdbcURL = (DataSource) context.lookup("jdbc/DerechoDS");*/

			try {
				//Connection cc = jdbcURL.getConnection();
        System.out.println(".... Dentro del try del servlet Inicio ...");

        /**Despachadores*/
        MySqlSeguridadDAO des = new MySqlSeguridadDAO(); 
      


        /**Beans*/
        Vector<TipoUsuario> tipoUsuario = new Vector<TipoUsuario>();		
				

        /**Set de conecccion*/
        
        tipoUsuario = des.muestraTipoUsuario();  
        
				
  
				
        /**lanzando Variables de aplicación*/
		
        config.getServletContext().setAttribute("tipoUsuarios", tipoUsuario);	
				System.out.println(" ..... Cargando completo: Lista de usuarios: "+tipoUsuario.size()+" ...");
       

			} catch (Exception e) {
				System.out.println(" Error al conectarse a la Base de Datos");
			}
	}

	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	* @param request servlet request
	* @param response servlet response
	*/
	protected void processRequest(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, java.io.IOException {
		getServletContext().getRequestDispatcher("/homeLogin.jsp").forward(request, response);
	}

	/** Handles the HTTP <code>GET</code> method.
	* @param request servlet request
	* @param response servlet response
	*/

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, java.io.IOException {
		processRequest(request, response);

	}

	/** Handles the HTTP <code>POST</code> method.
	* @param request servlet request
	* @param response servlet response
	*/
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	/** Returns a short description of the servlet.
	*/
	public String getServletInfo() {
		return "Short description";
	}
}