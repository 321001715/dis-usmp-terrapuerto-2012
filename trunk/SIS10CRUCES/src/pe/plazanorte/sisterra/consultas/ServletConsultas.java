package pe.plazanorte.sisterra.consultas;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.clasificacion.ServiceClasificacion;
import pe.plazanorte.sisterra.entidades.Chofer;
import pe.plazanorte.sisterra.entidades.Clasificacion;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.proveedor.ServiceProveedor;
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
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destino = request.getParameter("destino");
		String tipo = request.getParameter("tipo");
		RequestDispatcher rd = null;
		ServiceConsultas service = new ServiceConsultas();
		//***********************************INICIO CONSULTAR VIAJE***********************************//
		
		if(tipo.equalsIgnoreCase(Constantes.ACCION_CONSULTAR_VIAJE)) {
			Viaje viaje = new Viaje();
			
			try {
				int idViaje = Integer.parseInt(request.getParameter("idViaje"));
				viaje = service.consultarViaje(idViaje);
				request.setAttribute("viaje", viaje);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (destino == Constantes.MODIFICAR_VIAJE) {
				rd = getServletContext().getRequestDispatcher("/modificar_viaje.jsp");
			}	
			
		}
		
		//***********************************FIN CONSULTAR VIAJE***********************************//
	}

}
