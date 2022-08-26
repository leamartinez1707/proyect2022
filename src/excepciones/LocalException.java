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
public class LocalException extends Exception {

    /**
     * Creates a new instance of <code>LocalException</code> without detail
     * message.
     */
    public LocalException() {
    }

    /**
     * Constructs an instance of <code>LocalException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LocalException(String msg) {
        super(msg);
    }
}
