/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelos.Categoria;
import java.util.ArrayList;

/**
 *
 * @author Rolando
 */
public interface CategoriaInterface {
    public boolean agregar(Categoria c);
    public boolean eliminar(int id);
    public boolean editar(Categoria c);
    public ArrayList<Categoria> listarTodos();
    public Categoria listarUno(int id);
}
