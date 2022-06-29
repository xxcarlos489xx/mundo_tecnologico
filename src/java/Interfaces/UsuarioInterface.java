/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.ArrayList;
import Modelos.Usuario;

public interface UsuarioInterface {
    public boolean agregar(Usuario p);
    public boolean eliminar(String codigo);
    public boolean editar(Usuario p);
    public ArrayList<Usuario> listarTodos();
    public Usuario listarUno(String codigo);
}
