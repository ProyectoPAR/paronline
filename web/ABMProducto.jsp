<%-- 
    Document   : ABMProducto
    Created on : 01/05/2016, 10:20:47 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import = "com.par.paronline.modelo.ListaProductos"%>

<%
    ListaProductos productos = new ListaProductos();
    productos.getListaProductos("all", "");
    session.setAttribute("lista_productos", productos);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div name="table">
        <%for (int i = 0 ; i < productos.size() ; i ++){%>
            <div>
                <form name="producto">
                    <input type="text"  name="descripcion" value="<%=productos.get(i).getDescripcion()%>" readonly="yes">
                    <input type="text" name="precio" value="<%=productos.get(i).getPrecio()%>" readonly="yes">
                    <input type="text" name="categoria" value="<%=productos.get(i).getCategoria()%>" readonly="yes">
                </form>
                <form action="ServletABMProducto">
                    <input type="hidden" name="id_producto" value="<%=productos.get(i).getId_producto()%>">
                    <input type="hidden" name="accion" value="update">
                    <input type="submit" value="Modificar">
                </form>

                <form action="ServletABMProducto">
                    <input type="hidden" name="accion" value="delete">
                    <input type="hidden" name="id_producto" value="<%=productos.get(i).getId_producto()%>">
                    <input type="submit" value="Eliminar">
                </form>

                <br>
            </div>
        <%}%>
        </div>
        <form>
            <input type="button" id="add" value="Agregar" onclick="agregar()">
        </form>
        <script src="js/controles_abm.js"></script>
        
    </body>
</html>
