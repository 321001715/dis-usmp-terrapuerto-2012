package pe.plazanorte.sisterra.embarque;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.util.Constantes;

/**
 * Servlet implementation class ServletEmbarque
 */
@WebServlet("/ServletEmbarque")
public class ServletEmbarque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmbarque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String destino = request.getParameter("destino");
		String mensaje = "";
		ServiceEmbarque serviceEmbarque = new ServiceEmbarque();
		
		RequestDispatcher rd = null;
		//NRO 1
		if(tipo.equalsIgnoreCase(Constantes.ACCION_PREPARAR_LISTA_PASAJEROS)) {
			try {
				long idViaje = Long.parseLong(request.getParameter("idViaje"));		
				
				Vector<Pasajero> listaPasajeros = serviceEmbarque.listarPasajerosXViaje(idViaje);
				
				request.setAttribute("listaPasajeros", listaPasajeros);
				request.setAttribute("idViaje", idViaje);
				System.out.println(destino);
				if(destino.equalsIgnoreCase(Constantes.MANIFIESTO_DE_PASAJEROS)) {
					rd = getServletContext().getRequestDispatcher("/registrar_embarque.jsp");
				}		
			} catch (Exception e) {
				System.out.println("ERROR EN NRO1: PREPARAR LISTA DE PASAJEROS");
				mensaje="OCURRIO UN ERROR";
				e.printStackTrace();
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
		String destino = request.getParameter("destino");
		String mensaje = "";
		RequestDispatcher rd = null;
		ServiceEmbarque serviceEmbarque = new ServiceEmbarque();
		
		//NRO 2
		 if(tipo.equalsIgnoreCase(Constantes.REGISTRAR_EMBARQUE)) {
			try {
				String[] idBoleto = request.getParameterValues("idBoleto");
				int idViaje = Integer.parseInt(request.getParameter("idViaje"));
				
				for (int i = 0; i < idBoleto.length; i++) {
					System.out.println(idBoleto[i]);
					serviceEmbarque.registrarEmbarque(Integer.parseInt(idBoleto[i]), idViaje);	
				}				
				
				Vector<Pasajero> pasajeros = new Vector<Pasajero>();
				
				pasajeros = serviceEmbarque.listarPasajerosXViaje(idViaje);
				
				request.setAttribute("pasajeros", pasajeros);
				rd = getServletContext().getRequestDispatcher(
				"/index_embarque.jsp");
			} catch (Exception e) {
				System.out.println("ERROR EN NRO2: REGISTRAR EMBARQUE");
				mensaje="OCURRIO UN ERROR";
				e.printStackTrace();
			}
		}
		 
		request.setAttribute("mensaje", mensaje);		
		rd.forward(request, response);
		
		
	}

}
