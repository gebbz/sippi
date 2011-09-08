/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AgregarNuevoPrecio.java
 *
 * Created on 29/06/2011, 16:03:40
 */

package vista.cotizacion;

import controlador.cotizacion.GestorCotizacionMateriales;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.NTupla;
import util.TablaUtil;
import util.Tupla;

/**
 *
 * @author Emmanuel
 */
public class AgregarNuevoPrecio extends javax.swing.JInternalFrame {
    private GestorCotizacionMateriales gestor;
    private int idR;
    private int idRe;
    /** Creates new form AgregarNuevoPrecio */
    public AgregarNuevoPrecio(GestorCotizacionMateriales gestor, int idR, int idRe) {
        initComponents();
        this.gestor = gestor;
        this.idR = idR;
        this.idRe = idRe;
        mostrarMaterial();
        mostrarProveedores();

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
        jLabel1 = new javax.swing.JLabel();
        txtNombreMaterial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dcVigencia = new com.toedter.calendar.JDateChooser();
        btbAgregarNuevoPrecio = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNuevosPrecios = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Agregar Nuevo Precio a Material");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Material"));

        jLabel1.setText("Nombre:");

        txtNombreMaterial.setEditable(false);

        jLabel5.setText("Proveedor:");

        cmbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProveedores, 0, 349, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel2.setText("Cantidad:");

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Precio:");

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Vigencia:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btbAgregarNuevoPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/down2.png"))); // NOI18N
        btbAgregarNuevoPrecio.setText("Agregar");
        btbAgregarNuevoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAgregarNuevoPrecioActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/up.png"))); // NOI18N
        jButton4.setText("Quitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tablaNuevosPrecios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Precio", "Fecha Vigencia", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaNuevosPrecios);
        tablaNuevosPrecios.getColumnModel().getColumn(0).setPreferredWidth(250);
        tablaNuevosPrecios.getColumnModel().getColumn(1).setPreferredWidth(250);
        tablaNuevosPrecios.getColumnModel().getColumn(2).setPreferredWidth(250);
        tablaNuevosPrecios.getColumnModel().getColumn(3).setResizable(false);
        tablaNuevosPrecios.getColumnModel().getColumn(3).setPreferredWidth(0);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/delete.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btbAgregarNuevoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(btnSalir))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbAgregarNuevoPrecio)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedoresActionPerformed
        mostrarPreciosVigentes();
    }//GEN-LAST:event_cmbProveedoresActionPerformed

    private void btbAgregarNuevoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAgregarNuevoPrecioActionPerformed
        String msg = "";
        int cantidad = 0;
        try{
            cantidad = Integer.parseInt(txtCantidad.getText());
        }
        catch(Exception ex){msg+="- Debe ingresar una cantidad válida\n";}
        double precio = 0;
        try{
            precio = Double.parseDouble(txtPrecio.getText());
        }
        catch(Exception ex){msg+="- Debe ingresar un precio válido\n";}
        int idProv = ((Tupla)cmbProveedores.getSelectedItem()).getId();
        Date vigencia = dcVigencia.getDate();
        if(msg.equals("")){
            gestor.registrarPrecio(cantidad, precio, idProv, idRe, vigencia);
            txtCantidad.setText("");
            txtPrecio.setText("");
            dcVigencia.setDate(new Date());
            mostrarPreciosVigentes();
        }else{
            JOptionPane.showMessageDialog(this.getParent(), "Ha ocurrido un error debido a: \n"+msg+"Ingrese nuevamente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btbAgregarNuevoPrecioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(!gestor.quitarPrecioVigente((Integer)((DefaultTableModel)tablaNuevosPrecios.getModel()).getValueAt(tablaNuevosPrecios.getSelectedRow(), 3))){
            JOptionPane.showMessageDialog(this.getParent(), "Ha ocurrido un error al momento de quitar el precio vigente.\nContactese con su administrador.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            mostrarPreciosVigentes();
        }
}//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbAgregarNuevoPrecio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbProveedores;
    private com.toedter.calendar.JDateChooser dcVigencia;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaNuevosPrecios;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombreMaterial;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void mostrarMaterial() {
        this.txtNombreMaterial.setText(gestor.mostrarMaterial(idR)+" - "+gestor.mostrarRE(idRe));

    }

    private void mostrarProveedores() {
        Iterator<Tupla> it = gestor.mostrarProveedores().iterator();
        while(it.hasNext()){
            Tupla t = it.next();
            cmbProveedores.addItem(t);
        }
    }

    private void mostrarPreciosVigentes() {
        TablaUtil.vaciarDefaultTableModel((DefaultTableModel)tablaNuevosPrecios.getModel());
        int idProv = ((Tupla)cmbProveedores.getSelectedItem()).getId();
        ArrayList<NTupla> precios = gestor.mostrarPreciosVigentes(idProv,idRe);
        Iterator<NTupla> it = precios.iterator();
        DefaultTableModel dtm = (DefaultTableModel) tablaNuevosPrecios.getModel();
        while(it.hasNext()){
            NTupla nt = it.next();
            Object[] o = {((Object[])nt.getData())[0],((Object[])nt.getData())[1],((Object[])nt.getData())[2],nt.getId()};
            dtm.addRow(o);
        }
    }

}
