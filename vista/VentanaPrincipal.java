/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaPrincipal.java
 *
 * Created on 19/05/2010, 20:24:31
 */

package vista;

//import org.jfree.ui.RefineryUtilities;

import config.SConfig;
import controlador.xml.XMLReader;
import controlador.xml.XMLReaderMenu;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import util.HibernateUtil;
import util.SwingPanel;
import vista.comer.pantallaBuscarEmpresaCliente;
import vista.comer.pantallaBuscarPedido;
import vista.comer.pantallaConsultarEmpresaCliente;
import vista.comer.pantallaConsultarObra;
import vista.comer.pantallaRegistrarConfirmacionInicioObra;
import vista.comer.pantallaConsultarContactosResponsables;
import vista.comer.pantallaRegistrarEmpresaCliente;
import vista.comer.pantallaRegistrarNuevaPlanta;
import vista.comer.pantallaRegistrarPedido;
import vista.compras.pantallaConsultarOC;
import vista.compras.pantallaConsultarOrdenDeCompra;
import vista.compras.pantallaConsultarPrecioXProveedor;
import vista.compras.pantallaEmitirOrdenDeCompra;
import vista.compras.pantallaEmitirOrdenDeCompra1;
import vista.compras.pantallaRegistrarPrecioRecurso;
import vista.compras.pantallaRegistrarProveedor;
import vista.compras.pantallaRegistrarRecepcionOrdenCompra;
import vista.compras.pantallaGenerarOrdenCompra;
import vista.compras.pantallaConsultarPrecioXRecurso;
import vista.compras.pantallaRegistrarPrecioRecursoNueva;
import vista.gui.sidebar.IconTreeModel;
import vista.gui.sidebar.IconTreeRenderer;
import vista.gui.sidebar.TreeEntry;
import vista.planificacion.pantallaConsultarPresupuestos;
import vista.planificacion.pantallaNuevoPresupuesto;
import vista.planificacion.pantallaRegistrarTarea;
import vista.planificacion.pantallaRegistrarPresupuesto;
import vista.rrhh.pantallaConsultarCronogramaEmpleado;
import vista.rrhh.pantallaConsultarLicenciasEmpleado;
import vista.rrhh.pantallaConsultarTallerCapacitacion;
import vista.rrhh.pantallaGenerarListadoCompraIndumentaria;
import vista.rrhh.pantallaRegistrarAsistenciaTallerCapacitacion;
import vista.rrhh.pantallaConsultarCapacitadores;
import vista.rrhh.pantallaRegistrarEmpleado;
import vista.rrhh.pantallaConsultarEmpleado;
import vista.rrhh.pantallaRegistrarPlanSeguridad;
import vista.rrhh.pantallaRegistrarTaller;
import vista.rrhh.pantallaRegistrarTallerCapacitacion;


