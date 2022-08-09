package capa.presentacion;

import capa.logica.FachadaLogica;
import capa.logica.Negocio;
import capa.logica.Negocios;
import capa.logica.Persona;
import capa.logica.Personas;
import capa.logica.TipoDeNegocio;
import capa.logica.TiposDeNegocios;
import excepciones.NegocioException;
import excepciones.PersonaException;
import excepciones.TiposDeNegocioException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
            
        } 
        // FINALIZA MOSTRAR PERSONAS
        
        // MOSTRAR NEGOCIOS EN LA TABLA NEGOCIOS
        
        try {
            
            Negocios negocios = FachadaLogica.listarNegocios();
            Object[] bNegocios = new Object[4];
            DefaultTableModel modeloNeg = (DefaultTableModel) tablaNegocios.getModel();
            
            for (int i = 0; i < negocios.getNegocios().size(); i++) {
                
                Negocio negocio = negocios.getNegocios().get(i);
                
                bNegocios[0] = negocio.getIdNegocio();
                bNegocios[1] = negocio.getIdTipoDeNegocio();
                bNegocios[2] = negocio.getIdAfiliado();
                bNegocios[3] = negocio.getNombreNegocio();
                modeloNeg.addRow(bNegocios);
                }
                tablaNegocios.setModel(modeloNeg);
    }
        catch (NegocioException e) {
        }
        
        // FINALIZA MOSTRAR NEGOCIOS     
               
    // MOSTRAR TIPOS DE NEGOCIOS
    
            try{
            TiposDeNegocios tiposDeNegocios = FachadaLogica.listarTiposDeNegocios();
            Object[] bTipoNegocios = new Object[2];
            DefaultTableModel modeloTipoNeg = (DefaultTableModel) tablaTiposDeNegocios.getModel();
            
            
            for (int i = 0; i < tiposDeNegocios.getTiposDeNegocios().size(); i++){
        
                TipoDeNegocio tipoDeNegocio = tiposDeNegocios.getTiposDeNegocios().get(i);
                
                bTipoNegocios[0] = tipoDeNegocio.getIdTipoDeNegocio();
                bTipoNegocios[1] = tipoDeNegocio.getDescripcion();
                modeloTipoNeg.addRow(bTipoNegocios);
                }
            
                tablaTiposDeNegocios.setModel(modeloTipoNeg);
    }
    
        catch (TiposDeNegocioException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelPestañas = new javax.swing.JTabbedPane();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        botonActPersona = new javax.swing.JButton();
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
        txtIdAfiliado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgregarNegocio = new javax.swing.JButton();
        btnModificarNegocio = new javax.swing.JButton();
        btnEliminarNegocio = new javax.swing.JButton();
        btnLimpiarCeldasNeg = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTiposDeNegocios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreNegocio = new javax.swing.JTextField();
        botonActualizarNeg = new javax.swing.JButton();
        panelLocales = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("ventanaPrincipal"); // NOI18N
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPestañas.setBackground(new java.awt.Color(255, 255, 255));
        panelPestañas.setMinimumSize(new java.awt.Dimension(800, 600));

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

        panelAfiliados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 770, 150));

        btnAgregarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliado.setText("REGISTRAR");
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
        txtCedulaIdentidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCedulaIdentidadMousePressed(evt);
            }
        });
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
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        panelAfiliados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 170, -1));

        txtNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNacionalidad.setForeground(new java.awt.Color(153, 153, 153));
        txtNacionalidad.setText("Inserte Nacionalidad");
        txtNacionalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNacionalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNacionalidadMousePressed(evt);
            }
        });
        panelAfiliados.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 170, -1));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setText("Inserte Direccion");
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDireccionMousePressed(evt);
            }
        });
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
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        panelAfiliados.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 170, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setText("Inserte Email");
        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        panelAfiliados.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 170, -1));

        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFechaNacimiento.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNacimiento.setText("Inserte Fecha De Nacimiento");
        txtFechaNacimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoMousePressed(evt);
            }
        });
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

        jLabel9.setText("año-mes-día");
        panelAfiliados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 80, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("ABM Afiliados");
        panelAfiliados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 130, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelAfiliados.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 210, 10));
        panelAfiliados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        botonActPersona.setText("Actualizar");
        botonActPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActPersonaActionPerformed(evt);
            }
        });
        panelAfiliados.add(botonActPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        panelPestañas.addTab("Afiliados", panelAfiliados);

        panelNegocios.setBackground(new java.awt.Color(204, 204, 204));
        panelNegocios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaNegocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Negocio", "Id tipo de negocio", "Id Afiliado", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaNegocios);

        panelNegocios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, 190));

        jPanel1IdNegocio.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1IdNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1IdNegocio.setName("Id Negocio"); // NOI18N

        jLabel1IdNegocio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1IdNegocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1IdNegocio.setText("ID NEGOCIO");

        javax.swing.GroupLayout jPanel1IdNegocioLayout = new javax.swing.GroupLayout(jPanel1IdNegocio);
        jPanel1IdNegocio.setLayout(jPanel1IdNegocioLayout);
        jPanel1IdNegocioLayout.setHorizontalGroup(
            jPanel1IdNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1IdNegocioLayout.createSequentialGroup()
                .addComponent(jLabel1IdNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1IdNegocioLayout.setVerticalGroup(
            jPanel1IdNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1IdNegocioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1IdNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelNegocios.add(jPanel1IdNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 80, 20));
        jPanel1IdNegocio.getAccessibleContext().setAccessibleDescription("");

        txtTipoDeNegocio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipoDeNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelNegocios.add(txtTipoDeNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 110, -1));

        jPanel5IdTipoNegocio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2IdTipoNegocio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        panelNegocios.add(jPanel5IdTipoNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, 20));

        txtIdNegocio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdNegocio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelNegocios.add(txtIdNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 110, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        panelNegocios.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 90, 20));

        txtIdAfiliado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelNegocios.add(txtIdAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 110, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("ABM Negocios");
        panelNegocios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 130, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelNegocios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 210, 10));

        btnAgregarNegocio.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarNegocio.setText("REGISTRAR");
        btnAgregarNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNegocioActionPerformed(evt);
            }
        });
        panelNegocios.add(btnAgregarNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        btnModificarNegocio.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarNegocio.setText("MODIFICAR");
        btnModificarNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelNegocios.add(btnModificarNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        btnEliminarNegocio.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarNegocio.setText("ELIMINAR");
        btnEliminarNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelNegocios.add(btnEliminarNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        btnLimpiarCeldasNeg.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldasNeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldasNeg.setText("LIMPIAR");
        btnLimpiarCeldasNeg.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelNegocios.add(btnLimpiarCeldasNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 100, -1));

        tablaTiposDeNegocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Tipo de negocio", "Rubro"
            }
        ));
        jScrollPane3.setViewportView(tablaTiposDeNegocios);

        panelNegocios.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 230, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("NOMBRE DEL NEGOCIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelNegocios.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 140, 20));

        txtNombreNegocio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelNegocios.add(txtNombreNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 110, 20));

        botonActualizarNeg.setText("Actualizar");
        botonActualizarNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarNegActionPerformed(evt);
            }
        });
        panelNegocios.add(botonActualizarNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, -1, 30));

        panelPestañas.addTab("Negocios", panelNegocios);

        panelLocales.setBackground(new java.awt.Color(255, 255, 255));
        panelLocales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelPestañas.addTab("Locales", panelLocales);

        background.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

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

    private void txtFechaNacimientoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacimientoMousePressed
        txtFechaNacimiento.setText("");
        txtFechaNacimiento.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtFechaNacimientoMousePressed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        txtEmail.setText("");
        txtEmail.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        txtTelefono.setText("");
        txtTelefono.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMousePressed
        txtDireccion.setText("");
        txtDireccion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtDireccionMousePressed

    private void txtNacionalidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNacionalidadMousePressed
        txtNacionalidad.setText("");
        txtNacionalidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtNacionalidadMousePressed

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        txtNombre.setText("");
        txtNombre.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtCedulaIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaIdentidadActionPerformed

    private void txtCedulaIdentidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaIdentidadMousePressed
        txtCedulaIdentidad.setText("");
        txtCedulaIdentidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtCedulaIdentidadMousePressed

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
            
            JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
        } catch (PersonaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la persona");

        }
    }//GEN-LAST:event_btnAgregarAfiliadoActionPerformed

    private void btnAgregarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNegocioActionPerformed
        try {
            Negocio negocio = new Negocio();

            // String idNegocio = txtIdNegocio.getText();
            String idTipoDeNegocio = txtTipoDeNegocio.getText();
            String idAfiliado = txtIdAfiliado.getText();
            String nombreNegocio = txtNombreNegocio.getText();
            
            
            
            // negocio.setIdNegocio(idNegocio);
            negocio.setIdTipoDeNegocio(idTipoDeNegocio);
            negocio.setIdAfiliado(idAfiliado);
            negocio.setNombreNegocio(nombreNegocio);

            FachadaLogica.agregarNegocio(negocio);
            JOptionPane.showMessageDialog(null, "Negocio agregado correctamente");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el negocio");

        }
    }//GEN-LAST:event_btnAgregarNegocioActionPerformed

    private void botonActualizarNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarNegActionPerformed
        
    }//GEN-LAST:event_botonActualizarNegActionPerformed

    private void botonActPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActPersonaActionPerformed
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
            
        } 
    }//GEN-LAST:event_botonActPersonaActionPerformed


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
    private javax.swing.JButton botonActPersona;
    private javax.swing.JButton botonActualizarNeg;
    private javax.swing.JButton btnAgregarAfiliado;
    private javax.swing.JButton btnAgregarNegocio;
    private javax.swing.JButton btnEliminarAfiliado;
    private javax.swing.JButton btnEliminarNegocio;
    private javax.swing.JButton btnLimpiarCeldas;
    private javax.swing.JButton btnLimpiarCeldasNeg;
    private javax.swing.JButton btnModificarAfiliado;
    private javax.swing.JButton btnModificarNegocio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel1IdNegocio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2IdTipoNegocio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1IdNegocio;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5IdTipoNegocio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JPanel panelAfiliados;
    public javax.swing.JPanel panelLocales;
    public javax.swing.JPanel panelNegocios;
    public javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JTable tablaNegocios;
    private javax.swing.JTable tablaPersona;
    public javax.swing.JTable tablaTiposDeNegocios;
    public javax.swing.JTextField txtCedulaIdentidad;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFechaNacimiento;
    public javax.swing.JTextField txtIdAfiliado;
    public javax.swing.JTextField txtIdNegocio;
    public javax.swing.JTextField txtNacionalidad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombreNegocio;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtTipoDeNegocio;
    // End of variables declaration//GEN-END:variables
}
