/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import com.par.paronline.modelo.ABMProducto;
import com.par.paronline.modelo.ListaCategorias;
import java.sql.*;
import java.io.IOException;
import com.sun.rowset.CachedRowSetImpl;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import com.par.paronline.utils.Conexion;
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
    public void f() throws SQLException, ClassNotFoundException, Exception{

        
            
        
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException, Exception{
        PruebaBase p = new PruebaBase();
        p.f();
    }
    
}
