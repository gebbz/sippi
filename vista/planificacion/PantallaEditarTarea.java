/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * modificarPresupuesto.java
 *
 * Created on 24/04/2011, 15:49:18
 */

package vista.planificacion;

import controlador.planificacion.GestorEditarTarea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iuga
 */
public class PantallaEditarTarea extends javax.swing.JInternalFrame {

    private GestorEditarTarea gestor;
    private PantallaEditarTarea pantallaEditarTareaPadre;
    private PlanificacionSubTareas pst;

    private static final int OPTN_DATOSGRALES           = 0;
    private static final int OPTN_SUBTAREAS             = 1;
    private static final int OPTN_ASIG_EMPLEADOS        = 2;
    private static final int OPTN_HERRAMIENTAS          = 3;
    private static final int OPTN_MATERIALES            = 4;
    private static final int OPTN_ALQUILERES_COMPRAS    = 5;
    
    public PantallaEditarTarea(GestorEditarTarea gestor)
    {
        construirPantalla(gestor);
        this.pantallaEditarTareaPadre = null;
    }

    public PantallaEditarTarea(GestorEditarTarea gestorEditarTarea, PantallaEditarTarea pantallaPadre) {
        this.pantallaEditarTareaPadre = pantallaPadre;
        construirPantalla(gestorEditarTarea);
        this.btnGuardarTarea.setText("Agregar Subtarea");
    }
  
    private void construirPantalla(GestorEditarTarea gestor){
        initComponents();
        
        this.gestor = gestor;
        gestor.setPantalla(this);

        // POR DEFAULT VA DESCRIPCION DEL ITEM
        DefaultTableModel modelo = (DefaultTableModel)tblMenu.getModel();

        setNombrePanel(modelo.getValueAt(OPTN_DATOSGRALES, 0).toString());
//        CotizacionDescripcion ecd = new CotizacionDescripcion(gestor.getGestorDescripcion());
        PlanificacionDatosGenerales pdg = new PlanificacionDatosGenerales(gestor.getGestorDatosGenerales());
        panel.setViewportView(pdg);
        pdg.setVisible(true);
        
        ListSelectionModel selectionModel = tblMenu.getSelectionModel();
        selectionModel.setSelectionInterval(0,0);
        
        actualizar();
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        panel = new javax.swing.JScrollPane();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        btnGuardarTarea = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Tarea");

        panelGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        panel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/block.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú de Recursos"));
        jPanel3.setMaximumSize(new java.awt.Dimension(50, 50));

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Datos Generales"},
                {"Subtareas"},
                {"Asignación de Empleados"},
                {"Herramientas"},
                {"Materiales"},
                {"Alquileres/Compras"}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMenu.setIntercellSpacing(new java.awt.Dimension(10, 5));
        tblMenu.setMaximumSize(new java.awt.Dimension(300, 300));
        tblMenu.setRowHeight(25);
        tblMenu.setTableHeader(null);
        tblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMenuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblMenu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        btnGuardarTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/accept.png"))); // NOI18N
        btnGuardarTarea.setText("Aceptar");
        btnGuardarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardarTarea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardarTarea))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMenuMousePressed

        DefaultTableModel modelo = (DefaultTableModel)tblMenu.getModel();
        switch(tblMenu.getSelectedRow())
        {
            case OPTN_DATOSGRALES:
                setNombrePanel(modelo.getValueAt(OPTN_DATOSGRALES, 0).toString());
                PlanificacionDatosGenerales pdg = new PlanificacionDatosGenerales(gestor.getGestorDatosGenerales());
                panel.setViewportView(pdg);
                pdg.setVisible(true);
                break;
            case OPTN_SUBTAREAS:
                setNombrePanel(modelo.getValueAt(OPTN_SUBTAREAS, 0).toString());
                pst = new PlanificacionSubTareas(gestor.getGestorSubTareas());
                panel.setViewportView(pst);
                pst.setVisible(true);
                break;
//            case OPTN_MATERIALES:
//                setNombrePanel(modelo.getValueAt(OPTN_MATERIALES,0).toString());
//                VentanaPlanificacionMateriales cm = new VentanaPlanificacionMateriales(gestor.getGestorMateriales());
//                panel.setViewportView(cm);
//                cm.setVisible(true);
//                break;
//            case OPTN_ALQUILERES_COMPRAS:
//                setNombrePanel(modelo.getValueAt(OPTN_ALQUILERES_COMPRAS,0).toString());
//                VentanaPlanificacionAlquileresCompras cc = new VentanaPlanificacionAlquileresCompras(gestor.getGestorAlquileresCompras(),0);
//                panel.setViewportView(cc);
//                cc.setVisible(true);
//                break;
//            case OPTN_ASIG_EMPLEADOS:
//                setNombrePanel(modelo.getValueAt(OPTN_ASIG_EMPLEADOS,0).toString());
//                VentanaPlanificacionManoDeObraGeneral mo = new VentanaPlanificacionManoDeObraGeneral(gestor.getGestorManoObra());
//                panel.setViewportView(mo);
//                mo.setVisible(true);
//                break;
//            case OPTN_HERRAMIENTAS:
//                setNombrePanel(modelo.getValueAt(OPTN_HERRAMIENTAS, 0).toString());
//                VentanaPlanificacionHerramientas h = new VentanaPlanificacionHerramientas(gestor.getGestorHerramientas());
//                panel.setViewportView(h);
//                h.setVisible(true);
//                break;
            default:
                setNombrePanel(modelo.getValueAt(OPTN_DATOSGRALES, 0).toString());
                PlanificacionDatosGenerales pdg2 = new PlanificacionDatosGenerales(gestor.getGestorDatosGenerales());
                panel.setViewportView(pdg2);
                pdg2.setVisible(true);
        }
    }//GEN-LAST:event_tblMenuMousePressed

    private void btnGuardarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTareaActionPerformed
        gestor.guardarCambios();
        this.actualizar();
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarTareaActionPerformed
    

    private void setNombrePanel(String nombre)
    {
         panelGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder(nombre));
    }
    
    public void actualizar()
    {
        if(pantallaEditarTareaPadre != null){
            pantallaEditarTareaPadre.actualizar();
        }
        else
        {
            if(pst != null)
            {
                pst.actualizar();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarTarea;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane panel;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTable tblMenu;
    // End of variables declaration//GEN-END:variables

}
