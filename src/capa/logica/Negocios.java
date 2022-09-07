/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

import java.util.ArrayList;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
public class Negocios {

        ArrayList<Negocio> negocios = new ArrayList();

    /**
     *
     * @return
     */
    public ArrayList<Negocio> getNegocios() {
        return negocios;
    }

    /**
     *
     * @param negocios
     */
    public void setNegocios(ArrayList<Negocio> negocios) {
        this.negocios = negocios;
    }

    /**
     *
     * @param negocio
     */
    public void agregarNegocio(Negocio negocio){
        this.negocios.add(negocio);
    }    
    
}
