package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.ListaProductos;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    ListaProductos carrito = new ListaProductos();
    request.getSession(true);
    session.setAttribute("user", "unknow");
    session.setAttribute("carrito", carrito);


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Paronline</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\" charset=\"utf-8\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("          <div class=\"\">\r\n");
      out.write("            <nav>\r\n");
      out.write("              <ul>\r\n");
      out.write("                <li> <form action=\"Usuario\" method=\"get\"><input type=\"submit\" value=\"Usuario\"/></form> </li>\r\n");
      out.write("                <li> <a href=\"Producto\">Producto</a>\r\n");
      out.write("                <li> <a href=\"Carrito.jsp\"> Carrito</a> </li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("          </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <section>\r\n");
      out.write("            <div>\r\n");
      out.write("                <<form action=\"Login\" method=\"post\">\r\n");
      out.write("                    <input type=\"text\" name=\"user\" placeholder=\"Ingrese su nombre\"/>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <input type=\"password\" name=\"pass\" placeholder=\"Ingrese su pass\"/>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <input type=\"button\" name=\"registrarse\" value=\"Registrate\"/>\r\n");
      out.write("                    <input type=\"submit\" name=\"acceder\" value=\"Acceder\"/>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
