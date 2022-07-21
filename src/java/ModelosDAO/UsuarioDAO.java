/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Config.Conexion;
import Interfaces.UsuarioInterface;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xxbla
 */
public class UsuarioDAO implements UsuarioInterface{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u;
    ArrayList<Usuario>lista = new ArrayList<>();
    
    @Override
    public boolean agregar(Usuario u) {
        try {
            String sql = "Insert into usuarios(nombre,usuario,password,perfil,foto,estado) values (?,?,?,?,?,?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre() );
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getPerfil());
            ps.setString(5, u.getFoto());
            ps.setInt(6, u.getEstado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from usuarios where usuario=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editar(Usuario u) {
        try {
            //String sql = "Update usuarios set nombre=?,password=?,perfil=?,foto=?,estado=? where usuario="+u.getUsuario();
            String sql = "Update usuarios set nombre=?,perfil=?,estado=?,password=? where usuario=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre() );
            ps.setString(2, u.getPerfil());
            //ps.setString(4, u.getFoto());
            ps.setInt(3, u.getEstado());
            ps.setString(4, u.getPassword());
            //search
            ps.setString(5, u.getUsuario());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            //ex.getMessage();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        try {
            String sql = "Select * from usuarios";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs =  ps.executeQuery();
            while(rs.next()){
                String nombre = (rs.getString("nombre"));
                String usuario = (rs.getString("usuario"));
                String perfil = (rs.getString("perfil"));
                String foto = (rs.getString("foto"));
                int estado = (rs.getInt("estado"));
                u = new Usuario(nombre,usuario,perfil,foto,estado);
                lista.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("MESSAGE=>"+ex.getMessage());
            //ex.getMessage();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Usuario listarUno(String usuario) {
        try {
            String sql = "Select * from usuarios where usuario=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs =  ps.executeQuery();
            while(rs.next()){
                String nombre = (rs.getString("nombre"));
                String user = (rs.getString("usuario"));
                String perfil = (rs.getString("perfil"));
                String foto = (rs.getString("foto"));
                int estado = (rs.getInt("estado"));
                u = new Usuario(nombre,user,perfil,foto,estado);
            }
        } catch (SQLException ex) {
            //ex.getMessage();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
}
