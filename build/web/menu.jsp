<%-- 
    Document   : menu
    Created on : 29/06/2022, 12:51:16 PM
    Author     : xxbla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/font-awesome/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mundo Tecnologico</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="container" style="margin-top: 50px;">
                <div class="jumbotron">
                    <%
                        String nombre=(String)session.getAttribute("nombre");
                        if(nombre == null)
                        {
                            response.sendRedirect("/MundoTecnologico/index.jsp");
                        }
                    %>
                    <div class="row">
                        <div class="col-12">
                            <form method="post" action="ControlLogin">
                                <input type="hidden" name="accion" value="logout"/>
                                <button class="btn btn-primary" style="float: right">
                                    Cerrar sesión                            
                                </button>
                            </form>                            
                        </div>
                        <div class="col-12">
                            <h1>Inventory 8 </h1>
                            <h3>Bienvenido ${nombre}</h3>
                            <p style="margin-top: 50px;">                        
                                <a class="btn btn-primary btn-lg" 
                                   href="ControlUsuario?vista=lista" 
                                   role="button">
                                    <i class="fa fa-user h1"></i><br>
                                    Modulo Usuarios
                                </a>
                                <a class="btn btn-primary btn-lg" href="ControlCategoria?vista=lista" role="button">
                                    <i class="fa fa-user h1"></i><br>
                                    Modulo Categoria
                                </a>
                                <a class="btn btn-primary btn-lg" 
                                   href="ControlVentas?vista=lista" 
                                   role="button">
                                    <i class="fa fa-shopping-bag h1"></i><br>
                                    Modulo Venta
                                </a>
                            </p>
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </body>
</html>
