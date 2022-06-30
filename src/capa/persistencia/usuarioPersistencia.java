/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Usuarios;
import capa.logica.Usuario;

/**
 *
 * @author a
 */

// JDBC  CONNECTOR:
// jdbc:mysql://localhost:3306/ProyectoBios2022NombrePendiente?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]

public class usuarioPersistencia {
    
    
    public Usuarios listaUsuarios(){
         // paso 1 : crear la conexion a la base
         // paso 2 : crear el prepare statement
         // paso 3 : ejecutar la consulta de prepare statement
         // paso 4 : cargar los resultados de los objetos de la capa logica si es un select la consulta
         // paso 5 : cerrar la conexion de la base
         Usuarios objetoListaUsuarios = new Usuarios();
         return objetoListaUsuarios;
    }
    
    public boolean existeUsuario (Usuario nuevoObjetoUsuario) {
        boolean resultado = false;
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
