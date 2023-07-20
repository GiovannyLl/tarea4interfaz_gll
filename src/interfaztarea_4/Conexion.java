/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaztarea_4;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Conexion {
    String bd= "interfaztr4";
    String url="jdbc:mysql://localhost:3306/";
    String usuario="root";
    String password="root";
    String driver="com.mysql.cj.jdbc.Driver";
    
    Connection cx;
    public Conexion(){
 
    }
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd,usuario,password);
            System.out.println("Se conecto BD");
        } catch (ClassNotFoundException |  SQLException ex) {
            System.out.println("No se Conecto");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public static void main(String[] args) {
        Conexion conexion =new Conexion();
        conexion.conectar();
        
    }
}
    
    

