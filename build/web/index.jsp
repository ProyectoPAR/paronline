<%-- 
    Document   : JspProcutos
    Created on : 18/04/2016, 10:34:56 PM
    Author     : root
--%>
<%@page import = "javax.servlet.http.HttpSession"%>
<%@page import = "javax.servlet.http.HttpServlet"
        import = "javax.servlet.http.HttpServletRequest"
        import = "javax.servlet.http.HttpServletResponse"
        import = "javax.servlet.http.HttpSession" %>
    
    



<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <li> <a href="Producto">Producto</a>
                <li> <form action="Carrito" method="get"><input type="submit" value="Carrito"/></form> </li>
              </ul>
            </nav>
          </div>
        </header>
        <section>
            <div>
                <<form action="Login" method="get">
                    <input type="text" name="user" placeholder="Ingrese su nombre"/>
                    <br/>
                    <input type="password" name="pass" placeholder="Ingrese su pass"/>
                    <br/>
                    <input type="button" name="registrarse" value="Registrate"/>
                    <input type="submit" name="acceder" value="Acceder"/>
                </form>
            </div>
        </section>
    </body>
</html>
