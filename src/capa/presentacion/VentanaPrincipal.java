package capa.presentacion;

import capa.logica.FachadaLogica;
import capa.logica.Negocio;
import capa.logica.Negocios;
import capa.logica.Persona;
import capa.logica.Personas;
import excepciones.NegocioException;
import excepciones.PersonaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     *
     */
    public VentanaPrincipal() {
        
        
            initComponents();
            setLocationRelativeTo(null);
            setTitle("PROYECTO BIOS 2022 - JAVA ");
            setResizable(false);
            
            
        try {
            
        // MOSTRAR PERSONAS EN LA TABLA PERSONA            
            Personas personas = FachadaLogica.listarPersonas();
            Object[] bPersonas = new Object[7];
            DefaultTableModel modelo = (DefaultTableModel) tablaPersona.getModel();
            for (int i = 0; i < personas.getPersonas().size(); i++) {
                Persona persona = personas.getPersonas().get(i);
                bPersonas[0] = persona.getCedulaDeIdentidad();
                bPersonas[1] = persona.getNombre();
                bPersonas[2] = persona.getNacionalidad();
                bPersonas[3] = persona.getDireccion();
                bPersonas[4] = persona.getTelefono();
                bPersonas[5] = persona.getEmail();
                bPersonas[6] = persona.getFechaDeNacimiento();
                modelo.addRow(bPersonas);

            }
            tablaPersona.setModel(modelo);
        } catch (PersonaException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            //ACA PONGAN UN MENSJAE AL USUARIO
        } 
        // FINALIZA MOSTRAR PERSONAS
        
        // MOSTRAR NEGOCIOS EN LA TABLA NEGOCIOS
        
        try {
            
            Negocios negocios = FachadaLogica.listarNegocios();
            Object[] bNegocios = new Object[3];
            DefaultTableModel modeloNeg = (DefaultTableModel) tablaNegocios.getModel();
            for (int i = 0; i < negocios.getNegocios().size(); i++) {
                Negocio negocio = negocios.getNegocios().get(i);
                bNegocios[0] = negocio.getIdNegocio();
                bNegocios[1] = negocio.getIdTipoDeNegocio();
                bNegocios[2] = negocio.getIdAfiliado();
                modeloNeg.addRow(bNegocios);
                }
                tablaNegocios.setModel(modeloNeg);
    }
        catch (NegocioException e) {
        }
        }
        // FINALIZA MOSTRAR NEGOCIOS     
               
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelAfiliados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersona = new javax.swing.JTable();
        btnAgregarAfiliado = new javax.swing.JButton();
        btnModificarAfiliado = new javax.swing.JButton();
        btnEliminarAfiliado = new javax.swing.JButton();
        btnLimpiarCeldas = new javax.swing.JButton();
        txtCedulaIdentidad = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelNegocios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNegocios = new javax.swing.JTable();
        jPanel1IdNegocio = new javax.swing.JPanel();
        jLabel1IdNegocio = new javax.swing.JLabel();
        txtTipoDeNegocio = new javax.swing.JTextField();
        jPanel5IdTipoNegocio = new javax.swing.JPanel();
        jLabel2IdTipoNegocio = new javax.swing.JLabel();
        txtIdNegocio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panelLocales = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("ventanaPrincipal"); // NOI18N
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        panelAfiliados.setBackground(new java.awt.Color(204, 204, 204));
        panelAfiliados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C.I", "Nombre", "Nacionalidad", "Direccion", "Telefono", "Email", "Fecha de nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaPersona.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tablaPersona.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tablaPersona);

        panelAfiliados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 670, 150));

        btnAgregarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliado.setText("REGISTRAR");
        btnAgregarAfiliado.setActionCommand("REGISTRAR");
        btnAgregarAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAfiliadoActionPerformed(evt);
            }
        });
        panelAfiliados.add(btnAgregarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        btnModificarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarAfiliado.setText("MODIFICAR");
        btnModificarAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelAfiliados.add(btnModificarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        btnEliminarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarAfiliado.setText("ELIMINAR");
        btnEliminarAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelAfiliados.add(btnEliminarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        btnLimpiarCeldas.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldas.setText("LIMPIAR");
        btnLimpiarCeldas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelAfiliados.add(btnLimpiarCeldas, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 310, 100, -1));

        txtCedulaIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedulaIdentidad.setForeground(new java.awt.Color(153, 153, 153));
        txtCedulaIdentidad.setText("Inserte Cedula");
        txtCedulaIdentidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCedulaIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaIdentidadActionPerformed(evt);
            }
        });
        panelAfiliados.add(txtCedulaIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 170, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Inserte Nombre");
        txtNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAfiliados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 170, -1));

        txtNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNacionalidad.setForeground(new java.awt.Color(153, 153, 153));
        txtNacionalidad.setText("Inserte Nacionalidad");
        txtNacionalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAfiliados.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 170, -1));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setText("Inserte Direccion");
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        panelAfiliados.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 170, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setText("Inserte Telefono");
        txtTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAfiliados.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 170, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setText("Inserte Email");
        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAfiliados.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 170, -1));

        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFechaNacimiento.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNacimiento.setText("Inserte Fecha De Nacimiento");
        txtFechaNacimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAfiliados.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CEDULA");
        panelAfiliados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NOMBRE");
        panelAfiliados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NACIONALIDAD");
        panelAfiliados.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("DIRECCION");
        panelAfiliados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TELEFONO");
        panelAfiliados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("EMAIL");
        panelAfiliados.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("FECHA DE NACIMIENTO");
        panelAfiliados.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jTabbedPane1.addTab("Afiliados", panelAfiliados);

        panelNegocios.setBackground(new java.awt.Color(255, 255, 255));
        panelNegocios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaNegocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Negocio", "Id tipo de negocio", "Id Afiliado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaNegocios);

        panelNegocios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 340, 420));

        jPanel1IdNegocio.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1IdNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1IdNegocio.setName("Id Negocio"); // NOI18N

        jLabel1IdNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1IdNegocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1IdNegocio.setText("ID NEGOCIO");

        javax.swing.GroupLayout jPanel1IdNegocioLayout = new javax.swing.GroupLayout(jPanel1IdNegocio);
        jPanel1IdNegocio.setLayout(jPanel1IdNegocioLayout);
        jPanel1IdNegocioLayout.setHorizontalGroup(
            jPanel1IdNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1IdNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel1IdNegocioLayout.setVerticalGroup(
            jPanel1IdNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1IdNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        panelNegocios.add(jPanel1IdNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 100, 20));
        jPanel1IdNegocio.getAccessibleContext().setAccessibleDescription("");

        txtTipoDeNegocio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipoDeNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelNegocios.add(txtTipoDeNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 110, -1));

        jPanel5IdTipoNegocio.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2IdTipoNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2IdTipoNegocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2IdTipoNegocio.setText("ID TIPO DE NEGOCIO");

        javax.swing.GroupLayout jPanel5IdTipoNegocioLayout = new javax.swing.GroupLayout(jPanel5IdTipoNegocio);
        jPanel5IdTipoNegocio.setLayout(jPanel5IdTipoNegocioLayout);
        jPanel5IdTipoNegocioLayout.setHorizontalGroup(
            jPanel5IdTipoNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5IdTipoNegocioLayout.createSequentialGroup()
                .addComponent(jLabel2IdTipoNegocio)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5IdTipoNegocioLayout.setVerticalGroup(
            jPanel5IdTipoNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2IdTipoNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        panelNegocios.add(jPanel5IdTipoNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, 20));

        txtIdNegocio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdNegocio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelNegocios.add(txtIdNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 110, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID AFILIADO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        panelNegocios.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 90, 20));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelNegocios.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 110, 20));

        jTabbedPane1.addTab("Negocios", panelNegocios);

        panelLocales.setBackground(new java.awt.Color(255, 255, 255));
        panelLocales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Locales", panelLocales);

        background.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAfiliadoActionPerformed
        try {
            Persona persona = new Persona();
            
            String cedulaDeIdentidad = txtCedulaIdentidad.getText();
            String nombre = txtNombre.getText();
            String nacionalidad = txtNacionalidad.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String fechaDeNacimiento = txtFechaNacimiento.getText();
            
            persona.setCedulaDeIdentidad(cedulaDeIdentidad);
            persona.setNombre(nombre);
            persona.setNacionalidad(nacionalidad);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setFechaDeNacimiento(fechaDeNacimiento);
            
            FachadaLogica.agregarPersona(persona);
        } catch (PersonaException ex) {
            
                    
        }
    }//GEN-LAST:event_btnAgregarAfiliadoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCedulaIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaIdentidadActionPerformed

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAgregarAfiliado;
    private javax.swing.JButton btnEliminarAfiliado;
    private javax.swing.JButton btnLimpiarCeldas;
    private javax.swing.JButton btnModificarAfiliado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1IdNegocio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2IdTipoNegocio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1IdNegocio;
    private javax.swing.JPanel jPanel5IdTipoNegocio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JPanel panelAfiliados;
    public javax.swing.JPanel panelLocales;
    public javax.swing.JPanel panelNegocios;
    private javax.swing.JTable tablaNegocios;
    private javax.swing.JTable tablaPersona;
    public javax.swing.JTextField txtCedulaIdentidad;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtIdNegocio;
    public javax.swing.JTextField txtNacionalidad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoDeNegocio;
    // End of variables declaration//GEN-END:variables
}
