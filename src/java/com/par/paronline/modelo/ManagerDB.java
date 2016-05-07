/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.par.paronline.modelo;

/**
 *La clase ProductManager se encarga de traer la lista de productos de la base de datos, buscar productos en la lista de productos
 * y realizar altas, bajas y modificaciones en la base de datos.
 * Metodos a implementar
 *  -getListaProductos()
 *  -buscarProducto() por descripcion
 *  -buscarProducto() por id
 *  -alta() agregar un producto en la base de datos
 *  -baja() eliminar un producto de la base de datos
 *  -modificar() modificar un producto en la base datos
 * @author fabricio
 */
import java.util.ArrayList;
import com.par.paronline.modelo.ListaProductos;
import com.par.paronline.modelo.Producto;
import com.par.paronline.utils.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;


public class ManagerDB {
    
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private Connection conexion = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public ManagerDB() throws ClassNotFoundException, NamingException, Exception{
        //constructor
        this.conexion = Conexion.getConexion();
    }
    
    
    
    public void consultar(String query) throws SQLException, ClassNotFoundException{
        this.statement = this.conexion.prepareStatement(query);
        this.result = this.statement.executeQuery();
        
    }
    
    public void consultar(String query, ArrayList<String> args) throws SQLException, ClassNotFoundException{
        
        this.statement = this.conexion.prepareStatement(query);
        for(int i = 0 ; i < args.size() ; i ++){
            this.statement.setString(i + 1, args.get(i));
        }
        System.out.println(query);
        this.result = this.statement.executeQuery();
        
    }
    
    public ResultSet getResult(){
        return this.result;
    }
    
    public PreparedStatement getPrepareStatement(String query)throws SQLException, ClassNotFoundException{
        this.statement = this.conexion.prepareStatement(query);
        return this.statement;
    }
    
    public void iduquery (PreparedStatement sentencia)throws SQLException, ClassNotFoundException{
        sentencia.executeUpdate();
        sentencia.close();
        Conexion.closeConexion(this.conexion);
    }
    
    public void cerrarConexion() throws SQLException, ClassNotFoundException{
        this.statement.close();
        this.result.close();
        Conexion.closeConexion(this.conexion);
    }
}
