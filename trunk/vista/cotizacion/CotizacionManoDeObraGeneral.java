/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pantallaManoDeObra.java
 *
 * Created on 06/05/2011, 21:56:48
 */

package vista.cotizacion;

import java.util.Calendar;
import java.util.Date;
import util.NTupla;
import util.Tupla;
import vista.interfaces.ICallBack_v2;
import controlador.cotizacion.GestorCotizacionManoDeObra;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import javax.swing.table.DefaultTableModel;
import util.FechaUtil;
import util.SwingPanel;


/**
 *
 * @author Fran
 */
public class CotizacionManoDeObraGeneral extends javax.swing.JPanel implements ICallBack_v2 {
    
    private GestorCotizacionManoDeObra gestor;
    private  IntervalCategoryDataset dataset;

    public CotizacionManoDeObraGeneral(GestorCotizacionManoDeObra gestor)
    {
        initComponents();
        dataset=null;
        this.gestor=gestor;
        this.gestor.setPantalla(this);
        limpiarTabla();
        gestor.getTareasDeSubObra();
        //initGrafico();
        
    }
    private void initGrafico()
    {
        dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(panelGantt.getWidth(),panelGantt.getHeight());
        //chartPanel.setSize(450,137);
        panelGantt.add( chartPanel );
        panelGantt.getParent().validate();
    }
    private void limpiarTabla()
    {
        int fil=((DefaultTableModel) tblTareas.getModel()).getRowCount();
        for (int i = 0; i < fil; i++) {
            ((DefaultTableModel) tblTareas.getModel()).removeRow(0);
        }
    }
    
    public void agregarTarea(Object[] datos, boolean nueva)
    {
       if(nueva && !gestor.agregarTarea(datos))
       { 
           JOptionPane.showMessageDialog(this.getParent(), "Ocurrió un error cargando la tarea", "Eror",JOptionPane.ERROR_MESSAGE);
           return;
       }
       DefaultTableModel modelo = (DefaultTableModel) tblTareas.getModel();       
       panelGantt.removeAll();
       modelo.addRow(datos);
       initGrafico();
       panelGantt.getParent().validate();
    }

     /**
     * Creates a sample dataset for a Gantt chart.
     *
     * @return The dataset.
     */
    public IntervalCategoryDataset createDataset() {

        final TaskSeries s1 = new TaskSeries("Tareas");
        for (int i = 0; i < ((DefaultTableModel)tblTareas.getModel()).getRowCount(); i++) 
        {
               s1.add(new Task(((NTupla)(tblTareas.getModel().getValueAt(i, 0))).getNombre(),
               new SimpleTimePeriod(((Date)((NTupla)(tblTareas.getModel().getValueAt(i, 4))).getData()),
                                    FechaUtil.fechaMas(((Date)((NTupla)(tblTareas.getModel().getValueAt(i, 5))).getData()),1) )));
              
        } 

        

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        collection.add(s1);

        return collection;
    }

    /**
     * Utility method for creating <code>Date</code> objects.
     *
     * @param day  the date.
     * @param month  the month.
     * @param year  the year.
     *
     * @return a date.
     */
    private static Date date(final int day, final int month, final int year) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        return result;

    }
        
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createGanttChart(
            "",  // chart title
            "",              // domain axis label
            "",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );    
//        chart.getCategoryPlot().getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        return chart;    
    }
    

      public void actualizar(int id, String flag, boolean exito)
      {}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTareas = new javax.swing.JTable();
        panelGantt = new javax.swing.JPanel();
        txtSubtotal = new javax.swing.JTextField();

        jLabel9.setText("Plano");

        jLabel10.setText("Posición");

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/delete.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel11.setText("Subtotal Recursos Humanos   $");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas"));

        tblTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarea", "Personas", "Rango", "Hs/Día", "Fecha Inicio", "Fecha Fin", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTareas);

        panelGantt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelGantt.setAutoscrolls(true);

        javax.swing.GroupLayout panelGanttLayout = new javax.swing.GroupLayout(panelGantt);
        panelGantt.setLayout(panelGanttLayout);
        panelGanttLayout.setHorizontalGroup(
            panelGanttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        panelGanttLayout.setVerticalGroup(
            panelGanttLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(panelGantt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(panelGantt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtSubtotal.setEditable(false);
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(btnAgregar)
                .addGap(10, 10, 10)
                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      CotizacionManoDeObraAgregarMO at = new CotizacionManoDeObraAgregarMO(this, gestor);
        SwingPanel.getInstance().addWindow(at);
       at.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtSubtotalActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
       if(tblTareas.getSelectedRow()!=-1)
        {
            ((DefaultTableModel)tblTareas.getModel()).removeRow(tblTareas.getSelectedRow());
        //id=((Tupla)(tblTareas.getModel().getValueAt(tblTareas.getSelectedRow(), 0))).getId(); 
        }
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel panelGantt;
    private javax.swing.JTable tblTareas;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables

}
