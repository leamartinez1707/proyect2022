/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.logica;

import java.sql.Date;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
public class Persona {

    /**
     *
     */
    public String cedulaDeIdentidad = " ";
    public String idMatricula = " ";
    public String apellido = " ";
    public String nombre = " ";
    public String nacionalidad = " ";
    public String direccion = " ";
    public String telefono = " ";
    public String email = " ";
    public String fechaDeNacimiento = " ";
    
    
    public String getCedulaDeIdentidad() {
        return cedulaDeIdentidad;
    }

    /**
     *
     * @param cedulaDeIdentidad
     */
    public void setCedulaDeIdentidad(String cedulaDeIdentidad) {
        this.cedulaDeIdentidad = cedulaDeIdentidad;
    }

    /**
     *
     * @return
     */
    
    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }
    
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     *
     * @param nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     *
     * @param fechaDeNacimiento
     */
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    
            
}
