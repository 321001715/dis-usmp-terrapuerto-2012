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
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Usuario;

/**
 * Servlet implementation class Agregar
 */
@WebServlet("/Agregar")
public class AgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			SeguridadDao miusuariodao = mysqlFactory.getSeguridadDao();
			Usuario unusuario = new Usuario();
			unusuario.setUsuario(request.getParameter("txt_usuario"));
			unusuario.setClave(request.getParameter("txt_pass"));
			unusuario.setDni(Integer.parseInt(request.getParameter("txt_dni")));
			unusuario.setEstado(request.getParameter("sel_estado"));
			unusuario.setNombres(request.getParameter("txt_nombre"));
			unusuario.setApePat(request.getParameter("txt_apePat"));
			unusuario.setApeMat(request.getParameter("txt_apeMat"));
			
			int filas_afectadas = miusuariodao.registrarUsuario(unusuario);
			
			if(filas_afectadas == 1)
				request.setAttribute("mensaje", "Usuario Agregado");
			else
				request.setAttribute("mensaje", "ocurrio un error");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/tablero.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
