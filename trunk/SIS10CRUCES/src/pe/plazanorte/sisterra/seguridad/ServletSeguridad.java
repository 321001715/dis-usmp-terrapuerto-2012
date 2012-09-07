package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.util.Constantes;

/**
 * Servlet implementation class ServletEmpresa
 */
@WebServlet("/ServletSeguridad") //MODIFICADO
public class ServletSeguridad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeguridad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurrió un error.";
		
		ServiceSeguridad service = new ServiceSeguridad();
		
		RequestDispatcher rd = null;
		
		if(tipo.equalsIgnoreCase("listar")){						
		
			try {
				Vector<Usuario> usuarios = new Vector<Usuario>();				
				usuarios = service.listarUsuarios();
				request.setAttribute("proveedores", usuarios);	
				String origen = request.getParameter("origen");
				if(origen == null){
					rd = getServletContext().getRequestDispatcher("/listar_usuarios.jsp");
				}else if(Integer.parseInt(origen) == Constantes.MENU_PRINCIPAL){
					rd = getServletContext().getRequestDispatcher("/mantener_usuario.jsp");
				}
				request.setAttribute("usuarios", usuarios);	
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else if(tipo.equalsIgnoreCase("listarPerfiles")){
			try {
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				request.setAttribute("perfiles", perfiles);	
				String origen = request.getParameter("origen");
				if(origen == null){
					rd = getServletContext().getRequestDispatcher("/listar_perfiles.jsp");
				}else if(Integer.parseInt(origen) == Constantes.MENU_PRINCIPAL){
					rd = getServletContext().getRequestDispatcher("/mantener_perfil.jsp");
				}
				request.setAttribute("perfiles", perfiles);	
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_PERFIL)){
			Perfil perfil = new Perfil();	
			int destino = Integer.parseInt(request.getParameter("destino"));			
			try {
				perfil.setId(Integer.parseInt(request.getParameter("idPerfil")));
						
				perfil = service.consultarPerfil(perfil);				
				request.setAttribute("perfil", perfil);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MODIFICAR_PERFIL){
				rd = getServletContext().getRequestDispatcher("/modificar_perfil.jsp");
			}
		}
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String tipo = request.getParameter("tipo");
		System.out.println(tipo);
		String mensaje = "Ocurri� un error.";
		
		ServiceSeguridad service = new ServiceSeguridad();
		
		RequestDispatcher rd = null;
		//*****************************INICIO MANTENER USUARIO*****************************//
		
		if(tipo.equalsIgnoreCase("registrar")) {
			
			
			String user = request.getParameter("txt_usuario");
			String pass = request.getParameter("txt_pass");
			int dni = Integer.parseInt(request.getParameter("txt_dni"));
			String estado = request.getParameter("sel_estado");
			String nom=	request.getParameter("txt_nombre");	
			String apepat=request.getParameter("txt_apePat");
			String apemat=request.getParameter("txt_apeMat");
			try {
				Usuario usuario=new Usuario();
				
				usuario.setUsuario(user);
				usuario.setClave(pass);
				usuario.setDni(dni);
				usuario.setEstado(estado);
				usuario.setNombres(nom);
				usuario.setApePat(apepat);	
				usuario.setApeMat(apemat);	
				
				boolean retorno = service.agregarUsuario(usuario);			
				
				if(retorno) mensaje = "Usuario agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el usuario.";	
				
				rd = getServletContext().getRequestDispatcher("/login.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase("modificar")) {
			
			String user = request.getParameter("txt_usuario");
			String pass = request.getParameter("txt_pass");
			int dni = Integer.parseInt(request.getParameter("txt_dni"));
			String estado = request.getParameter("sel_estado");
			String nom=	request.getParameter("txt_nombre");	
			String apepat=request.getParameter("txt_apePat");
			String apemat=request.getParameter("txt_apeMat");		
			
			try {
				Usuario usuario=new Usuario();
				
				usuario.setUsuario(user);
				usuario.setClave(pass);
				usuario.setDni(dni);
				usuario.setEstado(estado);
				usuario.setNombres(nom);
				usuario.setApePat(apepat);	
				usuario.setApeMat(apemat);				
				
				boolean retorno = service.modificarUsuario(usuario);				
				
				if(retorno) mensaje = "Usuario modificado con éxito.";
				else mensaje = "Error, no se pudo modificar el usuario.";	
				
				Vector<Usuario> usuarios = new Vector<Usuario>();				
				usuarios = service.listarUsuarios();
				request.setAttribute("usuarios", usuarios);	
				
				rd = getServletContext().getRequestDispatcher("/mantener_usuario.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}else if(tipo.equalsIgnoreCase("eliminar")) {
			
			try {
				Usuario usuario=new Usuario();
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("id")));
			
				service.eliminarUsuario(usuario);
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase("consultar")) {
			Usuario usuario=new Usuario();
			Proveedor proveedor = new Proveedor();			
			
			try {
				//VALIDAR EL INGRESO DE STRING
				int id = Integer.parseInt(request.getParameter("idProveedor"));
				proveedor.setIdProveedor(id);			
				usuario = service.consultarUsuario(usuario);
				//if(usuario == null) mensaje = "No se encontraron resultados para su consulta. [Proveedor cod."+id+"]";
				//else mensaje = "";
				request.setAttribute("proveedor", proveedor);				
				
				rd = getServletContext().getRequestDispatcher("/modificar_usuario.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(tipo.equalsIgnoreCase("listar")){
			
			try {								
				
				Vector<Usuario> usuarios  = new Vector<Usuario>();		
				usuarios = service.listarUsuarios();
				request.setAttribute("usuarios", usuarios);
				rd = getServletContext().getRequestDispatcher("/listar_usuarios.jsp");				
			} catch (Exception e) {
				
			}			
		}
		
		//*****************************INICIO MANTENER PERFIL*****************************//
			if(tipo.equalsIgnoreCase("registrarPerfil")) {
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			
			try {
				Perfil perfil = new Perfil();
				perfil.setNombre(nombre);
				perfil.setDescripcion(descripcion);
							
				
				boolean retorno = service.agregarPerfil(perfil);				
				
				if(retorno) mensaje = "Perfil agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el perfil.";	
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase("modificarPerfil")) {
			
			int id=Integer.parseInt(request.getParameter("codigo"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
				
			
			try {
				
				Perfil perfil = new Perfil();
				
				perfil.setId(id);
				perfil.setNombre(nombre);
				perfil.setDescripcion(descripcion);				
				
				boolean retorno = service.modificarPerfil(perfil);				
				
				if(retorno) mensaje = "Perfil modificado con éxito.";
				else mensaje = "Error, no se pudo modificar el perfil.";	
				
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				
				
				request.setAttribute("perfiles", perfiles);	
				
				rd = getServletContext().getRequestDispatcher("/mantener_perfil.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}else if(tipo.equalsIgnoreCase("eliminarPerfil")) {
			
			/*try {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("id")));
			
				service.eliminarProveedor(proveedor);
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
		}else if(tipo.equalsIgnoreCase("consultarPerfil")) {
			
			Perfil perfil = new Perfil();			
			
			try {
				//VALIDAR EL INGRESO DE STRING
				int id = Integer.parseInt(request.getParameter("idPerfil"));
				perfil.setId(id);
				perfil = service.consultarPerfil(perfil);
				if(perfil == null) mensaje = "No se encontraron resultados para su consulta. [Proveedor cod."+id+"]";
				else mensaje = "";
				request.setAttribute("perfil", perfil);				
				
				rd = getServletContext().getRequestDispatcher("/modificar_perfil.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(tipo.equalsIgnoreCase("listarPerfil")){
			
			try {								
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				request.setAttribute("perfiles", perfiles);
				rd = getServletContext().getRequestDispatcher("/listar_perfiles.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(tipo.equalsIgnoreCase("filtroPerfil")){
			int destino = Integer.parseInt(request.getParameter("destino"));
			String nombre = request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
					
			Vector<Perfil> perfiles = null;
			try {
				perfiles = service.buscarPerfiles(codigo,nombre);				
				request.setAttribute("perfiles", perfiles);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MANTENER_PERFIL){
				rd = getServletContext().getRequestDispatcher("/mantener_perfil.jsp");
			
			}
		}
	
		request.setAttribute("mensaje", mensaje);	
		rd.forward(request, response);			
	
	}
	

}