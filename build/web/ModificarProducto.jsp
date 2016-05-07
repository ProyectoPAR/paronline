<%-- 
    Document   : ModificarProducto
    Created on : 05/05/2016, 12:42:13 PM
    Author     : root
--%>

<%@page import="com.par.paronline.modelo.ListaCategorias"%>
<%@page import="com.par.paronline.modelo.Producto"%>
<%@page import="com.par.paronline.modelo.ListaProductos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id_producto = request.getParameter("id_producto");
            ListaProductos productos = new ListaProductos();
            productos.getListaProductos("all", "");
            Producto p = productos.buscarId(id_producto);
            ListaCategorias categorias = new ListaCategorias();
            categorias.getListaCategorias();
        %>
        <form action="ServletABMProducto">
            <input type="hidden" name="lastpage" value="MP">
            <input type="hidden" name="accion" value="">
            <input type="text" name="id_producto" value="<%=p.getId_producto()%>" readonly="yes">
            <input type="text" name="descripcion" value="<%=p.getDescripcion()%>"  onfocus="habilitar()">
            <input type="text" name="precio" value="<%=p.getPrecio()%>"  onfocus="habilitar()">
            <select name="categoria">
                <option value="<%=p.getCategoria()%>"><%=p.getCategoria()%></option>
                <%
                    for(int i = 0 ; i < categorias.size() ; i ++){
                        if(!p.getCategoria().equals(categorias.get(i).getDescripcion()))%>
                        <option value="<%=categorias.get(i).getDescripcion()%>"><%=categorias.get(i).getDescripcion()%></option>
                    <%}%>
            </select>
            <input type="submit" value="Guardar">
            
        </form>
            <script>
                function habilitar(){
                    descripcion = document.getElementsByName("descripcion")[0];
                    precio = document.getElementsByName("precio")[0];
                    descripcion.readonly = "no";
                    precio.readonly = "no";
                }
            </script>
    </body>
</html>
