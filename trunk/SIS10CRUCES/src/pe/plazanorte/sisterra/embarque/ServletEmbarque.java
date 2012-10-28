package pe.plazanorte.sisterra.embarque;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.plazanorte.sisterra.entidades.Pasajero;
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
		RequestDispatcher rd = null;
		//NRO 1
		if(tipo.equalsIgnoreCase(Constantes.ACCION_PREPARAR_LISTA_PASAJEROS)) {
			try {
				long idViaje = Long.parseLong(request.getParameter("idViaje"));
				
				ServiceEmbarque serviceEmbarque = new ServiceEmbarque();
				
				Vector<Pasajero> listaPasajeros = serviceEmbarque.listarPasajerosXViaje(idViaje);
				
				request.setAttribute("listaPasajeros", listaPasajeros);
				
				if(destino.equalsIgnoreCase(Constantes.MANIFIESTO_DE_PASAJEROS)) {
					rd = getServletContext().getRequestDispatcher("/index_ventas.jsp");
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
		// TODO Auto-generated method stub
	}

}
