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
     * @return
     * @throws NegocioException
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

                int NegocioId = rs.getInt("idNegocio");
                String idNegocioInt = String.valueOf(NegocioId);
                negocio.setIdNegocio(NegocioId);

                int TipoDeNegocioId = rs.getInt("idTipoDeNegocio");
                String tipoDeNegocioInt = String.valueOf(TipoDeNegocioId);
                negocio.setIdTipoDeNegocio(TipoDeNegocioId);

                int AfiliadoId = rs.getInt("idAfiliado");
                String idAfiliadoInt = String.valueOf(AfiliadoId);
                negocio.setIdAfiliado(AfiliadoId);

                negocios.agregarNegocio(negocio);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return negocios;
    }
  
}
