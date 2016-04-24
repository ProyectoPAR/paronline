<%--
    Document   : Producto
    Created on : 18/04/2016, 11:17:31 PM
    Author     : root
--%>
<%@page import = "javax.servlet.http.HttpSession"
        import  = "componentes.Producto"
        import = "java.util.ArrayList"
        import = "javax.servlet.http.HttpServletResponse" 
        import = "java.io.PrintWriter"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Producto> productos = new ArrayList<Producto>();
    productos = (ArrayList)session.getAttribute("lista_productos");
    
    
%>
<%!
    public ArrayList<String> getCategorias(){
        <ArrayList> categorias = new <ArrayList>();
        return categorias;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Paronline</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css" charset="utf-8">
    </head>
    <body>
        <header>
          <div class="">
            <nav>
              <ul>
                <li> <form action="Usuario" method="get"><input type="submit" value="Usuario"/></form> </li>
                <li> <form action="Producto" method="get"><input type="submit" value="Producto"/></form> </li>
                <li> <form action="Carrito" method="get"><input type="submit" value="Carrito"/></form> </li>
              </ul>
            </nav>
          </div>
        </header>
        <section>
            <form action="Producto" method="get">
                <select name="categoria">
                    <option value="default">---</option>
                    <option value="Deportes">Deportes</option>
                </select>
                <input type="text" name="descripcion" placeholder="Escriba una descripcion del producto"/>
                <input type="submit" value="Buscar"/>
            </form>
            <%
                for(int i = 0 ; i < productos.size() ; i ++){%>
                <div><%=productos.get(i)%> <a href="Carrito">Agregar</a></div>
                <%}
            %>
        </section>
    </body>
</html>
