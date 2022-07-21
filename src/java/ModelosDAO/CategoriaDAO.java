/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Config.Conexion;
import Interfaces.CategoriaInterface;
import Modelos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAO implements CategoriaInterface {
   Conexion cn=new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   Categoria c;
   ArrayList<Categoria>lista = new ArrayList<>();

    @Override
    public boolean agregar(Categoria c) {
      try {
            String sql = "Insert into categorias(categoria) values (?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCat());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }

    @Override
    public boolean eliminar(int id) {
        try {
            String sql = "delete from categorias where id=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editar(Categoria c) {
      try {
            
            String sql = "Update categorias set categoria=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCat());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            //ex.getMessage();
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }

    @Override
    public ArrayList<Categoria> listarTodos() {
         try {
            String sql = "Select * from categorias";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs =  ps.executeQuery();
            while(rs.next()){
                int id = (rs.getInt("id"));
                String nombre = (rs.getString("categoria"));
                
                c = new Categoria(nombre, id);
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("MESSAGE=>"+ex.getMessage());
            //ex.getMessage();
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Categoria listarUno(int id) {
       try {
            String sql = "Select * from categoria where id=?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs =  ps.executeQuery();
            while(rs.next()){
                int idCat = (rs.getInt("id"));
                String nombreCat = (rs.getString("categoria"));
                
                c = new Categoria(nombreCat,idCat);
            }
        } catch (SQLException ex) {
            //ex.getMessage();
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    
    }
      
}
