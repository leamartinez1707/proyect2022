/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Usuarios;
import capa.logica.Usuario;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a
 */

// JDBC  CONNECTOR:
// jdbc:mysql://localhost:3306/ProyectoBios2022NombrePendiente?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]

public class PersonaPersistencia {
    
    
    public Usuarios listaUsuarios(){
        // jdbc:mysql://localhost:3306/nombretemporal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]
         // paso 1 : crear la conexion a la base
         // paso 2 : crear el prepare statement
         // paso 3 : ejecutar la consulta de prepare statement
         // paso 4 : cargar los resultados de los objetos de la capa logica si es un select la consulta
         // paso 5 : cerrar la conexion de la base
         Usuarios objetoListaUsuarios = new Usuarios();
         return objetoListaUsuarios;
    }
    
    public boolean existeUsuario (Usuario nuevoObjetoUsuario) throws PersistenciaException, SQLException {
        
        boolean resultado = false;
        Conexion nuevoObjetoConexion = new Conexion();
        Connection con = nuevoObjetoConexion.conectar();
        
        Statement st = null;
        ResultSet rs = null;
        
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM persona");
        
        while (rs.next()) {
            String a = rs.getString("cedulaIdentidad");
            String b = rs.getString("nombre");
            String c = rs.getString("nacionalidad");
            String d = rs.getString("direccion");
            String e = rs.getString("telefono");
            String f = rs.getString("email");
            String g = rs.getString("fechaDeNacimiento");
            
            
            System.out.println("Resultado a: " + a);
            System.out.println("Resultado b: " + b);
            System.out.println("Resultado c: " + c);
            System.out.println("Resultado d: " + d);
            System.out.println("Resultado e: " + e);
            System.out.println("Resultado f: " + f);
            System.out.println("Resultado g: " + g);

        }
        
        System.out.println("Resultado con: " + con);
        System.out.println("Resultado st: " + st);
        System.out.println("Resultado rs: " + rs);
        return resultado;
    }
    
    //public boolean validarLogin (Usuario nuevoObjetoUsuario) throws persistenciaExcepion{
        
   // }
    
    /*
    
    public Usuarios altaUsuarios(){
         // paso 1 : crear la conexion a la base
         // paso 2 : crear el prepare statement
         // paso 3 : ejecutar la consulta de prepare statement
         // paso 4 : cargar los resultados de los objetos de la capa logica si es un select la consulta
         // paso 5 : cerrar la conexion de la base
    }
    
    public Usuarios bajaUsuarios(){
         // paso 1 : crear la conexion a la base
         // paso 2 : crear el prepare statement
         // paso 3 : ejecutar la consulta de prepare statement
         // paso 4 : cargar los resultados de los objetos de la capa logica si es un select la consulta
         // paso 5 : cerrar la conexion de la base
    }

    */
}
