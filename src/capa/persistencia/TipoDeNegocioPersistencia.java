/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.TipoDeNegocio;
import capa.logica.TiposDeNegocios;
import excepciones.PersistenciaException;
import excepciones.TiposDeNegocioException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class TipoDeNegocioPersistencia {
    
    public TiposDeNegocios listarTiposDeNegocios() throws TiposDeNegocioException {
        TiposDeNegocios tiposDeNegocios = new TiposDeNegocios();

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();

            Statement st = null;
            ResultSet rs = null;

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM tipodenegocio");

            while (rs.next()) {
                TipoDeNegocio tipoDeNegocio = new TipoDeNegocio();

                int TipoNegocioId = rs.getInt("idTipoDeNegocio");
                String idTipoNegocioInt = String.valueOf(TipoNegocioId);
                tipoDeNegocio.setIdTipoDeNegocio(idTipoNegocioInt);
                
                tipoDeNegocio.setDescripcion(rs.getString("descripcion"));

                tiposDeNegocios.agregarTipoDeNegocio(tipoDeNegocio);
            }
            
    }   catch (PersistenciaException ex) {
            Logger.getLogger(TipoDeNegocioPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TipoDeNegocioPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tiposDeNegocios;
    
}
}
