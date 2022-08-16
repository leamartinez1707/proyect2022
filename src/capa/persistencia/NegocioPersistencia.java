/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Negocio;
import capa.logica.Negocios;
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
 * @author Leandro
 */
public class NegocioPersistencia {

    /**
     *
     * @return @throws NegocioException
     */
    public Negocios listarNegocios() throws NegocioException {
        Negocios negocios = new Negocios();

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();

            Statement st = null;
            ResultSet rs = null;

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM negocio");

            while (rs.next()) {
                Negocio negocio = new Negocio();
                
                int NEGid = rs.getInt("idNegocio");
                String idNegInt = String.valueOf(NEGid);
                negocio.setIdNegocio(idNegInt);
                
                int NEGafi = rs.getInt("idAfiliado");
                String idAfiInt = String.valueOf(NEGafi);
                negocio.setIdAfiliado(idAfiInt);
                
                negocio.setNombreNegocio(rs.getString("nombreNegocio"));
                negocio.setRubro(rs.getString("rubro"));
                negocio.setDescripcion(rs.getString("descripcion"));
                
                negocios.agregarNegocio(negocio);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return negocios;
    }

    public Negocio agregarNegocio(Negocio negocio) throws NegocioException {

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;

            ps = con.prepareStatement("INSERT INTO Negocio (idAfiliado, rubro, nombreNegocio, descripcion) VALUES (?, ?, ?, ?)");
            
                        
            ps.setString(1, negocio.getIdAfiliado());
            ps.setString(2, negocio.getRubro());
            ps.setString(3, negocio.getNombreNegocio());
            ps.setString(4, negocio.getDescripcion());
            ps.executeUpdate();

            ps.close();

        } catch (PersistenciaException ex) {
            throw new NegocioException("No pude insertar el negocio");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No pude insertar negocio, error en la base de datos.");
        }
        return negocio;
    }
    
    public Negocio modificarNegocio(Negocio negocio) throws NegocioException{
        
        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;

            ps = con.prepareStatement("UPDATE negocio SET idAfiliado=?, nombreNegocio=?, rubro=?, descripcion=?" + "WHERE idNegocio=?");
            
                        
            ps.setString(1, negocio.getIdAfiliado());
            ps.setString(2, negocio.getRubro());
            ps.setString(3, negocio.getNombreNegocio());
            ps.setString(4, negocio.getDescripcion());
            ps.setString(5, negocio.getIdNegocio());
            
            ps.executeUpdate();
            System.out.println("Negocio modificado correctamente");
            ps.close();

        } catch (PersistenciaException ex) {
            throw new NegocioException("No pude modificar el negocio");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No pude modificar el negocio, error en la base de datos.");
        }
        return negocio;
    }
            
    
    public Negocio eliminarNegocio(Negocio negocio) throws NegocioException{
        
        try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("DELETE FROM negocio WHERE (idNegocio=?)");
            
            ps.setString(1, negocio.getIdNegocio());
            ps.executeUpdate();
            System.out.println("Negocio eliminado correctamente");
            ps.close();

           } catch (PersistenciaException ex) {
               throw new NegocioException("No se pudo eliminar el negocio");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No se pudo eliminar el negocio, error en la base de datos.");
        }
          return negocio;
                  }
           
        
    }
