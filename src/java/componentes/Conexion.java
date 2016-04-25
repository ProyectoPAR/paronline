/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author root
 */
package componentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Conexion {
    public static String url = "jdbc:postgresql://localhost:5432/paronline";
    public static String user = "postgres";
    public static String pass = "sate150495";
    public static Connection conexion = null;
    public static PreparedStatement sentencia = null;
    public static ResultSet result = null;
    
    public Conexion(String url, String user, String pass)throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        this.conexion = DriverManager.getConnection(url,user, pass);
    }

    /**
     *
     * @param query
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void consultar(String query, ArrayList<String> args) throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url,user, pass);
        sentencia = conexion.prepareStatement(query);
        for(int i = 0 ; i < args.size() ; i ++){
            sentencia.setString(i + 1, args.get(i));
        }
        System.out.println(query);
        result = sentencia.executeQuery();
    }
    
    public static void consultar(String query) throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url,user, pass);
        sentencia = conexion.prepareStatement(query);
        result = sentencia.executeQuery();
    }
    
    public static ResultSet getResult(){
        return result;
    }
    
    public static void cerrarConexion() throws SQLException{
        result.close();
        sentencia.close();
        conexion.close();
    }
        
}
