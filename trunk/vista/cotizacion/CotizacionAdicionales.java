/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * editarCotizacion_Adicionales.java
 *
 * Created on 03/05/2011, 10:32:39
 */

package vista.cotizacion;

import controlador.cotizacion.GestorCotizacionAdicionales;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.NTupla;
import util.TablaUtil;
import util.Tupla;

/**
 *
 * @author Emmanuel
 */
public class CotizacionAdicionales extends javax.swing.JPanel {

    private GestorCotizacionAdicionales gestor;
    
    /** Creates new form editarCotizacion_Adicionales */
    public CotizacionAdicionales(GestorCotizacionAdicionales gestor) {
        initComponents();
        this.gestor = gestor;
        this.gestor.setPantalla(this);
        this.gestor.initVentana();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbTipoAdicional = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadPersonas = new javax.swing.JFormattedTextField();
        txtCantidadDias = new javax.swing.JFormattedTextField();
        txtPrecioUnitario = new javax.swing.JFormattedTextField();
        btnAgregarAdicional = new javax.swing.JButton();
        btnQuitarAdicional = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAdicionales = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSubtotalAdicionales = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(440, 380));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo (*)/Observación"));

        txtConcepto.setColumns(20);
        txtConcepto.setRows(5);
        jScrollPane1.setViewportView(txtConcepto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTipoAdicional, 0, 435, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cmbTipoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Concepto"));

        jLabel1.setText("Catidad Operarios (*)");

        jLabel2.setText("Cantidad Días (*)");

        jLabel3.setText("Precio Unitario (*)");
        jLabel3.setToolTipText("");

        jLabel4.setText("x");

        jLabel5.setText("x");

        jLabel6.setText("=");

        txtSubtotal.setEditable(false);

        jLabel7.setText("Subtotal");

        txtCantidadPersonas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txtCantidadPersonas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadPersonas.setText("0");
        txtCantidadPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadPersonasActionPerformed(evt);
            }
        });
        txtCantidadPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadPersonasKeyReleased(evt);
            }
        });

        txtCantidadDias.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txtCantidadDias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadDias.setText("0");
        txtCantidadDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadDiasActionPerformed(evt);
            }
        });
        txtCantidadDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadDiasKeyReleased(evt);
            }
        });

        txtPrecioUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.##"))));
        txtPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitario.setText("0");
        txtPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitarioActionPerformed(evt);
            }
        });
        txtPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioUnitarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidadDias)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarAdicional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/down2.png"))); // NOI18N
        btnAgregarAdicional.setText("Agregar");
        btnAgregarAdicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAdicionalActionPerformed(evt);
            }
        });

        btnQuitarAdicional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/up.png"))); // NOI18N
        btnQuitarAdicional.setText("Quitar");
        btnQuitarAdicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAdicionalActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Materiales a Utilizar"));

        tbAdicionales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Cantidad Operarios", "Cantidad Días", "Precio Unitario", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbAdicionales);

        jLabel8.setText("Subtotal Adicionales $");

        txtSubtotalAdicionales.setEditable(false);
        txtSubtotalAdicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalAdicionalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarAdicional, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotalAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarAdicional)
                    .addComponent(btnAgregarAdicional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotalAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarAdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAdicionalActionPerformed

        int cantidadDias = 0;
        if(!txtCantidadDias.getText().isEmpty())
        {
            cantidadDias = Integer.parseInt(txtCantidadDias.getText());
        }
        
        int cantidadOperarios = 0;
        if(!txtCantidadPersonas.getText().isEmpty())
        {
            cantidadOperarios = Integer.parseInt(txtCantidadPersonas.getText());
        }        
        
        double precio = 0;
        if(!txtPrecioUnitario.getText().isEmpty())
        {
            precio = Double.parseDouble(txtPrecioUnitario.getText().replaceAll(",","."));
        }
        
        Tupla tipo = (Tupla)cmbTipoAdicional.getSelectedItem();
        String descripcion = txtConcepto.getText();
        
        if(cantidadOperarios>0 && cantidadDias>0)
        {
            if(precio>0)
            {
                AgregarAdicional(tipo,descripcion,cantidadOperarios,cantidadDias,precio);
            }
            else
            {
                MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Debe ingresar un Precio positivo");
            }
        }
        else
        {
            MostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Debe ingresar una Cantidad positiva de Operarios y días");
        }
        
}//GEN-LAST:event_btnAgregarAdicionalActionPerformed

    private void btnQuitarAdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAdicionalActionPerformed
        if(tbAdicionales.getSelectedRow()!= -1)
        {
            DefaultTableModel dtm = (DefaultTableModel)tbAdicionales.getModel();
            NTupla ntp = (NTupla) dtm.getValueAt(tbAdicionales.getSelectedRow(), 0);
            gestor.quitarAlquilerCompra(ntp);

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Adicional","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_btnQuitarAdicionalActionPerformed

    private void txtSubtotalAdicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalAdicionalesActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtSubtotalAdicionalesActionPerformed

private void txtCantidadPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadPersonasActionPerformed
    MostrarSubtotalConcepto();
}//GEN-LAST:event_txtCantidadPersonasActionPerformed

