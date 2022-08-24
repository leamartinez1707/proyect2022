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
public class TiposDeNegocioException extends Exception {

    /**
     * Creates a new instance of <code>TiposDeNegocio</code> without detail
     * message.
     */
    public TiposDeNegocioException() {
    }

    /**
     * Constructs an instance of <code>TiposDeNegocio</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public TiposDeNegocioException(String msg) {
        super(msg);
    }
}
