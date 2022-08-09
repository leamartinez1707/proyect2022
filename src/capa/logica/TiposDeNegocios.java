/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

import java.util.ArrayList;

/**
 *
 * @author Leandro
 */
public class TiposDeNegocios {
    
    ArrayList<TipoDeNegocio> tiposDeNegocios = new ArrayList();

    public ArrayList<TipoDeNegocio> getTiposDeNegocios() {
        return tiposDeNegocios;
    }


    public void setTiposDeNegocios(ArrayList<TipoDeNegocio> tiposDeNegocios) {
        this.tiposDeNegocios = tiposDeNegocios;
    }

    public void agregarTipoDeNegocio(TipoDeNegocio tipoDeNegocio){
        this.tiposDeNegocios.add(tipoDeNegocio);
    }    
    
}
