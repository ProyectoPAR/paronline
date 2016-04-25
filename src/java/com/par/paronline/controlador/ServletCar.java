/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class ServletCar extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            String descripcion = (String)session.getAttribute("des_producto");
            String precio = (String) session.getAttribute("p_producto");
            out.println("<!DOCTYPE html>\n"+
                    "<html>\n" +
                    "    <head>\n" +
                    "        <title>Paronline</title>\n" +
                    "        <meta charset=\"UTF-8\">\n" +
                    "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "        <link rel=\"stylesheet\" href=\"css/login.css\" charset=\"utf-8\">\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        <header>\n" +
                    "          <div class=\"\">\n" +
                    "            <nav>\n" +
                    "              <ul>\n" +
                    "                <li><a href=\"Usuario\">Usuario</a></li>\n" +
                    "                <li><a href=\"Producto\">Producto</a></li>\n" +
                    "                <li><a href=\"#\">Carrito</a></li>\n" +
                    "              </ul>\n" +
                    "            </nav>\n" +
                    "          </div>\n" +
                    "        </header>\n" +
                             "<section> <h1> Procutos en el carrito"+ descripcion+": "+precio+
                                        "</hi>"+
                    "    </body>\n" +
                    "</html>");
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
