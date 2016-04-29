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
import com.par.paronline.utils.Conexion;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;
import com.par.paronline.modelo.Producto;

/**
 *
 * @author root
 */
public class PruebaBase {
    String descripcion_prod = "";
    String precio = "";
    String producto = "";
    String categoria = "";
    String id_producto = "";
    ArrayList<Producto> productos = new ArrayList<Producto>();
    public void f(){
        try{
            String categoria = "Deportes";
            String descripcion = "";
            String query = "select p.id_producto idp, p.descripcion pdes, c.descripcion cdes, precio from Producto p, Categoria c where "
                    + "p.id_categoria = c.id_categoria";
            ArrayList<String> args = new ArrayList<String>();
            if(categoria.equals("all") && descripcion.equals("")){
                Conexion.consultar(query);
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
                Conexion.consultar(query, args);
              
            }
            
            while(Conexion.getResult().next()){
                id_producto = Conexion.getResult().getString("idp");
                producto = Conexion.getResult().getString("pdes");
                descripcion_prod = Conexion.getResult().getString("cdes");
                precio = Conexion.getResult().getString("precio");
                productos.add(new Producto(id_producto, categoria,descripcion_prod,precio));
                System.out.println(producto + descripcion_prod + precio);
            }
            Conexion.cerrarConexion();
            
        }
        catch(Exception e){
            System.out.println("hola "+e);
        }
    }
    public static void main(String args[]){
        PruebaBase p = new PruebaBase();
        p.f();
    }
    
}
