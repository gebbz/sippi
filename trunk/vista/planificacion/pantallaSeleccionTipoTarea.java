/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pantallaRegistrarNuevaEtapaRapida.java
 *
 * Created on 15-oct-2010, 16:42:08
 */

package vista.planificacion;
import vista.interfaces.ICallBack_v2;
import util.SwingPanel;

/**
 *
 * @author Fran
 */
public class pantallaSeleccionTipoTarea extends javax.swing.JInternalFrame {

    private ICallBack_v2 pantallaEtapa;
    private int idEtapa;
    private  int idPresupuesto;

    /** Creates new form pantallaSeleccionTipoTarea */
    public pantallaSeleccionTipoTarea(ICallBack_v2 pantallaEt, int idPresupuesto, int idEtapa )
    {
        initComponents();
        pantallaEtapa=pantallaEt;
        this.idEtapa= idEtapa;
        this.idPresupuesto=idPresupuesto;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton4 = new javax.swing.JButton();
        rbCapacitacion = new javax.swing.JRadioButton();
        rbTM = new javax.swing.JRadioButton();
        rbTP = new javax.swing.JRadioButton();
        rbAlojamiento = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        rbTarea = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Seleccione un tipo de tarea");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/delete.png"))); // NOI18N
        jButton4.setText("Cancelar");

        buttonGroup1.add(rbCapacitacion);
        rbCapacitacion.setText("Capacitacion de personal");

        buttonGroup1.add(rbTM);
        rbTM.setText("Transporte de materiales");

        buttonGroup1.add(rbTP);
        rbTP.setText("Transporte de pasajeros");

        buttonGroup1.add(rbAlojamiento);
        rbAlojamiento.setText("Inicio de alojamiento");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add.png"))); // NOI18N
        jButton3.setLabel("Crear Tarea");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTarea);
        rbTarea.setLabel("Tarea operativa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTarea)
                    .addComponent(rbCapacitacion)
                    .addComponent(rbTM)
                    .addComponent(rbTP)
                    .addComponent(rbAlojamiento))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbTarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCapacitacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAlojamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Seleccione un tipo de tarea");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(rbTarea.isSelected())
        {
            pantallaRegistrarTarea pre = new pantallaRegistrarTarea(pantallaEtapa, idPresupuesto, idEtapa);
            SwingPanel.getInstance().addWindow(pre);
            pre.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JRadioButton rbAlojamiento;
    private javax.swing.JRadioButton rbCapacitacion;
    private javax.swing.JRadioButton rbTM;
    private javax.swing.JRadioButton rbTP;
    private javax.swing.JRadioButton rbTarea;
    // End of variables declaration//GEN-END:variables

}
