/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.compras;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import modelo.ItemStock;
import util.FechaUtil;
import util.HibernateUtil;
import util.TablaUtil;
import util.Tupla;

/**
 *
 * @author Administrador
 */
public class AjustarNivelesDeStock extends javax.swing.JInternalFrame {

    private int idOrdenDeCompra = -1;
    private List<ItemStock> itemsEnStockAActualizar;
    
    /**
     * AjustarNivelesDeStock
     * Llama a la vetnana con un array de items en stock, aparece uno por fila
     * y da la opcion de ajustarlos manualmente!.
     */
    public AjustarNivelesDeStock(List<ItemStock> itemsEnStockAActualizar) {
        this.itemsEnStockAActualizar = itemsEnStockAActualizar;
        initComponents();
        initAnchoColumnasTablaDetalles();
        initData(itemsEnStockAActualizar);
    }
    
    /**
     * AjustarNivelesDeStock
     * Carga la orden de compra y la recepción de la misma, carga un item por
     * recepción, y no le permite ingresar la cantidad Final, esta se carga desde
     * el detalle de recepción.
     */
    public AjustarNivelesDeStock(int idOrdenDeCompra) {
        this.idOrdenDeCompra = idOrdenDeCompra;
        initComponents();
        initAnchoColumnasTablaDetalles();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAjuste = new javax.swing.JTable();
        chkSeleccionarTodos = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar los Niveles de Stock");

        jLabel2.setText("<HTML>Desde aquí, facilmente puede actualizar los niveles de stock de los recursos que recibió y que haz ordenado. Por avor revise los cambios en los niveles de las existencias y seleccione solo los que realmente desee actualizar.");

        tblAjuste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre y Descripción", "Unidad", "Stock Actual", "Stock Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAjuste);