/**
 *
 * @author iuga
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /** Creates new form VentanaPrincipal */
    public VentanaPrincipal() {
        initComponents();

        this.jpbCargando.setVisible(false);

        // Mando el Panel a un Singleton para poder accederlo de manera unica
        SwingPanel.getInstance().setPane(panel);
        SwingPanel.getInstance().setVentanaPrincipal(this);

        this.setExtendedState(MAXIMIZED_BOTH);

        //this.setTitle(SConfig.getInstance().getNombreSistema() + " | "+ SConfig.getInstance().getNombreEmpresa() + " - " + SConfig.getInstance().getDireccionEmpresa());

        cargarMenu();
    }

    public void mostrarCargando(boolean flag)
    {
        if(flag==true)
        {
                jpbCargando.setVisible(true);
                setProgress(10);
                jpbCargando.setString("Cargando...");
                jpbCargando.setIndeterminate(true);
                jPanelCargando.update(jPanelCargando.getGraphics());

          setProgress(20);
          jPanelCargando.update(jPanelCargando.getGraphics());
          setProgress(30);
          jPanelCargando.update(jPanelCargando.getGraphics());

        }
        else
        {
            jPanelCargando.setVisible(false);
        }
    }

    public void setProgress(final int progress)
    {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            jpbCargando.setValue(progress);
          }
        });
    }

    private void cargarMenu()
    {
        treeMenu.setCellRenderer(new IconTreeRenderer());
        treeMenu.setOpaque(false);
        treeMenu.setRowHeight(26);
        treeMenu.setExpandsSelectedPaths(true);
        treeMenu.setBackground(null);

        XMLReaderMenu menuxml = new XMLReaderMenu(getClass().getResource("/config/menu.xml").getPath());
        IconTreeModel itm = new IconTreeModel();
        itm.RellenarArbol(menuxml.cargarMenu());
        treeMenu.setModel(itm);

        treeMenu.setRootVisible(false);

    }

    private void Salir()
    {
        int op = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?");
        if(op == JOptionPane.YES_OPTION)
        {
            HibernateUtil.closeSession();
            System.exit(0);
        }
    }

    private void NuevaPlanta()
    {
            pantallaRegistrarNuevaPlanta pre = new pantallaRegistrarNuevaPlanta();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnConsultarClientes = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnNuevoPedidoObra = new javax.swing.JButton();
        btnNuevoEmpleado = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSalir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanelCargando = new javax.swing.JPanel();
        jpbCargando = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeMenu = new javax.swing.JTree();
        jPanel5 = new javax.swing.JPanel();
        lblAyudaTitulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblAyudaDesc = new javax.swing.JTextArea();
        panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mObra = new javax.swing.JMenu();
        miNuevo = new javax.swing.JMenuItem();
        miConsultar = new javax.swing.JMenuItem();
        miModificar = new javax.swing.JMenuItem();
        miCompraMateriales = new javax.swing.JMenuItem();
        mPlanificacion = new javax.swing.JMenu();
        miEPresupuesto = new javax.swing.JMenuItem();
        miNueva = new javax.swing.JMenuItem();
        miPModificar = new javax.swing.JMenuItem();
        miPlanSeguridad = new javax.swing.JMenuItem();
        mEjecucion = new javax.swing.JMenu();
        miLanzamientoyFin = new javax.swing.JMenuItem();
        miReLanz = new javax.swing.JMenuItem();
        miAvance = new javax.swing.JMenuItem();
        miOrdenesTrab = new javax.swing.JMenuItem();
        mEtapa = new javax.swing.JMenu();
        miEtapaConsultar = new javax.swing.JMenuItem();
        miEtapaModificar = new javax.swing.JMenuItem();
        miEtapaEliminar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mRRHH = new javax.swing.JMenu();
        miNuevoRH = new javax.swing.JMenuItem();
        miConsultarRH = new javax.swing.JMenuItem();
        miModificarRH = new javax.swing.JMenuItem();
        miDarDeBajaRH = new javax.swing.JMenuItem();
        miCronogramaRH = new javax.swing.JMenuItem();
        miLicencia = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnuRecepcionOrdenCompra = new javax.swing.JMenuItem();
        mnuRegistrarProveedor = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemGenerarOC = new javax.swing.JMenuItem();
        mTalleres = new javax.swing.JMenu();
        mNuevoTaller = new javax.swing.JMenu();
        miParaEmpleado = new javax.swing.JMenuItem();
        miParaObra = new javax.swing.JMenuItem();
        miCapacitadores = new javax.swing.JMenuItem();
        miRegistroDeAsistencia = new javax.swing.JMenuItem();
        miLugaresDeCapacitacion = new javax.swing.JMenuItem();
        mSistema = new javax.swing.JMenu();
        mEmpresa = new javax.swing.JMenu();
        administrarEmpresas = new javax.swing.JMenuItem();
        mPlanta = new javax.swing.JMenu();
        miNuevaPlanta = new javax.swing.JMenuItem();
        miConsultarPlanta = new javax.swing.JMenuItem();
        miModificarPlanta = new javax.swing.JMenuItem();
        mContactos = new javax.swing.JMenu();
        miGestionContactos = new javax.swing.JMenuItem();
        mProveedor = new javax.swing.JMenu();
        miGestionProveedor = new javax.swing.JMenuItem();
        mHerramienta = new javax.swing.JMenu();
        miGestionHerramienta = new javax.swing.JMenuItem();
        mIndumentaria = new javax.swing.JMenu();
        miGestionIndumentaria = new javax.swing.JMenuItem();
        miOrdenDeCompra = new javax.swing.JMenuItem();
        mMateriales = new javax.swing.JMenu();
        miGestionMateriales = new javax.swing.JMenuItem();
        mUbicaciones = new javax.swing.JMenu();
        mLocalidad = new javax.swing.JMenu();
        miGestionLocalidad = new javax.swing.JMenuItem();
        mBarrio = new javax.swing.JMenu();
        miGestionBarrio = new javax.swing.JMenuItem();
        mProvincia = new javax.swing.JMenu();
        miGestionProvincia = new javax.swing.JMenuItem();
        mPais = new javax.swing.JMenu();
        miGestionPais = new javax.swing.JMenuItem();
        mUsuarios = new javax.swing.JMenu();
        miCerrarSesion = new javax.swing.JMenuItem();
        miCambiarUsuario = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnConsultarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/users.png"))); // NOI18N
        btnConsultarClientes.setText("Consultar Clientes");
        btnConsultarClientes.setFocusable(false);
        btnConsultarClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConsultarClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClientesActionPerformed(evt);
            }
        });
        jToolBar1.add(btnConsultarClientes);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/activity_monitor.png"))); // NOI18N
        jButton4.setText("Actualizar Precios");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/full_page.png"))); // NOI18N
        jButton2.setText("Consultar Talleres de Capacitación");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/comments.png"))); // NOI18N
        jButton3.setText("Gestionar Licencias");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        btnNuevoPedidoObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add_page.png"))); // NOI18N
        btnNuevoPedidoObra.setText("Nuevo Pedido de Obra");
        btnNuevoPedidoObra.setFocusable(false);
        btnNuevoPedidoObra.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevoPedidoObra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoPedidoObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoObraActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevoPedidoObra);

        btnNuevoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/user.png"))); // NOI18N
        btnNuevoEmpleado.setText("Consultar Empleados");
        btnNuevoEmpleado.setFocusable(false);
        btnNuevoEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevoEmpleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevoEmpleado);
        jToolBar1.add(jSeparator1);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/block.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);
        jToolBar1.add(jSeparator2);

        jpbCargando.setDoubleBuffered(true);
        jpbCargando.setString("Cargando...");
        jpbCargando.setStringPainted(true);

        javax.swing.GroupLayout jPanelCargandoLayout = new javax.swing.GroupLayout(jPanelCargando);
        jPanelCargando.setLayout(jPanelCargandoLayout);
        jPanelCargandoLayout.setHorizontalGroup(
            jPanelCargandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCargandoLayout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(jpbCargando, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCargandoLayout.setVerticalGroup(
            jPanelCargandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbCargando, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jToolBar1.add(jPanelCargando);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jSplitPane2.setDoubleBuffered(true);

        jSplitPane1.setDividerLocation(600);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        treeMenu.setModel(new IconTreeModel());
        treeMenu.setRootVisible(false);
        treeMenu.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeMenuValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeMenu);

        jSplitPane1.setTopComponent(jScrollPane1);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAyudaTitulo.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAyudaTitulo.setText("Titulo de la Ayuda");

        jButton1.setFont(new java.awt.Font("Dialog", 2, 10));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/help.png"))); // NOI18N
        jButton1.setText("Más Ayuda ...");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        lblAyudaDesc.setColumns(20);
        lblAyudaDesc.setLineWrap(true);
        lblAyudaDesc.setRows(5);
        lblAyudaDesc.setEnabled(false);
        jScrollPane2.setViewportView(lblAyudaDesc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addComponent(lblAyudaTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAyudaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel5);

        jSplitPane2.setLeftComponent(jSplitPane1);

        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel.setDoubleBuffered(true);
        jSplitPane2.setRightComponent(panel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        mObra.setText("Pedido Obra");

        miNuevo.setText("Nuevo");
        miNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoActionPerformed(evt);
            }
        });
        mObra.add(miNuevo);

        miConsultar.setText("Ver Obras Activas");
        miConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarActionPerformed(evt);
            }
        });
        mObra.add(miConsultar);

        miModificar.setText("Modificar");
        miModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModificarActionPerformed(evt);
            }
        });
        mObra.add(miModificar);

        miCompraMateriales.setText("Compra de Materiales");
        mObra.add(miCompraMateriales);

        mPlanificacion.setText("Planificación");

        miEPresupuesto.setText("Emisión de Presupuesto");
        mPlanificacion.add(miEPresupuesto);

        miNueva.setText("Nueva");
        mPlanificacion.add(miNueva);

        miPModificar.setText("Modificar");
        mPlanificacion.add(miPModificar);

        miPlanSeguridad.setText("Plan de Seguridad");
        mPlanificacion.add(miPlanSeguridad);

        mObra.add(mPlanificacion);

        mEjecucion.setText("Ejecución");
        mEjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEjecucionActionPerformed(evt);
            }
        });

        miLanzamientoyFin.setText("Lanzamiento y Fin");
        mEjecucion.add(miLanzamientoyFin);

        miReLanz.setText("Re-Lanzamiento");
        mEjecucion.add(miReLanz);

        miAvance.setText("Avance");
        mEjecucion.add(miAvance);

        miOrdenesTrab.setText("Órdenes de Trabajo");
        mEjecucion.add(miOrdenesTrab);

        mEtapa.setText("Etapa");

        miEtapaConsultar.setText("Consultar");
        mEtapa.add(miEtapaConsultar);

        miEtapaModificar.setText("Modificar");
        mEtapa.add(miEtapaModificar);

        miEtapaEliminar.setText("Eliminar");
        mEtapa.add(miEtapaEliminar);

        mEjecucion.add(mEtapa);

        mObra.add(mEjecucion);

        jMenuBar1.add(mObra);

        jMenu2.setText("Recursos");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search_page.png"))); // NOI18N
        jMenuItem2.setText("Consultar Precios por Proveedor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/activity_monitor.png"))); // NOI18N
        jMenuItem3.setText("Actualizar Precios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Presupuestación");

        jMenuItem8.setText("Nuevo Presupuesto");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/chart.png"))); // NOI18N
        jMenuItem5.setText("Nueva Etapa (NF)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search.png"))); // NOI18N
        jMenuItem7.setText("Consultar Presupuestos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        mRRHH.setText("Recursos Humanos");

        miNuevoRH.setText("Nuevo");
        miNuevoRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoRHActionPerformed(evt);
            }
        });
        mRRHH.add(miNuevoRH);

        miConsultarRH.setText("Consultar");
        mRRHH.add(miConsultarRH);

        miModificarRH.setText("Modificar");
        mRRHH.add(miModificarRH);

        miDarDeBajaRH.setText("Dar de Baja");
        mRRHH.add(miDarDeBajaRH);

        miCronogramaRH.setText("Cronograma");
        miCronogramaRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCronogramaRHActionPerformed(evt);
            }
        });
        mRRHH.add(miCronogramaRH);
        mRRHH.add(miLicencia);

        jMenu3.setText("jMenu3");
        mRRHH.add(jMenu3);

        jMenuBar1.add(mRRHH);

        jMenu1.setText("Compras");

        jMenuItem6.setText("Consultar precios por recurso");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        mnuRecepcionOrdenCompra.setText("Recepción Orden de Compra");
        mnuRecepcionOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRecepcionOrdenCompraActionPerformed(evt);
            }
        });
        jMenu1.add(mnuRecepcionOrdenCompra);

        mnuRegistrarProveedor.setText("Registrar Proveedor");
        mnuRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrarProveedorActionPerformed(evt);
            }
        });
        jMenu1.add(mnuRegistrarProveedor);

        jMenuItem1.setText("Consultar Orden de Compra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Emitir Orden de Compra");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItemGenerarOC.setText("Generar Orden de Compra");
        jMenuItemGenerarOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGenerarOCActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGenerarOC);

        jMenuBar1.add(jMenu1);

        mTalleres.setText("Talleres de Capacitación");

        mNuevoTaller.setText("Nuevo Taller");

        miParaEmpleado.setText("Para Empleados");
        mNuevoTaller.add(miParaEmpleado);

        miParaObra.setText("Para una Obra");
        mNuevoTaller.add(miParaObra);

        mTalleres.add(mNuevoTaller);

        miCapacitadores.setText("Capacitadores");
        mTalleres.add(miCapacitadores);

        miRegistroDeAsistencia.setText("Registro de Asistencias");
        mTalleres.add(miRegistroDeAsistencia);

        miLugaresDeCapacitacion.setText("Lugares de Capacitacion");
        mTalleres.add(miLugaresDeCapacitacion);

        jMenuBar1.add(mTalleres);

        mSistema.setText("Cargas Básicas");

        mEmpresa.setText("Empresa");

        administrarEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/promotion.png"))); // NOI18N
        administrarEmpresas.setText("Administrar...");
        administrarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarEmpresasActionPerformed(evt);
            }
        });
        mEmpresa.add(administrarEmpresas);

        mSistema.add(mEmpresa);

        mPlanta.setText("Planta");

        miNuevaPlanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add.png"))); // NOI18N
        miNuevaPlanta.setText("Nueva");
        miNuevaPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevaPlantaActionPerformed(evt);
            }
        });
        mPlanta.add(miNuevaPlanta);

        miConsultarPlanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search_page.png"))); // NOI18N
        miConsultarPlanta.setText("Consultar");
        mPlanta.add(miConsultarPlanta);

        miModificarPlanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add_page.png"))); // NOI18N
        miModificarPlanta.setText("Modificar");
        mPlanta.add(miModificarPlanta);

        mSistema.add(mPlanta);

        mContactos.setText("Contactos");

        miGestionContactos.setText("Gestión");
        mContactos.add(miGestionContactos);

        mSistema.add(mContactos);

        mProveedor.setText("Proveedor");

        miGestionProveedor.setText("Gestión");
        mProveedor.add(miGestionProveedor);

        mSistema.add(mProveedor);

        mHerramienta.setText("Herramienta");

        miGestionHerramienta.setText("Gestión");
        mHerramienta.add(miGestionHerramienta);

        mSistema.add(mHerramienta);

        mIndumentaria.setText("Indumentaria");

        miGestionIndumentaria.setText("Gestión");
        mIndumentaria.add(miGestionIndumentaria);

        miOrdenDeCompra.setText("Orden de Compra");
        miOrdenDeCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOrdenDeCompraActionPerformed(evt);
            }
        });
        mIndumentaria.add(miOrdenDeCompra);

        mSistema.add(mIndumentaria);

        mMateriales.setText("Materiales");

        miGestionMateriales.setText("Gestión");
        mMateriales.add(miGestionMateriales);

        mSistema.add(mMateriales);

        mLocalidad.setText("Localidad");

        miGestionLocalidad.setText("Gestión");
        mLocalidad.add(miGestionLocalidad);

        mUbicaciones.add(mLocalidad);

        mBarrio.setText("Barrio");

        miGestionBarrio.setText("Gestión");
        miGestionBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGestionBarrioActionPerformed(evt);
            }
        });
        mBarrio.add(miGestionBarrio);

        mUbicaciones.add(mBarrio);

        mProvincia.setText("Provincia");

        miGestionProvincia.setText("Gestión");
        mProvincia.add(miGestionProvincia);

        mUbicaciones.add(mProvincia);

        mPais.setText("País");

        miGestionPais.setText("Gestión");
        mPais.add(miGestionPais);

        mUbicaciones.add(mPais);

        mSistema.add(mUbicaciones);

        jMenuBar1.add(mSistema);

        mUsuarios.setText("Usuario");

        miCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/lock.png"))); // NOI18N
        miCerrarSesion.setText("Cerrar Sesión");
        mUsuarios.add(miCerrarSesion);

        miCambiarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/users.png"))); // NOI18N
        miCambiarUsuario.setText("Cambiar de Usuario");
        mUsuarios.add(miCambiarUsuario);

        jMenuBar1.add(mUsuarios);

        mAyuda.setText("Ayuda");
        jMenuBar1.add(mAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
             pantallaConsultarEmpleado pre = new pantallaConsultarEmpleado();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void treeMenuValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeMenuValueChanged
        TreeEntry node = (TreeEntry)evt.getPath().getLastPathComponent();

        if(node==null) return;
        //
        if(node.getTitulo().equals("Nuevo Empleado"))
        {
            pantallaConsultarEmpleado pre = new pantallaConsultarEmpleado();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
           // pre.opcionRegistrarEmpleado();
            return;
        }
        // Nuevo Pedido de Obra
        if(node.getTitulo().equals("Registrar Nuevo Pedido de Obra"))
        {
            pantallaRegistrarPedido pre = new pantallaRegistrarPedido();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        //Nueva Empresa Cliente
        if(node.getTitulo().equals("Nueva Empresa Cliente"))
        {
            pantallaRegistrarEmpresaCliente pre = new pantallaRegistrarEmpresaCliente();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        //Consultar Empresas Cliente
         if(node.getTitulo().equals("Consultar Empresas Cliente"))
        {
            pantallaConsultarEmpresaCliente pre = new pantallaConsultarEmpresaCliente();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Nueva Planta
        if(node.getTitulo().equals("Nueva Planta"))
        {
            NuevaPlanta();
            return;
        }
        // Consultar Obras
        if(node.getTitulo().equals("Ver Obras Activas"))
        {
            pantallaConsultarObra pre = new pantallaConsultarObra();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
                // Consultar Obras
        if(node.getTitulo().equals("Ver Obras Activas"))
        {
            pantallaConsultarObra pre = new pantallaConsultarObra();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Modificar una Empresa Cliente
        if(node.getTitulo().equals("Modificar Empresa Cliente"))
        {
            pantallaBuscarEmpresaCliente pre = new pantallaBuscarEmpresaCliente();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Cronogramas de Trabajo
        if(node.getTitulo().equals("Cronogramas de Trabajo"))
        {
            pantallaConsultarCronogramaEmpleado pre = new pantallaConsultarCronogramaEmpleado();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Nuevo Listado de Compra de Indumentaria
        if(node.getTitulo().equals("Nuevo Listado de Compra de Indumentaria"))
        {
            pantallaGenerarListadoCompraIndumentaria pre = new pantallaGenerarListadoCompraIndumentaria();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Nuevo Plan de Seguridad
        if(node.getTitulo().equals("Nuevo Plan de Seguridad"))
        {
            pantallaRegistrarPlanSeguridad pre = new pantallaRegistrarPlanSeguridad();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Nuevo Taller de Capcitación
        if(node.getTitulo().equals("Nuevo Taller de Capcitación"))
        {
            pantallaRegistrarTaller pre = new pantallaRegistrarTaller();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Nuevo Plan de Seguridad
        if(node.getTitulo().equals("Registrar Asistencias"))
        {
            pantallaRegistrarAsistenciaTallerCapacitacion pre = new pantallaRegistrarAsistenciaTallerCapacitacion();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            return;
        }
        // Emitir Listado de Asistencia
        if(node.getTitulo().equals("Emitir Listado de Asistencia"))
        {
//            pantallaEmitirListadoDeAsistenciaATallerDeCapacitacion pre = new pantallaEmitirListadoDeAsistenciaATallerDeCapacitacion();
//            SwingPanel.getInstance().addWindow(pre);
//            pre.setVisible(true);
//            return;
        }
        // Nuevo Capacitador
        if(node.getTitulo().equals("Nuevo Capacitador"))
        {
            pantallaConsultarCapacitadores prc = new pantallaConsultarCapacitadores();
            SwingPanel.getInstance().addWindow(prc);
            prc.setVisible(true);
            return;
        }
        // Nuevo Contacto
        if(node.getTitulo().equals("Nuevo Contacto"))
        {
            pantallaConsultarContactosResponsables prc = new pantallaConsultarContactosResponsables();
            SwingPanel.getInstance().addWindow(prc);
            prc.setVisible(true);
            return;
        }
    }//GEN-LAST:event_treeMenuValueChanged

    private void btnNuevoPedidoObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoObraActionPerformed

            pantallaRegistrarPedido pre = new pantallaRegistrarPedido();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);

    }//GEN-LAST:event_btnNuevoPedidoObraActionPerformed

    private void miNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoActionPerformed
        // TODO add your handling code here:
        pantallaRegistrarPedido pre = new pantallaRegistrarPedido();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        return;
}//GEN-LAST:event_miNuevoActionPerformed

    private void miConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarActionPerformed
        // TODO add your handling code here:
        pantallaConsultarObra pre = new pantallaConsultarObra();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
}//GEN-LAST:event_miConsultarActionPerformed

    private void mEjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEjecucionActionPerformed
        // TODO add your handling code here:
        pantallaRegistrarConfirmacionInicioObra pre = new pantallaRegistrarConfirmacionInicioObra();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        return;
}//GEN-LAST:event_mEjecucionActionPerformed

    private void miNuevoRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoRHActionPerformed
        // TODO add your handling code here:
        pantallaRegistrarEmpleado pre = new pantallaRegistrarEmpleado();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        pre.opcionRegistrarEmpleado();
        return;
}//GEN-LAST:event_miNuevoRHActionPerformed

    private void miCronogramaRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCronogramaRHActionPerformed
        // TODO add your handling code here:
        pantallaConsultarCronogramaEmpleado pre = new pantallaConsultarCronogramaEmpleado();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        return;
}//GEN-LAST:event_miCronogramaRHActionPerformed

    private void miNuevaPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevaPlantaActionPerformed
        // TODO add your handling code here:
        pantallaRegistrarNuevaPlanta pre = new pantallaRegistrarNuevaPlanta();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        return;
}//GEN-LAST:event_miNuevaPlantaActionPerformed

    private void miOrdenDeCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOrdenDeCompraActionPerformed
        // TODO add your handling code here:
        pantallaGenerarListadoCompraIndumentaria pre = new pantallaGenerarListadoCompraIndumentaria();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        return;
}//GEN-LAST:event_miOrdenDeCompraActionPerformed

    private void miGestionBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGestionBarrioActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_miGestionBarrioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        Salir();

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClientesActionPerformed
            pantallaConsultarEmpresaCliente pre = new pantallaConsultarEmpresaCliente();
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
    }//GEN-LAST:event_btnConsultarClientesActionPerformed

    private void miModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModificarActionPerformed
        pantallaBuscarPedido pre = new pantallaBuscarPedido();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
    }//GEN-LAST:event_miModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pantallaConsultarTallerCapacitacion pctc = new pantallaConsultarTallerCapacitacion();
        SwingPanel.getInstance().addWindow(pctc);
        pctc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        pantallaConsultarLicenciasEmpleado pcle = new pantallaConsultarLicenciasEmpleado();
        SwingPanel.getInstance().addWindow(pcle);
        pcle.filtrarPorEmpleado(1); 
        pcle.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void administrarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarEmpresasActionPerformed
        // TODO add your handling code here:
        pantallaBuscarEmpresaCliente pre = new pantallaBuscarEmpresaCliente();
        SwingPanel.getInstance().addWindow(pre);
        pre.setVisible(true);
        return;
}//GEN-LAST:event_administrarEmpresasActionPerformed

    private void mnuRecepcionOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecepcionOrdenCompraActionPerformed
        // TODO add your handling code here:
        pantallaRegistrarRecepcionOrdenCompra p = new pantallaRegistrarRecepcionOrdenCompra();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
        return;
    }//GEN-LAST:event_mnuRecepcionOrdenCompraActionPerformed

    private void mnuRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrarProveedorActionPerformed
        pantallaRegistrarProveedor p = new pantallaRegistrarProveedor();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
        return;
    }//GEN-LAST:event_mnuRegistrarProveedorActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pantallaRegistrarPrecioRecursoNueva p = new pantallaRegistrarPrecioRecursoNueva();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pantallaConsultarOrdenDeCompra p = new pantallaConsultarOrdenDeCompra();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        pantallaRegistrarPrecioRecurso p = new pantallaRegistrarPrecioRecurso();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        pantallaConsultarPrecioXProveedor p = new pantallaConsultarPrecioXProveedor();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        pantallaEmitirOrdenDeCompra1 p = new pantallaEmitirOrdenDeCompra1();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        pantallaRegistrarTarea p = new pantallaRegistrarTarea();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemGenerarOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGenerarOCActionPerformed
        pantallaGenerarOrdenCompra p = new pantallaGenerarOrdenCompra();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItemGenerarOCActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        pantallaConsultarPrecioXRecurso p = new pantallaConsultarPrecioXRecurso();
        SwingPanel.getInstance().addWindow(p);
        p.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        pantallaNuevoPresupuesto p = new pantallaNuevoPresupuesto();
        SwingPanel.getInstance().addWindow(p);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    pantallaConsultarPresupuestos pcp = new pantallaConsultarPresupuestos();
    SwingPanel.getInstance().addWindow(pcp);
    pcp.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem administrarEmpresas;
    private javax.swing.JButton btnConsultarClientes;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnNuevoPedidoObra;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemGenerarOC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelCargando;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JProgressBar jpbCargando;
    private javax.swing.JTextArea lblAyudaDesc;
    private javax.swing.JLabel lblAyudaTitulo;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mBarrio;
    private javax.swing.JMenu mContactos;
    private javax.swing.JMenu mEjecucion;
    private javax.swing.JMenu mEmpresa;
    private javax.swing.JMenu mEtapa;
    private javax.swing.JMenu mHerramienta;
    private javax.swing.JMenu mIndumentaria;
    private javax.swing.JMenu mLocalidad;
    private javax.swing.JMenu mMateriales;
    private javax.swing.JMenu mNuevoTaller;
    private javax.swing.JMenu mObra;
    private javax.swing.JMenu mPais;
    private javax.swing.JMenu mPlanificacion;
    private javax.swing.JMenu mPlanta;
    private javax.swing.JMenu mProveedor;
    private javax.swing.JMenu mProvincia;
    private javax.swing.JMenu mRRHH;
    private javax.swing.JMenu mSistema;
    private javax.swing.JMenu mTalleres;
    private javax.swing.JMenu mUbicaciones;
    private javax.swing.JMenu mUsuarios;
    private javax.swing.JMenuItem miAvance;
    private javax.swing.JMenuItem miCambiarUsuario;
    private javax.swing.JMenuItem miCapacitadores;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miCompraMateriales;
    private javax.swing.JMenuItem miConsultar;
    private javax.swing.JMenuItem miConsultarPlanta;
    private javax.swing.JMenuItem miConsultarRH;
    private javax.swing.JMenuItem miCronogramaRH;
    private javax.swing.JMenuItem miDarDeBajaRH;
    private javax.swing.JMenuItem miEPresupuesto;
    private javax.swing.JMenuItem miEtapaConsultar;
    private javax.swing.JMenuItem miEtapaEliminar;
    private javax.swing.JMenuItem miEtapaModificar;
    private javax.swing.JMenuItem miGestionBarrio;
    private javax.swing.JMenuItem miGestionContactos;
    private javax.swing.JMenuItem miGestionHerramienta;
    private javax.swing.JMenuItem miGestionIndumentaria;
    private javax.swing.JMenuItem miGestionLocalidad;
    private javax.swing.JMenuItem miGestionMateriales;
    private javax.swing.JMenuItem miGestionPais;
    private javax.swing.JMenuItem miGestionProveedor;
    private javax.swing.JMenuItem miGestionProvincia;
    private javax.swing.JMenuItem miLanzamientoyFin;
    private javax.swing.JMenuItem miLicencia;
    private javax.swing.JMenuItem miLugaresDeCapacitacion;
    private javax.swing.JMenuItem miModificar;
    private javax.swing.JMenuItem miModificarPlanta;
    private javax.swing.JMenuItem miModificarRH;
    private javax.swing.JMenuItem miNueva;
    private javax.swing.JMenuItem miNuevaPlanta;
    private javax.swing.JMenuItem miNuevo;
    private javax.swing.JMenuItem miNuevoRH;
    private javax.swing.JMenuItem miOrdenDeCompra;
    private javax.swing.JMenuItem miOrdenesTrab;
    private javax.swing.JMenuItem miPModificar;
    private javax.swing.JMenuItem miParaEmpleado;
    private javax.swing.JMenuItem miParaObra;
    private javax.swing.JMenuItem miPlanSeguridad;
    private javax.swing.JMenuItem miReLanz;
    private javax.swing.JMenuItem miRegistroDeAsistencia;
    private javax.swing.JMenuItem mnuRecepcionOrdenCompra;
    private javax.swing.JMenuItem mnuRegistrarProveedor;
    private javax.swing.JDesktopPane panel;
    private javax.swing.JTree treeMenu;
    // End of variables declaration//GEN-END:variables

    public void mostrarAyuda(String titulo, String desc, int id)
    {
        lblAyudaTitulo.setText(titulo);
        lblAyudaDesc.setText(desc);
    }

}
