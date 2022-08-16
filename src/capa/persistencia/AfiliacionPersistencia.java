/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Afiliacion;
import capa.logica.Afiliaciones;
import excepciones.AfiliacionException;
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
 * @author Leandro
 */
public class AfiliacionPersistencia {
    
    public Afiliaciones listarAfiliaciones() throws AfiliacionException {
        Afiliaciones afiliaciones = new Afiliaciones();

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();

            Statement st = null;
            ResultSet rs = null;

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM afiliacion");

            while (rs.next()) {
                
                Afiliacion afiliacion = new Afiliacion();

                int AfiliacionId = rs.getInt("idAfiliacion");
                String idAfiliacionInt = String.valueOf(AfiliacionId);
                afiliacion.setIdAfiliacion(idAfiliacionInt);
                afiliacion.setNombreAfiliacion(rs.getString("nombreAfiliacion"));
                
                int CiAfiliacion = rs.getInt("ciAfiliado");
                String cedulaInt = String.valueOf(CiAfiliacion);
                afiliacion.setCiAfiliado(cedulaInt);
                
                afiliacion.setDescripcion(rs.getString("descripcion"));

                afiliaciones.agregarAfiliacion(afiliacion);
            }
            
    }   catch (PersistenciaException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return afiliaciones;
    
}
    
    public Afiliacion agregarAfiliacion(Afiliacion afiliacion) throws AfiliacionException{
        
        try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("INSERT INTO afiliacion(nombreAfiliacion, ciAfiliado, descripcion) VALUES (?, ?, ?)");
            
            ps.setString(1, afiliacion.getNombreAfiliacion());
            ps.setString(2, afiliacion.getCiAfiliado());
            ps.setString(3, afiliacion.getDescripcion());
            
            ps.executeUpdate();
            System.out.println("Afiliacion agregada correctamente");
            ps.close();
                            
        }
            catch (PersistenciaException ex) {
               throw new AfiliacionException("No se pudo insertar la afiliación");
          } catch (SQLException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la base de datos al agregar afiliacion");
        }

          return afiliacion;
                  
    }
    
    public Afiliacion modificarAfiliacion(Afiliacion afiliacion) throws AfiliacionException{
        
                try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("UPDATE afiliacion SET nombreAfiliacion=?, ciAfiliado=?, descripcion=?" + "WHERE idAfiliacion=?");
            
            ps.setString(1, afiliacion.getNombreAfiliacion());
            ps.setString(2, afiliacion.getCiAfiliado());
            ps.setString(3, afiliacion.getDescripcion());
            ps.setString(4, afiliacion.getIdAfiliacion());
            
            ps.executeUpdate();
            System.out.println("Persona modificada correctamente");
            ps.close();
                            
        }
            catch (PersistenciaException ex) {
               throw new AfiliacionException("No se pudo modificar la afiliación");
          } catch (SQLException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionException("No se pudo modificar la afiliacion, error en la base de datos.");
        }

          return afiliacion;   
                
    }

    public Afiliacion eliminarAfiliacion(Afiliacion afiliacion) throws AfiliacionException{
        
        try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("DELETE FROM afiliacion WHERE (idAfiliacion=?)");
            
            ps.setString(1, afiliacion.getIdAfiliacion());
            
            ps.executeUpdate();
            System.out.println("Persona modificada correctamente");
            ps.close();
                            
        }
            catch (PersistenciaException ex) {
               throw new AfiliacionException("No se pudo modificar la afiliación");
          } catch (SQLException ex) {
            Logger.getLogger(AfiliacionPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new AfiliacionException("No se pudo modificar la afiliacion, error en la base de datos.");
        }

          return afiliacion;
        
        
    }


}
