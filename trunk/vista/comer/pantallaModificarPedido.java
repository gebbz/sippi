/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pantallaModificarPedido.java
 *
 * Created on 10/08/2010, 14:06:38
 */

package vista.comer;

import com.toedter.calendar.JDateChooser;
import controlador.comer.GestorRegistrarPedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.PedidoObra;
import util.Tupla;
import vista.interfaces.IPantallaPedidoABM;

/**
 *
 * @author Emmanuel
 */
public class pantallaModificarPedido extends javax.swing.JInternalFrame implements IPantallaPedidoABM {
    private GestorRegistrarPedido gestor;
    /** Creates new form pantallaModificarPedido */
    public pantallaModificarPedido(int id) {
        gestor = new GestorRegistrarPedido(this,id);
        initComponents();
        habilitarVentana();
        txtNroPedido.setText(String.valueOf(gestor.getIdPedido()));

        this.txtNombreObra.setText(gestor.getNombrePedido());
        this.txtDescripcion.setText(gestor.getDescripcionPedido());
        mostrarEmpresasCliente();
        mostrarPlantasEmpresaCliente();
        cmbfechaInicio.setDate(gestor.getFechaInicioPedido());
        cmbfechaFin.setDate(gestor.getFechaFinPedido());
        txtMonto.setText(gestor.getMontoPedido());
        cmbLEP.setDate(gestor.getFechaLEPPedido());
        cmbLVP.setDate(gestor.getFechaLVPPedido());
        txtPliego.setText(gestor.getPliegoPedido());
        txtPlanos.setText(gestor.getPlanosPedido());
    }

