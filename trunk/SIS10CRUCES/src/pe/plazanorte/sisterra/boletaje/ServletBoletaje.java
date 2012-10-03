package pe.plazanorte.sisterra.boletaje;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.util.Constantes;

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
		
		String tipo = request.getParameter("tipo");
		long codViaje = Long.parseLong(request.getParameter("codViaje"));
		
		//********************************INICIO RESERVAR BOLETO DE VIAJE**********************************//		
		
		if(tipo.equals(Constantes.ACCION_RESERVAR_BOLETO)){
			
			
		}
		
		//********************************FIN RESERVAR BOLETO DE VIAJE**********************************//

		//********************************INICIO VENDER BOLETO DE VIAJE**********************************//
		
		//********************************FIN VENDER BOLETO DE VIAJE**********************************//
		
	}

}
