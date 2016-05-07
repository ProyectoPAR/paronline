/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.par.paronline.modelo;

import com.par.paronline.utils.Conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ABMProducto {
    
    private PreparedStatement statement;
    private String query;
    
    public void alta(ArrayList args) throws SQLException, ClassNotFoundException{
        query = "insert into Productos (descripcion, imagen, precio_unitario, id_categoria) values (?,?,?,?)";
        statement = Conexion.getPrepareStatement(query);
        statement.setString(1, (String) args.get(0));
        statement.setString(2, (String) args.get(1));
        statement.setDouble(3, (double) args.get(2));
        statement.setInt(4, (int) args.get(3));
        Conexion.iduquery(statement);
        Conexion.cerrarConexion();
    }
    
    public void baja(int id_producto) throws SQLException, ClassNotFoundException{
        query = "delete from Productos where id_producto = ?";
        statement = Conexion.getPrepareStatement(query);
        statement.setInt(1, id_producto);
        Conexion.iduquery(statement);
        Conexion.cerrarConexion();
    }
    
    public void modificar(ArrayList args) throws SQLException, ClassNotFoundException{
        query = "update Productos set descripcion = ?, imagen = ?, precio_unitario = ?, id_categoria = ? where"
                + " id_producto = ?";
        statement = Conexion.getPrepareStatement(query);
        statement.setString(1, (String)args.get(0));
        statement.setString(2, (String)args.get(1));
        statement.setDouble(3, (double)args.get(2));
        statement.setInt(4, (int)args.get(3));
        statement.setInt(5, (int)args.get(4));
        System.out.println(statement.toString());
        Conexion.iduquery(statement);
        Conexion.cerrarConexion();
    }
}
