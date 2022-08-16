package capa.presentacion;

import capa.logica.FachadaLogica;
import capa.logica.Negocio;
import capa.logica.Negocios;
import capa.logica.Persona;
import capa.logica.Personas;
import capa.logica.Afiliacion;
import capa.logica.Afiliaciones;
import excepciones.AfiliacionException;
import excepciones.NegocioException;
import excepciones.PersonaException;
import excepciones.TiposDeNegocioException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public void limpiarAfiliado() {

        txtCedulaIdentidad.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtNacionalidad.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtFechaNacimiento.setText("");
    }

    public final void mostrarPersonasTabla() {

        try {

            // MOSTRAR AFILIADOS EN LA TABLA
            Personas personas = FachadaLogica.listarPersonas();
            Object[] bPersonas = new Object[9];
            DefaultTableModel modelo = (DefaultTableModel) tablaPersona.getModel();
            modelo.setRowCount(0);
            for (int i = 0; i < personas.getPersonas().size(); i++) {

                Persona persona = personas.getPersonas().get(i);

                bPersonas[0] = persona.getCedulaDeIdentidad();
                bPersonas[1] = persona.getIdMatricula();
                bPersonas[2] = persona.getNombre();
                bPersonas[3] = persona.getApellido();
                bPersonas[4] = persona.getNacionalidad();
                bPersonas[5] = persona.getDireccion();
                bPersonas[6] = persona.getTelefono();
                bPersonas[7] = persona.getEmail();
                bPersonas[8] = persona.getFechaDeNacimiento();
                modelo.addRow(bPersonas);

            }
            tablaPersona.setModel(modelo);
        } catch (PersonaException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public final void mostrarNegociosTabla() {
        try {

            Negocios negocios = FachadaLogica.listarNegocios();
            Object[] bNegocios = new Object[5];
            DefaultTableModel modeloNeg = (DefaultTableModel) tablaNegocios.getModel();
            modeloNeg.setRowCount(0);

            for (int i = 0; i < negocios.getNegocios().size(); i++) {

                Negocio negocio = negocios.getNegocios().get(i);

                bNegocios[0] = negocio.getIdNegocio();
                bNegocios[1] = negocio.getIdAfiliado();
                bNegocios[2] = negocio.getNombreNegocio();
                bNegocios[3] = negocio.getRubro();
                bNegocios[4] = negocio.getDescripcion();
                modeloNeg.addRow(bNegocios);
            }
            tablaNegocios.setModel(modeloNeg);
        } catch (NegocioException e) {
        }
    }
    
    public final void mostrarAfiliacionesTabla(){
        
        try {

            // MOSTRAR AFILIADOS EN LA TABLA
            
            Afiliaciones afiliaciones = FachadaLogica.listarAfiliaciones();
            Object[] bAfiliaciones = new Object[4];
            DefaultTableModel modeloAfi = (DefaultTableModel) tablaAfiliaciones.getModel();
            modeloAfi.setRowCount(0);
            
            for (int i = 0; i < afiliaciones.getAfiliaciones().size(); i++) {

                Afiliacion afiliacion = afiliaciones.getAfiliaciones().get(i);

                bAfiliaciones[0] = afiliacion.getIdAfiliacion();
                bAfiliaciones[1] = afiliacion.getNombreAfiliacion();
                bAfiliaciones[2] = afiliacion.getCiAfiliado();
                bAfiliaciones[3] = afiliacion.getDescripcion();
                
                modeloAfi.addRow(bAfiliaciones);

            }
            tablaAfiliaciones.setModel(modeloAfi);
            
           
        }catch (AfiliacionException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VentanaPrincipal() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("PROYECTO BIOS 2022 - JAVA ");
        setResizable(false);

        // MUESTRA TODAS LAS PERSONAS EN LA TABLA        
        mostrarPersonasTabla();
        // FINALIZA MOSTRAR PERSONAS

        // MOSTRAR NEGOCIOS EN LA TABLA NEGOCIOS
        mostrarNegociosTabla();
        // FINALIZA MOSTRAR NEGOCIOS     

        // MOSTRAR AFILIACIONES
        mostrarAfiliacionesTabla();
        // FINALIZA MOSTRAR AFILIACIONES   

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoPagos = new javax.swing.ButtonGroup();
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
        tituloRellenar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregarAfiliacion = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        panelAfiliaciones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAfiliaciones = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNombreAfiliacion = new javax.swing.JTextField();
        txtCedulaAfiliacion = new javax.swing.JTextField();
        txtDescripcionAfiliacion = new javax.swing.JTextField();
        btnAgregarAfiliaciones = new javax.swing.JButton();
        btnModificarAfiliaciones = new javax.swing.JButton();
        btnEliminarAfiliaciones = new javax.swing.JButton();
        btnLimpiarCeldasAfiliaciones = new javax.swing.JButton();
        tituloRellenar1 = new javax.swing.JLabel();
        panelNegocios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNegocios = new javax.swing.JTable();
        txtRubro = new javax.swing.JTextField();
        txtIdAfiliado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgregarNegocio = new javax.swing.JButton();
        btnModificarNegocio = new javax.swing.JButton();
        btnEliminarNegocio = new javax.swing.JButton();
        btnLimpiarCeldasNeg = new javax.swing.JButton();
        txtNombreNegocio = new javax.swing.JTextField();
        botonActualizarNeg = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tituloRellenar2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtIdNegocioMod = new javax.swing.JTextField();
        panelLocales = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaLocales = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtIdNegocioLocal = new javax.swing.JTextField();
        txtDireccionLocal = new javax.swing.JTextField();
        txtNombreEncargado = new javax.swing.JTextField();
        txtApellidoEncargado = new javax.swing.JTextField();
        txtCedulaEncargadoLocal = new javax.swing.JTextField();
        btnAgregarLocal = new javax.swing.JButton();
        btnModificarLocal = new javax.swing.JButton();
        btnEliminarLocal = new javax.swing.JButton();
        btnLimpiarCeldasLoc = new javax.swing.JButton();
        btnBuscarLocal = new javax.swing.JButton();
        panelPagos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnCuota = new javax.swing.JRadioButton();
        btnMatricula = new javax.swing.JRadioButton();
        btnAgregarAfiliado1 = new javax.swing.JButton();
        btnModificarAfiliado1 = new javax.swing.JButton();
        btnEliminarAfiliado1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("ventanaPrincipal"); // NOI18N
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(1024, 768));
        background.setPreferredSize(new java.awt.Dimension(1024, 768));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPestañas.setBackground(new java.awt.Color(255, 255, 255));
        panelPestañas.setMinimumSize(new java.awt.Dimension(800, 600));

        panelAfiliados.setBackground(new java.awt.Color(204, 204, 204));
        panelAfiliados.setMinimumSize(new java.awt.Dimension(1024, 768));
        panelAfiliados.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelAfiliados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C.I", "Matricula", "Nombre", "Apellido", "Nacionalidad", "Direccion", "Telefono", "Email", "Fecha de nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPersona.setColumnSelectionAllowed(true);
        tablaPersona.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tablaPersona.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tablaPersona);
        tablaPersona.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelAfiliados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 970, 210));

        btnAgregarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliado.setText("INGRESAR");
        btnAgregarAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAfiliadoActionPerformed(evt);
            }
        });
        btnAgregarAfiliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarAfiliadoKeyPressed(evt);
            }
        });
        panelAfiliados.add(btnAgregarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 120, 20));

        btnModificarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarAfiliado.setText("MODIFICAR");
        btnModificarAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnModificarAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAfiliadoActionPerformed(evt);
            }
        });
        btnModificarAfiliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarAfiliadoKeyPressed(evt);
            }
        });
        panelAfiliados.add(btnModificarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 120, 20));

        btnEliminarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarAfiliado.setText("ELIMINAR");
        btnEliminarAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAfiliadoActionPerformed(evt);
            }
        });
        btnEliminarAfiliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarAfiliadoKeyPressed(evt);
            }
        });
        panelAfiliados.add(btnEliminarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, 20));

        btnLimpiarCeldas.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldas.setText("LIMPIAR");
        btnLimpiarCeldas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnLimpiarCeldas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldasActionPerformed(evt);
            }
        });
        btnLimpiarCeldas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimpiarCeldasKeyPressed(evt);
            }
        });
        panelAfiliados.add(btnLimpiarCeldas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 100, 20));

        txtCedulaIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedulaIdentidad.setForeground(new java.awt.Color(153, 153, 153));
        txtCedulaIdentidad.setBorder(null);
        txtCedulaIdentidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaIdentidadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCedulaIdentidadMousePressed(evt);
            }
        });
        txtCedulaIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaIdentidadActionPerformed(evt);
            }
        });
        panelAfiliados.add(txtCedulaIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 170, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        panelAfiliados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 170, -1));

        txtNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNacionalidad.setForeground(new java.awt.Color(153, 153, 153));
        txtNacionalidad.setBorder(null);
        txtNacionalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNacionalidadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNacionalidadMousePressed(evt);
            }
        });
        panelAfiliados.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 170, -1));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setBorder(null);
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtDireccionMousePressed(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        panelAfiliados.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 170, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setBorder(null);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        panelAfiliados.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 170, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(153, 153, 153));
        txtEmail.setBorder(null);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        panelAfiliados.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 170, -1));

        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFechaNacimiento.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNacimiento.setText("1999-12-31");
        txtFechaNacimiento.setBorder(null);
        txtFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoMousePressed(evt);
            }
        });
        panelAfiliados.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CEDULA DE IDENTIDAD");
        panelAfiliados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("APELLIDO");
        panelAfiliados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NACIONALIDAD");
        panelAfiliados.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("DIRECCION");
        panelAfiliados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TELEFONO");
        panelAfiliados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("EMAIL");
        panelAfiliados.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("FECHA DE NACIMIENTO");
        panelAfiliados.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jLabel9.setText("año-mes-día");
        panelAfiliados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 80, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("ABM Afiliados");
        panelAfiliados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 130, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelAfiliados.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 210, 10));
        panelAfiliados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        botonActPersona.setText("Actualizar");
        botonActPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActPersonaActionPerformed(evt);
            }
        });
        panelAfiliados.add(botonActPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, -1, -1));

        tituloRellenar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tituloRellenar.setText("Rellene todos los campos: ");
        panelAfiliados.add(tituloRellenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 180, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("NOMBRE");
        panelAfiliados.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        btnAgregarAfiliacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregarAfiliacion.setText("Agregar afiliación");
        panelAfiliados.add(btnAgregarAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(153, 153, 153));
        txtApellido.setBorder(null);
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMousePressed(evt);
            }
        });
        panelAfiliados.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 170, -1));

        panelPestañas.addTab("Afiliados", panelAfiliados);

        panelAfiliaciones.setBackground(new java.awt.Color(204, 204, 204));
        panelAfiliaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAfiliaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Afiliacion", "Nombre", "C.I Afiliado", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaAfiliaciones);

        panelAfiliaciones.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 920, 200));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Afiliaciones");
        panelAfiliaciones.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 110, 50));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelAfiliaciones.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 160, 10));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("NOMBRE AFILIACION");
        panelAfiliaciones.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("C.I AFILIADO");
        panelAfiliaciones.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("DESCRIPCIÓN");
        panelAfiliaciones.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jButton1.setText("Ingresar Pago");
        panelAfiliaciones.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));

        txtNombreAfiliacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreAfiliacion.setBorder(null);
        panelAfiliaciones.add(txtNombreAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 230, 20));

        txtCedulaAfiliacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedulaAfiliacion.setBorder(null);
        panelAfiliaciones.add(txtCedulaAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 230, 20));

        txtDescripcionAfiliacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcionAfiliacion.setBorder(null);
        panelAfiliaciones.add(txtDescripcionAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 230, 90));

        btnAgregarAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliaciones.setText("INGRESAR");
        btnAgregarAfiliaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnAgregarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 420, -1, 20));

        btnModificarAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarAfiliaciones.setText("MODIFICAR");
        btnModificarAfiliaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnModificarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnModificarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, 20));

        btnEliminarAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarAfiliaciones.setText("ELIMINAR");
        btnEliminarAfiliaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnEliminarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, -1, 20));

        btnLimpiarCeldasAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldasAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldasAfiliaciones.setText("LIMPIAR");
        btnLimpiarCeldasAfiliaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnLimpiarCeldasAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldasAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnLimpiarCeldasAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, 20));

        tituloRellenar1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tituloRellenar1.setText("Rellene todos los campos: ");
        panelAfiliaciones.add(tituloRellenar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 180, 30));

        panelPestañas.addTab("Afiliaciones", panelAfiliaciones);

        panelNegocios.setBackground(new java.awt.Color(204, 204, 204));
        panelNegocios.setMinimumSize(new java.awt.Dimension(1024, 768));
        panelNegocios.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelNegocios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaNegocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Negocio", "ID Afiliado", "Nombre del Negocio", "Rubro", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaNegocios);

        panelNegocios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 920, 190));

        txtRubro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRubro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelNegocios.add(txtRubro, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 300, 20));

        txtIdAfiliado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelNegocios.add(txtIdAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 300, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("ABM Negocios");
        panelNegocios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 130, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelNegocios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 210, 10));

        btnAgregarNegocio.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarNegocio.setText("INGRESAR");
        btnAgregarNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNegocioActionPerformed(evt);
            }
        });
        panelNegocios.add(btnAgregarNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, 20));

        btnModificarNegocio.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarNegocio.setText("MODIFICAR");
        btnModificarNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnModificarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarNegocioActionPerformed(evt);
            }
        });
        panelNegocios.add(btnModificarNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, -1, 20));

        btnEliminarNegocio.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarNegocio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarNegocio.setText("ELIMINAR");
        btnEliminarNegocio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarNegocioActionPerformed(evt);
            }
        });
        panelNegocios.add(btnEliminarNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, -1, 20));

        btnLimpiarCeldasNeg.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldasNeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldasNeg.setText("LIMPIAR");
        btnLimpiarCeldasNeg.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnLimpiarCeldasNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldasNegActionPerformed(evt);
            }
        });
        panelNegocios.add(btnLimpiarCeldasNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 100, 20));

        txtNombreNegocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelNegocios.add(txtNombreNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 300, 20));

        botonActualizarNeg.setText("Actualizar");
        botonActualizarNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarNegActionPerformed(evt);
            }
        });
        panelNegocios.add(botonActualizarNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 90, -1));

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        panelNegocios.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 300, 100));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("RUBRO");
        panelNegocios.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 80, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("ID AFILIADO");
        panelNegocios.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("NOMBRE DEL NEGOCIO");
        panelNegocios.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("DESCRIPCION");
        panelNegocios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        tituloRellenar2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        tituloRellenar2.setText("Rellene todos los campos: ");
        panelNegocios.add(tituloRellenar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 180, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("ID NEGOCIO");
        panelNegocios.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));
        panelNegocios.add(txtIdNegocioMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 170, -1));

        panelPestañas.addTab("Negocios", panelNegocios);

        panelLocales.setBackground(new java.awt.Color(204, 204, 204));
        panelLocales.setMinimumSize(new java.awt.Dimension(1024, 768));
        panelLocales.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelLocales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("ABM Locales");
        panelLocales.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, 50));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelLocales.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 170, 10));

        tablaLocales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Local", "ID Negocio", "Dirección", "Nombre Encargado", "Apellido Encargado", "C.I Encargado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaLocales);

        panelLocales.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 720, 200));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("ID NEGOCIO");
        panelLocales.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("DIRECCIÓN");
        panelLocales.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("NOMBRE ENCARGADO");
        panelLocales.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("APELLIDO ENCARGADO");
        panelLocales.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("C.I ENCARGADO");
        panelLocales.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        txtIdNegocioLocal.setBorder(null);
        panelLocales.add(txtIdNegocioLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 170, 20));

        txtDireccionLocal.setBorder(null);
        panelLocales.add(txtDireccionLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 170, 20));

        txtNombreEncargado.setBorder(null);
        panelLocales.add(txtNombreEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 170, 20));

        txtApellidoEncargado.setBorder(null);
        panelLocales.add(txtApellidoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 170, 20));

        txtCedulaEncargadoLocal.setBorder(null);
        panelLocales.add(txtCedulaEncargadoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 170, 20));

        btnAgregarLocal.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarLocal.setText("INGRESAR");
        btnAgregarLocal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLocalActionPerformed(evt);
            }
        });
        panelLocales.add(btnAgregarLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 120, 20));

        btnModificarLocal.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarLocal.setText("MODIFICAR");
        btnModificarLocal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelLocales.add(btnModificarLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 120, 20));

        btnEliminarLocal.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarLocal.setText("ELIMINAR");
        btnEliminarLocal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLocalActionPerformed(evt);
            }
        });
        panelLocales.add(btnEliminarLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 120, 20));

        btnLimpiarCeldasLoc.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldasLoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldasLoc.setText("LIMPIAR");
        btnLimpiarCeldasLoc.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnLimpiarCeldasLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldasLocActionPerformed(evt);
            }
        });
        panelLocales.add(btnLimpiarCeldasLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 120, 20));

        btnBuscarLocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarLocal.setText("BUSCAR");
        panelLocales.add(btnBuscarLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 167, 80, -1));

        panelPestañas.addTab("Locales", panelLocales);

        panelPagos.setBackground(new java.awt.Color(204, 204, 204));
        panelPagos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("ABM Pagos");
        panelPagos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 130, 40));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelPagos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 210, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pago", "C.I", "Fecha de Pago", "Tipo de Pago", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable1);

        panelPagos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 390, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CEDULA DE IDENTIDAD");
        panelPagos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 170, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("TIPO DE PAGO");
        panelPagos.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("MONTO A DEPÓSITAR");
        panelPagos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));

        jTextField1.setBorder(null);
        panelPagos.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 120, 20));

        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        panelPagos.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 120, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("$U");
        panelPagos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 30, 40));

        btnCuota.setBackground(new java.awt.Color(204, 204, 204));
        btnGrupoPagos.add(btnCuota);
        btnCuota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCuota.setText("Cuota");
        btnCuota.setBorder(null);
        panelPagos.add(btnCuota, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 120, 30));

        btnMatricula.setBackground(new java.awt.Color(204, 204, 204));
        btnGrupoPagos.add(btnMatricula);
        btnMatricula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMatricula.setText("Matricula");
        btnMatricula.setBorder(null);
        panelPagos.add(btnMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 120, 30));

        btnAgregarAfiliado1.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliado1.setText("DEPÓSITAR");
        btnAgregarAfiliado1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarAfiliado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAfiliado1ActionPerformed(evt);
            }
        });
        btnAgregarAfiliado1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarAfiliado1KeyPressed(evt);
            }
        });
        panelPagos.add(btnAgregarAfiliado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 120, 20));

        btnModificarAfiliado1.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarAfiliado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarAfiliado1.setText("MODIFICAR");
        btnModificarAfiliado1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnModificarAfiliado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAfiliado1ActionPerformed(evt);
            }
        });
        btnModificarAfiliado1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarAfiliado1KeyPressed(evt);
            }
        });
        panelPagos.add(btnModificarAfiliado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 120, 20));

        btnEliminarAfiliado1.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarAfiliado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarAfiliado1.setText("ELIMINAR");
        btnEliminarAfiliado1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarAfiliado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAfiliado1ActionPerformed(evt);
            }
        });
        btnEliminarAfiliado1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarAfiliado1KeyPressed(evt);
            }
        });
        panelPagos.add(btnEliminarAfiliado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, -1, 20));

        panelPestañas.addTab("Pagos", panelPagos);

        background.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 790));

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

    }//GEN-LAST:event_txtFechaNacimientoMousePressed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed

    }//GEN-LAST:event_txtEmailMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed

    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMousePressed

    }//GEN-LAST:event_txtDireccionMousePressed

    private void txtNacionalidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNacionalidadMousePressed

    }//GEN-LAST:event_txtNacionalidadMousePressed

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtCedulaIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaIdentidadActionPerformed

    private void txtCedulaIdentidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaIdentidadMousePressed

    }//GEN-LAST:event_txtCedulaIdentidadMousePressed

    private void btnAgregarAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAfiliadoActionPerformed

        try {
            Persona persona = new Persona();

            String cedulaDeIdentidad = txtCedulaIdentidad.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String nacionalidad = txtNacionalidad.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String fechaDeNacimiento = txtFechaNacimiento.getText();

            persona.setCedulaDeIdentidad(cedulaDeIdentidad);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setNacionalidad(nacionalidad);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setFechaDeNacimiento(fechaDeNacimiento);

            FachadaLogica.agregarPersona(persona);
            JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
            mostrarPersonasTabla();
            limpiarAfiliado();

        } catch (PersonaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la persona");

        }
    }//GEN-LAST:event_btnAgregarAfiliadoActionPerformed

    private void btnAgregarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNegocioActionPerformed
        try {
            Negocio negocio = new Negocio();

            String idAfiliado = txtIdAfiliado.getText();
            String rubro = txtRubro.getText();
            String nombreNegocio = txtNombreNegocio.getText();
            String descripcion = txtDescripcion.getText();

            negocio.setIdAfiliado(idAfiliado);
            negocio.setRubro(rubro);
            negocio.setNombreNegocio(nombreNegocio);
            negocio.setDescripcion(descripcion);

            FachadaLogica.agregarNegocio(negocio);
            JOptionPane.showMessageDialog(null, "Negocio agregado correctamente");
            mostrarNegociosTabla();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el negocio");

        }
    }//GEN-LAST:event_btnAgregarNegocioActionPerformed

    private void botonActualizarNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarNegActionPerformed
        mostrarNegociosTabla();
    }//GEN-LAST:event_botonActualizarNegActionPerformed

    private void botonActPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActPersonaActionPerformed

        mostrarPersonasTabla();


    }//GEN-LAST:event_botonActPersonaActionPerformed

    private void btnEliminarAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAfiliadoActionPerformed

        try {
            Persona persona = new Persona();

            //String cedulaDeIdentidad = txtCedulaIdentidad.getText();
            // La variable CEDULA obtiene valor del dato clickeado en la columna.
            String cedulaDeIdentidad = tablaPersona.getValueAt(tablaPersona.getSelectedRow(), 0).toString();

            // Setea el dato que fue clickeado y se lo agrega a la persona creada.
            persona.setCedulaDeIdentidad(cedulaDeIdentidad);

            // Ejecuta el método eliminar persona.
            FachadaLogica.eliminarPersona(persona);
            JOptionPane.showMessageDialog(null, "Persona eliminada correctamente");
            mostrarPersonasTabla();

        } catch (PersonaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar a la persona");
        }

    }//GEN-LAST:event_btnEliminarAfiliadoActionPerformed

    private void btnModificarAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAfiliadoActionPerformed

        try {
            Persona persona = new Persona();

            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String nacionalidad = txtNacionalidad.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String fechaDeNacimiento = txtFechaNacimiento.getText();
            String cedulaDeIdentidad = txtCedulaIdentidad.getText();

            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setNacionalidad(nacionalidad);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setFechaDeNacimiento(fechaDeNacimiento);
            persona.setCedulaDeIdentidad(cedulaDeIdentidad);

            FachadaLogica.modificarPersona(persona);
            JOptionPane.showMessageDialog(null, "Se modificó la persona correctamente");
            mostrarPersonasTabla();

        } catch (PersonaException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la persona");

        }
    }//GEN-LAST:event_btnModificarAfiliadoActionPerformed

    private void txtCedulaIdentidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaIdentidadMouseClicked
        txtCedulaIdentidad.setText("");
        txtCedulaIdentidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtCedulaIdentidadMouseClicked

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        txtNombre.setText("");
        txtNombre.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtNacionalidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNacionalidadMouseClicked
        txtNacionalidad.setText("");
        txtNacionalidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtNacionalidadMouseClicked

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        txtDireccion.setText("");
        txtDireccion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        txtTelefono.setText("");
        txtTelefono.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        txtEmail.setText("");
        txtEmail.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtFechaNacimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaNacimientoMouseClicked
        txtFechaNacimiento.setText("");
        txtFechaNacimiento.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtFechaNacimientoMouseClicked

    private void btnAgregarAfiliadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarAfiliadoKeyPressed
        char aTeclaPresionada = evt.getKeyChar();

        if (aTeclaPresionada == KeyEvent.VK_ENTER) {
            btnAgregarAfiliado.doClick();
        }
    }//GEN-LAST:event_btnAgregarAfiliadoKeyPressed

    private void btnModificarAfiliadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarAfiliadoKeyPressed

        char zTeclaPresionada = evt.getKeyChar();

        if (zTeclaPresionada == KeyEvent.VK_ENTER) {
            btnModificarAfiliado.doClick();
        }
    }//GEN-LAST:event_btnModificarAfiliadoKeyPressed

    private void btnEliminarAfiliadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarAfiliadoKeyPressed

        char nTeclaPresionada = evt.getKeyChar();

        if (nTeclaPresionada == KeyEvent.VK_ENTER) {
            btnEliminarAfiliado.doClick();
        }
    }//GEN-LAST:event_btnEliminarAfiliadoKeyPressed

    private void btnLimpiarCeldasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasKeyPressed

        char yTeclaPresionada = evt.getKeyChar();

        if (yTeclaPresionada == KeyEvent.VK_ENTER) {
            btnLimpiarCeldas.doClick();
        }
    }//GEN-LAST:event_btnLimpiarCeldasKeyPressed

    private void btnLimpiarCeldasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasActionPerformed

        limpiarAfiliado();

    }//GEN-LAST:event_btnLimpiarCeldasActionPerformed

    private void btnLimpiarCeldasNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasNegActionPerformed

    }//GEN-LAST:event_btnLimpiarCeldasNegActionPerformed

    private void btnEliminarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarNegocioActionPerformed
        try {
            Negocio negocio = new Negocio();

            //String cedulaDeIdentidad = txtCedulaIdentidad.getText();
            // La variable CEDULA obtiene valor del dato clickeado en la columna.
            String idNegocio = tablaNegocios.getValueAt(tablaNegocios.getSelectedRow(), 0).toString();

            // Setea el dato que fue clickeado y se lo agrega a la persona creada.
            negocio.setIdNegocio(idNegocio);
            
            // Ejecuta el método eliminar persona.
            FachadaLogica.eliminarNegocio(negocio);

            JOptionPane.showMessageDialog(null, "Negocio eliminado correctamente");
            mostrarNegociosTabla();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el negocio");
        }
    }//GEN-LAST:event_btnEliminarNegocioActionPerformed

    private void txtApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMouseClicked

    private void txtApellidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMousePressed

    private void btnAgregarAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAfiliacionesActionPerformed
        try {

            Afiliacion afiliacion = new Afiliacion();

            String nombreAfiliacion = txtNombreAfiliacion.getText();
            String ciAfiliado = txtCedulaAfiliacion.getText();
            String descripcion = txtDescripcionAfiliacion.getText();

            afiliacion.setNombreAfiliacion(nombreAfiliacion);
            afiliacion.setCiAfiliado(ciAfiliado);
            afiliacion.setDescripcion(descripcion);

            FachadaLogica.agregarAfiliacion(afiliacion);

            JOptionPane.showMessageDialog(null, "Afiliación agregada correctamente");
            
            mostrarAfiliacionesTabla();

        } catch (AfiliacionException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo agregar la afiliación");
        }
    }//GEN-LAST:event_btnAgregarAfiliacionesActionPerformed

    private void btnEliminarAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAfiliacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarAfiliacionesActionPerformed

    private void btnLimpiarCeldasAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasAfiliacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarCeldasAfiliacionesActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnAgregarAfiliado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAfiliado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarAfiliado1ActionPerformed

    private void btnAgregarAfiliado1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarAfiliado1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarAfiliado1KeyPressed

    private void btnModificarAfiliado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAfiliado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarAfiliado1ActionPerformed

    private void btnModificarAfiliado1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarAfiliado1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarAfiliado1KeyPressed

    private void btnEliminarAfiliado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAfiliado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarAfiliado1ActionPerformed

    private void btnEliminarAfiliado1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarAfiliado1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarAfiliado1KeyPressed

    private void btnAgregarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarLocalActionPerformed

    private void btnEliminarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarLocalActionPerformed

    private void btnLimpiarCeldasLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarCeldasLocActionPerformed

    private void btnModificarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarNegocioActionPerformed
        
        try {
        
        Negocio negocio = new Negocio();
        
        
        String idAfiliado = txtIdAfiliado.getText();
        String nombreNegocio = txtNombreNegocio.getText();
        String rubro = txtRubro.getText();
        String descripcion = txtDescripcion.getText();
        String idNegocio = txtIdNegocioMod.getText();
        
        
        
        negocio.setIdAfiliado(idAfiliado);
        negocio.setNombreNegocio(nombreNegocio);
        negocio.setRubro(rubro);
        negocio.setDescripcion(descripcion);
        negocio.setIdNegocio(idNegocio);
        
            FachadaLogica.modificarNegocio(negocio);
            JOptionPane.showMessageDialog(null, "Se modificó el negocio correctamente");
            mostrarNegociosTabla();
        
        } catch (NegocioException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar el negocio");
        }
        

        
        
    }//GEN-LAST:event_btnModificarNegocioActionPerformed

    private void btnModificarAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAfiliacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarAfiliacionesActionPerformed

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
    private javax.swing.JButton btnAgregarAfiliacion;
    private javax.swing.JButton btnAgregarAfiliaciones;
    private javax.swing.JButton btnAgregarAfiliado;
    private javax.swing.JButton btnAgregarAfiliado1;
    private javax.swing.JButton btnAgregarLocal;
    private javax.swing.JButton btnAgregarNegocio;
    private javax.swing.JButton btnBuscarLocal;
    private javax.swing.JRadioButton btnCuota;
    private javax.swing.JButton btnEliminarAfiliaciones;
    private javax.swing.JButton btnEliminarAfiliado;
    private javax.swing.JButton btnEliminarAfiliado1;
    private javax.swing.JButton btnEliminarLocal;
    private javax.swing.JButton btnEliminarNegocio;
    private javax.swing.ButtonGroup btnGrupoPagos;
    private javax.swing.JButton btnLimpiarCeldas;
    private javax.swing.JButton btnLimpiarCeldasAfiliaciones;
    private javax.swing.JButton btnLimpiarCeldasLoc;
    private javax.swing.JButton btnLimpiarCeldasNeg;
    private javax.swing.JRadioButton btnMatricula;
    private javax.swing.JButton btnModificarAfiliaciones;
    private javax.swing.JButton btnModificarAfiliado;
    private javax.swing.JButton btnModificarAfiliado1;
    private javax.swing.JButton btnModificarLocal;
    private javax.swing.JButton btnModificarNegocio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel panelAfiliaciones;
    public javax.swing.JPanel panelAfiliados;
    public javax.swing.JPanel panelLocales;
    public javax.swing.JPanel panelNegocios;
    private javax.swing.JPanel panelPagos;
    public javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JTable tablaAfiliaciones;
    private javax.swing.JTable tablaLocales;
    private javax.swing.JTable tablaNegocios;
    private javax.swing.JTable tablaPersona;
    private javax.swing.JLabel tituloRellenar;
    private javax.swing.JLabel tituloRellenar1;
    private javax.swing.JLabel tituloRellenar2;
    public javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEncargado;
    private javax.swing.JTextField txtCedulaAfiliacion;
    private javax.swing.JTextField txtCedulaEncargadoLocal;
    public javax.swing.JTextField txtCedulaIdentidad;
    public javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcionAfiliacion;
    public javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionLocal;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFechaNacimiento;
    public javax.swing.JTextField txtIdAfiliado;
    private javax.swing.JTextField txtIdNegocioLocal;
    private javax.swing.JTextField txtIdNegocioMod;
    public javax.swing.JTextField txtNacionalidad;
    public javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreAfiliacion;
    private javax.swing.JTextField txtNombreEncargado;
    public javax.swing.JTextField txtNombreNegocio;
    public javax.swing.JTextField txtRubro;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
