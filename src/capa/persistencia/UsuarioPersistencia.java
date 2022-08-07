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

/**
 *
 * @author a
 */
public class UsuarioPersistencia {
    
    //buscar usuario
    // correccion del login ( 7 de agosto del 2022 ) 
    // EN NETBEANS: NO REQUIERE USAR APÓSTROFE PARA REPRESENTAR LA COLUMNA: VA TODO PEGADO: nombreUsuario=?    ? ES REEMPLAZADO POR EL VALOR DE LA COLUMNA.
    private static final String PS_SELECT_USUARIO = "Select * from nombretemporal.usuarios where nombreUsuario=? and claveUsuario=?";

    // mal:  static final String PS_LOGIN = "mysql -u ? -p? -h localhost nombretemporal";
    // usar una tabla en la base de datos para disponer de usuarios para manejar el PROGRAMA.
    
    //private static final String PS_UPDATE_USUARIO = "UPDATE grupo_centro.usuarios SET apellido = '?' WHERE (nombre = '?')";
    //private static final String PS_INSERT_USUARIO = "INSERT INTO grupo_centro.usuarios (nombre, apellido,clave) VALUES (?, ?, ?)";

    /**
     *
     * @param nuevoObjetoUsuario
     * @throws UsuarioException
     * @throws PersistenciaException
     */

    public static void ingresarUsuario(Usuario nuevoObjetoUsuario) throws UsuarioException, PersistenciaException {

        PreparedStatement ps = null;

        Conexion nuevoObjetoConexion = new Conexion();
        Connection con = null;
        
        try {
            con = nuevoObjetoConexion.conectar();
            ps = con.prepareStatement(PS_SELECT_USUARIO);
            ps.setString(1,nuevoObjetoUsuario.getNombreDelUsuario());
            ps.setString(2,nuevoObjetoUsuario.getClaveDelUsuario());

            System.out.println(ps);
            
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException("No pude encontrar el usuario");
        } finally {

        }

    }

    /**
     *
     * @return
     */
    public Usuarios listaUsuarios() {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Usuarios objetoListaUsuarios = new Usuarios();

        return objetoListaUsuarios;

    }

    /**
     *
     * @param nuevoObjetoUsuario
     * @return
     * @throws PersistenciaException
     */
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

    /**
     *
     * @param nuevoObjetoUsuario
     */
    public void altaUsuario(Usuario nuevoObjetoUsuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    /**
     *
     * @param nuevoObjetoUsuario
     */
    public void bajaUsuario(Usuario nuevoObjetoUsuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    /**
     *
     * @param nuevoObjetoUsuario
     */
    public void modificacionUsuario(Usuario nuevoObjetoUsuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

}

