/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
public class UsuarioException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioException</code> without detail
     * message.
     */
    public UsuarioException() {
    }

    /**
     * Constructs an instance of <code>UsuarioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioException(String msg) {
        super(msg);
    }
}
