<%-- 
    Document   : Carrito
    Created on : 19/04/2016, 12:14:54 AM
    Author     : root
--%>
<%@page 
        import  = "com.par.paronline.modelo.Producto"
        import = "java.util.ArrayList"
        import = "java.sql.SQLException" 
        import = "java.io.PrintWriter"
        import = "com.par.paronline.modelo.ListaProductos"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/login.css" charset="utf-8">
    </head>
    <body>
        <header>
          <div class="">
            <nav>
              <ul>
                <li> <form action="Usuario" method="get"><input type="submit" value="Usuario"/></form> </li>
                <li> <form action="Producto" method="get"><input type="submit" value="Producto"/></form> </li>
                <li> <a href="Carrito.jsp"> Carrito</a> </li>
              </ul>
            </nav>
          </div>
        </header>
        <form action="ServletPop" method="get">
            <%
                ListaProductos carrito = (ListaProductos)session.getAttribute("carrito");
                if(carrito.size() > 0){
                    for(int i = 0 ; i < carrito.size() ; i ++){%>
                    <div>
                        <input type="text" name="descripcion" value="<%=carrito.get(i).getDescripcion()%>" readonly="yes">
                        <input type="submit" name="agregar" value="Sacar">
                    </div>
                    <%}
                }
                else{%>
                    <h2>El carrito esta vacio</h2>
              <%}
            %>
        </form>
        <a href="ServletCompra">Comprar Productos</a>
        <div><%= (String)request.getAttribute("javax.servlet.forward.request_uri")%></div>
    </body>
</html>
