package capa.presentacion;

import capa.logica.FachadaLogica;
import capa.logica.Negocio;
import capa.logica.Negocios;
import capa.logica.Persona;
import capa.logica.Personas;
import capa.logica.Afiliacion;
import capa.logica.Afiliaciones;
import capa.logica.Local;
import capa.logica.Locales;
import capa.logica.Pago;
import capa.logica.Pagos;
import excepciones.AfiliacionException;
import excepciones.LocalException;
import excepciones.NegocioException;
import excepciones.PagoException;
import excepciones.PersonaException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axel Albano Arias Rodríguez, Leandro Nahuel Martínez Santos, Andrés Laureano Pardo Brun, Ruben Alejandro Perurena Akrabian
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public void limpiarAfiliacion() {

        txtNombreAfiliacion.setText("");
        txtCedulaAfiliacion.setText("");
        txtDescripcionAfiliacion.setText("");

    }

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

    public void limpiarNegocios() {

        txtRubro.setText("");
        txtIdAfiliado.setText("");
        txtNombreNegocio.setText("");
        txtDescripcion.setText("");
    }

    public void limpiarLocales() {

        txtIdNegocioLocal.setText("");
        txtDireccionLocal.setText("");
        txtNombreEncargado.setText("");
        txtApellidoEncargado.setText("");
        txtCedulaEncargadoLocal.setText("");
    }

    public void limpiarPagos() {

        txtIdCiPagos.setText("");
        txtIdMonto.setText("");
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

    public final void mostrarAfiliacionesTabla() {

        try {

            // MOSTRAR AFILIADOS EN LA TABLA
            Afiliaciones afiliaciones = FachadaLogica.listarAfiliaciones();
            Object[] bAfiliaciones = new Object[5];
            DefaultTableModel modeloAfi = (DefaultTableModel) tablaAfiliaciones.getModel();
            modeloAfi.setRowCount(0);

            for (int i = 0; i < afiliaciones.getAfiliaciones().size(); i++) {

                Afiliacion afiliacion = afiliaciones.getAfiliaciones().get(i);

                bAfiliaciones[0] = afiliacion.getIdAfiliacion();
                bAfiliaciones[1] = afiliacion.getNombreAfiliacion();
                bAfiliaciones[2] = afiliacion.getCiAfiliado();
                bAfiliaciones[3] = afiliacion.getDescripcion();
                bAfiliaciones[4] = afiliacion.getFechaAfiliacion();

                modeloAfi.addRow(bAfiliaciones);

            }
            tablaAfiliaciones.setModel(modeloAfi);

        } catch (AfiliacionException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public final void mostrarLocalesTabla() {

        try {

            // MOSTRAR AFILIADOS EN LA TABLA
            Locales locales = FachadaLogica.listarLocales();
            Object[] bLocales = new Object[6];
            DefaultTableModel modeloLoc = (DefaultTableModel) tablaLocales.getModel();
            modeloLoc.setRowCount(0);

            for (int i = 0; i < locales.getLocales().size(); i++) {

                Local local = locales.getLocales().get(i);

                bLocales[0] = local.getIdLocal();
                bLocales[1] = local.getIdNegocio();
                bLocales[2] = local.getDireccionLocal();
                bLocales[3] = local.getNombreEncargado();
                bLocales[4] = local.getApellidoEncargado();
                bLocales[5] = local.getCiEncargado();

                modeloLoc.addRow(bLocales);

            }
            tablaLocales.setModel(modeloLoc);

        } catch (LocalException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void mostrarLocalesFiltradoPorIdNegocioTabla(Local local) {
        try {

            // MOSTRAR AFILIADOS EN LA TABLA
            Locales locales = FachadaLogica.listarLocalesFiltradosPorIdNegocio(local);
            Object[] bLocales = new Object[6];
            DefaultTableModel modeloLoc = (DefaultTableModel) tablaLocales.getModel();
            modeloLoc.setRowCount(0);

            for (int i = 0; i < locales.getLocales().size(); i++) {

                local = locales.getLocales().get(i);

                bLocales[0] = local.getIdLocal();
                bLocales[1] = local.getIdNegocio();
                bLocales[2] = local.getDireccionLocal();
                bLocales[3] = local.getNombreEncargado();
                bLocales[4] = local.getApellidoEncargado();
                bLocales[5] = local.getCiEncargado();

                modeloLoc.addRow(bLocales);

            }
            tablaLocales.setModel(modeloLoc);

        } catch (LocalException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void mostrarPagosTabla() {

        try {

            // MOSTRAR PAGOS EN LA TABLA
            Pagos pagos = FachadaLogica.listarPagos();
            Object[] bPagos = new Object[5];
            DefaultTableModel modeloPag = (DefaultTableModel) tablaPagos.getModel();
            modeloPag.setRowCount(0);

            for (int i = 0; i < pagos.getPagos().size(); i++) {

                Pago pago = pagos.getPagos().get(i);

                bPagos[0] = pago.getIdPago();
                bPagos[1] = pago.getCi();
                bPagos[2] = pago.getFechaDePago();
                bPagos[3] = pago.getTipoDePago();
                bPagos[4] = pago.getMonto();

                modeloPag.addRow(bPagos);

            }
            tablaPagos.setModel(modeloPag);

        } catch (PagoException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VentanaPrincipal() {

        initComponents();
        setLocationRelativeTo(null);
        setTitle("Biosearcher");
        setResizable(false);

        // MUESTRA TODAS LAS PERSONAS EN LA TABLA        
        mostrarPersonasTabla();
        tablaPersona.setAutoCreateRowSorter(true);
        // FINALIZA MOSTRAR PERSONAS

        // MOSTRAR AFILIACIONES
        mostrarAfiliacionesTabla();
        tablaAfiliaciones.setAutoCreateRowSorter(true);
        // FINALIZA MOSTRAR AFILIACIONES 

        // MOSTRAR NEGOCIOS EN LA TABLA NEGOCIOS
        mostrarNegociosTabla();
        tablaNegocios.setAutoCreateRowSorter(true);
        // FINALIZA MOSTRAR NEGOCIOS     

        // MOSTRAR LOCALES
        mostrarLocalesTabla();
        tablaLocales.setAutoCreateRowSorter(true);
        // FINALIZA MOSTRAR LOCALES

        // MOSTRAR PAGOS
        mostrarPagosTabla();
        tablaPagos.setAutoCreateRowSorter(true);
        // FINALIZA MOSTRAR PAGOS  
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
        botonActualizarPersonas = new javax.swing.JButton();
        tituloRellenar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregarAfiliacion = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        panelAfiliaciones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAfiliaciones = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnIngresarPago = new javax.swing.JButton();
        txtNombreAfiliacion = new javax.swing.JTextField();
        txtCedulaAfiliacion = new javax.swing.JTextField();
        txtDescripcionAfiliacion = new javax.swing.JTextField();
        btnAgregarAfiliaciones = new javax.swing.JButton();
        btnModificarAfiliaciones = new javax.swing.JButton();
        btnEliminarAfiliaciones = new javax.swing.JButton();
        btnLimpiarCeldasAfiliaciones = new javax.swing.JButton();
        botonActualizarAfiliaciones = new javax.swing.JButton();
        tituloRellenar3 = new javax.swing.JLabel();
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
        botonActualizarNegocios = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tituloRellenar4 = new javax.swing.JLabel();
        btnAgregarLocall = new javax.swing.JButton();
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
        botonActualizarLocales = new javax.swing.JButton();
        tituloRellenar5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        txtBuscar = new javax.swing.JTextField();
        panelPagos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtIdCiPagos = new javax.swing.JTextField();
        txtIdMonto = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnAgregarPago = new javax.swing.JButton();
        btnModificarAfiliado1 = new javax.swing.JButton();
        btnEliminarPago = new javax.swing.JButton();
        botonActualizarPagos = new javax.swing.JButton();
        btnLimpiarCeldasPago = new javax.swing.JButton();
        jComboBoxTipoDePago = new javax.swing.JComboBox<>();
        tituloRellenar6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("ventanaPrincipal"); // NOI18N
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(1024, 768));
        background.setPreferredSize(new java.awt.Dimension(1024, 768));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPestañas.setBackground(new java.awt.Color(255, 255, 204));
        panelPestañas.setMinimumSize(new java.awt.Dimension(800, 600));
        panelPestañas.setPreferredSize(new java.awt.Dimension(1024, 768));

        panelAfiliados.setBackground(new java.awt.Color(204, 255, 255));
        panelAfiliados.setMinimumSize(new java.awt.Dimension(1024, 768));
        panelAfiliados.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelAfiliados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPersona.setBackground(new java.awt.Color(255, 255, 204));
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
        tablaPersona.setGridColor(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(tablaPersona);
        tablaPersona.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelAfiliados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 970, 210));

        btnAgregarAfiliado.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliado.setText("INGRESAR");
        btnAgregarAfiliado.setBorder(null);
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
        btnModificarAfiliado.setBorder(null);
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
        btnEliminarAfiliado.setBorder(null);
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
        panelAfiliados.add(btnEliminarAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 110, 20));

        btnLimpiarCeldas.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldas.setText("LIMPIAR");
        btnLimpiarCeldas.setBorder(null);
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

        txtCedulaIdentidad.setBackground(new java.awt.Color(255, 255, 204));
        txtCedulaIdentidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedulaIdentidad.setForeground(new java.awt.Color(204, 204, 204));
        txtCedulaIdentidad.setText("8 dígitos");
        txtCedulaIdentidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        panelAfiliados.add(txtCedulaIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 200, 20));

        txtNombre.setBackground(new java.awt.Color(255, 255, 204));
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        panelAfiliados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 200, 20));

        txtNacionalidad.setBackground(new java.awt.Color(255, 255, 204));
        txtNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNacionalidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNacionalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNacionalidadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNacionalidadMousePressed(evt);
            }
        });
        panelAfiliados.add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 200, 20));

        txtDireccion.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        panelAfiliados.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 200, 20));

        txtTelefono.setBackground(new java.awt.Color(255, 255, 204));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });
        panelAfiliados.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 200, 20));

        txtEmail.setBackground(new java.awt.Color(255, 255, 204));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        panelAfiliados.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 200, 20));

        txtFechaNacimiento.setBackground(new java.awt.Color(255, 255, 204));
        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFechaNacimiento.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNacimiento.setText("1999-12-31");
        txtFechaNacimiento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFechaNacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaNacimientoMousePressed(evt);
            }
        });
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });
        panelAfiliados.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 200, 20));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("CEDULA DE IDENTIDAD");
        panelAfiliados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("APELLIDO");
        panelAfiliados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("NACIONALIDAD");
        panelAfiliados.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("DIRECCION");
        panelAfiliados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setText("TELEFONO");
        panelAfiliados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setText("EMAIL");
        panelAfiliados.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setText("FECHA DE NACIMIENTO");
        panelAfiliados.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jLabel9.setText("año-mes-día");
        panelAfiliados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 80, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("ABM Afiliados");
        panelAfiliados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 130, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelAfiliados.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 180, 10));
        panelAfiliados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        botonActualizarPersonas.setText("Actualizar");
        botonActualizarPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarPersonasActionPerformed(evt);
            }
        });
        panelAfiliados.add(botonActualizarPersonas, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, -1, -1));

        tituloRellenar.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        tituloRellenar.setForeground(new java.awt.Color(51, 51, 51));
        tituloRellenar.setText("Rellene todos los campos: ");
        panelAfiliados.add(tituloRellenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 220, 20));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setText("NOMBRE");
        panelAfiliados.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        btnAgregarAfiliacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregarAfiliacion.setText("Agregar afiliación");
        btnAgregarAfiliacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAfiliacionActionPerformed(evt);
            }
        });
        panelAfiliados.add(btnAgregarAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        txtApellido.setBackground(new java.awt.Color(255, 255, 204));
        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidoMousePressed(evt);
            }
        });
        panelAfiliados.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 200, 20));

        jButton1.setText("Volver al Logín");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelAfiliados.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 430, -1, -1));

        panelPestañas.addTab("Afiliados", panelAfiliados);

        panelAfiliaciones.setBackground(new java.awt.Color(204, 255, 255));
        panelAfiliaciones.setMinimumSize(new java.awt.Dimension(800, 600));
        panelAfiliaciones.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelAfiliaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 204));

        tablaAfiliaciones.setBackground(new java.awt.Color(255, 255, 204));
        tablaAfiliaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Afiliacion", "Nombre", "C.I Afiliado", "Descripción", "Fecha Afiliacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAfiliaciones.setColumnSelectionAllowed(true);
        tablaAfiliaciones.setGridColor(new java.awt.Color(255, 255, 204));
        jScrollPane3.setViewportView(tablaAfiliaciones);
        tablaAfiliaciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelAfiliaciones.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 860, 200));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("ABM Afiliaciones");
        panelAfiliaciones.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 150, 50));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelAfiliaciones.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 210, 10));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setText("NOMBRE AFILIACION");
        panelAfiliaciones.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel17.setText("C.I AFILIADO");
        panelAfiliaciones.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel18.setText("DESCRIPCIÓN");
        panelAfiliaciones.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        btnIngresarPago.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresarPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIngresarPago.setText("Ingresar Pago");
        btnIngresarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPagoActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnIngresarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 120, -1));

        txtNombreAfiliacion.setBackground(new java.awt.Color(255, 255, 204));
        txtNombreAfiliacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreAfiliacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAfiliaciones.add(txtNombreAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 230, 20));

        txtCedulaAfiliacion.setBackground(new java.awt.Color(255, 255, 204));
        txtCedulaAfiliacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedulaAfiliacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAfiliaciones.add(txtCedulaAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 230, 20));

        txtDescripcionAfiliacion.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcionAfiliacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcionAfiliacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAfiliaciones.add(txtDescripcionAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 230, 90));

        btnAgregarAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarAfiliaciones.setText("INGRESAR");
        btnAgregarAfiliaciones.setBorder(null);
        btnAgregarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnAgregarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 420, 100, 20));

        btnModificarAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarAfiliaciones.setText("MODIFICAR");
        btnModificarAfiliaciones.setBorder(null);
        btnModificarAfiliaciones.setMaximumSize(new java.awt.Dimension(77, 17));
        btnModificarAfiliaciones.setMinimumSize(new java.awt.Dimension(77, 17));
        btnModificarAfiliaciones.setPreferredSize(new java.awt.Dimension(77, 17));
        btnModificarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnModificarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 110, 20));

        btnEliminarAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarAfiliaciones.setText("ELIMINAR");
        btnEliminarAfiliaciones.setBorder(null);
        btnEliminarAfiliaciones.setMaximumSize(new java.awt.Dimension(77, 17));
        btnEliminarAfiliaciones.setMinimumSize(new java.awt.Dimension(77, 17));
        btnEliminarAfiliaciones.setPreferredSize(new java.awt.Dimension(77, 17));
        btnEliminarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnEliminarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 100, 20));

        btnLimpiarCeldasAfiliaciones.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldasAfiliaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldasAfiliaciones.setText("LIMPIAR");
        btnLimpiarCeldasAfiliaciones.setBorder(null);
        btnLimpiarCeldasAfiliaciones.setMaximumSize(new java.awt.Dimension(77, 17));
        btnLimpiarCeldasAfiliaciones.setMinimumSize(new java.awt.Dimension(77, 17));
        btnLimpiarCeldasAfiliaciones.setPreferredSize(new java.awt.Dimension(77, 17));
        btnLimpiarCeldasAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldasAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(btnLimpiarCeldasAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 110, 20));

        botonActualizarAfiliaciones.setText("Actualizar");
        botonActualizarAfiliaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarAfiliacionesActionPerformed(evt);
            }
        });
        panelAfiliaciones.add(botonActualizarAfiliaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, -1, -1));

        tituloRellenar3.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        tituloRellenar3.setForeground(new java.awt.Color(51, 51, 51));
        tituloRellenar3.setText("Rellene todos los campos: ");
        panelAfiliaciones.add(tituloRellenar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 220, 20));

        panelPestañas.addTab("Afiliaciones", panelAfiliaciones);

        panelNegocios.setBackground(new java.awt.Color(204, 255, 255));
        panelNegocios.setMinimumSize(new java.awt.Dimension(800, 600));
        panelNegocios.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelNegocios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaNegocios.setBackground(new java.awt.Color(255, 255, 204));
        tablaNegocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Negocio", "ID Afiliado", "Nombre del Negocio", "Rubro", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaNegocios.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tablaNegocios);
        tablaNegocios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelNegocios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 920, 190));

        txtRubro.setBackground(new java.awt.Color(255, 255, 204));
        txtRubro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRubro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtRubro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelNegocios.add(txtRubro, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 260, 20));

        txtIdAfiliado.setBackground(new java.awt.Color(255, 255, 204));
        txtIdAfiliado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdAfiliado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelNegocios.add(txtIdAfiliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 260, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("ABM Negocios");
        panelNegocios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 130, 40));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelNegocios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 170, 10));

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

        txtNombreNegocio.setBackground(new java.awt.Color(255, 255, 204));
        txtNombreNegocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreNegocio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelNegocios.add(txtNombreNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 260, 20));

        botonActualizarNegocios.setText("Actualizar");
        botonActualizarNegocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarNegociosActionPerformed(evt);
            }
        });
        panelNegocios.add(botonActualizarNegocios, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 90, -1));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 204));
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescripcion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelNegocios.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 260, 100));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel19.setText("RUBRO");
        panelNegocios.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 80, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setText("ID AFILIADO");
        panelNegocios.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel21.setText("NOMBRE DEL NEGOCIO");
        panelNegocios.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel22.setText("DESCRIPCION");
        panelNegocios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        tituloRellenar4.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        tituloRellenar4.setForeground(new java.awt.Color(51, 51, 51));
        tituloRellenar4.setText("Rellene todos los campos: ");
        panelNegocios.add(tituloRellenar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 220, 20));

        btnAgregarLocall.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregarLocall.setText("Agregar Local");
        btnAgregarLocall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLocallActionPerformed(evt);
            }
        });
        panelNegocios.add(btnAgregarLocall, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 130, -1));

        panelPestañas.addTab("Negocios", panelNegocios);

        panelLocales.setBackground(new java.awt.Color(204, 255, 255));
        panelLocales.setMinimumSize(new java.awt.Dimension(800, 600));
        panelLocales.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelLocales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("ABM Locales");
        panelLocales.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 50));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelLocales.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 170, 10));

        tablaLocales.setBackground(new java.awt.Color(255, 255, 204));
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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLocales.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(tablaLocales);
        tablaLocales.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelLocales.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 720, 200));

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel27.setText("ID NEGOCIO");
        panelLocales.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel28.setText("DIRECCIÓN");
        panelLocales.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel29.setText("NOMBRE ENCARGADO");
        panelLocales.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel30.setText("APELLIDO ENCARGADO");
        panelLocales.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel31.setText("C.I ENCARGADO");
        panelLocales.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        txtIdNegocioLocal.setBackground(new java.awt.Color(255, 255, 204));
        txtIdNegocioLocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdNegocioLocal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLocales.add(txtIdNegocioLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 190, 20));

        txtDireccionLocal.setBackground(new java.awt.Color(255, 255, 204));
        txtDireccionLocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDireccionLocal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLocales.add(txtDireccionLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 190, 20));

        txtNombreEncargado.setBackground(new java.awt.Color(255, 255, 204));
        txtNombreEncargado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreEncargado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLocales.add(txtNombreEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 190, 20));

        txtApellidoEncargado.setBackground(new java.awt.Color(255, 255, 204));
        txtApellidoEncargado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellidoEncargado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLocales.add(txtApellidoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 190, 20));

        txtCedulaEncargadoLocal.setBackground(new java.awt.Color(255, 255, 204));
        txtCedulaEncargadoLocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedulaEncargadoLocal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLocales.add(txtCedulaEncargadoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 190, 20));

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
        btnModificarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLocalActionPerformed(evt);
            }
        });
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

        botonActualizarLocales.setText("Actualizar");
        botonActualizarLocales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarLocalesActionPerformed(evt);
            }
        });
        panelLocales.add(botonActualizarLocales, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 90, -1));

        tituloRellenar5.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        tituloRellenar5.setForeground(new java.awt.Color(51, 51, 51));
        tituloRellenar5.setText("Rellene todos los campos: ");
        panelLocales.add(tituloRellenar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 220, 20));

        jToggleButton1.setText("BUSCAR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        panelLocales.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        panelLocales.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 110, -1));

        panelPestañas.addTab("Locales", panelLocales);

        panelPagos.setBackground(new java.awt.Color(204, 255, 255));
        panelPagos.setMinimumSize(new java.awt.Dimension(800, 600));
        panelPagos.setPreferredSize(new java.awt.Dimension(1024, 768));
        panelPagos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("ABM Pagos");
        panelPagos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 130, 40));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelPagos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 160, 10));

        tablaPagos.setBackground(new java.awt.Color(255, 255, 204));
        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPagos.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(tablaPagos);
        tablaPagos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelPagos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 390, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("CEDULA DE IDENTIDAD");
        panelPagos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 170, 20));

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel24.setText("TIPO DE PAGO");
        panelPagos.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel23.setText("MONTO A DEPÓSITAR");
        panelPagos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        txtIdCiPagos.setBackground(new java.awt.Color(255, 255, 204));
        txtIdCiPagos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdCiPagos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPagos.add(txtIdCiPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 170, 20));

        txtIdMonto.setBackground(new java.awt.Color(255, 255, 204));
        txtIdMonto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIdMonto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIdMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMontoActionPerformed(evt);
            }
        });
        panelPagos.add(txtIdMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, 170, 20));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel25.setText("$U");
        panelPagos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, 30, 40));

        btnAgregarPago.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarPago.setText("DEPÓSITAR");
        btnAgregarPago.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPagoActionPerformed(evt);
            }
        });
        btnAgregarPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarPagoKeyPressed(evt);
            }
        });
        panelPagos.add(btnAgregarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 120, 20));

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
        panelPagos.add(btnModificarAfiliado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 120, 20));

        btnEliminarPago.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarPago.setText("ELIMINAR");
        btnEliminarPago.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPagoActionPerformed(evt);
            }
        });
        btnEliminarPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarPagoKeyPressed(evt);
            }
        });
        panelPagos.add(btnEliminarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, -1, 20));

        botonActualizarPagos.setText("Actualizar");
        botonActualizarPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarPagosActionPerformed(evt);
            }
        });
        panelPagos.add(botonActualizarPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, 90, -1));

        btnLimpiarCeldasPago.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarCeldasPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiarCeldasPago.setText("LIMPIAR");
        btnLimpiarCeldasPago.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnLimpiarCeldasPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCeldasPagoActionPerformed(evt);
            }
        });
        panelPagos.add(btnLimpiarCeldasPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 120, 20));

        jComboBoxTipoDePago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxTipoDePago.setMaximumRowCount(2);
        jComboBoxTipoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matrícula", "Mensual" }));
        jComboBoxTipoDePago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBoxTipoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDePagoActionPerformed(evt);
            }
        });
        panelPagos.add(jComboBoxTipoDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 170, -1));

        tituloRellenar6.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        tituloRellenar6.setForeground(new java.awt.Color(51, 51, 51));
        tituloRellenar6.setText("Rellene todos los campos: ");
        panelPagos.add(tituloRellenar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 220, 20));

        panelPestañas.addTab("Pagos", panelPagos);

        background.add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void botonActualizarNegociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarNegociosActionPerformed
        mostrarNegociosTabla();
    }//GEN-LAST:event_botonActualizarNegociosActionPerformed

    private void botonActualizarPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarPersonasActionPerformed

        mostrarPersonasTabla();


    }//GEN-LAST:event_botonActualizarPersonasActionPerformed

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

            String cedulaDeIdentidad = tablaPersona.getValueAt(tablaPersona.getSelectedRow(), 0).toString();

            // Setea el dato que fue clickeado y se lo agrega a la persona creada.
            persona.setCedulaDeIdentidad(cedulaDeIdentidad);

            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String nacionalidad = txtNacionalidad.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String fechaDeNacimiento = txtFechaNacimiento.getText();

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
        limpiarNegocios();
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
            
            SimpleDateFormat FormatoFechaHora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            String fechaAfiliacion = FormatoFechaHora.format(date);

            afiliacion.setNombreAfiliacion(nombreAfiliacion);
            afiliacion.setCiAfiliado(ciAfiliado);
            afiliacion.setDescripcion(descripcion);
            afiliacion.setFechaAfiliacion(fechaAfiliacion);

            FachadaLogica.agregarAfiliacion(afiliacion);

            JOptionPane.showMessageDialog(null, "Afiliación agregada correctamente");

            mostrarAfiliacionesTabla();

        } catch (AfiliacionException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo agregar la afiliación");
        }
    }//GEN-LAST:event_btnAgregarAfiliacionesActionPerformed

    private void btnEliminarAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAfiliacionesActionPerformed
        try {
            Afiliacion afiliacion = new Afiliacion();

            //String cedulaDeIdentidad = txtCedulaIdentidad.getText();
            // La variable CEDULA obtiene valor del dato clickeado en la columna.
            String idAfiliacion = tablaAfiliaciones.getValueAt(tablaAfiliaciones.getSelectedRow(), 0).toString();

            // Setea el dato que fue clickeado y se lo agrega a la persona creada.
            afiliacion.setIdAfiliacion(idAfiliacion);

            // Ejecuta el método eliminar persona.
            FachadaLogica.eliminarAfiliacion(afiliacion);
            JOptionPane.showMessageDialog(null, "Afiliacion eliminada correctamente");
            mostrarPersonasTabla();

            mostrarAfiliacionesTabla();
        } catch (AfiliacionException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEliminarAfiliacionesActionPerformed

    private void btnLimpiarCeldasAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasAfiliacionesActionPerformed
        limpiarAfiliacion();
    }//GEN-LAST:event_btnLimpiarCeldasAfiliacionesActionPerformed

    private void txtIdMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMontoActionPerformed

    private void btnAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPagoActionPerformed
        try {

            Pago pago = new Pago();

            String ciPagos = txtIdCiPagos.getText();

            SimpleDateFormat FormatoFechaHora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            String fechaHoraPago = FormatoFechaHora.format(date);

            Object tipoDePagoOBJ = jComboBoxTipoDePago.getSelectedItem();
            String tipoDePago = tipoDePagoOBJ.toString();

            String idMonto = txtIdMonto.getText();
            System.out.println(idMonto);

            pago.setCi(ciPagos);
            pago.setFechaDePago(fechaHoraPago);
            pago.setTipoDePago(tipoDePago);
            pago.setMonto(idMonto);

            FachadaLogica.agregarPago(pago);

            JOptionPane.showMessageDialog(null, "Pago agregado correctamente");

            mostrarPagosTabla();

        } catch (PagoException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo agregar el pago");
        }
    }//GEN-LAST:event_btnAgregarPagoActionPerformed

    private void btnAgregarPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarPagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPagoKeyPressed

    private void btnModificarAfiliado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAfiliado1ActionPerformed
        try {

            Pago pago = new Pago();

            String idPago = tablaPagos.getValueAt(tablaPagos.getSelectedRow(), 0).toString();

            String ciPagador = txtIdCiPagos.getText();

            String fechaDePago = tablaPagos.getValueAt(tablaPagos.getSelectedRow(), 2).toString();

            Object tipoDePagoOBJ = jComboBoxTipoDePago.getSelectedItem();
            String tipoDePago = tipoDePagoOBJ.toString();

            String monto = txtIdMonto.getText();

            pago.setIdPago(idPago);
            pago.setCi(ciPagador);
            pago.setFechaDePago(fechaDePago);
            pago.setTipoDePago(tipoDePago);
            pago.setMonto(monto);

            FachadaLogica.modificarPago(pago);
            JOptionPane.showMessageDialog(null, "Se modificó el pago correctamente");

            mostrarPagosTabla();

        } catch (PagoException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar el pago");
        }

    }//GEN-LAST:event_btnModificarAfiliado1ActionPerformed

    private void btnModificarAfiliado1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarAfiliado1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarAfiliado1KeyPressed

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
        try {
            Pago pago = new Pago();

            String idPago = tablaPagos.getValueAt(tablaPagos.getSelectedRow(), 0).toString();
            pago.setIdPago(idPago);

            FachadaLogica.eliminarPago(pago);

            JOptionPane.showMessageDialog(null, "Pago eliminado correctamente");

            mostrarPagosTabla();

        } catch (PagoException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el pago");
        }
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnEliminarPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarPagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPagoKeyPressed

    private void btnAgregarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLocalActionPerformed
        try {

            Local local = new Local();

            String idNegocio = txtIdNegocioLocal.getText();
            String direccionLocal = txtDireccionLocal.getText();
            String nombreEncargado = txtNombreEncargado.getText();
            String apellidoEncargado = txtApellidoEncargado.getText();
            String ciEncargado = txtCedulaEncargadoLocal.getText();

            local.setIdNegocio(idNegocio);
            local.setDireccionLocal(direccionLocal);
            local.setNombreEncargado(nombreEncargado);
            local.setApellidoEncargado(apellidoEncargado);
            local.setCiEncargado(ciEncargado);

            FachadaLogica.agregarLocal(local);

            JOptionPane.showMessageDialog(null, "Local agregado correctamente");

            mostrarLocalesTabla();

        } catch (LocalException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo agregar el local");
        }
    }//GEN-LAST:event_btnAgregarLocalActionPerformed

    private void btnEliminarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLocalActionPerformed
        try {
            Local local = new Local();

            String idLocal = tablaLocales.getValueAt(tablaLocales.getSelectedRow(), 0).toString();

            local.setIdLocal(idLocal);

            FachadaLogica.eliminarLocal(local);

            JOptionPane.showMessageDialog(null, "Local eliminado correctamente");

            mostrarLocalesTabla();

        } catch (LocalException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el local");
        }
    }//GEN-LAST:event_btnEliminarLocalActionPerformed

    private void btnLimpiarCeldasLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasLocActionPerformed
        limpiarLocales();
    }//GEN-LAST:event_btnLimpiarCeldasLocActionPerformed

    private void btnModificarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarNegocioActionPerformed

        try {

            Negocio negocio = new Negocio();

            String idNegocio = tablaNegocios.getValueAt(tablaNegocios.getSelectedRow(), 0).toString();
            negocio.setIdNegocio(idNegocio);

            String idAfiliado = txtIdAfiliado.getText();
            String nombreNegocio = txtNombreNegocio.getText();
            String rubro = txtRubro.getText();
            String descripcion = txtDescripcion.getText();

            negocio.setIdAfiliado(idAfiliado);
            negocio.setNombreNegocio(nombreNegocio);
            negocio.setRubro(rubro);
            negocio.setDescripcion(descripcion);

            FachadaLogica.modificarNegocio(negocio);
            JOptionPane.showMessageDialog(null, "Se modificó el negocio correctamente");
            mostrarNegociosTabla();

        } catch (NegocioException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar el negocio");
        }


    }//GEN-LAST:event_btnModificarNegocioActionPerformed

    private void btnModificarAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAfiliacionesActionPerformed

        Afiliacion afiliacion = new Afiliacion();

        try {

            String idAfiliacion = tablaAfiliaciones.getValueAt(tablaAfiliaciones.getSelectedRow(), 0).toString();
            afiliacion.setIdAfiliacion(idAfiliacion);

            String nombreAfiliacion = txtNombreAfiliacion.getText();
            String ciAfiliado = txtCedulaAfiliacion.getText();
            String descripcion = txtDescripcionAfiliacion.getText();

            afiliacion.setNombreAfiliacion(nombreAfiliacion);
            afiliacion.setCiAfiliado(ciAfiliado);
            afiliacion.setDescripcion(descripcion);

            FachadaLogica.modificarAfiliacion(afiliacion);
            JOptionPane.showMessageDialog(null, "Se modificó la afiliación correctamente");
            mostrarAfiliacionesTabla();

        } catch (AfiliacionException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la afiliación");

        }
    }//GEN-LAST:event_btnModificarAfiliacionesActionPerformed

    private void botonActualizarAfiliacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarAfiliacionesActionPerformed
        mostrarAfiliacionesTabla();
    }//GEN-LAST:event_botonActualizarAfiliacionesActionPerformed

    private void btnAgregarAfiliacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAfiliacionActionPerformed
        panelPestañas.setSelectedIndex(1);
    }//GEN-LAST:event_btnAgregarAfiliacionActionPerformed

    private void btnIngresarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPagoActionPerformed
        panelPestañas.setSelectedIndex(4);
    }//GEN-LAST:event_btnIngresarPagoActionPerformed

    private void btnModificarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLocalActionPerformed

        try {

            Local local = new Local();

            String idLocal = tablaLocales.getValueAt(tablaLocales.getSelectedRow(), 0).toString();
            local.setIdLocal(idLocal);

            String idNegocio = txtIdNegocioLocal.getText();
            String direccionLocal = txtDireccionLocal.getText();
            String nombreEncargado = txtNombreEncargado.getText();
            String apellidoEncargado = txtApellidoEncargado.getText();
            String ciEncargado = txtCedulaEncargadoLocal.getText();

            local.setIdNegocio(idNegocio);
            local.setDireccionLocal(direccionLocal);
            local.setNombreEncargado(nombreEncargado);
            local.setApellidoEncargado(apellidoEncargado);
            local.setCiEncargado(ciEncargado);

            FachadaLogica.modificarLocal(local);
            JOptionPane.showMessageDialog(null, "Se modificó el local correctamente");

            mostrarLocalesTabla();

        } catch (LocalException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar el local");
        }
    }//GEN-LAST:event_btnModificarLocalActionPerformed

    private void botonActualizarLocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarLocalesActionPerformed
        mostrarLocalesTabla();
    }//GEN-LAST:event_botonActualizarLocalesActionPerformed

    private void botonActualizarPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarPagosActionPerformed
        mostrarPagosTabla();
    }//GEN-LAST:event_botonActualizarPagosActionPerformed

    private void btnLimpiarCeldasPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCeldasPagoActionPerformed
        limpiarPagos();
    }//GEN-LAST:event_btnLimpiarCeldasPagoActionPerformed

    private void jComboBoxTipoDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoDePagoActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void btnAgregarLocallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLocallActionPerformed
        panelPestañas.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarLocallActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaLogin venttLogin = new VentanaLogin();

        venttLogin.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        Local local = new Local();

        String idNegocio = txtBuscar.getText();

        local.setIdNegocio(idNegocio);

        try {
            FachadaLogica.listarLocalesFiltradosPorIdNegocio(local);
        } catch (LocalException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        mostrarLocalesFiltradoPorIdNegocioTabla(local);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
    private javax.swing.JButton botonActualizarAfiliaciones;
    private javax.swing.JButton botonActualizarLocales;
    private javax.swing.JButton botonActualizarNegocios;
    private javax.swing.JButton botonActualizarPagos;
    private javax.swing.JButton botonActualizarPersonas;
    private javax.swing.JButton btnAgregarAfiliacion;
    private javax.swing.JButton btnAgregarAfiliaciones;
    private javax.swing.JButton btnAgregarAfiliado;
    private javax.swing.JButton btnAgregarLocal;
    private javax.swing.JButton btnAgregarLocall;
    private javax.swing.JButton btnAgregarNegocio;
    private javax.swing.JButton btnAgregarPago;
    private javax.swing.JButton btnEliminarAfiliaciones;
    private javax.swing.JButton btnEliminarAfiliado;
    private javax.swing.JButton btnEliminarLocal;
    private javax.swing.JButton btnEliminarNegocio;
    private javax.swing.JButton btnEliminarPago;
    private javax.swing.ButtonGroup btnGrupoPagos;
    private javax.swing.JButton btnIngresarPago;
    private javax.swing.JButton btnLimpiarCeldas;
    private javax.swing.JButton btnLimpiarCeldasAfiliaciones;
    private javax.swing.JButton btnLimpiarCeldasLoc;
    private javax.swing.JButton btnLimpiarCeldasNeg;
    private javax.swing.JButton btnLimpiarCeldasPago;
    private javax.swing.JButton btnModificarAfiliaciones;
    private javax.swing.JButton btnModificarAfiliado;
    private javax.swing.JButton btnModificarAfiliado1;
    private javax.swing.JButton btnModificarLocal;
    private javax.swing.JButton btnModificarNegocio;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxTipoDePago;
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel panelAfiliaciones;
    public javax.swing.JPanel panelAfiliados;
    public javax.swing.JPanel panelLocales;
    public javax.swing.JPanel panelNegocios;
    private javax.swing.JPanel panelPagos;
    public javax.swing.JTabbedPane panelPestañas;
    private javax.swing.JTable tablaAfiliaciones;
    private javax.swing.JTable tablaLocales;
    private javax.swing.JTable tablaNegocios;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTable tablaPersona;
    private javax.swing.JLabel tituloRellenar;
    private javax.swing.JLabel tituloRellenar3;
    private javax.swing.JLabel tituloRellenar4;
    private javax.swing.JLabel tituloRellenar5;
    private javax.swing.JLabel tituloRellenar6;
    public javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEncargado;
    private javax.swing.JTextField txtBuscar;
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
    private javax.swing.JTextField txtIdCiPagos;
    private javax.swing.JTextField txtIdMonto;
    private javax.swing.JTextField txtIdNegocioLocal;
    public javax.swing.JTextField txtNacionalidad;
    public javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreAfiliacion;
    private javax.swing.JTextField txtNombreEncargado;
    public javax.swing.JTextField txtNombreNegocio;
    public javax.swing.JTextField txtRubro;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
