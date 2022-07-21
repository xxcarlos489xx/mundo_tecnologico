/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Config.Conexion;
import Modelos.Venta;
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
public class VentaDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Venta v;
    ArrayList<Venta>lista = new ArrayList<>();

    public ArrayList<Venta> listarTodos() {
        try {
            String sql = "Select * from ventas";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs =  ps.executeQuery();
            while(rs.next()){
                String nombre = (rs.getString("nombre"));
                String usuario = (rs.getString("usuario"));
                String perfil = (rs.getString("perfil"));
                String foto = (rs.getString("foto"));
                int estado = (rs.getInt("estado"));
                v = new Venta();
                lista.add(v);
            }
        } catch (SQLException ex) {
            System.out.println("MESSAGE=>"+ex.getMessage());
            //ex.getMessage();
            Logger.getLogger(VentaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
