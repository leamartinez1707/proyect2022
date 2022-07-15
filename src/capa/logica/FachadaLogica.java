/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Llama a todas las persistencias.

package capa.logica;

import capa.persistencia.UsuarioPersistencia;
import capa.persistencia.PersonaPersistencia;
import excepciones.PersistenciaException;
import excepciones.PersonaException;
import excepciones.UsuarioException;

/**
 *
 * @author a
 */
public class FachadaLogica {
    
     public static Boolean existeUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException{

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuario(nuevoObjetoUsuario);
        return existe;
    }

    public static void ingresarUsuario(Usuario nuevoObjetoUsuario) throws UsuarioException, PersistenciaException {

        UsuarioPersistencia.ingresarUsuario(nuevoObjetoUsuario);
    }
    
    public static String[] buscarPersona(Usuario nuevoObjetoUsuario) throws PersistenciaException{
        String[] datosPersona = new String[7];
        PersonaPersistencia.buscarPersona(nuevoObjetoPersona);
        return datosPersona;
    }

}
