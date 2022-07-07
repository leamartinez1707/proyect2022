/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.presentacion;

import capa.persistencia.usuarioPersistencia;
import capa.logica.Usuario;
import java.sql.DriverManager;

/**
 *
 * @author a
 */

// JDBC  CONNECTOR:
// jdbc:mysql://localhost:3306/ProyectoBios2022NombrePendiente?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]
public class VentanaLogin extends javax.swing.JFrame {

    public String usuarioEscrito = " ";
    public String claveEscrita = " ";
    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuario = new javax.swing.JLabel();
        labelClave = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoClave = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonConectar = new javax.swing.JButton();
        labelIniciarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("ventanaInicioSesion"); // NOI18N
        setResizable(false);

        labelUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelUsuario.setText("Usuario");

        labelClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelClave.setText("Contraseña");

        campoUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        campoClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        botonCancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonConectar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        labelIniciarSesion.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelIniciarSesion.setText("Iniciar Sesión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(botonConectar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsuario)
                            .addComponent(labelClave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(campoClave))))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(labelIniciarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelIniciarSesion)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClave))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonConectar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        usuarioEscrito = campoUsuario.getText();
        claveEscrita = campoClave.getText();
        
        Usuario nuevoObjetoUsuario = new Usuario();
        nuevoObjetoUsuario.nombreDelUsuario = usuarioEscrito;
        nuevoObjetoUsuario.claveDelUsuario = claveEscrita;

        System.out.println("Usuario escito: " + usuarioEscrito);
        System.out.println("Contraseña escita: " + claveEscrita);

        System.out.print("nuevoObjetoUsuario.nombreDelUsuario: ");
        System.out.println(nuevoObjetoUsuario.nombreDelUsuario);
        
        System.out.print("nuevoObjetoUsuario.claveDelUsuario: ");
        System.out.println(nuevoObjetoUsuario.claveDelUsuario);    
        
        // invoco al existeUsuario con el usuario que cargue en memoria para saber que existe en la base
        
        usuarioPersistencia nuevoObjetoUsuarioPersistencia = new usuarioPersistencia();
        boolean existeUsuario = nuevoObjetoUsuarioPersistencia.existeUsuario(nuevoObjetoUsuario);
        if (existeUsuario) {
            System.out.println("El usuario existe");
        } else {
            System.out.println("El usuario no existe");
        }
        
        DriverManager.getDrivers();
    }//GEN-LAST:event_botonConectarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConectar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel labelClave;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}