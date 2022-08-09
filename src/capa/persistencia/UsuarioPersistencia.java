/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Usuario;
import capa.logica.Usuarios;
import excepciones.PersistenciaException;
import excepciones.UsuarioException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leandro1707
 */
public class UsuarioPersistencia {
    
    //buscar usuario
    // correccion del login ( 7 de agosto del 2022 ) 
    // EN NETBEANS: NO REQUIERE USAR APÓSTROFE PARA REPRESENTAR LA COLUMNA: VA TODO PEGADO: nombreUsuario=?    ? ES REEMPLAZADO POR EL VALOR DE LA COLUMNA.
    private static final String PS_SELECT_USUARIO = "Select * from nombretemporal.usuarios where nombreUsuario=? and claveUsuario=?";

    // mal:  static final String PS_LOGIN = "mysql -u ? -p? -h localhost nombretemporal";
    // usar una tabla en la base de datos para disponer de usuarios para manejar el PROGRAMA.
    private static final String PS_INSERT_USUARIO = "INSERT INTO nombretemporal.usuarios (nombreUsuario, claveUsuario) VALUES (?, ?)";
   
    
    //private static final String PS_UPDATE_USUARIO = "UPDATE grupo_centro.usuarios SET apellido = '?' WHERE (nombre = '?')";
    //private static final String PS_INSERT_USUARIO = "INSERT INTO grupo_centro.usuarios (nombre, apellido,clave) VALUES (?, ?, ?)";


    public Usuarios listaUsuarios() {
        
        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Usuarios usuarios = new Usuarios();

        try {
              
              Conexion nuevoObjetoConexion = new Conexion();
              Connection con = nuevoObjetoConexion.conectar();
              
              Statement st = null;
              ResultSet rs = null;
              
              st = con.createStatement();
              rs = st.executeQuery("SELECT * FROM usuarios");
                      
              while (rs.next()) {
                  Usuario usuario = new Usuario();

                  usuario.setNombreDelUsuario(rs.getString("nombreUsuario"));
                  usuario.setClaveDelUsuario(rs.getString("claveUsuario"));
                  
                  usuarios.agregarUsuario(usuario);
                  
                  
              }
    
          } catch (PersistenciaException ex) {
              Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          }
          
              return usuarios;
    }

    public static Boolean existeUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Boolean resultado = false;

        Conexion con = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection nuevoObjetoConexion = con.conectar();

            ps = nuevoObjetoConexion.prepareStatement(PS_SELECT_USUARIO);
            ps.setString(1,nuevoObjetoUsuario.getNombreDelUsuario());
            ps.setString(2,nuevoObjetoUsuario.getClaveDelUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public void altaUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException {

        PreparedStatement ps = null;

        Conexion nuevoObjetoConexion = new Conexion();
        Connection con = null;
        
        try {
            con = nuevoObjetoConexion.conectar();
            ps = con.prepareStatement(PS_INSERT_USUARIO);
            ps.setString(1,nuevoObjetoUsuario.getNombreDelUsuario());
            ps.setString(2,nuevoObjetoUsuario.getClaveDelUsuario());

            System.out.println(ps);
            
            ps.executeUpdate();

        } catch (SQLException e) {
            //throw new UsuarioException("No pude agregar el usuario");
            System.out.println("error ");
        } finally {

        }
    }

    public void bajaUsuario(Usuario nuevoObjetoUsuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void modificacionUsuario(Usuario nuevoObjetoUsuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

}

