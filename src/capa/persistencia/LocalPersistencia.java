/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Local;
import capa.logica.Locales;
import capa.logica.Negocio;
import capa.logica.Negocios;
import excepciones.LocalException;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
public class LocalPersistencia {
    public Locales listarLocales() throws LocalException {
        Locales locales = new Locales();

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();

            Statement st = null;
            ResultSet rs = null;

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM local");

            while (rs.next()) {
                Local local = new Local();
                
                int LOCid = rs.getInt("idLocal");
                String idLOCInt = String.valueOf(LOCid);
                local.setIdLocal(idLOCInt);
                
                int NEGid = rs.getInt("idNegocio");
                String idNegInt = String.valueOf(NEGid);
                local.setIdNegocio(idNegInt);
                
                local.setDireccionLocal(rs.getString("direccionLocal"));
                local.setNombreEncargado(rs.getString("nombreEncargado"));
                local.setApellidoEncargado(rs.getString("apellidoEncargado"));
                
                int LocCiEncargado = rs.getInt("ciEncargado");
                String ciEncargadoInt = String.valueOf(LocCiEncargado);
                local.setCiEncargado(ciEncargadoInt);
                
                locales.agregarLocal(local);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return locales;
    }

    public Local agregarLocal(Local local) throws LocalException {

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;

            ps = con.prepareStatement("INSERT INTO Local (idLocal, idNegocio, direccionLocal, nombreEncargado, apellidoEncargado, ciEncargado) VALUES (?, ?, ?, ?, ?, ?)");
            
                        
            ps.setString(1, local.getIdLocal());
            ps.setString(2, local.getIdNegocio());
            ps.setString(3, local.getDireccionLocal());
            ps.setString(4, local.getNombreEncargado());
            ps.setString(5, local.getApellidoEncargado());
            ps.setString(6, local.getCiEncargado());

            ps.executeUpdate();

            ps.close();

        } catch (PersistenciaException ex) {
            throw new LocalException("No pude insertar el local");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new LocalException("No pude insertar local, error en la base de datos.");
        }
        return local;
    }
    
    public Local modificarLocal(Local local) throws LocalException{
        
        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;

            ps = con.prepareStatement("UPDATE local SET idNegocio=?, direccionLocal=?, nombreEncargado=?, apellidoEncargado=?, ciEncargado=?" + "WHERE idLocal=?");
               
            ps.setString(1, local.getIdNegocio());
            ps.setString(2, local.getDireccionLocal());
            ps.setString(3, local.getNombreEncargado());
            ps.setString(4, local.getApellidoEncargado());
            ps.setString(5, local.getCiEncargado());
            ps.setString(6, local.getIdLocal());
            
            ps.executeUpdate();
            System.out.println("Local modificado correctamente");
            ps.close();

        } catch (PersistenciaException ex) {
            throw new LocalException("No pude modificar el local");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new LocalException("No pude modificar el local, error en la base de datos.");
        }
        return local;
    }
            
    
    public Local eliminarLocal(Local local) throws LocalException{
        
        try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("DELETE FROM local WHERE (idLocal=?)");
            
            ps.setString(1, local.getIdLocal());
            ps.executeUpdate();
            System.out.println("Local eliminado correctamente");
            ps.close();

           } catch (PersistenciaException ex) {
               throw new LocalException("No se pudo eliminar el local");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new LocalException("No se pudo eliminar el local, error en la base de datos.");
        }
          return local;
    }
           
}
