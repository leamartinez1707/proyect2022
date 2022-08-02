/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Leandro
 */
public class NegocioException extends Exception {

    /**
     * Creates a new instance of <code>NegocioException</code> without detail
     * message.
     */
    public NegocioException() {
    }

    /**
     * Constructs an instance of <code>NegocioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NegocioException(String msg) {
        super(msg);
    }
}
