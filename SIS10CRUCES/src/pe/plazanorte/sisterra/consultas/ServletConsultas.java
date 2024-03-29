package pe.plazanorte.sisterra.consultas;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.plazanorte.sisterra.clasificacion.ServiceClasificacion;
import pe.plazanorte.sisterra.entidades.Chofer;
import pe.plazanorte.sisterra.entidades.Clasificacion;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.proveedor.ServiceProveedor;
import pe.plazanorte.sisterra.proveedor.ServletProveedor;
import pe.plazanorte.sisterra.util.Constantes;

/**
 * Servlet implementation class ServletConsultas
 */
@WebServlet("/ServletConsultas")
public class ServletConsultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String destino = request.getParameter("destino");
		String tipo = request.getParameter("tipo");
		RequestDispatcher rd = null;
		String mensaje = " ";
		ServiceConsultas service = new ServiceConsultas();
		//***********************************INICIO CONSULTAR VIAJE***********************************//
		
		if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VIAJE)) {
			Viaje viaje = new Viaje();
			ServiceProveedor serviceProveedor = new ServiceProveedor();
			ServiceClasificacion serviceClasificacion = new ServiceClasificacion();
			Proveedor proveedor = new Proveedor();
			HttpSession session = request.getSession(true);
			proveedor = (Proveedor)session.getAttribute("BProveedor");
			
			try {
				int idViaje = Integer.parseInt(request.getParameter("idViaje"));
				viaje = service.consultarViaje(idViaje);				
				Vector<Ruta> listaRutas = serviceProveedor.listarRuta(proveedor);
				Vector<Vehiculo> listaVehiculos = serviceProveedor.listarVehiculos(proveedor);
				Vector<Clasificacion> listaClasificaciones = serviceClasificacion.listarClasificaciones();
				Vector<Chofer> listaChoferes = serviceProveedor.listarChoferes(proveedor);
				request.setAttribute("viaje", viaje);
				request.setAttribute("listaRutas", listaRutas);
				request.setAttribute("listaVehiculos", listaVehiculos);
				request.setAttribute("listaClasificaciones", listaClasificaciones);
				request.setAttribute("listaChoferes", listaChoferes);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino.equalsIgnoreCase(Constantes.MODIFICAR_VIAJE)) {
				rd = getServletContext().getRequestDispatcher("/modificar_viaje.jsp");
			}
				
		}		
		//***********************************FIN CONSULTAR VIAJE***********************************//
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
