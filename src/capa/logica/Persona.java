/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

import java.sql.Date;

/**
 *
 * @author a
 */
public class Persona {
    public String cedulaDeIdentidad = " ";
    public String nombre = " ";
    public String nacionalidad = " ";
    public String direccion = " ";
    public String telefono = " ";
    public String email = " ";
    public String fechaDeNacimiento = " ";

    public String getCedulaDeIdentidad() {
        return cedulaDeIdentidad;
    }

    public void setCedulaDeIdentidad(String cedulaDeIdentidad) {
        this.cedulaDeIdentidad = cedulaDeIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    
            
}
