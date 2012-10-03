package pe.plazanorte.sisterra.boletaje;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.util.Constantes;
import sun.print.resources.serviceui;

/**
 * Servlet implementation class ServletBoletaje
 */
@WebServlet("/ServletBoletaje")
public class ServletBoletaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBoletaje() {
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
		
		ServiceBoletaje service = new ServiceBoletaje();
		String tipo = request.getParameter("tipo");
		long codViaje = Long.parseLong(request.getParameter("codViaje"));
		int nroAsiento = Integer.parseInt(request.getParameter("nroAsiento"));
		String mensaje = "Ocurrio un error";
		
		//********************************INICIO RESERVAR BOLETO DE VIAJE**********************************//		
		
		if(tipo.equals(Constantes.ACCION_RESERVAR_BOLETO)){
			
			try {
				Boleto boleto = new Boleto();
				boleto.setIdViaje(codViaje);
				boleto.setAsiento(nroAsiento);
				boolean retorno = service.reservarBoleto(boleto);
				
				if(retorno) {
					mensaje = "Boleto reservado exitosamente.";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//********************************FIN RESERVAR BOLETO DE VIAJE**********************************//

		//********************************INICIO VENDER BOLETO DE VIAJE**********************************//
		
		if(tipo.equals(Constantes.ACCION_VENDER_BOLETO)){
			
			
		}
		
		//********************************FIN VENDER BOLETO DE VIAJE**********************************//
		
	}

}
