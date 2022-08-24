
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */

// JDBC  CONNECTOR:

public class Conexion {
    String usuario = "root";
    String contrasena = "password";

    Connection con = null;

    /**
     *
     * @return
     */
    public Connection getCon() {
        return con;
    }

    /**
     *
     * @return
     * @throws PersistenciaException
     */
    public Connection conectar() throws PersistenciaException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biosearcher?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, contrasena);
            
        } catch (SQLException ex) {
            throw new PersistenciaException("Fallo en BD ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    /**
     *
     * @return
     */
    public Connection desconectar(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biosearcher?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, contrasena);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return con;
    }
    
    /**
     *
     * @param con
     */
    public void desconectar(Connection con){
    
    
    }

}
