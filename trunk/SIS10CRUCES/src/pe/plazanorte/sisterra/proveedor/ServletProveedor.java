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
import pe.plazanorte.sisterra.entidades.Vehiculo;
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
		
		
		//*****************************INICIO MANTENER PROVEEDOR*****************************//
		
		if(tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_PROVEEDOR)){						
		
			try {
				Vector<Proveedor> proveedores = new Vector<Proveedor>();				
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);	
				String destino = request.getParameter("destino");
				if(destino == null){
					rd = getServletContext().getRequestDispatcher("/listar_proveedores.jsp");
				}else if(Integer.parseInt(destino) == Constantes.MANTENER_PROVEEDOR){					
					rd = getServletContext().getRequestDispatcher("/mantener_proveedor.jsp");
				}else if(Integer.parseInt(destino) == Constantes.ELIMINAR_PROVEEDOR){
					rd = getServletContext().getRequestDispatcher("/eliminar_proveedor.jsp");
				}
				
				request.setAttribute("proveedores", proveedores);	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_PROVEEDOR)){
			Proveedor proveedor = new Proveedor();	
			int destino = Integer.parseInt(request.getParameter("destino"));			
			try {
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor")));			
				proveedor = service.consultarProveedor(proveedor);				
				request.setAttribute("proveedor", proveedor);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MODIFICAR_PROVEEDOR){
				rd = getServletContext().getRequestDispatcher("/modificar_proveedor.jsp");
			}		
		} else if(tipo.equalsIgnoreCase("eliminar")){
		/*	Proveedor proveedor = new Proveedor();	
			int destino = Integer.parseInt(request.getParameter("destino"));			
			try {
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor")));			
				boolean respuesta = service.eliminarProveedor(proveedor);
				if(respuesta){
					request.setAttribute("proveedor", proveedor);
					mensaje = "Proveedor deshabilitado.";
				}else {mensaje = "Ocurrió un error."; }
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MODIFICAR_PROVEEDOR){
				rd = getServletContext().getRequestDispatcher("/modificar_proveedor.jsp");
			}	*/	
		}
		
		//*****************************FIN MANTENER PROVEEDOR*****************************//
		
		//*****************************INICIO GESTIONAR VEHICULO*****************************//
		
				if(tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_VEHICULO)){						
				
					try {
						Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();				
						vehiculos = service.listarVehiculos();
						request.setAttribute("vehiculos", vehiculos);	
						String destino = request.getParameter("destino");
						if(destino == null){
							rd = getServletContext().getRequestDispatcher("/listar_vehiculos.jsp");
						}else if(Integer.parseInt(destino) == Constantes.GESTIONAR_VEHICULO){					
							rd = getServletContext().getRequestDispatcher("/gestion_vehiculos.jsp");
						}else if(Integer.parseInt(destino) == Constantes.ELIMINAR_PROVEEDOR){
							rd = getServletContext().getRequestDispatcher("/eliminar_proveedor.jsp");
						}
						
						request.setAttribute("proveedores", vehiculos);	
					} catch (Exception e) {
						e.printStackTrace();
					}			
				}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VEHICULO)){
					Vehiculo vehiculo = new Vehiculo();	
					int destino = Integer.parseInt(request.getParameter("destino"));			
					try {
						vehiculo.setIdProveedor(Integer.parseInt(request.getParameter("idVehiculo")));			
						vehiculo = service.consultarVehiculo(vehiculo);				
						request.setAttribute("vehiculo", vehiculo);				
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(destino == Constantes.MODIFICAR_VEHICULO){
						rd = getServletContext().getRequestDispatcher("/modificar_vehiculo.jsp");
					}		
				} else if(tipo.equalsIgnoreCase("eliminar")){
				/*	Proveedor proveedor = new Proveedor();	
					int destino = Integer.parseInt(request.getParameter("destino"));			
					try {
						proveedor.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor")));			
						boolean respuesta = service.eliminarProveedor(proveedor);
						if(respuesta){
							request.setAttribute("proveedor", proveedor);
							mensaje = "Proveedor deshabilitado.";
						}else {mensaje = "Ocurrió un error."; }
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(destino == Constantes.MODIFICAR_PROVEEDOR){
						rd = getServletContext().getRequestDispatcher("/modificar_proveedor.jsp");
					}	*/	
				}
				
				//*****************************FIN GESTIONAR VEHICULO*****************************//
		
		
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
	
		
		//*****************************INICIO MANTENER PROVEEDOR*****************************//
		
		if(tipo.equalsIgnoreCase(Constantes.ACCION_REGISTRAR_PROVEEDOR)) {
			
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
				proveedor.setDireccion(direccion);				
				
				boolean retorno = service.agregarProveedor(proveedor);				
				
				if(retorno) mensaje = "Proveedor agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el proveedor.";
				
				Vector<Proveedor> proveedores = new Vector<Proveedor>();				
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);	
				
				rd = getServletContext().getRequestDispatcher("/mantener_proveedor.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_MODIFICAR_PROVEEDOR)) {
			
			long codigo = Long.parseLong(request.getParameter("codigo"));
			String ruc = request.getParameter("ruc");
			String razonSocial = request.getParameter("razon_social");
			String razonComercial = request.getParameter("razon_comercial");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String estado = request.getParameter("estado");
			String direccion = request.getParameter("direccion");			
			
			try {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(codigo);
				proveedor.setRuc(ruc);	
				proveedor.setRazonSocial(razonSocial);
				proveedor.setRazCom(razonComercial);
				proveedor.setEstado(estado);
				proveedor.setTel(telefono);
				proveedor.setDireccion(direccion);				
				
				boolean retorno = service.modificarProveedor(proveedor);				
				
				if(retorno) mensaje = "Proveedor modificado con éxito.";
				else mensaje = "Error, no se pudo modificar el proveedor.";	
				
				Vector<Proveedor> proveedores = new Vector<Proveedor>();				
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);	
				
				rd = getServletContext().getRequestDispatcher("/mantener_proveedor.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}else if(tipo.equalsIgnoreCase("eliminar")) {
			
			/*try {
				Proveedor proveedor = new Proveedor();
				proveedor.setIdProveedor(Integer.parseInt(request.getParameter("id")));
			
				service.eliminarProveedor(proveedor);
				
				rd = getServletContext().getRequestDispatcher("/index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_PROVEEDOR)) {
			
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
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_PROVEEDOR)){
			
			try {								
				Vector<Proveedor> proveedores = new Vector<Proveedor>();				
				proveedores = service.listarProveedores();
				request.setAttribute("proveedores", proveedores);
				rd = getServletContext().getRequestDispatcher("/listar_proveedores.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_FILTRO_PROVEEDOR)){
			int destino = Integer.parseInt(request.getParameter("destino"));
			String ruc = request.getParameter("ruc");
			String razSocial = request.getParameter("razSocial");
			Vector<Proveedor> proveedores = null;
			try {
				proveedores = service.buscarProveedores(ruc, razSocial);				
				request.setAttribute("proveedores", proveedores);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.MANTENER_PROVEEDOR){
				rd = getServletContext().getRequestDispatcher("/mantener_proveedor.jsp");
			}
		}				
		
		//*****************************FIN MANTENER PROVEEDOR*****************************//
		
		
		//*****************************INICIO GESTIONAR VEHICULO*****************************//
		
		if(tipo.equalsIgnoreCase(Constantes.ACCION_REGISTRAR_VEHICULO)) {
			
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String placa = request.getParameter("placa");
			int numPiso = Integer.parseInt(request.getParameter("numPiso"));
			int numAsientos = Integer.parseInt(request.getParameter("numAsientos"));
			String obs = request.getParameter("obs");
			
			try {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setMarca(marca);
				vehiculo.setModelo(modelo);
				vehiculo.setPlaca(placa);
				vehiculo.setNumPiso(numPiso);
				vehiculo.setNumAsientos(numAsientos);
				vehiculo.setObs(obs);
				
				boolean retorno = service.agregarVehiculo(vehiculo);				
				
				if(retorno) mensaje = "Vehículo agregado con éxito.";
				else mensaje = "Error, no se pudo registrar el vehículo.";	
				
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();				
				vehiculos = service.listarVehiculos();
				request.setAttribute("vehiculos", vehiculos);	
				
				rd = getServletContext().getRequestDispatcher("/gestion_vehiculos.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_MODIFICAR_VEHICULO)) {
			
			long idVehiculo = Long.parseLong(request.getParameter("idVehiculo"));			
			String estado = request.getParameter("estado");
			String obs = request.getParameter("obs");
			
			try {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setIdVehiculo(idVehiculo);				
				vehiculo.setObs(obs);
				vehiculo.setEstado(estado);
				
				boolean retorno = service.modificarVehiculo(vehiculo);				
				
				if(retorno) mensaje = "Vehículo modificado con éxito.";
				else mensaje = "Error, no se pudo modificar el vehículo.";	
				
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();				
				vehiculos = service.listarVehiculos();
				request.setAttribute("vehiculos", vehiculos);	
				
				rd = getServletContext().getRequestDispatcher("/gestion_vehiculos.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VEHICULO)) {
			
			Vehiculo vehiculo = new Vehiculo();			
			
			try {				
				int id = Integer.parseInt(request.getParameter("idVehiculo"));
				vehiculo.setIdVehiculo(id);			
				vehiculo = service.consultarVehiculo(vehiculo);
				if(vehiculo == null) mensaje = "No se encontraron resultados para su consulta. [Vehiculo cod."+id+"]";
				else mensaje = "";
				request.setAttribute("proveedor", vehiculo);				
				
				rd = getServletContext().getRequestDispatcher("/modificar_vehiculo.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_LISTAR_VEHICULO)){
			
			try {								
				Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();				
				vehiculos = service.listarVehiculos();
				request.setAttribute("vehiculos", vehiculos);
				rd = getServletContext().getRequestDispatcher("/listar_vehiculos.jsp");				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(tipo.equalsIgnoreCase(Constantes.ACCION_FILTRO_VEHICULO)){
			int destino = Integer.parseInt(request.getParameter("destino"));
			long idVehiculo = Long.parseLong(request.getParameter("idVehiculo"));
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String placa = request.getParameter("placa");
			
			Vehiculo vehiculo = new Vehiculo();
			
			vehiculo.setIdVehiculo(idVehiculo);
			vehiculo.setMarca(marca);
			vehiculo.setModelo(modelo);
			vehiculo.setPlaca(placa);
			
			Vector<Vehiculo> vehiculos = null;
			try {
				vehiculos = service.buscarVehiculo(vehiculo);				
				request.setAttribute("vehiculos", vehiculos);						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(destino == Constantes.GESTIONAR_VEHICULO){
				rd = getServletContext().getRequestDispatcher("/gestion_vehiculos.jsp");
			}
		}	
		
		//*****************************FIN GESTIONAR VEHICULO*****************************//

		
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
	}

}
