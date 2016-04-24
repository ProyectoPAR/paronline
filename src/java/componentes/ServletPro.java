/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author root
 */
public class ServletPro extends HttpServlet {
    String descripcion_prod = "";
    String precio = "";
    String id_producto = "";
    String categoria = "";
    String query = "";
    ArrayList<Producto> productos = new ArrayList<Producto>();
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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        
        try{
            String url = "jdbc:postgresql://localhost:5432/paronline";
            Conexion c = new Conexion(url,"postgres","sate150495");
            c.consultar("select p.descripcion pdes, c.descripcion cdes, p.precio precio from Producto p, Categoria c where p.id_categoria = c.id_categoria;");
            while(c.getResult().next()){
                
                categoria = c.getResult().getString("pdes");
                descripcion_prod = c.getResult().getString("cdes");
                precio = c.getResult().getString("precio");
                productos.add(new Producto(id_producto,categoria,descripcion_prod,precio));
            }
            c.cerrarConexion();
            session.setAttribute("lista_productos", productos);
            response.sendRedirect("Producto.jsp");
        }
        catch(Exception e){
            session.setAttribute("excepcion", e);
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
