/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;


import capa.logica.Pago;
import capa.logica.Pagos;
import excepciones.PagoException;
import excepciones.PersistenciaException;
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
 * @author a
 */
public class PagoPersistencia {
    public Pagos listarPagos() throws PagoException {
        Pagos pagos = new Pagos();

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();

            Statement st = null;
            ResultSet rs = null;

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM pagos");

            while (rs.next()) {
                Pago pago = new Pago();
                
                int PAGOid = rs.getInt("idPago");
                String idPagoInt = String.valueOf(PAGOid);
                pago.setIdPago(idPagoInt);
                
                int ci = rs.getInt("cedulaIdentidad");
                String ciInt = String.valueOf(ci);
                pago.setCi(ciInt);
                
                Date FechaHoraPagoCuota = rs.getDate("fechaHoraPagoCuota");
                String FechaHoraPagoCuotaDate = String.valueOf(FechaHoraPagoCuota);
                pago.setFechaDePago(FechaHoraPagoCuotaDate);
                
                String tipoDePagoString = rs.getString("tipoDePago");
                pago.setTipoDePago(tipoDePagoString);
                
                int precio = rs.getInt("precio");
                String precioString = String.valueOf(precio);
                pago.setMonto(precioString);
                
                pagos.agregarPago(pago);
                
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pagos;
    }

    public Pago agregarPago(Pago pago) throws PagoException {

        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;

            ps = con.prepareStatement("INSERT INTO pagos (cedulaIdentidad, fechaHoraPagoCuota, tipoDePago, precio) VALUES (?, ?, ?, ?)");
            
            ps.setString(1, pago.getCi());
            ps.setString(2, pago.getFechaDePago());
            ps.setString(3, pago.getTipoDePago());
            ps.setString(4, pago.getMonto());
            
            ps.executeUpdate();

            ps.close();

        } catch (PersistenciaException ex) {
            throw new PagoException("No pude insertar el pago");
        } catch (SQLException ex) {
            Logger.getLogger(PagoPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PagoException("No pude insertar el pago, error en la base de datos.");
        }
        return pago;
    }
    
    public Pago modificarPago(Pago pago) throws PagoException{
        
        try {

            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;

            ps = con.prepareStatement("UPDATE pagos SET cedulaIdentidad=?, fechaHoraPagoCuota=?, tipoDePago=?, precio=?" + "WHERE idPago=?");
               
            ps.setString(1, pago.getCi());
            ps.setString(2, pago.getFechaDePago());
            ps.setString(3, pago.getTipoDePago());
            ps.setString(4, pago.getMonto());
            ps.setString(5, pago.getIdPago());
            
            ps.executeUpdate();
            System.out.println("Pago modificado correctamente");
            ps.close();

        } catch (PersistenciaException ex) {
            throw new PagoException("No pude modificar el pago");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PagoException("No pude modificar el pago, error en la base de datos.");
        }
        return pago;
    }
            
    
    public Pago eliminarPago(Pago pago) throws PagoException{
        
        try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("DELETE FROM pagos WHERE (idPago=?)");
            
            ps.setString(1, pago.getIdPago());
            ps.executeUpdate();
            System.out.println("Pago eliminado correctamente");
            ps.close();

           } catch (PersistenciaException ex) {
               throw new PagoException("No se pudo eliminar el pago");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PagoException("No se pudo eliminar el pago, error en la base de datos.");
        }
          return pago;
    }
}
