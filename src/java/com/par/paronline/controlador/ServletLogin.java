/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.par.paronline.controlador;

import com.par.paronline.modelo.ManagerDB;
import com.par.paronline.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.par.paronline.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author root
 */
public class ServletLogin extends HttpServlet {

    public Usuario comprobarLogin(String user,String pass) throws SQLException, ClassNotFoundException, Exception{
    Usuario u = null;
    ArrayList<String> args = new ArrayList();
    args.add(user);
    args.add(pass);
    String sql = "select * from persona where usuario = ? and pass = ?;";
    ManagerDB man = new ManagerDB();
    man.consultar(sql, args);
    if(man.getResult().next()){
        Usuario us = new Usuario();
        us.setUsuario(man.getResult().getString("usuario"));
        us.setPass(man.getResult().getString("pass")); 
        return us;
    }

    return u;
    }
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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Usuario u = comprobarLogin(request.getParameter("user"),request.getParameter("pass"));
            if (u != null){
                request.getSession().setAttribute("user", u.getUsuario()); //se setea la sesion con el username registrado
                response.sendRedirect("producto.jsp"); //redirecciona a esta pagina mientras tanto averiguo como redireccionar 
                //a la pagina de donde se vino
            }else{
                out.println("Nombre de usuario o contrasenha no validos. Intente de nuevo");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request,response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
