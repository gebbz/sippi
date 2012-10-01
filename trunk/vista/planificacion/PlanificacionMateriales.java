/*
 * editarPlanificiacion_Materiales.java
 *
 * Created on 01/05/2012, 11:20:38
 */

package vista.planificacion;

import controlador.planificacion.GestorPlanificacionMateriales;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.TareaPlanificacion;
import util.NTupla;
import util.StringUtil;
import util.TablaUtil;

/**
 *
 * @author Emmanuel
 */
public class PlanificacionMateriales extends javax.swing.JPanel {

    private GestorPlanificacionMateriales gestor;
    
    /** Creates new form editarCotizacion_Materiales */
    public PlanificacionMateriales(GestorPlanificacionMateriales gestor) 
    {
        initComponents();
        
        this.gestor = gestor;
        this.gestor.setPantalla(this);
        mostrarMaterialesAsociados();
    }

    private void FiltrarTabla(JTable table,JTextField field){
//       if(!field.getText().matches("[\[\*\(\)\?]")){
           TableRowSorter<TableModel> modeloOrdenado;
           modeloOrdenado = new TableRowSorter<TableModel>(table.getModel());
           table.setRowSorter(modeloOrdenado);

               String[] cadena=field.getText().trim().split(" ");
               List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
               for (int i= 0; i < cadena.length; i++)
               {
                 filters.add(RowFilter.regexFilter("(?i)" + cadena[i]));
               }
               RowFilter<Object,Object> cadenaFilter = RowFilter.andFilter(filters);
               modeloOrdenado.setRowFilter(cadenaFilter);

               // CAMBIO LOS TAMAÃƒÆ’Ã¢â‚¬ËœOS DE LAS FILAS
               DefaultTableModel modelo = (DefaultTableModel) table.getModel();
               for (int i = 0; i < modelo.getRowCount(); i++)
               {
                // REDIMENSIONO LA FILA !!! -----------------------------------
                    int index = modeloOrdenado.convertRowIndexToView(i);
                    if(index>-1)
                    {
                        // ESTA
                            String item = ((NTupla) modelo.getValueAt(i,1)).getNombre() ;
                            int cantItems = StringUtil.cantidadOcurrencias(item,"<b>x</b>");
                            if(cantItems!=0)
                            {
                                table.setRowHeight(index,16*cantItems);
                            }
//                        }
                        //LogUtil.addDebug("ConsultarPreciosXProveedor: Cantidad de Repeticiones: "+cantItems);
                    }
                    // REDIMENSIONO LA FILA !!! -----------------------------------
               }
//        }
    }
   
