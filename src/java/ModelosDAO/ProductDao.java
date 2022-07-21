/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelosDAO;

import Config.Conexion;
import Modelos.Products;
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
public class ProductDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Products p;
    ArrayList<Products>lista = new ArrayList<>();
    
    public ArrayList<Products> listarTodos() {
        try {
            String sql = "Select p.id,p.id_categoria,p.codigo,p.descripcion,p.stock,p.precio_compra,p.precio_venta,c.categoria from productos p inner join categorias c on p.id_categoria = c.id";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs =  ps.executeQuery();
            while(rs.next()){
                int id = (rs.getInt("id"));
                int id_categoria = (rs.getInt("id_categoria"));
                String codigo = (rs.getString("codigo"));
                String descripcion = (rs.getString("descripcion"));
                int stock = (rs.getInt("stock"));
                double precio_compra = (rs.getDouble("precio_compra"));
                double precio_venta = (rs.getDouble("precio_venta"));
                String categoria = (rs.getString("categoria"));
                p = new Products();
                p.setId(id);
                p.setId_categoria(id_categoria);
                p.setCodigo(codigo);
                p.setDescripcion(descripcion);
                p.setStock(stock);
                p.setPrecio_compra(precio_compra);
                p.setPrecio_venta(precio_venta);
                p.setCategoria(categoria);
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("MESSAGE=>"+ex.getMessage());
            //ex.getMessage();
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
