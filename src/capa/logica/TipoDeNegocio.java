/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

/**
 *
 * @author Leandro
 */
public class TipoDeNegocio {

    public String getIdTipoDeNegocio() {
        return idTipoDeNegocio;
    }

    public void setIdTipoDeNegocio(String idTipoDeNegocio) {
        this.idTipoDeNegocio = idTipoDeNegocio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    String idTipoDeNegocio = "";
    String descripcion = "";
    
}
