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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
              rs = st.executeQuery("SELECT * FROM persona");
                      
              while (rs.next()) {
                  Persona persona = new Persona();
                  
                  int CI = rs.getInt("cedulaIdentidad");
                  String cedulaInt = String.valueOf(CI);
                  persona.setCedulaDeIdentidad(cedulaInt);
                  
                  persona.setNombre(rs.getString("nombre"));
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
             
            ps = con.prepareStatement("INSERT INTO Persona (cedulaIdentidad, nombre, nacionalidad, direccion, telefono, email, fechaDeNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, persona.getCedulaDeIdentidad());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getNacionalidad());
            ps.setString(4, persona.getDireccion());
            ps.setString(5, persona.getTelefono());
            ps.setString(6, persona.getEmail());
            ps.setString(7, persona.getFechaDeNacimiento());
            ps.executeUpdate();
            
            
            ps.close();

           } catch (PersistenciaException ex) {
               throw new PersonaException("No pude insertar persona");
          } catch (SQLException ex) {
            Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersonaException("No pude insertar persona, error en la base de datos.");
        }
          return persona;
                  }
      }
          
     
          /*
          public boolean ingresarPersona(Persona prsona) throws SQLException, PersistenciaException {
          PreparedStatement ps = null;
          Conexion nuevoObjetoConexion = new Conexion();
          Connection con = nuevoObjetoConexion.conectar();
          String sql = "INSERT INTO Persona (cedulaIdentidad, nombre, nacionalidad, direccion, telefono, email, fechaDeNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)";
          try {
          ps = con.prepareStatement(sql);
          ps.setString(1, prsona.getCedulaDeIdentidad());
          ps.setString(2, prsona.getNombre());
          ps.setString(3, prsona.getNacionalidad());
          ps.setString(4, prsona.getDireccion());
          ps.setString(5, prsona.getTelefono());
          ps.setString(6, prsona.getEmail());
          ps.setString(7, prsona.getFechaDeNacimiento());
          ps.execute();
          return true;
          } catch (SQLException e) {
          System.err.println(e);
          return false;
          } finally {
          try {
          con.close();
          } catch (SQLException e) {
          System.err.println(e);
          }
          }
          }


          public boolean modificarPersona(Persona prsona) throws SQLException, PersistenciaException {
          PreparedStatement ps = null;
          Conexion nuevoObjetoConexion = new Conexion();
          Connection con = nuevoObjetoConexion.conectar();
          String sql = "UPDATE Persona SET cedulaIdentidad=?, nombre=?, nacionalidad=?, direccion=?, telefono=?, email=?, fechaDeNacimiento=? WHERE cedulaIdentidad=?";
          try {
          ps = con.prepareStatement(sql);
          ps.setString(1, prsona.getCedulaDeIdentidad());
          ps.setString(2, prsona.getNombre());
          ps.setString(3, prsona.getNacionalidad());
          ps.setString(4, prsona.getDireccion());
          ps.setString(5, prsona.getTelefono());
          ps.setString(6, prsona.getEmail());
          ps.setString(7, prsona.getFechaDeNacimiento());
          ps.setString(8, prsona.getCedulaDeIdentidad());
          ps.execute();
          return true;
          } catch (SQLException e) {
          System.err.println(e);
          return false;
          } finally {
          try {
          con.close();
          } catch (SQLException e) {
          System.err.println(e);
          }
          }
          }
          public boolean eliminarPersona(Persona prsona) throws SQLException, PersistenciaException {
          PreparedStatement ps = null;
          Conexion nuevoObjetoConexion = new Conexion();
          Connection con = nuevoObjetoConexion.conectar();
          String sql = "DELETE FROM Persona WHERE cedulaIdentidad=?";
          try {
          ps = con.prepareStatement(sql);
          ps.setString(1, prsona.getCedulaDeIdentidad());
          ps.execute();
          return true;
          } catch (SQLException e) {
          System.err.println(e);
          return false;
          } finally {
          try {
          con.close();
          } catch (SQLException e) {
          System.err.println(e);
          }
          }
          }
          /*
          public static boolean buscarPersona(Persona prsona) throws SQLException, PersistenciaException {
          PreparedStatement ps = null;
          ResultSet rs = null;
          Conexion nuevoObjetoConexion = new Conexion();
          Connection con = nuevoObjetoConexion.conectar();
          String sql = "SELECT * FROM Persona WHERE cedulaIdentidad=?";
          try {
          ps = con.prepareStatement(sql);
          ps.setString(1, prsona.getCedulaDeIdentidad());
          rs = ps.executeQuery();
          if(rs.next())
          {
          prsona.setCedulaDeIdentidad(rs.getString("cedulaIdentidad"));
          prsona.setNombre(rs.getString("nombre"));
          prsona.setNacionalidad(rs.getString("nacionalidad"));
          prsona.setDireccion(rs.getString("direccion"));
          prsona.setTelefono(rs.getString("telefono"));
          prsona.setEmail(rs.getString("email"));
          prsona.setFechaDeNacimiento(rs.getString("fechaDeNacimiento"));
          return true;
          }
          return false;
          } catch (SQLException e) {
          System.err.println(e);
          return false;
          } finally {
          try {
          con.close();
          } catch (SQLException e) {
          System.err.println(e);
          }
          }
          }
            catch (SQLException ex) {
              Logger.getLogger(PersonaPersistencia.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}

//public boolean validarLogin (Usuario nuevoObjetoUsuario) throws persistenciaExcepion{
// }
/*
    
    public Usuarios altaUsuarios(){
         // paso 1 : crear la conexion a la base
         // paso 2 : crear el prepare statement
         // paso 3 : ejecutar la consulta de prepare statement
         // paso 4 : cargar los resultados de los objetos de la capa logica si es un select la consulta
         // paso 5 : cerrar la conexion de la base
    }
    
    public Usuarios bajaUsuarios(){
         // paso 1 : crear la conexion a la base
         // paso 2 : crear el prepare statement
         // paso 3 : ejecutar la consulta de prepare statement
         // paso 4 : cargar los resultados de los objetos de la capa logica si es un select la consulta
         // paso 5 : cerrar la conexion de la base
    }

 */
