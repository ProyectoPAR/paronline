/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.par.paronline.modelo;

import com.par.paronline.utils.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
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
    
    public void getListaProductos(String categoria, String descripcion) throws SQLException, ClassNotFoundException, Exception{
        String query = "select p.id_producto idp,p.descripcion pdes, c.descripcion cdes, precio_unitario from Productos p, Categorias c where "
                    + "p.id_categoria = c.id_categoria";
        ArrayList<String> args = new ArrayList<String>();
        ManagerDB man = new ManagerDB();
        if(categoria.equals("all") && descripcion.equals("")){
            
            man.consultar(query);
        }
        else{
            
            if(!categoria.equals("all")){
                query = query + " and c.descripcion = ?";
                args.add(categoria);
            }
            if(!descripcion.equals("")){
                query = query + " and p.descripcion like ?";
                args.add(descripcion);
            }
            man.consultar(query, args);
              
        }
            
        while(man.getResult().next()){
            String id_producto = man.getResult().getString("idp");
            categoria = man.getResult().getString("cdes");
            String descripcion_prod = man.getResult().getString("pdes");
            String precio = man.getResult().getString("precio_unitario");
            this.addProducto(new Producto(id_producto, categoria,descripcion_prod,precio));
        }
        
        
    }
    
    
}