private void txtCantidadDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadDiasActionPerformed
    MostrarSubtotalConcepto();
}//GEN-LAST:event_txtCantidadDiasActionPerformed

private void txtPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioActionPerformed
    MostrarSubtotalConcepto();
}//GEN-LAST:event_txtPrecioUnitarioActionPerformed

private void txtCantidadPersonasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadPersonasKeyReleased
    MostrarSubtotalConcepto();
}//GEN-LAST:event_txtCantidadPersonasKeyReleased

private void txtCantidadDiasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadDiasKeyReleased
    MostrarSubtotalConcepto();
}//GEN-LAST:event_txtCantidadDiasKeyReleased

private void txtPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioKeyReleased
    MostrarSubtotalConcepto();
}//GEN-LAST:event_txtPrecioUnitarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAdicional;
    private javax.swing.JButton btnQuitarAdicional;
    private javax.swing.JComboBox cmbTipoAdicional;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAdicionales;
    private javax.swing.JFormattedTextField txtCantidadDias;
    private javax.swing.JFormattedTextField txtCantidadPersonas;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JFormattedTextField txtPrecioUnitario;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtSubtotalAdicionales;
    // End of variables declaration//GEN-END:variables

    public void llenarComboTipos(ArrayList<Tupla> listaTipos) 
    {
        cmbTipoAdicional.removeAllItems();
        for (int i = 0; i < listaTipos.size(); i++) 
        {
            Tupla tp = listaTipos.get(i);
            cmbTipoAdicional.addItem(tp);
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

    public void llenarTabla(ArrayList<NTupla> listaFilas) {
                double total = 0;
        
        DefaultTableModel modelo = (DefaultTableModel)tbAdicionales.getModel();
        // Vacio la tabla por si ya tiene filas de otra llamada
        TablaUtil.vaciarDefaultTableModel(modelo);
        // lleno con los nuevos datos
        for (int i = 0; i < listaFilas.size(); i++) 
        {
            NTupla nt = listaFilas.get(i);
            
            String[] data = (String[])nt.getData();
            
            Object fila[] = new Object[5];
                fila[0] = nt;
                fila[1] = data[0];
                fila[2] = data[1];
                fila[3] = data[2];
                fila[4] = data[3];
                
                total += Double.valueOf(data[3]);
                
            modelo.addRow(fila);
        }
        
        // muestro el total calculado
        txtSubtotalAdicionales.setText(String.valueOf(total));
    }
    
    private void MostrarSubtotalConcepto()
    {
        double cantPersonas = Double.parseDouble(txtCantidadPersonas.getText());
        double cantDías = Double.parseDouble(txtCantidadDias.getText());
        double precioUnitario = Double.parseDouble(txtPrecioUnitario.getText());
        
        txtSubtotal.setText("$"+cantDías*cantPersonas*precioUnitario);
        
    }

    private void AgregarAdicional(Tupla tipo, String descripcion, int cantidadOperarios, int cantidadDias, double precio) 
    {
        gestor.AgregarAdicional(tipo,descripcion,cantidadOperarios,cantidadDias,precio);
    }
    
}