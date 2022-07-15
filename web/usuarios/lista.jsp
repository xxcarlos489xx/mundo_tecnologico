<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/usuarios.css">
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12 mt-5">
                    <div class="d-flex">
                        <h1>Lista de usuarios</h1>
                        <button type="button" 
                                class="btn btn-primary" 
                                data-toggle="modal" data-target="#modalAgregarUsuario">
                            Agregar
                        </button>
                    </div>
                    <table class="table table-striped mt-5 tabla-user">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Usuario</th>
                                <th>Perfil</th>
                                <th>Foto</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="x" items="${lis}" >
                                <tr>
                                    <td>${x.getNombre()}</td>
                                    <td>${x.getUsuario()}</td>
                                    <td>${x.getPerfil()}</td>
                                    <td>${x.getFoto()}</td>
                                    <td>${x.getEstado()}</td>
                                    <td>
                                        <form method="POST">
                                            <input type="hidden" name="codigo" value="${x.getUsuario()}">
                                            <input type="hidden" name="accion" value="eliminar">
                                        <button class="btn btn-danger" type="submit"/>Eliminar</button>
                                        </form>
                                        <button type="button" 
                                                class="btn btn-primary btnEditarUsuario" 
                                                idUsuario="${x.getUsuario()}"
                                                data-toggle="modal" data-target="#modalEditarUsuario">
                                            Editar
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <div/>
            <div/>
        <div/>
        <div id="modalEditarUsuario" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form role="form" method="post">
                        <div class="modal-header" style="background:#3c8dbc; color:white">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Editar usuario</h4>
                        </div>
                        <div class="modal-body">
                            <div class="box-body">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span> 
                                        <input type="text" class="form-control input-lg" id="editarNombre" name="editarNombre" value="" required>
                                    </div>
                                </div>
                                <!-- ENTRADA PARA EL USUARIO -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-key"></i></span> 
                                        <input type="text" class="form-control input-lg" id="editarUsuario" name="editarUsuario" value="" readonly>
                                    </div>
                                </div>
                                <!-- ENTRADA PARA LA CONTRASEÑA -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span> 
                                        <input type="password" class="form-control input-lg" name="editarPassword" placeholder="Escriba la nueva contraseña">
                                        <input type="hidden" id="passwordActual" name="passwordActual">
                                    </div>
                                </div>
                                <!-- ENTRADA PARA SELECCIONAR SU PERFIL -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-users"></i></span> 
                                        <select class="form-control input-lg" name="editarPerfil">
                                            <option value="" id="editarPerfil"></option>
                                            <option value="Administrador">Administrador</option>
                                            <option value="Especial">Logístico</option>
                                            <option value="Vendedor">Vendedor</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- ENTRADA PARA SELECCIONAR ESTADO -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-users"></i></span> 
                                        <select class="form-control input-lg" name="editarEstado">
                                            <option value="" id="editarEstado"></option>
                                            <option value="1">Activado</option>
                                            <option value="0">Desactivado</option>
                                        </select>
                                    </div>
                                </div>
                                <input type="hidden" value="edit" name="accion">
                                <!-- ENTRADA PARA SUBIR FOTO -->
                                <!-- <div class="form-group">
                                    <div class="panel">SUBIR FOTO</div>
                                    <input type="file" class="nuevaFoto" name="editarFoto">
                                    <p class="help-block">Peso máximo de la foto 2MB</p>
                                    <img src="vistas/img/usuarios/default/anonymous.png" class="img-thumbnail previsualizarEditar" width="100px">
                                    <input type="hidden" name="fotoActual" id="fotoActual">
                                </div> -->
                            </div>
                        </div>
                        <!--=====================================
                        PIE DEL MODAL
                        ======================================-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Salir</button>
                            <button type="submit" class="btn btn-primary">Modificar usuario</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div id="modalAgregarUsuario" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form role="form" method="post">
                        <div class="modal-header" style="background:#3c8dbc; color:white">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Agregar usuario</h4>
                        </div>
                        <div class="modal-body">
                            <div class="box-body">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span> 
                                        <input type="text" placeholder="Ingrese los nombres" class="form-control input-lg" name="nombre" value="" required>
                                    </div>
                                </div>
                                <!-- ENTRADA PARA EL USUARIO -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-key"></i></span> 
                                        <input type="text" placeholder="Ingrese el usuario para el acceso" class="form-control input-lg" name="usuario" value="" required>
                                    </div>
                                </div>
                                <!-- ENTRADA PARA LA CONTRASEÑA -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span> 
                                        <input type="password" class="form-control input-lg" name="password" placeholder="Escriba la contraseña">
                                    </div>
                                </div>
                                <!-- ENTRADA PARA SELECCIONAR SU PERFIL -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-users"></i></span> 
                                        <select class="form-control input-lg" name="perfil">
                                            <option value="Administrador">Administrador</option>
                                            <option value="Vendedor">Vendedor</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- ENTRADA PARA SELECCIONAR ESTADO -->
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-users"></i></span> 
                                        <select class="form-control input-lg" name="estado">
                                            <option value="1">Activado</option>
                                            <option value="0">Desactivado</option>
                                        </select>
                                    </div>
                                </div>
                                <input type="hidden" value="agregar" name="accion">
                                <!-- ENTRADA PARA SUBIR FOTO -->
                                <!-- <div class="form-group">
                                    <div class="panel">SUBIR FOTO</div>
                                    <input type="file" class="nuevaFoto" name="editarFoto">
                                    <p class="help-block">Peso máximo de la foto 2MB</p>
                                    <img src="vistas/img/usuarios/default/anonymous.png" class="img-thumbnail previsualizarEditar" width="100px">
                                    <input type="hidden" name="fotoActual" id="fotoActual">
                                </div> -->
                            </div>
                        </div>
                        <!--=====================================
                        PIE DEL MODAL
                        ======================================-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Salir</button>
                            <button type="submit" class="btn btn-primary">Agregar usuario</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>    
    <script  src="https://code.jquery.com/jquery-2.2.4.js"  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="  crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/dist/js/usuarios.js"></script>
</html>
