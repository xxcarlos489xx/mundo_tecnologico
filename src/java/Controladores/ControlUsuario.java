/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelos.Usuario;
import ModelosDAO.UsuarioDAO;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author xxbla
 */
@WebServlet(name = "ControlUsuario", urlPatterns = {"/ControlUsuario"})
public class ControlUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getParameter("vista");
        String pagina = "";
        UsuarioDAO ul = new UsuarioDAO();
        ArrayList<Usuario>lista = new ArrayList<>();
        
        if (url.equalsIgnoreCase("lista")) {
            lista = ul.listarTodos();
            //System.out.println("LISTA"+lista);
            request.setAttribute("lis", lista);
            pagina = "usuarios/lista.jsp";
        }
        RequestDispatcher rd= request.getRequestDispatcher(pagina);
        rd.forward(request, response);
        
        //String dire=request.getParameter("direccion");
        //response.sendRedirect("http://"+pagina);
        
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acc = request.getParameter("accion");
        String pagina = "";
        UsuarioDAO ud = new UsuarioDAO();
  
        if (acc.equalsIgnoreCase("getUser")) {
            Gson gson = new Gson();
            Usuario user;
            String id = request.getParameter("idUsuario");
            user = ud.listarUno(id);
            String userJsonString = gson.toJson(user);
            //System.out.println(""+user.getPerfil());
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(userJsonString);
        }else if(acc.equalsIgnoreCase("edit")){
            //CREANDO USUARIO
            String nombre = request.getParameter("editarNombre");
            String usuario = request.getParameter("editarUsuario");
            String perfil = request.getParameter("editarPerfil");
            int estado = Integer.parseInt((request.getParameter("editarEstado")));
            String pass = request.getParameter("editarPassword");
            String passwordMD5 = DigestUtils.md5Hex(pass);            
            String foto = "";
            Usuario u = new Usuario(nombre,usuario,perfil,foto,estado);
            u.setPassword(passwordMD5);
            ud.editar(u);
            //ACTUALIZANDO LISTADO
            ArrayList<Usuario>lista;
            lista = ud.listarTodos();
            //System.out.println("LISTA"+lista);
            request.setAttribute("lis", lista);
            pagina = "usuarios/lista.jsp";
            RequestDispatcher rd= request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        }else if(acc.equalsIgnoreCase("agregar")){
            //CREANDO USUARIO
            String nombre = request.getParameter("nombre");
            String usuario = request.getParameter("usuario");
            String perfil = request.getParameter("perfil");
            int estado = Integer.parseInt((request.getParameter("estado")));
            String pass = request.getParameter("password");
            String foto = "";
            Usuario u = new Usuario(nombre,usuario,perfil,foto,estado);
            String passwordMD5 = DigestUtils.md5Hex(pass);
            u.setPassword(passwordMD5);
            ud.agregar(u);
            //ACTUALIZANDO LISTADO
            ArrayList<Usuario>lista;
            lista = ud.listarTodos();
            //System.out.println("LISTA"+lista);
            request.setAttribute("lis", lista);
            pagina = "usuarios/lista.jsp";
            RequestDispatcher rd= request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        }else if(acc.equalsIgnoreCase("eliminar")){
            //CREANDO USUARIO
            String nombre = request.getParameter("codigo");
            
            ud.eliminar(nombre);
            //ACTUALIZANDO LISTADO
            ArrayList<Usuario>lista;
            lista = ud.listarTodos();
            //System.out.println("LISTA"+lista);
            request.setAttribute("lis", lista);
            pagina = "usuarios/lista.jsp";
            RequestDispatcher rd= request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        }
                
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
