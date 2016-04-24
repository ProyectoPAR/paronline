/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.sql.*;
import java.io.IOException;
import com.sun.rowset.CachedRowSetImpl;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import org.postgresql.Driver;

/**
 *
 * @author root
 */
public class PruebaBase {
    String descripcion_prod = "";
    String precio = "";
    String id_producto = "";
    String categoria = "";
    ArrayList<Producto> productos = new ArrayList<Producto>();
    public void f(){
        try{
            String url = "jdbc:postgresql://localhost:5432/paronline";
            Conexion c = new Conexion(url,"postgres","sate150495");
            c.consultar("select p.descripcion pdes, c.descripcion cdes, p.precio precio from Producto p, Categoria c where p.id_categoria = c.id_categoria;");
            while(c.getResult().next()){
                
                categoria = c.getResult().getString("cdes");
                descripcion_prod = c.getResult().getString("pdes");
                precio = c.getResult().getString("precio");
                productos.add(new Producto(id_producto,categoria,descripcion_prod,precio));
            }
            System.out.println(productos.get(0));
            c.cerrarConexion();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        PruebaBase p = new PruebaBase();
        p.f();
    }
    
}
