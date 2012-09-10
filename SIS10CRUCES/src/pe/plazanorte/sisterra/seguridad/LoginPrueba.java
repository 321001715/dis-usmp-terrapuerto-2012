package pe.plazanorte.sisterra.seguridad;

import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDAO;
import java.net.InetAddress;
import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;


/**modified for administrator jul 2003 */
public class LoginPrueba extends HttpServlet {
    /** Initializes the servlet.
     */
    private String msgError;
    InitialContext context = null;
    DataSource pool = null;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);

   
    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    /**/ protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException {
        HttpSession session = request.getSession(true);
       
       
   
        try {
            Usuario uu = new Usuario();
            uu.setUsuario(request.getParameter("usuario").toUpperCase());
            uu.setClave(request.getParameter("password"));
            uu.setIdTipUsuario(Integer.parseInt(request.getParameter("esc")));
          

            MySqlSeguridadDAO du = new MySqlSeguridadDAO();
      
       //   String ip = request.getParameter("ip");
   
        //    String host = request.getParameter("host");
           
        //    VeriHostDAO vh =new VeriHostDAO();
        //    GetPublicHostname gt=new GetPublicHostname();
        
         
     
                if (du.validarUser(uu)) {
                	 
                //	Vector<Programa> prls = new Vector<Programa>();
                	
                        
                          session.setAttribute("BUsuario", uu);
                       //   session.setAttribute("listaprog", prls);
                         // session.setAttribute("ip",ip);
                        //  session.setAttribute("host",host); 
                           uu = (Usuario) session.getAttribute("BUsuario");
   
                          getServletContext().getRequestDispatcher("/presentacion.jsp").forward(request,response);
                    
                    
                    
        }else {
                   
                    getServletContext().getRequestDispatcher("/loginPrueba.jsp").forward(request,response);
                }
            /*}else{
              getServletContext().getRequestDispatcher("/Error.html").forward(request,response);
            }*/
        } catch (Exception sq) {
            System.out.println("No cerro la conexion "+sq.getCause());
        }
    }

    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
