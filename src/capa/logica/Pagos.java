/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

import java.util.ArrayList;

/**
 *
 * @author a
 */
public class Pagos {
    
    ArrayList<Pago> pagos = new ArrayList();

    /**
     *
     * @return
     */
    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    /**
     *
     * @param pagos
     */
    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    /**
     *
     * @param pago
     */
    public void agregarPago(Pago pago){
        this.pagos.add(pago);
    }    
}
