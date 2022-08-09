/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Negocio;
import capa.logica.Negocios;
import capa.logica.Persona;
import capa.logica.Personas;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import excepciones.PersonaException;
import java.sql.Connection;
import java.sql.Date;
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

                negocio.setIdNegocio(rs.getString("idNegocio"));               
                negocio.setIdTipoDeNegocio("idTipoNegocio");
                negocio.setIdAfiliado("idAfiliado");                                
                negocio.setNombreNegocio(rs.getString("nombreNegocio"));
                
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

            ps = con.prepareStatement("INSERT INTO Negocio (idTipoDeNegocio, idAfiliado, nombreNegocio) VALUES (?, ?, ?)");
            ps.setString(1, negocio.getIdTipoDeNegocio());
            ps.setString(2, negocio.getIdAfiliado());
            ps.setString(3, negocio.getNombreNegocio());
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
}
