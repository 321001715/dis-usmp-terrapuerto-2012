package pe.plazanorte.sisterra.proveedor;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.util.Constantes;

/**
 * Servlet implementation class ServletEmpresa
 */
@WebServlet("/ServletProveedor")
public class ServletProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo");
		String mensaje = "Ocurrió un error.";
		
		ServiceProveedor service = new ServiceProveedor();
		
		RequestDispatcher rd = null;
		
		if(tipo.equalsIgnoreCase("listar")){						
		
			try {
				Vector<Proveedor> proveedores = new Vector<Proveedor>();				
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);	
				String origen = request.getParameter("origen");
				if(origen == null){
					rd = getServletContext().getRequestDispatcher("/listar_proveedores.jsp");
				}else if(Integer.parseInt(origen) == Constantes.MENU_PRINCIPAL){
					rd = getServletContext().getRequestDispatcher("/mantener_proveedor.jsp");
				}
				request.setAttribute("proveedores", proveedores);	
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
		String mensaje = "Ocurrió un error.";
		
		ServiceProveedor service = new ServiceProveedor();
		
		RequestDispatcher rd = null;
	
		if(tipo.equalsIgnoreCase("registrar")) {
			
			String ruc = request.getParameter("ruc");
			String razonSocial = request.getParameter("razon_social");
			String razonComercial = request.getParameter("razon_comercial");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String direccion = request.getParameter("direccion");			
			
			try {
				Proveedor proveedor = new Proveedor();
				proveedor.setRuc(ruc);	
				proveedor.setRazonSocial(razonSocial);
				proveedor.setRazCom(razonComercial);
				proveedor.setTel(telefono);
				proveedor.setDirec(direccion);				
				
				boolean retorno = service.agregarProveedor(proveedor);				
				
				if(retorno) mensaje = "Proveedor agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el proveedor.";	
				
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
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(codigo);
				proveedor.setRuc(ruc);	
				proveedor.setRazonSocial(razonSocial);
				proveedor.setRazCom(razonComercial);
				proveedor.setTel(telefono);
				proveedor.setDirec(direccion);				
				
				boolean retorno = service.modificarProveedor(proveedor);				
				
				if(retorno) mensaje = "Proveedor modificado con éxito.";
				else mensaje = "Error, no se pudo modificar el proveedor.";	
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}else if(tipo.equalsIgnoreCase("eliminar")) {
			
			try {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("id")));
			
				service.eliminarProveedor(proveedor);
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase("consultar")) {
			
			Proveedor proveedor = new Proveedor();			
			
			try {
				//VALIDAR EL INGRESO DE STRING
				int id = Integer.parseInt(request.getParameter("idProveedor"));
				proveedor.setIdProveedor(id);			
				proveedor = service.consultarProveedor(proveedor);
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
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);
				rd = getServletContext().getRequestDispatcher("/listar_proveedores.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}				
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

}
