/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Llama a todas las persistencias.
package capa.logica;

import capa.persistencia.NegocioPersistencia;
import capa.persistencia.UsuarioPersistencia;
import capa.persistencia.PersonaPersistencia;
import capa.persistencia.AfiliacionPersistencia;
import capa.persistencia.LocalPersistencia;
import capa.persistencia.PagoPersistencia;
import capa.presentacion.VentanaPrincipal;
import excepciones.AfiliacionException;
import excepciones.LocalException;
import excepciones.NegocioException;
import excepciones.PagoException;
import excepciones.PersistenciaException;
import excepciones.PersonaException;
import excepciones.TiposDeNegocioException;
import excepciones.UsuarioException;
import java.sql.SQLException;

/**
 *
 * @author leandro1707
 */
public class FachadaLogica {

    // ALTA, BAJA,MODIFICAR Y EXISTE USUARIO
    public static Boolean existeUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException {

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuario(nuevoObjetoUsuario);
        return existe;
    }

    //////////////////////////////////////////
    // ABM USUARIOS
    
    public static Boolean existeUsuarioParaGestionar(Usuario nuevoObjetoUsuario) throws PersistenciaException {

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuarioParaGestionar(nuevoObjetoUsuario);
        return existe;
    }

    public static Usuarios listarUsuarios() throws UsuarioException {
        UsuarioPersistencia pers = new UsuarioPersistencia();

        Usuarios mostrarUsuarios = pers.listaUsuarios();

        return mostrarUsuarios;

    }

    public static void altaUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException {

        UsuarioPersistencia pers = new UsuarioPersistencia();
        pers.altaUsuario(nuevoObjetoUsuario);

    }

    public static void bajaUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException {
        UsuarioPersistencia pers = new UsuarioPersistencia();
        pers.bajaUsuario(nuevoObjetoUsuario);

    }

    //////////////////////////////////////////
    
    // ABM PERSONAS
    public static Personas listarPersonas() throws PersonaException {
        PersonaPersistencia pers = new PersonaPersistencia();

        Personas mostrarPersonas = pers.listarPersonas();

        return mostrarPersonas;

    }

    public static void agregarPersona(Persona persona) throws PersonaException {
        PersonaPersistencia per = new PersonaPersistencia();
        per.agregarPersona(persona);
    }

    public static void eliminarPersona(Persona persona) throws PersonaException {
        PersonaPersistencia pers = new PersonaPersistencia();
        pers.eliminarPersona(persona);
    }

    public static void modificarPersona(Persona persona) throws PersonaException {
        PersonaPersistencia perr = new PersonaPersistencia();
        perr.modificarPersona(persona);

    }
    
    //////////////////////////////////////////
    // ABM NEGOCIOS

    public static Negocios listarNegocios() throws NegocioException {
        NegocioPersistencia neg = new NegocioPersistencia();

        Negocios mostrarNegocios = neg.listarNegocios();

        return mostrarNegocios;

    }

    public static void agregarNegocio(Negocio negocio) throws NegocioException {

        NegocioPersistencia neg = new NegocioPersistencia();
        neg.agregarNegocio(negocio);
    }
    
    public static void modificarNegocio(Negocio negocio) throws NegocioException{
        
        NegocioPersistencia mneg = new NegocioPersistencia();
        mneg.modificarNegocio(negocio);
        
    }

    public static void eliminarNegocio(Negocio negocio) throws NegocioException {

        NegocioPersistencia negg = new NegocioPersistencia();
        negg.eliminarNegocio(negocio);

    }
    
    //////////////////////////////////////////
    // ABM AFILIACIONES

    public static Afiliaciones listarAfiliaciones() throws AfiliacionException {
        AfiliacionPersistencia ap = new AfiliacionPersistencia();

        Afiliaciones mostrarAfiliaciones = ap.listarAfiliaciones();

        return mostrarAfiliaciones;

    }

    public static void agregarAfiliacion(Afiliacion afiliacion) throws AfiliacionException {

        AfiliacionPersistencia aaf = new AfiliacionPersistencia();
        aaf.agregarAfiliacion(afiliacion);

    }

    public static void modificarAfiliacion(Afiliacion afiliacion) throws AfiliacionException {

        AfiliacionPersistencia maf = new AfiliacionPersistencia();
        maf.modificarAfiliacion(afiliacion);
    }

    public static void eliminarAfiliacion(Afiliacion afiliacion) throws AfiliacionException {

        AfiliacionPersistencia eaf = new AfiliacionPersistencia();
        eaf.eliminarAfiliacion(afiliacion);
    }
    
    //////////////////////////////////////////
    // ABM LOCALES
    public static Locales listarLocales() throws LocalException {
        LocalPersistencia lp = new LocalPersistencia();

        Locales mostrarLocales = lp.listarLocales();

        return mostrarLocales;

    }

    public static void agregarLocal(Local local) throws LocalException {

        LocalPersistencia lp = new LocalPersistencia();
        lp.agregarLocal(local);

    }

    public static void modificarLocal(Local local) throws LocalException {

        LocalPersistencia lp = new LocalPersistencia();
        lp.modificarLocal(local);
    }

    public static void eliminarLocal(Local local) throws LocalException {

        LocalPersistencia lp = new LocalPersistencia();
        lp.eliminarLocal(local);
    }
    
    
    //////////////////////////////////////////
    // ABM PAGOS
    
    public static Pagos listarPagos() throws PagoException {
        PagoPersistencia pp = new PagoPersistencia();

        Pagos mostrarPagos = pp.listarPagos();

        return mostrarPagos;

    }

    public static void agregarPago(Pago pago) throws PagoException {

        PagoPersistencia pp = new PagoPersistencia();
        pp.agregarPago(pago);

    }

    public static void modificarPago(Pago pago) throws PagoException {

        PagoPersistencia pp = new PagoPersistencia();
        pp.modificarPago(pago);
    }

    public static void eliminarPago(Pago pago) throws PagoException {

        PagoPersistencia pp = new PagoPersistencia();
        pp.eliminarPago(pago);
    }
}

