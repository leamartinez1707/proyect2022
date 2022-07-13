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
    private static final String PS_SELECT_USUARIO = "Select user from mysql.user where user=?";
    
    //private static final String PS_UPDATE_USUARIO = "UPDATE grupo_centro.usuarios SET apellido = '?' WHERE (nombre = '?')";
    //private static final String PS_INSERT_USUARIO = "INSERT INTO grupo_centro.usuarios (nombre, apellido,clave) VALUES (?, ?, ?)";

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException, PersistenciaException {

        PreparedStatement ps = null;

        Conexion nuevoObjetoConexion = new Conexion();
        Connection con = null;
        
        try {
            con = nuevoObjetoConexion.conectar();
            ps = con.prepareStatement(PS_SELECT_USUARIO);
            ps.setString(1,usuario.getNombreDelUsuario() );
            //ps.setString(2, usuario.getClaveDelUsuario());

            System.out.println(ps);
            
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new UsuarioException("No pude insertar el usuario");
        } finally {

        }

    }

    public Usuarios listaUsuarios() {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Usuarios usuarios = new Usuarios();

        return usuarios;

    }

    public static Boolean existeUsuario(Usuario usuario) throws PersistenciaException {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 4 : cargar los resultados en los objetos de la capa logica si es un select la consulta
        //paso 5 : cerrar la conexion a la base
        Boolean resultado = false;

        Conexion con = new Conexion();
        String nombre = usuario.getNombreDelUsuario();
        String clave = usuario.getClaveDelUsuario();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Connection conexion = con.conectar();
            String sqlStm = "select * from grupo_centro.usuarios where nombre='" + nombre + "' and clave='" + clave + "';";
            ps = conexion.prepareStatement(sqlStm);
            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

        }

        return resultado;

    }

    public void altaUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void bajaUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

    public void modificacionUsuario(Usuario usuario) {

        //paso 1 : crear la conexion a la base
        //paso 2 : crear el prepare statement
        //paso 3 : ejecutar la consulta del preparestatement
        //paso 5 : cerrar la conexion a la base
    }

}

