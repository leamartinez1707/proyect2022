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
public class AfiliacionException extends Exception {

    /**
     * Creates a new instance of <code>AfiliacionException</code> without detail
     * message.
     */
    public AfiliacionException() {
    }

    /**
     * Constructs an instance of <code>AfiliacionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AfiliacionException(String msg) {
        super(msg);
    }
}
