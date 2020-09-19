import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //String nombreDeTarjeta = request.getParameter("nombre");
        //int numeroDeTarjeta = Integer.parseInt(request.getParameter("numero"));        
        //TarjetaDeCredito tarjeta = new TarjetaDeCredito();    
        //tarjeta.setNombreDeTarjeta(request.getParameter("nombre"));
        //tarjeta.setNumeroDeTarjeta(request.getParameter("numero"));
        
        String carne = request.getParameter("carne");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String genero = request.getParameter("genero");
        
        StringBuffer res = new StringBuffer();
        Writer ajaxSalida =  response.getWriter(); 
        
        Alumno alumno = new Alumno();    
        
        try(PrintWriter out = response.getWriter()) {
          alumno.insert(carne, nombre, apellido, correo, genero, res);
          alumno.consultarRegistros(res);  // CONSULTAMOS
          ajaxSalida.write(res.toString());
          ajaxSalida.flush();
          ajaxSalida.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
