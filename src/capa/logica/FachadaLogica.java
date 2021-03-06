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
import capa.presentacion.VentanaPrincipal;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import excepciones.PersonaException;
import excepciones.UsuarioException;
import java.sql.SQLException;

/**
 *
 * @author a
 */
public class FachadaLogica {

    /**
     *
     * @param nuevoObjetoUsuario
     * @return
     * @throws PersistenciaException
     */
    public static Boolean existeUsuario(Usuario nuevoObjetoUsuario) throws PersistenciaException {

        Boolean existe = false;
        existe = UsuarioPersistencia.existeUsuario(nuevoObjetoUsuario);
        return existe;
    }

    /*public static void ingresarUsuario(Usuario nuevoObjetoUsuario) throws UsuarioException, PersistenciaException {

        UsuarioPersistencia.ingresarUsuario(nuevoObjetoUsuario);
        
    }
     */

    /**
     *
     * @return
     * @throws PersonaException
     */

    public static Personas listarPersonas() throws PersonaException {
        PersonaPersistencia pers = new PersonaPersistencia();

        Personas mostrarPersonas = pers.listarPersonas();

        return mostrarPersonas;

    }

    /**
     *
     * @return
     * @throws NegocioException
     */
    public static Negocios listarNegocios() throws NegocioException {
        NegocioPersistencia neg = new NegocioPersistencia();

        Negocios mostrarNegocios = neg.listarNegocios();

        return mostrarNegocios;

    }
    
    public static void agregarPersona(Persona persona) throws PersonaException{
        PersonaPersistencia per = new PersonaPersistencia();
        per.agregarPersona(persona);
        }
        
    /* public static String[] buscarPersona() throws PersistenciaException, SQLException, PersonaException
    {
        
    }
    /*
    /* private Persona mod;
    private PersonaPersistencia modP;
    private pruebaPrincipal prueba;
    
    public FachadaLogica(Persona mod, PersonaPersistencia modP, pruebaPrincipal prueba)
    {
        this.mod = mod;
        this.modP = modP;
        this.prueba = prueba;
        this.prueba.btnGuardar.addActionListener(this);
        this.prueba.btnModificar.addActionListener(this);
        this.prueba.btnBorrar.addActionListener(this);
        this.prueba.btnLimpiar.addActionListener(this);
        this.prueba.btnBuscar.addActionListener(this);
    }
        
        public void iniciar()
        {
            prueba.setTitle("Personas");
            prueba.setLocationRelativeTo(null);
            prueba.txtId.setVisible(false);
        }
        
        /*
        public void actionPerfomed(ActionEvent e) throws SQLException, PersistenciaException
          
        {
            // Segun el boton que presione el usuario, ejecuta una accion para ingresar, guardar etc una Persona
            if(e.getSource()== prueba.btnGuardar){  
                
                mod.setCedulaDeIdentidad(prueba.txtCedula.getText());
                mod.setNombre(prueba.txtNombre.getText());
                mod.setNacionalidad(prueba.txtNacionalidad.getText());
                mod.setDireccion(prueba.txtDireccion.getText());
                mod.setTelefono(prueba.txtTelefono.getText());
                mod.setEmail(prueba.txtEmail.getText());
                mod.setFechaDeNacimiento(prueba.txtNacimiento.getText());
                
                if(modP.ingresarPersona(mod)){
                    JOptionPane.showMessageDialog(null, "Registro guardado ex??tosamente");
                    borrar();
                } else{
                    JOptionPane.showMessageDialog(null, "Error al registrar la persona");
                    borrar();
                }
            }
            
            if(e.getSource()== prueba.btnModificar){  
                
                mod.setCedulaDeIdentidad(prueba.txtCedula.getText());
                mod.setNombre(prueba.txtNombre.getText());
                mod.setNacionalidad(prueba.txtNacionalidad.getText());
                mod.setDireccion(prueba.txtDireccion.getText());
                mod.setTelefono(prueba.txtTelefono.getText());
                mod.setEmail(prueba.txtEmail.getText());
                mod.setFechaDeNacimiento(prueba.txtNacimiento.getText());
                
                if(modP.modificarPersona(mod)){
                    JOptionPane.showMessageDialog(null, "Registro modificado ex??tosamente");
                    borrar();
                } else{
                    JOptionPane.showMessageDialog(null, "Error al modificar la persona");
                    borrar();
                }
            }
           
            if(e.getSource()== prueba.btnBorrar){  
                
                mod.setCedulaDeIdentidad(prueba.txtCedula.getText());
                
                if(modP.eliminarPersona(mod)){
                    JOptionPane.showMessageDialog(null, "Persona borrada ex??tosamente");
                    borrar();
                } else{
                    JOptionPane.showMessageDialog(null, "Error al eliminar la persona");
                    borrar();
                }
            }
            
            if(e.getSource()== prueba.btnBuscar){  
                
                mod.setCedulaDeIdentidad(prueba.txtCedula.getText());
                
                if(modP.buscarPersona(mod))
                {
                    prueba.txtCedula.setText(mod.getCedulaDeIdentidad());
                    prueba.txtNombre.setText(mod.getNombre());
                    prueba.txtNacionalidad.setText(mod.getNacionalidad());
                    prueba.txtDireccion.setText(mod.getDireccion());
                    prueba.txtTelefono.setText(mod.getTelefono());
                    prueba.txtEmail.setText(mod.getEmail());
                    prueba.txtNacimiento.setText(mod.getFechaDeNacimiento());
                    
                    
                } 
                else{
                    JOptionPane.showMessageDialog(null, "No se encontr?? la persona buscada");
                }
            }
            
                if(e.getSource()== prueba.btnLimpiar){
                    borrar();
                }
            
        }
     */
}
