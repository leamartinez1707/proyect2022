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
public class Afiliaciones {
    
    ArrayList<Afiliacion> afiliaciones = new ArrayList();

    public ArrayList<Afiliacion> getAfiliaciones() {
        return afiliaciones;
    }

    public void setAfiliaciones(ArrayList<Afiliacion> afiliaciones) {
        this.afiliaciones = afiliaciones;
    }

    public void agregarAfiliacion(Afiliacion afiliacion){
        this.afiliaciones.add(afiliacion);
    }    
    
}