        public void mostrarEmpresasCliente()
    {
        ArrayList<Tupla> lista = gestor.mostrarEmpresasCliente();

        DefaultComboBoxModel valores = new DefaultComboBoxModel();

        int idEmpresaCliente = gestor.buscarEmpresaCliente();

        Iterator<Tupla> it = lista.iterator();
        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
            if (tu.getId() == idEmpresaCliente)
                valores.setSelectedItem(tu);
        }
        cmbEmpresa.setModel(valores);
    }


    public void mostrarPlantasEmpresaCliente()
    {
        ArrayList<Tupla> lista = gestor.mostrarPlantasEmpresaCliente(((Tupla)cmbEmpresa.getSelectedItem()).getId());

        DefaultComboBoxModel valores = new DefaultComboBoxModel();

        Iterator<Tupla> it = lista.iterator();
        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
            if (tu.getId() == gestor.getIdPlantaPedido())
                valores.setSelectedItem(tu);
        }
        cmbPlanta.setModel(valores);
    }

    private void habilitarVentana()
    {
        cmbPlanta.setEnabled(true);

        // Seteo los combos de la fecha, para que seleccione...
        // FECHA DE INICIO
        //cmbfechaInicio = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        //cmbfechaInicio.setBounds(105,170,155,20); // x y ancho alto
        //add(cmbfechaInicio);
        // FECHA DE FIN
        //cmbfechaFin = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        //cmbfechaFin.setBounds(360,170,110,20); // x y ancho alto
        //add(cmbfechaFin);
        // FECHA LEP
        //cmbLEP = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        //cmbLEP.setBounds(273,235,140,20); // x y ancho alto
        //add(cmbLEP);
        // FECHA LVP
        //cmbLVP = new JDateChooser("dd/MM/yyyy", "####/##/##", '_');
        //cmbLVP.setBounds(273,265,140,20); // x y ancho alto
        //add(cmbLVP);

    }

       private boolean ValidarDatos()
    {
        boolean ban=true;
        String mensaje="Faltan ingresar/seleccionar los siguientes campos:\n";
        if(txtNombreObra.getText().equals("")){
            mensaje+="- Nombre de la Obra\n";
            ban=false;
        }
        if(cmbEmpresa.getSelectedIndex() == -1){
            mensaje+="- Empresa\n";
            ban=false;
        }
        if(cmbPlanta.getSelectedIndex() == -1){
            mensaje+="- Planta\n";
            ban=false;
        }
        if(((JDateChooser)cmbfechaInicio).getDate() == null){
            mensaje+="- Fecha de Inicio\n";
            ban=false;
        }
        if(((JDateChooser)cmbfechaFin).getDate() == null){
            mensaje+="- Fecha de Fin\n";
            ban=false;
        }
        if(txtMonto.getText().equals("")){
            mensaje+="- Monto de la Obra\n";
            ban=false;
        }
        if(((JDateChooser)cmbLEP).getDate() == null){
            mensaje+="- Fecha Límite de Entrega de Presupuesto\n";
            ban=false;
        }
        if(((JDateChooser)cmbLVP).getDate() == null){
            mensaje+="- Fecha Límite de Validez del Presupuesto\n";
            ban=false;
        }
        if(!ban){
            JOptionPane.showMessageDialog(this.getParent(),mensaje,"ERROR,Faltan campos requeridos",JOptionPane.ERROR_MESSAGE);
        }
        return ban;
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPliego = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPlanos = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbPlanta = new javax.swing.JComboBox();
        btnAgregarPlanta = new javax.swing.JButton();
        txtNroPedido = new javax.swing.JTextField();
        btnAgregarEmpresaCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbEmpresa = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtNombreObra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbfechaInicio = new com.toedter.calendar.JDateChooser();
        cmbfechaFin = new com.toedter.calendar.JDateChooser();
        cmbLEP = new com.toedter.calendar.JDateChooser();
        cmbLVP = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Pliego:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("Fecha Límite de Entrega del Presupuesto:");

        txtPliego.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPliegoFocusLost(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/accept.png"))); // NOI18N
        btnConfirmar.setText("Aceptar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("Planos:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Presupuesto Máximo ($):");

        txtPlanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlanosActionPerformed(evt);
            }
        });
        txtPlanos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlanosFocusLost(evt);
            }
        });

        txtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText("Fecha Límite de Validez del Presupuesto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Fecha de Inicio:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Fecha de Fin:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Planta:");

        cmbPlanta.setEnabled(false);
        cmbPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlantaActionPerformed(evt);
            }
        });

        btnAgregarPlanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add.png"))); // NOI18N
        btnAgregarPlanta.setEnabled(false);
        btnAgregarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPlantaActionPerformed(evt);
            }
        });

        txtNroPedido.setEditable(false);
        txtNroPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAgregarEmpresaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/add.png"))); // NOI18N
        btnAgregarEmpresaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpresaClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Número de Pedido:");

        cmbEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpresaActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Descripción:");

        txtNombreObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreObraActionPerformed(evt);
            }
        });
        txtNombreObra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreObraFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Nombre de la Obra:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Empresa Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel8)
                                .addGap(16, 16, 16))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbLVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbLEP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPliego, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                    .addComponent(txtPlanos, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnConfirmar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                    .addComponent(txtNombreObra, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbfechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbEmpresa, 0, 107, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarEmpresaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbfechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarEmpresaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbfechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cmbLEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cmbLVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPliego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPlanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfirmar))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPliegoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPliegoFocusLost
        gestor.pliegoObra(txtPliego.getText());
}//GEN-LAST:event_txtPliegoFocusLost

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(ValidarDatos()){
            //VALIDO LAS FECHAS
            // HACER
            //PASO LAS FECHAS AL GESTOR
            gestor.nombreObra(txtNombreObra.getText());
            gestor.descripcionObra(txtDescripcion.getText());
            gestor.montoMaximo(Double.parseDouble(txtMonto.getText()));
            gestor.pliegoObra(txtPliego.getText());
            gestor.planosObra(txtPlanos.getText());

            Date fechaI = ((JDateChooser) cmbfechaInicio).getDate();
            Date fechaF = ((JDateChooser) cmbfechaFin).getDate();
            gestor.fechaInicioYFin(fechaI, fechaF);
            Date fechaLVP = ((JDateChooser) cmbLVP).getDate();
            gestor.fechaLVP(fechaLVP);
            Date fechaLEP = ((JDateChooser) cmbLEP).getDate();
            gestor.fechaLEP(fechaLEP);
            // LANZO EL CREAR
            gestor.seleccionPlanta((Tupla)cmbPlanta.getSelectedItem());
            int id = gestor.confirmacionRegistro();

            JOptionPane.showMessageDialog(this.getParent(),"Se registro con éxito el pedido número "+id,"Registración Exitosa",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtPlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlanosActionPerformed

}//GEN-LAST:event_txtPlanosActionPerformed

    private void txtPlanosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlanosFocusLost
        gestor.planosObra(txtPlanos.getText());
}//GEN-LAST:event_txtPlanosFocusLost

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtMontoActionPerformed

    private void txtMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusLost


        gestor.montoMaximo(Double.parseDouble(txtMonto.getText()));
    }//GEN-LAST:event_txtMontoFocusLost

    private void cmbPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlantaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cmbPlantaActionPerformed

    private void btnAgregarPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPlantaActionPerformed
        gestor.llamarCURegistrarNuevaPlanta(((Tupla)cmbEmpresa.getSelectedItem()));
}//GEN-LAST:event_btnAgregarPlantaActionPerformed

    private void btnAgregarEmpresaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpresaClienteActionPerformed
        gestor.llamarCURegistrarNuevaEmpresaCliente();
}//GEN-LAST:event_btnAgregarEmpresaClienteActionPerformed

    private void cmbEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpresaActionPerformed
        this.mostrarPlantasEmpresaCliente();
        if(cmbEmpresa.getSelectedIndex() != -1){
            btnAgregarPlanta.setEnabled(true);
            cmbPlanta.setEnabled(true);} else{
            btnAgregarPlanta.setEnabled(false);
            cmbPlanta.setEnabled(false);}
}//GEN-LAST:event_cmbEmpresaActionPerformed

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost

        gestor.descripcionObra(txtDescripcion.getText());
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtNombreObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreObraActionPerformed


    }//GEN-LAST:event_txtNombreObraActionPerformed

    private void txtNombreObraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreObraFocusLost

        gestor.nombreObra(txtNombreObra.getText()); // le paso el nombre al gestor
    }//GEN-LAST:event_txtNombreObraFocusLost

    /**
    * @param args the command line arguments
    *//*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantallaModificarPedido().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEmpresaCliente;
    private javax.swing.JButton btnAgregarPlanta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox cmbEmpresa;
    private com.toedter.calendar.JDateChooser cmbLEP;
    private com.toedter.calendar.JDateChooser cmbLVP;
    private javax.swing.JComboBox cmbPlanta;
    private com.toedter.calendar.JDateChooser cmbfechaFin;
    private com.toedter.calendar.JDateChooser cmbfechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombreObra;
    private javax.swing.JTextField txtNroPedido;
    private javax.swing.JTextField txtPlanos;
    private javax.swing.JTextField txtPliego;
    // End of variables declaration//GEN-END:variables

}
