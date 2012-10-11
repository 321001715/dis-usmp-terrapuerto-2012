package pe.plazanorte.sisterra.seguridad;

import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Persona;
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
				Vector<Perfil> perfiles = new Vector<Perfil>();	
				usuarios = service.listarUsuarios();
				request.setAttribute("usuarios", usuarios);	
				String origen = request.getParameter("origen");
				if(origen == null){
					rd = getServletContext().getRequestDispatcher("/listar_usuarios.jsp");
				}else if(Integer.parseInt(origen) == Constantes.MENU_PRINCIPAL){
					perfiles = service.listarPerfiles();
					
					request.setAttribute("perfiles", perfiles);	
					rd = getServletContext().getRequestDispatcher("/mantener_usuario.jsp");
				}
				request.setAttribute("usuarios", usuarios);	
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else if(tipo.equalsIgnoreCase("agregarUsuario")){
			String busqueda="nobuscar";
			Persona persona=new Persona();
			try {
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				persona=null;
				request.setAttribute("busqueda", busqueda);	
				request.setAttribute("persona", persona);	
				request.setAttribute("perfiles", perfiles);	
				rd = getServletContext().getRequestDispatcher("/registrar_usuario.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		else if(tipo.equalsIgnoreCase("listarPerfiles")){
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
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_USUARIO)){
				Usuario usuario = new Usuario();	
				Vector<Perfil> perfiles = new Vector<Perfil>();	
				
				int destino = Integer.parseInt(request.getParameter("destino"));			
				try {
					usuario.setId(Integer.parseInt(request.getParameter("idUsuario")));
							
					usuario = service.consultarUsuario(usuario);
					perfiles = service.listarPerfiles();
					
					request.setAttribute("perfiles", perfiles);	
					request.setAttribute("usuario", usuario);						
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(destino == Constantes.MODIFICAR_USUARIO){
					
					rd = getServletContext().getRequestDispatcher("/modificar_usuario.jsp");
				}
				
			}
			
		else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_PERFIL)){
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
		String mensaje = "Ocurrió un error.";
		
		ServiceSeguridad service = new ServiceSeguridad();
		
		RequestDispatcher rd = null;
		//*****************************INICIO MANTENER USUARIO*****************************//
		
		if(tipo.equalsIgnoreCase("registrar")) {
			
			
			String user = request.getParameter("txt_usuario");
			String pass = request.getParameter("txt_pass");
			int dni = Integer.parseInt(request.getParameter("txt_dni"));
			int perfil = Integer.parseInt(request.getParameter("sel_perfil"));
			String estado = request.getParameter("estado");
			String nom=	request.getParameter("txt_nombre");	
			String apepat=request.getParameter("txt_apePat");
			String apemat=request.getParameter("txt_apeMat");
			try {
				Usuario usuario=new Usuario();
				
				usuario.setUsuario(user.toUpperCase());
				usuario.setClave(pass);
				usuario.setDni(dni);
				usuario.setEstado(estado.toUpperCase());
				usuario.setNombres(nom.toUpperCase());
				usuario.setApePat(apepat.toUpperCase());	
				usuario.setApeMat(apemat.toUpperCase());	
				usuario.setIdTipUsuario(perfil);
				
				
				
				boolean retorno = service.agregarUsuario(usuario);	
				if (retorno) {
					
					Usuario usu=service.buscarUsuario(user.toUpperCase());
					
					if(perfil==20){
						Cliente cliente=new Cliente();
						cliente.setApeMat(usu.getApeMat());
						cliente.setApePat(usu.getApePat());
						cliente.setCodClienteFrecuente("");
						cliente.setDireccion(usu.getDireccion());
						cliente.setEmail(usu.getDireccion());
						cliente.setIdUsuario(usu.getId());
						cliente.setIdUbigeo((int)usu.getIdCiudad());
						cliente.setNombres(usu.getNombres());
						cliente.setNumDoc(usu.getDni()+"");
						cliente.setSexo(usu.getSexo());
						cliente.setTel(usu.getTel()+"");
						cliente.setTipoDoc("");/*TODO*/
						
						
						boolean ret=service.agregarCliente(cliente);
					}
				}
				
				if(retorno) mensaje = "Usuario agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el usuario.";	
				
				Vector<Usuario> usuarios = new Vector<Usuario>();	
				
				usuarios = service.listarUsuarios();
				request.setAttribute("usuarios", usuarios);
				
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				request.setAttribute("perfiles", perfiles);	
				
				rd = getServletContext().getRequestDispatcher("/mantener_usuario.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase("modificar")) {
			
			String user = request.getParameter("txt_usuario");
			String pass = request.getParameter("txt_pass");
			int dni = Integer.parseInt(request.getParameter("txt_dni"));
			int idtipo = Integer.parseInt(request.getParameter("idTipoUsuario"));
			int id=Integer.parseInt(request.getParameter("id"));
			String estado = request.getParameter("estado");
			String nom=	request.getParameter("txt_nombre");	
			String apepat=request.getParameter("txt_apePat");
			String apemat=request.getParameter("txt_apeMat");		
			
			try {
				Usuario usuario=new Usuario();
				usuario.setId(id);
				usuario.setUsuario(user.toUpperCase());
				usuario.setClave(pass);
				usuario.setDni(dni);
				usuario.setEstado(estado.toUpperCase());
				usuario.setNombres(nom.toUpperCase());
				usuario.setIdTipUsuario(idtipo);
				usuario.setApePat(apepat.toUpperCase());	
				usuario.setApeMat(apemat.toUpperCase());				
				
				
			
				
				boolean retorno = service.modificarUsuario(usuario);				
				
				if(retorno) mensaje = "Usuario modificado con éxito.";
				else mensaje = "Error, no se pudo modificar el usuario.";
				
				
				
				Vector<Usuario> usuarios = new Vector<Usuario>();				
				usuarios = service.listarUsuarios();
				request.setAttribute("usuarios", usuarios);	
				
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				request.setAttribute("perfiles", perfiles);	
				
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
		}else if(tipo.equalsIgnoreCase("buscarDni")){
			int dnipers=Integer.parseInt(request.getParameter("dni"));
			Persona unapersona=new Persona();
			String busqueda=Constantes.ACCION_BUSQUEDA_NO_REALIZADA;
			try {								
				unapersona=service.consultarPersona(dnipers);
				if(unapersona!=null){
					busqueda=Constantes.ACCION_BUSQUEDA_REALIZADA;
				}
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				request.setAttribute("perfiles", perfiles);	
				request.setAttribute("busqueda", busqueda);
				request.setAttribute("unapersona", unapersona);
				
				
				rd = getServletContext().getRequestDispatcher("/registrar_usuario.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
		}else if(tipo.equalsIgnoreCase("filtroUsuario")){
			int destino = Integer.parseInt(request.getParameter("destino"));
			String usuario = request.getParameter("usuario");
			String apellido = request.getParameter("apellido");
			String perfil = request.getParameter("perfil");
			String dni = request.getParameter("dni");
			
			Vector<Usuario> usuarios = null;
			Vector<Perfil> perfiles = new Vector<Perfil>();	
			
			try {
				usuarios = service.buscarUsuarios(usuario, perfil, apellido, dni);				
				request.setAttribute("usuarios", usuarios);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MANTENER_USUARIO){
				perfiles = service.listarPerfiles();
				request.setAttribute("perfiles", perfiles);	
				rd = getServletContext().getRequestDispatcher("/mantener_usuario.jsp");
			
			}
			
		}
		
		//*****************************INICIO MANTENER PERFIL*****************************//
			if(tipo.equalsIgnoreCase("registrarPerfil")) {
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			
			try {
				Perfil perfil = new Perfil();
				perfil.setNombre(nombre.toUpperCase());
				perfil.setDescripcion(descripcion.toUpperCase());
							
				
				boolean retorno = service.agregarPerfil(perfil);				
				
				if(retorno) mensaje = "Perfil agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el perfil.";	
				
				Vector<Perfil> perfiles = new Vector<Perfil>();				
				perfiles = service.listarPerfiles();
				
				
				request.setAttribute("perfiles", perfiles);
				rd = getServletContext().getRequestDispatcher("/mantener_perfil.jsp");
				
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
				perfil.setNombre(nombre.toUpperCase());
				perfil.setDescripcion(descripcion.toUpperCase());				
				
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
	
			if(tipo.equalsIgnoreCase(Constantes.ACCION_RECUPERAR_CONTRASENA)){
				String usuario = request.getParameter("usuario");
				int destino = Integer.parseInt(request.getParameter("destino"));
				System.out.println("usuario: "+usuario);
				
				Usuario usuVal=service.recuperarclave(usuario);
				
				
				final String username = "dis.46h.usmp.2012@gmail.com";
				final String password = "alamierdalosjudas";

				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				Session session = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								
								return new PasswordAuthentication(username,
										password);
								
							}
						});
				try {
					System.out.println("mail: "+usuVal.getEmail());
					
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("sisetepl@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(usuVal.getEmail()));
					message.setSubject("Olvido su contraseña");
					message.setText("Estimado: " + usuVal.getNombres()
							+ "\n\n Su contraseña es: " + usuVal.getClave());

					Transport.send(message);

					System.out.println("Done");
					
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				if(destino == Constantes.MENU_PRINCIPAL){
					rd = getServletContext().getRequestDispatcher("/login.jsp");
				
				}
			}
			
		request.setAttribute("mensaje", mensaje);	
		rd.forward(request, response);			
	
	}
	

	
	
	

}