/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
public class Afiliacion {

        String idAfiliacion;
        String nombreAfiliacion;
        String ciAfiliado;
        String descripcion;
        String fechaAfiliacion;

    public String getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(String fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public String getIdAfiliacion() {
        return idAfiliacion;
    }

    public void setIdAfiliacion(String idAfiliacion) {
        this.idAfiliacion = idAfiliacion;
    }

    public String getNombreAfiliacion() {
        return nombreAfiliacion;
    }

    public void setNombreAfiliacion(String nombreAfiliacion) {
        this.nombreAfiliacion = nombreAfiliacion;
    }

    public String getCiAfiliado() {
        return ciAfiliado;
    }

    public void setCiAfiliado(String ciAfiliado) {
        this.ciAfiliado = ciAfiliado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