    private void mostrarMaterialesAsociados() {
        ArrayList<NTupla> materiales = gestor.getMaterialesAsociados();

        DefaultTableModel modelo = (DefaultTableModel)tbMaterialesAUsar.getModel();

        TablaUtil.vaciarDefaultTableModel(modelo);

        Iterator it = materiales.iterator();

        int cantidad;
        double precio;
        double total = 0;
        while (it.hasNext())
        {
            NTupla ntp = (NTupla)it.next();
            Object[] fila = new Object[5];
            Object[] o = (Object[]) ntp.getData();
            fila[0] = o[1];
            fila[1] = ntp;
            fila[2] = o[0];
            cantidad = (Integer)o[1];
            precio = (Double)o[2];
            fila[3] = precio;
            double subtotal = cantidad*precio;
            fila[4] = subtotal;
            total+=subtotal;
            modelo.addRow(fila);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarMaterial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnQuitarMaterial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaterialesAUsar = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(440, 380));

        txtBuscarMaterial.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtBuscarMaterial.setForeground(java.awt.Color.gray);
        txtBuscarMaterial.setText("Buscar...");
        txtBuscarMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarMaterialFocusGained(evt);
            }
        });
        txtBuscarMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarMaterialKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search.png"))); // NOI18N

        btnQuitarMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/delete.png"))); // NOI18N
        btnQuitarMaterial.setText("Quitar");
        btnQuitarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarMaterialActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Materiales Asociados"));

        tbMaterialesAUsar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Tipo", "Nombre", "Precio Unitario", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbMaterialesAUsar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnQuitarMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarMaterial, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarMaterial)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMaterialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarMaterialFocusGained
        txtBuscarMaterial.setText("");
}//GEN-LAST:event_txtBuscarMaterialFocusGained

    private void txtBuscarMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMaterialKeyReleased
        this.FiltrarTabla(this.tbMaterialesAUsar, txtBuscarMaterial);
}//GEN-LAST:event_txtBuscarMaterialKeyReleased

    private void btnQuitarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarMaterialActionPerformed
        if(tbMaterialesAUsar.getSelectedRow()>=0){
            NTupla nt = (NTupla)tbMaterialesAUsar.getModel().getValueAt(tbMaterialesAUsar.getSelectedRow(), 1);
            if(nt!=null)
            {
                System.out.println("NT:"+nt.getNombre()+"/"+nt.getId());
                StringBuilder msg = new StringBuilder("<HTML>");
                msg.append("Está a punto de eliminar la asignación de");
                msg.append(" <b>");
                msg.append("<span color=\"#FF0000\">");
                    Object[] data = (Object[]) nt.getData();
                msg.append(data[1].toString()).append(" ").append(data[3].toString());
                msg.append("</span>");
                msg.append("</b> ");
                msg.append(" del material:");
                msg.append("<br/>");
                msg.append("<b>");
                msg.append(nt).append("</b> (").append(data[0].toString()).append(")");
                msg.append("<br/>");
                msg.append("de la tarea:");
                msg.append("<br/>");
                msg.append("<b>");
                    TareaPlanificacion tarea = gestor.getTareaActual();
                msg.append(tarea.getNombre());
                msg.append("</b>");
                
                Object[] options = {"Cancelar","Eliminar Asignación + Gastos Asociados","Eliminar Asignación"};
                int n = JOptionPane.showInternalOptionDialog(this,msg.toString(),"Atencion!",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);            
                System.out.println("SELECCIONO: "+n);

                switch(n)
                {
                    case 0:
                       // Cancelar ..nadaremos
                       break;
                    case 1:
                        // Elimino asignación + Gastos
                        if(gestor.quitarMaterial(nt.getId(),true)){
                            this.mostrarMensajeExitoEliminacion(data[1] + " " +data[3], nt.getNombre(), true);
                            this.mostrarMaterialesAsociados();
                        }
                        else
                        {
                            this.mostrarMensajeExitoEliminacion(data[1] + " " +data[3], nt.getNombre(), false);
                        }
                        break;
                    case 2: 
                        // Elimino solo la asignacion
                        if(gestor.quitarMaterial(nt.getId(),false)){
                            this.mostrarMensajeExitoEliminacion(data[1] + " " +data[3], nt.getNombre(), true);
                            this.mostrarMaterialesAsociados();
                        }
                        else
                        {
                            this.mostrarMensajeExitoEliminacion(data[1] + " " +data[3], nt.getNombre(), false);
                        }
                        break;
                    default:
                        // No ocurre
                }
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(),"Seleccione una fila para eliminar","Atencion!",JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnQuitarMaterialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuitarMaterial;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMaterialesAUsar;
    private javax.swing.JTextField txtBuscarMaterial;
    // End of variables declaration//GEN-END:variables

    public void actualizar(int id, String msg, boolean pass){
        this.mostrarMaterialesAsociados();
    }
    
    private void mostrarMensajeExitoEliminacion(String cantidad, String material, boolean exito)
    {
        StringBuilder msg = new StringBuilder("<HTML>");
        if(exito)
        {
            msg.append("<span color=\"#009900\">");
            msg.append("Se eliminó correctamente la asignación de");
            msg.append("</span>");            
        }
        else
        {
            msg.append("<span color=\"#FF0000\">");
            msg.append("Se detecto un problema al eliminar la asignación de " );
            msg.append("</span>");
        }
        msg.append("<br/>");
        msg.append("<b>");
        msg.append(cantidad);
        msg.append("</b>");
        msg.append(" del material ");
        msg.append("<b>");
        msg.append(material);
        msg.append("</b>");
        
        if(exito)
        {
            JOptionPane.showMessageDialog(new JFrame(),msg.toString(),"Atención!",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(),msg.toString(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
