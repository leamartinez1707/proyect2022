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
public class Personas {
    // encapsular en una clase persona, como las voy a representar.
    ArrayList<Persona> personas = new ArrayList();

    /**
     *
     * @return
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     *
     * @param personas
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    /**
     *
     * @param persona
     */
    public void agregarPersona(Persona persona){
        this.personas.add(persona);
    }
}
