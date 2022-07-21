<%-- 
    Document   : index.jsp
    Created on : 28/06/2022, 08:04:12 PM
    Author     : xxbla
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/login.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">        <title>Login Page</title>
    </head>
    <body class="skin-blue sidebar-collapse sidebar-mini login-page">
        <div id="back"></div>
        <div class="login-box">
            <div class="login-logo">
                <img src="${pageContext.request.contextPath}/dist/imagenes/logo-blanco-bloque.png" class="img-responsive" style="padding:30px 100px 0px 100px">
            </div>
            <div class="login-box-body">
                <p class="login-box-msg">Ingresar al sistema</p>
                <form method="post" action="ControlLogin">
                    <div class="form-group has-feedback">
                        <input type="text" 
                               class="form-control" 
                               placeholder="Usuario" 
                               name="user" 
                               required>
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                  <div class="form-group has-feedback">
                    <input type="password" 
                           class="form-control" 
                           placeholder="Contraseña" 
                           name="pass" required>
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Ingresar</button>
                        </div>
                    </div>
                    <input type="hidden" name="accion" value="login"/>
                </form>
                <div class="row" style="margin-top: 15px">
                    <c:if test="${error != null}">
                        <div class="alert alert-danger" role="alert">
                            ${msg}
                        </div>
                    </c:if>
                    <c:remove var="msg" scope="session" />
                    <c:remove var="error" scope="session" />
                </div>
             </div>
        </div>
    </body>
</html>