        chkSeleccionarTodos.setSelected(true);
        chkSeleccionarTodos.setText("Seleccionar Todos");
        chkSeleccionarTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkSeleccionarTodosMouseReleased(evt);
            }
        });
        chkSeleccionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSeleccionarTodosActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/accept.png"))); // NOI18N
        btnAceptar.setText("Ajustar el Stock");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/block.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(chkSeleccionarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSeleccionarTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chkSeleccionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSeleccionarTodosActionPerformed
        if(chkSeleccionarTodos.isSelected())
        {
            // Selecciono todos
            TablaUtil.cambiarSeleccionarTodos((DefaultTableModel)tblAjuste.getModel(),0,true);
        }
        else
        {
            // Deselecciono Todos
            TablaUtil.cambiarSeleccionarTodos((DefaultTableModel)tblAjuste.getModel(),0,false);
        }    
    }//GEN-LAST:event_chkSeleccionarTodosActionPerformed

    private void chkSeleccionarTodosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkSeleccionarTodosMouseReleased

    }//GEN-LAST:event_chkSeleccionarTodosMouseReleased

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        ajustarStock();
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox chkSeleccionarTodos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAjuste;
    // End of variables declaration//GEN-END:variables

   /**
     * Setea el ancho de las columnas de la tabla por defecto
     */
    private void initAnchoColumnasTablaDetalles() {
        int anchoColumna = 0; 
        TableColumnModel modeloColumna = tblAjuste.getColumnModel(); 
        TableColumn columnaTabla; 
        for (int i = 0; i < tblAjuste.getColumnCount(); i++) { 
            columnaTabla = modeloColumna.getColumn(i); 
            switch(i){ 
                case 0: anchoColumna = 30; 
                        break; 
                case 1: anchoColumna = 500; 
                        break; 
                case 2: anchoColumna = 150; 
                        break; 
                case 3: anchoColumna = 150; 
                        break; 
            }                      
            columnaTabla.setPreferredWidth(anchoColumna); 
            columnaTabla.setWidth(anchoColumna);
        } 
    }

    /**
     * Carga la tabla pero desde el ajuste manual de Stock
     */
    private void initData(List<ItemStock> itemsEnStockAActualizar) {
        
        DefaultTableModel modelo = (DefaultTableModel)tblAjuste.getModel();
        
        TablaUtil.vaciarDefaultTableModel(modelo);
        
        for (int i = 0; i < itemsEnStockAActualizar.size(); i++) {
            ItemStock is = itemsEnStockAActualizar.get(i);
                if(is.getItem()!=null)
                {
                    Tupla tp = new Tupla(is.getId(),is.getItem().getNombre());

                    Object[] fila = new Object[5];
                        fila[0] = true;
                        fila[1] = tp;
                        fila[2] = is.getItem().getUnidadDeMedida();
                        fila[3] = is.getCantidad();
                        fila[4] = is.getCantidad();

                    modelo.addRow(fila);
                }
        }
        
    }

    /**
     * Actualiza el Stock en la DB.
     */
    private void ajustarStock() {
         
         List<ItemStock> itemsActualizados = new ArrayList<ItemStock>();
                 
         DefaultTableModel modelo = (DefaultTableModel)tblAjuste.getModel();
         
         // Por cada Fila:
         for(int i=0; i<modelo.getRowCount();i++)
         {
             boolean esSelected = (Boolean)modelo.getValueAt(i,0);
             // Si está seleccionado
             if(esSelected)
             {
                 // Y la cantidad inicial es distinta a la final
                 double ini,fin;
                 ini = (Double)modelo.getValueAt(i,3);
                 fin = (Double)modelo.getValueAt(i,4);
                 // Solo acepto Stock positivo
                 if(ini!=fin && fin>0)
                 {
                    // Actualizo el Stock
                    Tupla tp = (Tupla)modelo.getValueAt(i,1);
                    ItemStock is = loadItemStock(tp.getId());
                    is.setCantidad(fin);
                    is.setFechaModificacion(new Date());
                    itemsActualizados.add(is);
                 }
             }
         }
         
         // Pregunto si desea actualizar el Stock !!
         if(itemsActualizados.size()>0)
         {
            StringBuilder msg = new StringBuilder("<HTML>Se actualizará el stock de los siguientes items:");
            for (int i = 0; i < itemsActualizados.size(); i++) {
                ItemStock itemStock = itemsActualizados.get(i);
                if(itemStock!=null)
                {
                    msg.append("<br>- <span color=\"#330099\">");
                    msg.append(itemStock.getItem().getNombre());
                    msg.append("</span> a <span color=\"#00802B\">");
                    msg.append(itemStock.getCantidad());
                    msg.append(" ");
                    msg.append(itemStock.getItem().getUnidadDeMedida());
                    msg.append("</span>");
                }
            }
            msg.append("<br><b>¿Desea continuar?</b>");

            int seleccion = JOptionPane.showOptionDialog(
                this, // Componente padre
                msg.toString(), //Mensaje
                "Atención!", // Título
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { "Si, Deseo Actualizar el Stock", "Cancelar"},    // null para YES, NO y CANCEL
                "Si, Deseo Actualizar el Stock");

            if (seleccion != -1)
            {
                if((seleccion + 1)==1)
                {
                    // SI - Actualizo el Stock
                    try
                    {
                        HibernateUtil.beginTransaction();
                        for (int i = 0; i < itemsActualizados.size(); i++) {
                            ItemStock itemStock = itemsActualizados.get(i);
                            HibernateUtil.getSession().saveOrUpdate(itemStock);
                        }
                        HibernateUtil.commitTransaction();

                    }catch(Exception e)
                    {
                        HibernateUtil.rollbackTransaction();
                        mostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Se produjo un error al actualizar el Stock\n"+e.getMessage());
                        e.printStackTrace();
                        return;
                    } 
                    
                    mostrarMensaje(JOptionPane.INFORMATION_MESSAGE,"Exito!","Se actualizo con éxito el Stock de la Empresa");
                    
                    if(idOrdenDeCompra!=-1)
                    {
                        
                    }
                    else
                    {
                        initData(itemsEnStockAActualizar);
                    }
                }
            }     
        }
         else
         {
             mostrarMensaje(JOptionPane.INFORMATION_MESSAGE,"Atencion!","No hay cambios de Stock seleccionados.\nCambie la cantidad Final de Stock y seleccione un item para continuar");
         }
    }
    
    /**
     * Carga un ItemStock!
     * @param id
     * @return 
     */
    private ItemStock loadItemStock(int id) {
        ItemStock is = null;
        try
        {
            HibernateUtil.beginTransaction();
            is = (ItemStock)HibernateUtil.getSession().load(ItemStock.class, id);
            HibernateUtil.commitTransaction();

        }catch(Exception e)
        {
            HibernateUtil.rollbackTransaction();
            System.err.println("Se produjo un error al cargar los ItemStock!");
            e.printStackTrace();
        }         
        return is;
    }
    
    /**
     * Muestra un mensaje
     * @param tipo
     * @param titulo
     * @param mensaje 
     */
    public void mostrarMensaje(int tipo,String titulo,String mensaje)
    {
         JOptionPane.showMessageDialog(this.getParent(),mensaje,titulo,tipo);
    }    
    
}
