/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.persistencia;

import capa.logica.Persona;
import capa.logica.Personas;
import excepciones.PersistenciaException;
import excepciones.PersonaException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a
 */
// JDBC  CONNECTOR:
// jdbc:mysql://localhost:3306/ProyectoBios2022NombrePendiente?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]
public class PersonaPersistencia extends Conexion {

    /**
     *
     * @return
     * @throws PersonaException
     */
    public Personas listarPersonas() throws PersonaException {
        Personas personas = new Personas();
        
          try {
              
              Conexion nuevoObjetoConexion = new Conexion();
              Connection con = nuevoObjetoConexion.conectar();
              
              Statement st = null;
              ResultSet rs = null;
              
              st = con.createStatement();
              rs = st.executeQuery("SELECT * FROM afiliado");
                      
              while (rs.next()) {
                  Persona persona = new Persona();
                  
                  int CI = rs.getInt("cedulaIdentidad");
                  String cedulaInt = String.valueOf(CI);
                  persona.setCedulaDeIdentidad(cedulaInt);
                  
                  int MATRI = rs.getInt("idMatricula");
                  String matriInt = String.valueOf(MATRI);
                  persona.setIdMatricula(matriInt);
                  
                  persona.setNombre(rs.getString("nombre"));
                  persona.setApellido(rs.getString("apellido"));
                  persona.setNacionalidad(rs.getString("nacionalidad"));
                  persona.setDireccion(rs.getString("direccion"));
                  persona.setTelefono(rs.getString("telefono"));
                  persona.setEmail(rs.getString("email"));
                  
                  Date FechaNacimiento = rs.getDate("fechaDeNacimiento");
                  String FechaNacDate = String.valueOf(FechaNacimiento);
                  persona.setFechaDeNacimiento(FechaNacDate);
                  
                  personas.agregarPersona(persona);
                  
                  
              }
    
          } catch (PersistenciaException ex) {
              Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          }
          
              return personas;
          } 
    
    public Persona agregarPersona(Persona persona) throws PersonaException {
          
          try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("INSERT INTO afiliado (cedulaIdentidad, nombre, apellido, nacionalidad, direccion, telefono, email, fechaDeNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, persona.getCedulaDeIdentidad());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getNacionalidad());
            ps.setString(5, persona.getDireccion());
            ps.setString(6, persona.getTelefono());
            ps.setString(7, persona.getEmail());
            ps.setString(8, persona.getFechaDeNacimiento());
            ps.executeUpdate();
            
            
            ps.close();

           } catch (PersistenciaException ex) {
               throw new PersonaException("No se pudo insertar el afiliado");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersonaException("No se pudo insertar el afiliado, error en la base de datos.");
        }
          return persona;
                  }
    
    public Persona modificarPersona(Persona persona) throws PersonaException {
          
          try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("UPDATE afiliado SET nombre=?, apellido=?, nacionalidad=?, direccion=?, telefono=?, email=?, fechaDeNacimiento=?" + "WHERE cedulaIdentidad=?");
            
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getNacionalidad());
            ps.setString(4, persona.getDireccion());
            ps.setString(5, persona.getTelefono());
            ps.setString(6, persona.getEmail());
            ps.setString(7, persona.getFechaDeNacimiento());
            ps.setString(8, persona.getCedulaDeIdentidad());
            ps.executeUpdate();
            System.out.println("Persona modificada correctamente");
            ps.close();

           } catch (PersistenciaException ex) {
               throw new PersonaException("No se pudo modificar al afiliado");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersonaException("No se pudo modificar al afiliado, error en la base de datos.");
        }
          return persona;
                  }
 
    public Persona eliminarPersona(Persona persona) throws PersonaException {
          
          try {
              
            Conexion nuevoObjetoConexion = new Conexion();
            Connection con = nuevoObjetoConexion.conectar();
            PreparedStatement ps = null;
             
            ps = con.prepareStatement("DELETE FROM afiliado WHERE (cedulaIdentidad=?)");
            
            ps.setString(1, persona.getCedulaDeIdentidad());
            
            
            ps.executeUpdate();
            System.out.println("Afiliado eliminado correctamente");
            ps.close();

           } catch (PersistenciaException ex) {
               throw new PersonaException("No se pudo eliminar al afiliado");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersonaException("No se pudo insertar al afiliado, error en la base de datos.");
        }
          return persona;
                  }
}
                   
