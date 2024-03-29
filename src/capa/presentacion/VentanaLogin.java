/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.presentacion;

import capa.logica.FachadaLogica;
import capa.logica.Usuario;
import excepciones.PersistenciaException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
// JDBC  CONNECTOR:
// jdbc:mysql://localhost:3306/ProyectoBios2022NombrePendiente?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]
public class VentanaLogin extends javax.swing.JFrame {

    /**
     *
     */
    public String usuarioEscrito = " ";

    /**
     *
     */
    public String claveEscrita = " ";

    /**
     * Creates new form VentanaLogin
     */
    public VentanaLogin() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("Login Proyecto 2022 - Biosearcher");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContrasena = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoClave = new javax.swing.JPasswordField();
        botonCancelar = new javax.swing.JButton();
        botonConectar = new javax.swing.JButton();
        botonRegistrarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnInstrucciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName("ventanaInicioSesion"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/imagPro.jpeg"))); // NOI18N
        jPanel1.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 480, 310));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUsuario.setText("Usuario:");
        jLabelUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 80, 40));

        jLabelContrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelContrasena.setText("Contraseña: ");
        jPanel1.add(jLabelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 90, 40));

        campoUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        campoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(campoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 90, -1));

        campoClave.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(campoClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 90, -1));

        botonCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        botonCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 110, 40));

        botonConectar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });
        botonConectar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonConectarKeyPressed(evt);
            }
        });
        jPanel1.add(botonConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 100, 40));

        botonRegistrarse.setText("REGISTRARSE");
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });
        botonRegistrarse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botonRegistrarseKeyPressed(evt);
            }
        });
        jPanel1.add(botonRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 110, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("PROYECTO BIOS 2022");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 270, 40));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 260, 10));

        btnInstrucciones.setText("Instrucciones");
        btnInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruccionesActionPerformed(evt);
            }
        });
        btnInstrucciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnInstruccionesKeyPressed(evt);
            }
        });
        jPanel1.add(btnInstrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        try {
            // Llamo a la fachada logica

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

            Boolean existe = FachadaLogica.existeUsuario(nuevoObjetoUsuario);
            if (existe) {
                // Le doy la bienvenida al usuario ingresado.
                JOptionPane.showMessageDialog(null, "Usuario correcto");
                JOptionPane.showMessageDialog(null, "Bienvenido/a " + usuarioEscrito);
                VentanaPrincipal nuevaVentanaPrincipal = new VentanaPrincipal();
                nuevaVentanaPrincipal.setVisible(true);
                this.setVisible(false);
            } else {
                // No existe, no lo dejo ingresar
                JOptionPane.showMessageDialog(null, "El usuario ingresado no existe");
                System.out.println("No existe el usuario");
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonConectarActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed

        VentanaGestionUsuarios nuevaVentanaGestionUsuarios = new VentanaGestionUsuarios();
        nuevaVentanaGestionUsuarios.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    private void botonConectarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonConectarKeyPressed

        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            botonConectar.doClick();
        }
    }//GEN-LAST:event_botonConectarKeyPressed

    private void botonCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonCancelarKeyPressed

        char fTeclaPresionada = evt.getKeyChar();

        if (fTeclaPresionada == KeyEvent.VK_ENTER) {
            botonCancelar.doClick();
        }
    }//GEN-LAST:event_botonCancelarKeyPressed

    private void botonRegistrarseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botonRegistrarseKeyPressed
        char rTeclaPresionada = evt.getKeyChar();

        if (rTeclaPresionada == KeyEvent.VK_ENTER) {
            botonRegistrarse.doClick();
        }
    }//GEN-LAST:event_botonRegistrarseKeyPressed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed

        Instrucciones instru = new Instrucciones();
        instru.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    private void btnInstruccionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnInstruccionesKeyPressed
        char zTeclaPresionada = evt.getKeyChar();

        if (zTeclaPresionada == KeyEvent.VK_ENTER) {
            btnInstrucciones.doClick();
        }
    }//GEN-LAST:event_btnInstruccionesKeyPressed

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
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelContrasena;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
