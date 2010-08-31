package vista.compras;

import controlador.Compras.gestorRegistrarPrecioRecurso;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import util.Tupla;

/**
 * @author Iuga
 */
public class pantallaRegistrarPrecioRecurso extends javax.swing.JInternalFrame {

    private gestorRegistrarPrecioRecurso gestor;

    /** Creates new form pantallaRegistrarPrecioRecurso */
    public pantallaRegistrarPrecioRecurso() {
        initComponents();

        gestor = new gestorRegistrarPrecioRecurso(this);

        habilitarVentana();

    }

    private void habilitarVentana()
    {
        cargarProveedores();
    }

    private void cargarProveedores()
    {
        ArrayList<Tupla> lista = gestor.mostrarProveedores();

        DefaultComboBoxModel valores = new DefaultComboBoxModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"No hay Proveedores cargados"));
        }

        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
        }

        cmbProveedores.setModel(valores);
    }

    private void buscarTipoRecursoPorProveedor(int idProv)
    {
        ArrayList<Tupla> lista = gestor.buscarRecursoPorProveedor(idProv);

        DefaultComboBoxModel valores = new DefaultComboBoxModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"No hay Tipo de Recursos cargados"));
        }

        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
        }

        cmbTipoRecurso.setModel(valores);
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
        cmbProveedores = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoRecurso = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Precio de Recurso");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Proveedor:");

        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedoresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Tipo de Recurso:");

        cmbTipoRecurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoRecurso, 0, 184, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedoresActionPerformed

        Tupla t = (Tupla)cmbProveedores.getSelectedItem();
        buscarTipoRecursoPorProveedor(t.getId());

    }//GEN-LAST:event_cmbProveedoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbProveedores;
    private javax.swing.JComboBox cmbTipoRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


    /**
     * ME-0020 : No se pudo cargar la lista de Proveedores
     * ME-0021 : No se pudo cargar el proveedor
     * @param cod
     */
    public void MostrarMensaje(String cod)
    {
        if(cod.equals("ME-0020"))
        {
            // Se guardó en orden
            JOptionPane.showMessageDialog(this.getParent(),"No se pudo cargar la lista de Proveedores","Error en la Carga",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        if(cod.equals("ME-0021"))
        {
            // Se guardó en orden
            JOptionPane.showMessageDialog(this.getParent(),"No se pudo el listado de Tipos de Recurso","Error en la Carga",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

}