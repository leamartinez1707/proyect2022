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
public class Locales {
      
    ArrayList<Local> locales = new ArrayList();

    /**
     *
     * @return
     */
    public ArrayList<Local> getLocales() {
        return locales;
    }

    /**
     *
     * @param locales
     */
    public void setLocales(ArrayList<Local> locales) {
        this.locales = locales;
    }

    /**
     *
     * @param local
     */
    public void agregarLocal(Local local){
        this.locales.add(local);
    }    
}
