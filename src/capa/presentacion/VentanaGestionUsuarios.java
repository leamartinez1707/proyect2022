/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.presentacion;

import capa.logica.FachadaLogica;
import capa.logica.Persona;
import capa.logica.Personas;
import capa.logica.Usuario;
import capa.logica.Usuarios;
import excepciones.PersistenciaException;
import excepciones.PersonaException;
import excepciones.UsuarioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
public class VentanaGestionUsuarios extends javax.swing.JFrame {

    public String usuarioEscrito = " ";
    public String claveEscrita = " ";
    
    /**
     * Creates new form VentanaGestionUsuarios
     */
    public VentanaGestionUsuarios() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gestión de Usuarios");
        
        try {
            
        // MOSTRAR USUARIOS EN LA TABLA USUARIOS        
            Usuarios usuarios = FachadaLogica.listarUsuarios();
            Object[] bUsuarios = new Object[2];
            DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
            modelo.setRowCount(0);
            for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
                Usuario usuario = usuarios.getUsuarios().get(i);
                bUsuarios[0] = usuario.getNombreDelUsuario();
                bUsuarios[1] = usuario.getClaveDelUsuario();
               
                modelo.addRow(bUsuarios);

            }
            tablaUsuarios.setModel(modelo);
        } catch (UsuarioException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            //ACA PONGAN UN MENSJAE AL USUARIO
        } 
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabelGestionUsuarios = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoClave = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelClave = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frameGestionUsuarios"); // NOI18N
        setResizable(false);

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Contraseña"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabelGestionUsuarios.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelGestionUsuarios.setText("Gestión de usuarios");

        campoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        campoClave.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoClaveActionPerformed(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelUsuario.setText("Usuario");

        jLabelClave.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelClave.setText("Contraseña");

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelClave)
                    .addComponent(jLabelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(botonActualizar)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelGestionUsuarios)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonVolver)
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelGestionUsuarios)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUsuario))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelClave)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(botonAgregar)
                        .addGap(35, 35, 35)
                        .addComponent(botonBorrar)))
                .addGap(6, 6, 6)
                .addComponent(botonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoClaveActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        try {
            //Llamo a la fachada logica
            
            usuarioEscrito = campoUsuario.getText();
            
            Usuario nuevoObjetoUsuario = new Usuario();
            nuevoObjetoUsuario.nombreDelUsuario = usuarioEscrito;
            
            System.out.println("Usuario escrito: " + usuarioEscrito);
            
            System.out.print("nuevoObjetoUsuario.nombreDelUsuario: ");
            System.out.println(nuevoObjetoUsuario.nombreDelUsuario);            
            
            Boolean existe = FachadaLogica.existeUsuarioParaGestionar(nuevoObjetoUsuario);
            if (existe) {
                //Borro el usuario
                System.out.println("El usuario escrito si existe");
                FachadaLogica.bajaUsuario(nuevoObjetoUsuario);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");

            } else {
                //No borro el usuario, porque no existe.
                System.out.println("El usuario escrito no existe");
                JOptionPane.showMessageDialog(null, "El usuario " + usuarioEscrito + " no puede ser borrado porque no existe.");
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            actualizarListaDeUsuarios();
        }    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        try {
            //Llamo a la fachada logica
            
            usuarioEscrito = campoUsuario.getText();
            claveEscrita = campoClave.getText();
            
            Usuario nuevoObjetoUsuario = new Usuario();
            nuevoObjetoUsuario.nombreDelUsuario = usuarioEscrito;
            nuevoObjetoUsuario.claveDelUsuario = claveEscrita;
            
            System.out.println("Usuario escrito: " + usuarioEscrito);
            System.out.println("Contraseña escrita: " + claveEscrita);
            
            System.out.print("nuevoObjetoUsuario.nombreDelUsuario: ");
            System.out.println(nuevoObjetoUsuario.nombreDelUsuario);
            
            System.out.print("nuevoObjetoUsuario.claveDelUsuario: ");
            System.out.println(nuevoObjetoUsuario.claveDelUsuario);
            
            
            Boolean existe = FachadaLogica.existeUsuarioParaGestionar(nuevoObjetoUsuario);
            if (existe) {
                //No agrego el usuario, porque ya existe.
                System.out.println("El usuario ya existe");
                JOptionPane.showMessageDialog(null, "El usuario " + usuarioEscrito + " ya existe.");
            } else {
                //Agrego el usuario
                System.out.println("Usuario agregado correctamente");
                FachadaLogica.altaUsuario(nuevoObjetoUsuario);
                JOptionPane.showMessageDialog(null, "Usuario agregado satisfactoriamente");
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            actualizarListaDeUsuarios();
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        VentanaLogin venL = new VentanaLogin();
        venL.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        
        actualizarListaDeUsuarios();
    }//GEN-LAST:event_botonActualizarActionPerformed

    
    private void actualizarListaDeUsuarios(){
        try {
            
        // MOSTRAR USUARIOS EN LA TABLA USUARIOS           
            Usuarios usuarios = FachadaLogica.listarUsuarios();
            Object[] bUsuarios = new Object[2];
            DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
            modelo.setRowCount(0);
            for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
                Usuario usuario = usuarios.getUsuarios().get(i);
                bUsuarios[0] = usuario.getNombreDelUsuario();
                bUsuarios[1] = usuario.getClaveDelUsuario();
               
                modelo.addRow(bUsuarios);

            }
            tablaUsuarios.setModel(modelo);
        } catch (UsuarioException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGestionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabelClave;
    private javax.swing.JLabel jLabelGestionUsuarios;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
