/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(".tabla-user").on("click", ".btnEditarUsuario", function(){

    var idUsuario = $(this).attr("idUsuario");
    console.log(idUsuario);
    let obj = {idUsuario,accion:'getUser'};
    var datos = new FormData();
    datos.append("idUsuario", idUsuario);
    $.ajax({
        url:"ControlUsuario",
        method: "POST",
        data:obj,
        success: function(respuesta){
            console.log(respuesta);
            estado = 'Activado';
            if(respuesta["estado"] === 0){
                estado = 'Desactivado';
            }
            $("#editarNombre").val(respuesta["nombre"]);
            $("#editarUsuario").val(respuesta["usuario"]);
            $("#editarPerfil").html(respuesta["perfil"]);
            $("#editarPerfil").val(respuesta["perfil"]);
            $("#editarEstado").html(estado);
            $("#editarEstado").val(respuesta["estado"]);
            $("#fotoActual").val(respuesta["foto"]);
        }
    });
});