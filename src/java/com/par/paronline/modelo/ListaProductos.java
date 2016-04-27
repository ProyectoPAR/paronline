/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.par.paronline.modelo;

import java.util.ArrayList;

/**
 *Clas que representa la lista de productos, con metodos para agregar productos, buscar mediante su id y remover.
 * @author root
 */
public class ListaProductos{
    private ArrayList<Producto> productos;
    
    public ListaProductos(){
        this.productos = new ArrayList<Producto>();
    }
    
    public void addProducto(Producto p){
        this.productos.add(p);
    }
    
    public void removeProducto(String id_producto){
        Producto p = buscarId(id_producto);
        this.productos.remove(this.buscarId(id_producto));
    }
    
    public void removeProducto(Producto p){
        this.productos.remove(p);
    }
    
    public Producto buscarId(String id_producto){
        for (int i = 0 ; i < this.productos.size() ; i ++)
            if (this.productos.get(i).getId_producto().equals(id_producto))
                return this.productos.get(i);
        return null;//retorna null si no hay ningun producto con ese id
    }
    
    public Producto buscarDescripcion(String descripcion){
        for (int i = 0 ; i < this.productos.size() ; i ++)
            if (this.productos.get(i).getDescripcion().equals(descripcion))
                return this.productos.get(i);
        return null;//retorna null si no hay ningun producto con ese id
    }
    
    public Boolean existeProducto(Producto p){
        if(this.buscarId(p.getId_producto()) == null) return false;
        else return true;
    }
    
    public Producto get(int i){
        return this.productos.get(i);
    }
    
    public int size(){
        return this.productos.size();
    }
}
