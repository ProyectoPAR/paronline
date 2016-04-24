/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

/**
 *
 * @author root
 */
public class Producto {
    private String id_producto,categoria, descripcion, precio;

    public Producto(String id, String cat, String des, String valor){
        id_producto = id;
        categoria = cat;
        descripcion = des;
        precio = valor;
    }
    public String toString(){
        return categoria + descripcion + precio;
    }
}