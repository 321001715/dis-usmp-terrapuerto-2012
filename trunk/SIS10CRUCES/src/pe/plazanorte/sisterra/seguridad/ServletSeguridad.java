package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.util.Constantes;

/**
 * Servlet implementation class ServletEmpresa
 */
@WebServlet("/ServletProveedor")
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
		String mensaje = "Ocurri� un error.";
		
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
		}else if(tipo.equalsIgnoreCase("consultar")){
			/*Proveedor proveedor = new Proveedor();			
			
			try {
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor")));			
				proveedor = service.consultarProveedor(proveedor);				
				request.setAttribute("proveedor", proveedor);				
				rd = getServletContext().getRequestDispatcher("/listar_proveedores.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		}
		
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurri� un error.";
		
		ServiceSeguridad service = new ServiceSeguridad();
		
		RequestDispatcher rd = null;
	
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
				
				if(retorno) mensaje = "Usuario agregado con �xito.";
				else mensaje = "Error, no se pudo registrar el usuario.";	
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase("modificar")) {
			
			long codigo = Long.parseLong(request.getParameter("codigo"));
			String ruc = request.getParameter("ruc");
			String razonSocial = request.getParameter("razon_social");
			String razonComercial = request.getParameter("razon_comercial");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String direccion = request.getParameter("direccion");			
			
			try {
				Usuario usuario=new Usuario();
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(codigo);
				proveedor.setRuc(ruc);	
				proveedor.setRazonSocial(razonSocial);
				proveedor.setRazCom(razonComercial);
				proveedor.setTel(telefono);
				proveedor.setDireccion(direccion);				
				
				boolean retorno = service.modificarUsuario(usuario);				
				
				if(retorno) mensaje = "Proveedor modificado con �xito.";
				else mensaje = "Error, no se pudo modificar el proveedor.";	
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
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
				if(proveedor == null) mensaje = "No se encontraron resultados para su consulta. [Proveedor cod."+id+"]";
				else mensaje = "";
				request.setAttribute("proveedor", proveedor);				
				
				rd = getServletContext().getRequestDispatcher("/modificar_proveedor.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(tipo.equalsIgnoreCase("listar")){
			
			try {								
				Vector<Proveedor> proveedores = new Vector<Proveedor>();
				Vector<Usuario> usuarios = new Vector<Usuario>();		
				usuarios = service.listarUsuarios();
				request.setAttribute("proveedores", proveedores);
				rd = getServletContext().getRequestDispatcher("/listar_proveedores.jsp");				
			} catch (Exception e) {
				
			}			
		}				
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

}