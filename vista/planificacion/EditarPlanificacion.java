/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditarPlanificacion.java
 *
 * Created on 08-ene-2012, 17:13:17
 */
package vista.planificacion;

import vista.gui.dnd.PanelDropTarget;
import com.hackelare.coolgantt.*;
import com.hackelare.coolgantt.demo.demoEvents;
import com.hackelare.coolgantt.demo.demoTypes;
import com.hackelare.coolgantt.legacy.model.ColorLabel;
import config.Iconos;
import controlador.planificacion.GestorEditarPlanificacion;
import controlador.planificacion.GestorEditarTarea;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import modelo.TareaPlanificacion;
import util.NTupla;
import util.SwingPanel;
import util.TablaUtil;
import vista.cotizacion.ExplorarSubObras;
import vista.gui.dnd.IDropEvent;
import vista.gui.sidebar.IconTreeModel;
import vista.gui.sidebar.IconTreeRenderer;
import vista.planificacion.arbolTareas.ArbolIconoNodo;
import vista.planificacion.arbolTareas.ArbolIconoRenderer;

/**
 *
 * @author Administrador
 */
public class EditarPlanificacion extends javax.swing.JInternalFrame {

    private static final String iconoSubObra = "/res/iconos/var/16x16/Application.png";
    private static final String iconoTarea = "/res/iconos/var/16x16/calendar.png";
    private final String CADENA_SUB_TAREA = "@";
    private int idObra;
    private int template;
    private GestorEditarPlanificacion _gestor;
    ICoolGantt graph;
    JComponent grafico;
   
    public EditarPlanificacion(int template, int idObra) {
        this.template = template;
        this.idObra = idObra;
        
        _gestor = new GestorEditarPlanificacion(this,idObra);
        initComponents(); 
        
        tblSubObras.setDefaultRenderer(Object.class, new ListaDeTareasRender());
        tblTareas.setDefaultRenderer(Object.class, new ListaDeTareasRender());        
        treeRecursos.setCellRenderer(new IconTreeRenderer());
        treeRecursos.setRootVisible(false);

        initArbolRecursos();
        initDatosGenerales(idObra);
        inicializarArbolDeTareas();
        initGraph();

        //TODO: Sacar esto, test de DnD
        PanelDropTarget target = new PanelDropTarget(jPanel2, new GanttDropEvent());    
    }

    private void initDatosGenerales(int idObra) {
        _gestor.mostrarDatosGenerales(idObra);
    }    
    
    private void initArbolRecursos() {
        initTablaSubObras(this.idObra);
    }

    private void initGraph() {
        graph = CoolGanttFactory.create();
        graph.setEventHandler(new demoEvents());

        initTypeModel();
        initModel();

        grafico = graph.getComponent();
        
        // Soporte para Drop
        PanelDropTarget target = new PanelDropTarget(grafico, new GanttDropEvent());
        
        panelLineaDeTiempo.add(grafico, BorderLayout.CENTER);
        pack();
        setVisible(true);
        
        // Agrego el menu del boton derecho
        grafico.setComponentPopupMenu(jpm);
        
        // Le doy el zoom que quiero
         graph.setZoomOut();
          graph.setZoomOut();
           graph.setZoomOut();
            graph.setZoomOut();
             graph.setZoomOut();
         
        graph.setEventHandler(new GanttEventMouse());
    }

    private void updateGantt()
    {
        panelLineaDeTiempo.remove(grafico);
        pack();
        grafico = graph.getComponent();
        panelLineaDeTiempo.add(grafico, BorderLayout.CENTER);
        pack();
        // Soporte para Drop
        PanelDropTarget target = new PanelDropTarget(grafico, new GanttDropEvent());
    }
    
    private void initModel() {

        int n = 0;
        // TODO: Llenar el Gantt
        List<TareaPlanificacion> lista = _gestor.getListaTareasPlanificadas();
        for (int i = 0; i < lista.size(); i++) {
            TareaPlanificacion tplan = lista.get(i);
            cargarTareasRecursivas(tplan,n);
        }
        
        graph.refreshModel();
    }

