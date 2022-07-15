/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author a
 */
public class PersistenciaException extends Exception {

    /**
     * Creates a new instance of <code>PersistenciaException</code> without
     * detail message.
     */
    public PersistenciaException() {
    }

    /**
     * Constructs an instance of <code>PersistenciaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PersistenciaException(String msg) {
        super(msg);
    }
}
