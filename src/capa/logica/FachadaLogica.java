/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Llama a todas las persistencias.

package capa.logica;

import excepciones.UsuarioException;

/**
 *
 * @author a
 */
public class FachadaLogica {
    
     public static Boolean existeUsuario(Usuario usuario) {

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuario(usuario);
        return existe;
    }

    public static void ingresarUsuario(Usuario usuario) throws UsuarioException {

        UsuarioPersistencia.ingresarUsuario(usuario);
    }
    
}