    private void cargarTareasRecursivas(TareaPlanificacion tplan, int n) {

        CoolGanttPhase p1 = new CoolGanttPhase();
        p1.setEditable(true);
        p1.setId(tplan.getIdTareaGantt());
        p1.setNombre(tplan.getNombre());
        p1.setType(demoTypes.TYPE_NORMAL);
        p1.setStartDate(tplan.getFechaInicio());
        p1.setEndDate(tplan.getFechaFin());

        // Agrego el nivel de tarea al gantt
        for (int j = 0; j < n; j++) {
            p1.setNombre(p1.getNombre()+" @");
        }
        
        graph.addPhase(p1);

        tplan.getSubtareas();
        if (tplan.getSubtareas() != null) {
            for (int i = 0; i < tplan.getSubtareas().size(); i++) {
                TareaPlanificacion tp = tplan.getSubtareas().get(i);
                cargarTareasRecursivas(tp,n++);
            }
        }
    }

    private Date fechaMas(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }

    private void initTypeModel() {
        CoolGanttTypeModel typeModel = new CoolGanttTypeModel();
        typeModel.addType(demoTypes.TYPE_NORMAL, ColorLabel.COLOR_LABELS[0]);
        typeModel.addType(demoTypes.TYPE_TRANSPORTE, ColorLabel.COLOR_LABELS[1]);
        typeModel.addType(demoTypes.TYPE_MONTAJE, ColorLabel.COLOR_LABELS[2]);
        graph.getModel().setTypeModel(typeModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpm = new javax.swing.JPopupMenu();
        menuNuevaEtapa = new javax.swing.JMenuItem();
        menuZoomMas = new javax.swing.JMenuItem();
        menuZoomMenos = new javax.swing.JMenuItem();
        menuDerecha = new javax.swing.JMenuItem();
        menuIzquierda = new javax.swing.JMenuItem();
        menuFechaActual = new javax.swing.JMenuItem();
        menuVistaAnual = new javax.swing.JMenuItem();
        menuVistaSemanal = new javax.swing.JMenuItem();
        jTextField3 = new javax.swing.JTextField();
        panelBarraIzquierda = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        treeRecursos = new javax.swing.JTree();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubObras = new javax.swing.JTable();
        btnEmitirInforme = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelCentral = new javax.swing.JTabbedPane();
        panelLineaDeTiempo = new javax.swing.JPanel();
        panelArbolTareas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        arbolTareas = new javax.swing.JTree();
        panelDatosGenerales = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtNroPlanificacion = new javax.swing.JTextField();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblObraNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblObraLugar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblObraPlanta = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblObraFechaInicio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblObraFechaFin = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNroCotizacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblCotMontoTotal = new javax.swing.JLabel();

        menuNuevaEtapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add.png"))); // NOI18N
        menuNuevaEtapa.setText("Nueva Tarea");
        menuNuevaEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevaEtapaActionPerformed(evt);
            }
        });
        jpm.add(menuNuevaEtapa);

        menuZoomMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search.png"))); // NOI18N
        menuZoomMas.setText("Zoom +");
        menuZoomMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuZoomMasActionPerformed(evt);
            }
        });
        jpm.add(menuZoomMas);

        menuZoomMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search.png"))); // NOI18N
        menuZoomMenos.setText("Zoom -");
        menuZoomMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuZoomMenosActionPerformed(evt);
            }
        });
        jpm.add(menuZoomMenos);

        menuDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/next.png"))); // NOI18N
        menuDerecha.setText("Mover a la Derecha");
        menuDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDerechaActionPerformed(evt);
            }
        });
        jpm.add(menuDerecha);

        menuIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/back.png"))); // NOI18N
        menuIzquierda.setText("Mover a la Izquierda");
        menuIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIzquierdaActionPerformed(evt);
            }
        });
        jpm.add(menuIzquierda);

        menuFechaActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/calendar.png"))); // NOI18N
        menuFechaActual.setText("Ir a Fecha Actual");
        menuFechaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFechaActualActionPerformed(evt);
            }
        });
        jpm.add(menuFechaActual);

        menuVistaAnual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/calendar.png"))); // NOI18N
        menuVistaAnual.setText("Vista Anual");
        menuVistaAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVistaAnualActionPerformed(evt);
            }
        });
        jpm.add(menuVistaAnual);

        menuVistaSemanal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/calendar.png"))); // NOI18N
        menuVistaSemanal.setText("Vista Semanal");
        menuVistaSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVistaSemanalActionPerformed(evt);
            }
        });
        jpm.add(menuVistaSemanal);

        jTextField3.setText("jTextField3");

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Planificación");

        panelBarraIzquierda.setBorder(javax.swing.BorderFactory.createTitledBorder("Sub Obras Cotizadas"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la SubObra"));

        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tareas Cotizadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTareas.setCellSelectionEnabled(true);
        tblTareas.setDragEnabled(true);
        tblTareas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblTareas);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeRecursos.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeRecursos.setDragEnabled(true);
        treeRecursos.setRootVisible(false);
        jScrollPane3.setViewportView(treeRecursos);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/Modify.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 204, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar))
        );

        tblSubObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la SubObra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubObras.setCellSelectionEnabled(true);
        tblSubObras.setDragEnabled(true);
        tblSubObras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSubObras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubObrasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSubObras);

        javax.swing.GroupLayout panelBarraIzquierdaLayout = new javax.swing.GroupLayout(panelBarraIzquierda);
        panelBarraIzquierda.setLayout(panelBarraIzquierdaLayout);
        panelBarraIzquierdaLayout.setHorizontalGroup(
            panelBarraIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBarraIzquierdaLayout.setVerticalGroup(
            panelBarraIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraIzquierdaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEmitirInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/List.png"))); // NOI18N
        btnEmitirInforme.setText("Generar Planificacion");
        btnEmitirInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirInformeActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/block.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/Save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles Generales"));

        panelLineaDeTiempo.setLayout(new java.awt.BorderLayout());
        panelCentral.addTab("Línea de Tiempo", panelLineaDeTiempo);

        arbolTareas.setModel(null);
        jScrollPane5.setViewportView(arbolTareas);

        javax.swing.GroupLayout panelArbolTareasLayout = new javax.swing.GroupLayout(panelArbolTareas);
        panelArbolTareas.setLayout(panelArbolTareasLayout);
        panelArbolTareasLayout.setHorizontalGroup(
            panelArbolTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        panelArbolTareasLayout.setVerticalGroup(
            panelArbolTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        panelCentral.addTab("Árbol de Tareas", panelArbolTareas);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDatosGeneralesLayout = new javax.swing.GroupLayout(panelDatosGenerales);
        panelDatosGenerales.setLayout(panelDatosGeneralesLayout);
        panelDatosGeneralesLayout.setHorizontalGroup(
            panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDatosGeneralesLayout.setVerticalGroup(
            panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        panelCentral.addTab("Test de Drag&Drop DnD", panelDatosGenerales);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Planificación"));

        txtNroPlanificacion.setEditable(false);

        txtFechaFin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFinFocusLost(evt);
            }
        });

        txtFechaInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaInicioFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Número de Planificación: ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha de Inicio: ");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de Fin: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtNroPlanificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNroPlanificacion)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Pedido de Obra"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nombre:");

        lblObraNombre.setText("---");
        lblObraNombre.setPreferredSize(new java.awt.Dimension(1, 1));
        lblObraNombre.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Planta: ");

        lblObraLugar.setText("---");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Lugar de la Planta:");

        lblObraPlanta.setText("---");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fecha de Inicio:");

        lblObraFechaInicio.setText("---");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Fecha de Fin:");

        lblObraFechaFin.setText("---");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObraFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(lblObraFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(lblObraNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(lblObraPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(lblObraLugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(lblObraNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblObraPlanta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblObraLugar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblObraFechaInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblObraFechaFin))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Cotización"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Cotización sobre la que se planifico: ");

        txtNroCotizacion.setEditable(false);
        txtNroCotizacion.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jButton1.setText("Abrir Cotización");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Monto Total Cotizado: ");

        lblCotMontoTotal.setText("---");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtNroCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                    .addComponent(lblCotMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNroCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblCotMontoTotal))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        panelCentral.addTab("Datos Generales", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBarraIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEmitirInforme)
                        .addGap(127, 127, 127)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBarraIzquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnSave)
                            .addComponent(btnEmitirInforme))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirInformeActionPerformed
    }//GEN-LAST:event_btnEmitirInformeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    }//GEN-LAST:event_btnSaveActionPerformed

    private void menuNuevaEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevaEtapaActionPerformed
       
    }//GEN-LAST:event_menuNuevaEtapaActionPerformed

    private void menuZoomMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuZoomMasActionPerformed
        graph.setZoomIn();
    }//GEN-LAST:event_menuZoomMasActionPerformed

    private void menuZoomMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuZoomMenosActionPerformed
        graph.setZoomOut();
    }//GEN-LAST:event_menuZoomMenosActionPerformed

    private void menuDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDerechaActionPerformed
        graph.moveRight();
    }//GEN-LAST:event_menuDerechaActionPerformed

    private void menuIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIzquierdaActionPerformed
        graph.moveLeft();
    }//GEN-LAST:event_menuIzquierdaActionPerformed

    private void menuFechaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFechaActualActionPerformed
        graph.setFocusToday();
    }//GEN-LAST:event_menuFechaActualActionPerformed

    private void menuVistaAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVistaAnualActionPerformed
        graph.setYearView();
    }//GEN-LAST:event_menuVistaAnualActionPerformed

    private void menuVistaSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVistaSemanalActionPerformed
        graph.setWeeklyView();
    }//GEN-LAST:event_menuVistaSemanalActionPerformed

    private void tblSubObrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubObrasMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON1)
        {
            ListaDeTareasCelda tpSelected = (ListaDeTareasCelda) tblSubObras.getModel().getValueAt(tblSubObras.getSelectedRow(),0);
            if(tpSelected!=null)
            {
                initTablaTareas(Integer.parseInt(tpSelected.getId()));
                initArbolRecursosCotizados(Integer.parseInt(tpSelected.getId()));
            }
        }
    }//GEN-LAST:event_tblSubObrasMouseClicked

    private void txtFechaFinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFinFocusLost

    }//GEN-LAST:event_txtFechaFinFocusLost

    private void txtFechaInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaInicioFocusLost

    }//GEN-LAST:event_txtFechaInicioFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ExplorarSubObras eso = new ExplorarSubObras(_gestor.getCotizacionPlanificada());
        SwingPanel.getInstance().addWindow(eso);
        eso.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolTareas;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEmitirInforme;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPopupMenu jpm;
    private javax.swing.JLabel lblCotMontoTotal;
    private javax.swing.JLabel lblObraFechaFin;
    private javax.swing.JLabel lblObraFechaInicio;
    private javax.swing.JLabel lblObraLugar;
    private javax.swing.JLabel lblObraNombre;
    private javax.swing.JLabel lblObraPlanta;
    private javax.swing.JMenuItem menuDerecha;
    private javax.swing.JMenuItem menuFechaActual;
    private javax.swing.JMenuItem menuIzquierda;
    private javax.swing.JMenuItem menuNuevaEtapa;
    private javax.swing.JMenuItem menuVistaAnual;
    private javax.swing.JMenuItem menuVistaSemanal;
    private javax.swing.JMenuItem menuZoomMas;
    private javax.swing.JMenuItem menuZoomMenos;
    private javax.swing.JPanel panelArbolTareas;
    private javax.swing.JPanel panelBarraIzquierda;
    private javax.swing.JTabbedPane panelCentral;
    private javax.swing.JPanel panelDatosGenerales;
    private javax.swing.JPanel panelLineaDeTiempo;
    private javax.swing.JTable tblSubObras;
    private javax.swing.JTable tblTareas;
    private javax.swing.JTree treeRecursos;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private javax.swing.JTextField txtNroCotizacion;
    private javax.swing.JTextField txtNroPlanificacion;
    // End of variables declaration//GEN-END:variables

    private void initTablaSubObras(int idPedidoDeObra) {

        ArrayList<NTupla> lista = (ArrayList<NTupla>) _gestor.getListaSubObras();

        for (int i = 0; i < lista.size(); i++) {
            NTupla nt = lista.get(i);
                   
            ListaDeTareasCelda item = new ListaDeTareasCelda(ArbolDeTareasTipos.TIPO_SUBOBRA,String.valueOf(nt.getId()));
            item.setItemData(iconoSubObra, nt.getNombre());

            DefaultTableModel modelo = (DefaultTableModel) tblSubObras.getModel();
            Object[] fila = new Object[1];
            fila[0] = item;
            modelo.addRow(fila);
        }
    }

    private void initTablaTareas(int idSubObra) {
        
        ArrayList<NTupla> lista = (ArrayList<NTupla>) _gestor.getListaTareasXSubObra(idSubObra);
        
        DefaultTableModel modelo = (DefaultTableModel)tblTareas.getModel();
        modelo = TablaUtil.vaciarDefaultTableModel(modelo);

        for (int i = 0; i < lista.size(); i++) {
            NTupla nt = lista.get(i);
            ListaDeTareasCelda item = new ListaDeTareasCelda(ArbolDeTareasTipos.TIPO_TAREA,String.valueOf(nt.getId()));
            item.setItemData(iconoTarea, nt.getNombre());

            Object[] fila = new Object[1];
            fila[0] = item;
            modelo.addRow(fila);
        }
        
    }

    private void initArbolRecursosCotizados(int idSubObra) {
        _gestor.cargarArbolRecursos(idSubObra,treeRecursos);
    }
        
    
    public void agregarNuevaTareaGantt(int id,String nombre,int idTareaPadre)
    { 
        // Create a new Phrase
        CoolGanttPhase p5 = new CoolGanttPhase();
        p5.setEditable(true);
        p5.setId(id);
        p5.setNombre(nombre);
        p5.setStartDate(fechaMas(new Date(), 10));
        p5.setEndDate(fechaMas(new Date(), 20));
        
        graph.addPhase(p5);

        graph.refreshModel();     
        updateGantt();
        inicializarArbolDeTareas();
        
    }
    
    public void agregarNuevaTareaArbol(int id,String nombre,int idTareaPadre)
    { 
        //idTareaPadre sera siempre o una tarea, subtarea o la obra. Nada mas. En caso de ser la obra, el id sera 0 (cero)
        
        //Arbol
        ArbolIconoNodo nodoTarea = new ArbolIconoNodo(id,ArbolDeTareasTipos.TIPO_TAREA,nombre,Iconos.ICONO_TAREA);
        ArbolIconoNodo padre=getNodoArbolTareasPorId(arbolTareas,idTareaPadre);        
        if(padre!=null)
        {
            ((DefaultTreeModel)(arbolTareas.getModel())).insertNodeInto(nodoTarea, padre, padre.getChildCount());
            arbolTareas.expandPath(getTreeNodePath(padre));
        }
        else
        {
             JOptionPane.showMessageDialog(new JFrame(),"Se ha producido un error interno. Razon: Nodo padre inexistente.");
        }
        graph.refreshModel();     
        updateGantt();
        
    }
    
    private ArbolIconoNodo getNodoArbolTareasPorId(JTree arbol,int id)
    {
        ArbolIconoNodo nodoActual=(ArbolIconoNodo)arbol.getModel().getRoot();
        if(id<=0)
        {
            return nodoActual;
        }
        else
        {
            return getNodoArbolTareasPorIdRecursivo(nodoActual, id);
        }
        
    }
    
    private ArbolIconoNodo getNodoArbolTareasPorIdRecursivo(ArbolIconoNodo nodoPadre, int id)
    {
        ArbolIconoNodo nodo=null;
        for (int i = 0; i < nodoPadre.getChildCount(); i++) 
        {
           
           if(((ArbolIconoNodo)nodoPadre.getChildAt(i)).getTipo().equals(ArbolDeTareasTipos.TIPO_TAREA))
           {
               if(((ArbolIconoNodo)nodoPadre.getChildAt(i)).getId()==id)
               { 
                  nodo= ((ArbolIconoNodo)nodoPadre.getChildAt(i));
                  break;
               }
               else
               {
                  nodo= getNodoArbolTareasPorIdRecursivo(((ArbolIconoNodo)nodoPadre.getChildAt(i)), id );
                  if(nodo!=null)
                  {                    
                      break;
                  }
               }  
           }      
        }   
        return nodo;
        
    }
    
    public static TreePath getTreeNodePath(TreeNode treeNode) {
    List<Object> nodes = new ArrayList<Object>();
    if (treeNode != null) {
      nodes.add(treeNode);
      treeNode = treeNode.getParent();
      while (treeNode != null) {
        nodes.add(0, treeNode);
        treeNode = treeNode.getParent();
      }
    }

    return nodes.isEmpty() ? null : new TreePath(nodes.toArray());
  }

    public void setLblObraFechaFin(String lblObraFechaFin) {
        this.lblObraFechaFin.setText(lblObraFechaFin);
    }

    public void setLblObraFechaInicio(String lblObraFechaInicio) {
        this.lblObraFechaInicio.setText(lblObraFechaInicio);
    }

    public void setLblObraLugar(String lblObraLugar) {
        this.lblObraLugar.setText(lblObraLugar);
    }

    public void setLblObraNombre(String lblObraNombre) {
        this.lblObraNombre.setText(lblObraNombre);
    }

    public void setLblObraPlanta(String lblObraPlanta) {
        this.lblObraPlanta.setText(lblObraPlanta);
    }
    
    public void setTxtNroCotizacion(String nro) {
        this.txtNroCotizacion.setText(nro);
    }    
    
    public void setCotizacionMontoTotal(String monto) {
        this.lblCotMontoTotal.setText("$ "+monto);
    }     
    
    public void setNroPlanificacion(String nroPlanificacion) {
        this.txtNroPlanificacion.setText(nroPlanificacion);
    }
    
    public void setFechaInicioPlanif(Date fecha) {
        this.txtFechaInicio.setDate(fecha);
    }    
    
    public void setFechaFinPlanif(Date fecha) {
        this.txtFechaFin.setDate(fecha);
    }     
    
    
    /**
     * InnerClass para manerja el disparo de evento Drag&Drop en el Gantt
     */
    public class GanttDropEvent implements IDropEvent{

        @Override
        public void dropEvent(String data,Point location) {

            // Veo a que apunta location !!!
            CoolGanttPhase p = graph.getPhase(location);
            // p==NULL : El Drop no callo sobre ninguna Tarea
            // p!=NULL :  El Drop callo sobre una Tarea en el Gantt (p)

            
            // Desencadeno la accion
            if(data!=null && !data.isEmpty())
            {
                String[] dataTrigger = data.split(";");
                if(dataTrigger.length==3)
                {
                    if(dataTrigger[0].equals(ArbolDeTareasTipos.TIPO_SUBOBRA))
                    {
                        // Por ahora no hago nada
                        JOptionPane.showMessageDialog(new JFrame(),"ESTO ES UNA SUBOBRA IDIOTA \n Disparador del Drop > Tipo:"+ dataTrigger[0]+"  ID: "+dataTrigger[1]);
                    }
                    if(dataTrigger[0].equals(ArbolDeTareasTipos.TIPO_TAREA))
                    {
                        if(p==null)
                        {
                            // Agrego una nueva Tarea
                            //No tiene tarea padre, paso un cero como IdTareaGantt
                            _gestor.agregarNuevaTareaGantt(Integer.parseInt(dataTrigger[1]),dataTrigger[2],0,0);
                        }
                        else
                        {
                            // Agrego una nueva Sub Tarea
                            int nivel = calcularNivel(p);
                            nivel++;
                            _gestor.agregarNuevaTareaGantt(Integer.parseInt(dataTrigger[1]),dataTrigger[2],p.getId(),nivel);
                        }        
                    }
                    if(dataTrigger[0].equals(ArbolDeTareasTipos.TIPO_HERRAMIENTA))
                    {
                        if(p==null)
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"En Contruccion!\nEstas intentando agregar un "+ArbolDeTareasTipos.TIPO_HERRAMIENTA+"\nPero no se lo estsa asignando a ninguna Tarea");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"En Contruccion!\nEstas intentando agregar un "+ArbolDeTareasTipos.TIPO_HERRAMIENTA+"\nA la Tarea "+p.getNombre());
                        }
                        
                    }
                    if(dataTrigger[0].equals(ArbolDeTareasTipos.TIPO_MATERIAL))
                    {
                        if(p==null)
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"En Contruccion!\nEstas intentando agregar un "+ArbolDeTareasTipos.TIPO_MATERIAL+"\nPero no se lo estsa asignando a ninguna Tarea");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"En Contruccion!\nEstas intentando agregar un "+ArbolDeTareasTipos.TIPO_MATERIAL+"\nA la Tarea "+p.getNombre());
                        }
                                    
                    }
                    if(dataTrigger[0].equals(ArbolDeTareasTipos.TIPO_ALQUILERCOMPRA))
                    {
                        if(p==null)
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"En Contruccion!\nEstas intentando agregar un "+ArbolDeTareasTipos.TIPO_ALQUILERCOMPRA+"\nPero no se lo estsa asignando a ninguna Tarea");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"En Contruccion!\nEstas intentando agregar un "+ArbolDeTareasTipos.TIPO_ALQUILERCOMPRA+"\nA la Tarea "+p.getNombre());
                        }
                    }                    
                }
            }   
        }

        private int calcularNivel(CoolGanttPhase p) {
            String taskNameSearch = p.getNombre();
            int subNivel = 0;
            while (taskNameSearch.indexOf(CADENA_SUB_TAREA) > -1) 
            {
                taskNameSearch = taskNameSearch.substring(taskNameSearch.indexOf(CADENA_SUB_TAREA)+CADENA_SUB_TAREA.length(),taskNameSearch.length());
                subNivel++;
                System.out.println("[DEBUG] Task Level ++");
            }
            return subNivel;
        }
    }
    
    /**
     * Muestra un mensaje
     * @param tipo
     * @param titulo
     * @param mensaje 
     */
    public void MostrarMensaje(int tipo,String titulo,String mensaje)
    {
         JOptionPane.showMessageDialog(this.getParent(),mensaje,titulo,tipo);
    } 
    
    
    /**
     * Arbol de tareas
     */
    public void inicializarArbolDeTareas()
    {
        PanelDropTarget target = new PanelDropTarget(arbolTareas, new ArbolDropEvent());
        DefaultTreeModel modelo=_gestor.getModeloArbolTareas();
        arbolTareas.setModel(modelo);
        arbolTareas.setCellRenderer(new ArbolIconoRenderer());
        arbolTareas.repaint();        
        //arbolTareas.setRootVisible(false);
    }
    
    /**
     * InnerClass para manerja el disparo de evento Drag&Drop en el arbol
     */
    public class ArbolDropEvent implements IDropEvent
    {

        @Override
        public void dropEvent(String data,Point location) 
        {

          TreePath path = arbolTareas.getPathForLocation(location.x, location.y);
          ArbolIconoNodo padre;
          if(path != null)
          {
            padre= (ArbolIconoNodo) path.getLastPathComponent();
            System.out.println("Receptor:"+padre);
            for (int i = 0; i < ArbolDeTareasTipos.getSinHijos().length; i++) 
            {
                if(ArbolDeTareasTipos.getSinHijos()[i].equals(padre.getTipo()));
                {return;}  
            }            
          }
          else
          {
              return;
          }
          
          if(data!=null && !data.isEmpty() && padre!=null)
          {
              String[] dataTrigger = data.split(";");
              if(dataTrigger.length==3)
              {
                String tipo=dataTrigger[0];
                int id= Integer.parseInt(dataTrigger[1]);
                String nombre=dataTrigger[2]; 
                int idTareaPadre=padre.getId(); 
                
                //Agregamos una tarea
                if(tipo.equals(ArbolDeTareasTipos.TIPO_TAREA))
                {
                    //Es una tarea, pero no es una subtarea
                    if(padre.getTipo().equals(ArbolDeTareasTipos.TIPO_OBRA))
                    {
                        idTareaPadre=0;
                    }
                    else
                    {
                      //Si el nodo padre es un recurso
                      if(!padre.getTipo().equals(ArbolDeTareasTipos.TIPO_TAREA))
                        {
                            return;
                        }  
                    }
                    _gestor.agregarNuevaTareaArbol(id, nombre, idTareaPadre);                    
                } 
                if(tipo.equals(ArbolDeTareasTipos.TIPO_MATERIAL))
                {
                }
            }
          }
            
        }
       
    }

    public class GanttEventMouse implements ICoolGanttEvent{

        @Override
        public Date inGetProjectStartDate() {
            return new Date();
        }

        @Override
        public Date inGetProjectEndDate() {
            return new Date();
        }

        @Override
        public void outClickPhase(int i) {
            //JOptionPane.showMessageDialog(new JFrame(),"Se hizo click en la tarea: "+i);
            GestorEditarTarea gestorEditarTarea = new GestorEditarTarea(_gestor);
            gestorEditarTarea.seleccionarTarea(i);
            PantallaEditarTarea editarTarea = new PantallaEditarTarea(gestorEditarTarea);
            SwingPanel.getInstance().addWindow(editarTarea);
            editarTarea.setVisible(true);
        }

        @Override
        public void outMovePhase(int i, Date date) {
              //JOptionPane.showMessageDialog(new JFrame(),"Se movio en la tarea: "+i);
        }

        @Override
        public void outExtendPhaseBackward(int i, Date date) {
              //JOptionPane.showMessageDialog(new JFrame(),"Se agrando a la izquierda la tarea: "+i);
        }

        @Override
        public void outExtendPhaseForward(int i, Date date) {
             //JOptionPane.showMessageDialog(new JFrame(),"Se agrando a la derecha la tarea: "+i);
        }

    }

}