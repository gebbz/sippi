package vista.compras;

import controlador.Compras.gestorRegistrarPrecioRecurso;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        initListaRecurso();
        initListaTipoRecurso();
        initListaRecursosEspecificos();
        initListaProveedores();
    }

    private void initListaRecursosEspecificos()
    {
        DefaultListModel valores = new DefaultListModel();
        lstRecursosEspecificos.setModel(valores);
    }

    private void initListaProveedores()
    {
        DefaultComboBoxModel valores = new DefaultComboBoxModel();

        valores.addElement(new Tupla(0,"Seleccione un Tipo..."));

        cmbProveedores.setModel(valores);
    }

    private void initListaRecurso()
    {
        DefaultComboBoxModel valores = new DefaultComboBoxModel();

        valores.addElement(new Tupla(0,"Seleccione un Recurso..."));

        cmbRecurso.setModel(valores);
    }

    private void initListaTipoRecurso()
    {
        ArrayList<Tupla> lista = gestor.mostrarRubros();

        DefaultComboBoxModel valores = new DefaultComboBoxModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"No hay Tipos de Recursos Cargados"));
        }

        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
        }

        cmbTipoRecurso.setModel(valores);
    }

    private void cargarRecursos(int id)
    {
        ArrayList<Tupla> lista = gestor.mostrarRecursosPorTipoRecurso(id);

        DefaultComboBoxModel valores = new DefaultComboBoxModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"No hay Recursos Cargados"));
        }

        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
        }

        cmbRecurso.setModel(valores);
    }

    private void cargarListaDeRecursosEspecificos(int idRecurso)
    {
        ArrayList<Tupla> lista = gestor.mostrarRecursosEspecificos(idRecurso);

        DefaultListModel valores = new DefaultListModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"No Hay Recursos"));
        }

        while(it.hasNext())
        {
            Tupla tu = it.next();
            valores.addElement(tu);
        }
        lstRecursosEspecificos.setModel(valores);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbRecurso = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRecursosEspecificos = new javax.swing.JList();
        cmbTipoRecurso = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstUltimosPrecios = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbLEP = new com.toedter.calendar.JDateChooser();
        btnActualizarPrecio = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        txtPrecio = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblActualizaciones = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Precio de Recurso");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Recursos Disponibles"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("1. Seleccione el Recurso"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo:");

        cmbRecurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Torno" }));
        cmbRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRecursoActionPerformed(evt);
            }
        });

        lstRecursosEspecificos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstRecursosEspecificosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstRecursosEspecificos);

        cmbTipoRecurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Herramienta" }));
        cmbTipoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoRecursoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Rubro:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoRecurso, 0, 208, Short.MAX_VALUE)
                            .addComponent(cmbRecurso, 0, 208, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("2. Datos del Recurso Seleccionado"));

        jLabel4.setText("Descripción");

        jLabel5.setText("Últimos precios conocidos:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Proveedor:");

        cmbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedoresActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setEditable(false);
        txtDescripcion.setRows(5);
        jScrollPane4.setViewportView(txtDescripcion);

        jScrollPane5.setViewportView(lstUltimosPrecios);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProveedores, 0, 252, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("3. Actualizar los Precios para el Proveedor elegido"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Nuevo Precio");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Fecha de Vigencia");

        cmbLEP.setDateFormatString("dd/MM/yyyy");

        btnActualizarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/down.png"))); // NOI18N
        btnActualizarPrecio.setText("Actualizar Precio");
        btnActualizarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPrecioActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Cantidad");

        lblUnidadMedida.setText("UN.");

        jLabel12.setText("$");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtCantidad.setText("1");

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("(Si no tiene vigencia, dejar en blanco)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbLEP, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17))
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                    .addComponent(btnActualizarPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidadMedida)
                    .addComponent(jLabel12)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1)
                .addComponent(cmbLEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarPrecio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("3. Listado de Actualizaciones por Realizar"));

        tblActualizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recurso", "Proveedor", "Vigencia", "Cantidad", "Precio"
            }
        ));
        tblActualizaciones.setShowHorizontalLines(false);
        jScrollPane3.setViewportView(tblActualizaciones);

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/delete.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/save_upload.png"))); // NOI18N
        jButton3.setText("Guardar Lista de Actualizaciones");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitar)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedoresActionPerformed

        

    }//GEN-LAST:event_cmbProveedoresActionPerformed

    private void btnActualizarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPrecioActionPerformed

        // VALIDO TODOS LOS FUCKING DATOS
        boolean valido = true;
        // RECURSO ESPECIFICO
        Tupla tp_re = (Tupla) lstRecursosEspecificos.getModel().getElementAt(lstRecursosEspecificos.getSelectedIndex());
        if(tp_re.getId()==0)
        {
            valido = false;
            JOptionPane.showMessageDialog(this.getParent(),"Debe seleccionar el item a actualizar","Faltan Datos",JOptionPane.ERROR_MESSAGE);
        }
        // PROVEEDOR
        Tupla tp_pr = (Tupla) cmbProveedores.getSelectedItem();
        if(tp_pr.getId()==0)
        {
            valido = false;
            JOptionPane.showMessageDialog(this.getParent(),"Debe seleccionar un Proveedor\nEl precio Actualizado se asignara a él","Faltan Datos",JOptionPane.ERROR_MESSAGE);
        }
        // CANTIDAD
        if(txtCantidad.getText().isEmpty())
        {
            valido = false;
            JOptionPane.showMessageDialog(this.getParent(),"Ingrese una cantidad","Faltan Datos",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int cant = Integer.valueOf(txtCantidad.getText());
            if(cant<=0)
            {
                valido = false;
                JOptionPane.showMessageDialog(this.getParent(),"La Cantidad debe ser mayor a Cero","Faltan Datos",JOptionPane.ERROR_MESSAGE);
            }
        }
        // PRECIO
        if(txtPrecio.getText().isEmpty())
        {
            valido = false;
            JOptionPane.showMessageDialog(this.getParent(),"Ingrese un Precio","Faltan Datos",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            double cant = Double.valueOf(txtPrecio.getText());
            if(cant<=0)
            {
                valido = false;
                JOptionPane.showMessageDialog(this.getParent(),"La Precio debe ser mayor a Cero","Faltan Datos",JOptionPane.ERROR_MESSAGE);
            }
        }
        // LISTOOO
        if(valido)
        {
            // AGREGO A LA TABLA
            Object[] fila = new Object[5];
            fila[0] = tp_re;
            fila[1] = tp_pr;
            fila[2] = cmbLEP.getDate();
            fila[3] = Integer.valueOf(txtCantidad.getText());
            fila[4] = Double.valueOf(txtPrecio.getText());

            DefaultTableModel modelo = (DefaultTableModel) tblActualizaciones.getModel();
            modelo.addRow(fila);
        }

        


    }//GEN-LAST:event_btnActualizarPrecioActionPerformed

    private void cmbTipoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoRecursoActionPerformed

        Tupla tp = (Tupla)cmbTipoRecurso.getSelectedItem();
        if(tp.getId()!=0)
        {
            initListaRecursosEspecificos(); // VACIO LA LISTA DE RECURSOS ESPECIFICOS
            cargarRecursos(tp.getId());
        }


    }//GEN-LAST:event_cmbTipoRecursoActionPerformed

    private void cmbRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRecursoActionPerformed

        Tupla tpR = (Tupla)cmbRecurso.getSelectedItem();
        if(tpR.getId()!=0)
        {
            cargarListaDeRecursosEspecificos(tpR.getId());

            Tupla tpp = (Tupla) cmbRecurso.getSelectedItem();
            cargarProveedoresXTipoRecurso(tpp.getId());

        }

    }//GEN-LAST:event_cmbRecursoActionPerformed

    public void setUnidadDeMedida(String unidad)
    {
        lblUnidadMedida.setText(unidad);
    }

    private void lstRecursosEspecificosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstRecursosEspecificosMouseReleased

        Tupla tp  = (Tupla) lstRecursosEspecificos.getSelectedValue();
        gestor.mostrarInfoDeRecursoEspecifico(tp.getId());

        Tupla tpp = (Tupla)cmbProveedores.getSelectedItem();
        if(tpp.getId()!=0)
        {
            mostrarUltimoPrecioXProveedor(tpp.getId(),tp.getId());
        }

    }//GEN-LAST:event_lstRecursosEspecificosMouseReleased

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if((tblActualizaciones.getSelectedRowCount())==1)
        {
            int seleccion = JOptionPane.showOptionDialog(
            this, // Componente padre
            "¿Esta seguro que desea eliminar la fila de la actualización de precios?", //Mensaje
            "Seleccione una opción", // Título
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
            "Si");

            if (seleccion != -1)
            {
               if((seleccion + 1)==1)
               {

                        DefaultTableModel modelo = (DefaultTableModel) tblActualizaciones.getModel();
                        modelo.removeRow(tblActualizaciones.getSelectedRow());

               }
            }
        }



    }//GEN-LAST:event_btnQuitarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            int seleccion = JOptionPane.showOptionDialog(
            this, // Componente padre
            "Guardar las actualizaciones registrará los cambios de precios de la lista\n¿Esta seguro que desea Actualizar?", //Mensaje
            "Seleccione una opción", // Título
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,    // null para icono por defecto.
            new Object[] { "Si", "No"},    // null para YES, NO y CANCEL
            "Si");

            if (seleccion != -1)
            {
               if((seleccion + 1)==1)
               {
                  // PRESIONO SI
                  confirmarActualizarPrecios();
               }
            }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void confirmarActualizarPrecios()
    {
        // ME CONFIRMO LA ACTUALIZACION, POR CADA PRECIO
        // PASO TODAS LAS ACTUALIZACIONES
        DefaultTableModel modelo = (DefaultTableModel) tblActualizaciones.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++)
        {
            Tupla tp_re = (Tupla)modelo.getValueAt(i,0);
            Tupla tp_pr = (Tupla)modelo.getValueAt(i,1);
            Date vigencia = (Date)modelo.getValueAt(i,2);
            int cantidad = (Integer)modelo.getValueAt(i,3);
            double precio = (Double)modelo.getValueAt(i,4);
            gestor.actualizarPrecio(tp_re,tp_pr,vigencia,cantidad,precio);

        }
    }

    private void mostrarUltimoPrecioXProveedor(int idProv,int idRecEsc)
    {
        ArrayList<Tupla> lista = gestor.mostrarUltimoPrecioXProveedor(idProv,idRecEsc);

        DefaultListModel valores = new DefaultListModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"No Hay Precios Cagados"));
        }

        while(it.hasNext())
        {
            Tupla tu = it.next();
            valores.addElement(tu);
        }
        lstUltimosPrecios.setModel(valores);
    }

    private void cargarProveedoresXTipoRecurso(int id)
    {
        ArrayList<Tupla> lista = gestor.cargarProveedoresXTipoRecurso(id);

        DefaultComboBoxModel valores = new DefaultComboBoxModel();
        Iterator<Tupla> it = lista.iterator();

        if(lista.size()==0)
        {
            valores.addElement(new Tupla(0,"Sin Proveedores de este tipo"));
        }

        while(it.hasNext()){
            Tupla tu = it.next();
            valores.addElement(tu);
        }

        cmbProveedores.setModel(valores);
    }

    public void mostrarDescipcionRecursoEspecifico(String desc)
    {
        txtDescripcion.setText(desc);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPrecio;
    private javax.swing.JButton btnQuitar;
    private com.toedter.calendar.JDateChooser cmbLEP;
    private javax.swing.JComboBox cmbProveedores;
    private javax.swing.JComboBox cmbRecurso;
    private javax.swing.JComboBox cmbTipoRecurso;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JList lstRecursosEspecificos;
    private javax.swing.JList lstUltimosPrecios;
    private javax.swing.JTable tblActualizaciones;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables


    /**
     * ME-0020 : No se pudo cargar la lista de Recursos
     * ME-0021 : No se pudo cargar los recursos especificos
     * ME-0021 : No se pudo cargar la lista de proveedores
     * @param cod
     */
    public void MostrarMensaje(String cod)
    {
        if(cod.equals("ME-0020"))
        {
            // Se guardó en orden
            JOptionPane.showMessageDialog(this.getParent(),"No se pudo cargar la lista de Recursos","Error en la Carga",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        if(cod.equals("ME-0021"))
        {
            // Se guardó en orden
            JOptionPane.showMessageDialog(this.getParent(),"No se pudo el listado de Recursos","Error en la Carga",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        if(cod.equals("ME-0022"))
        {
            // Se guardó en orden
            JOptionPane.showMessageDialog(this.getParent(),"No se pudo cargar la lista de Proveedores","Error en la Carga",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        if(cod.equals("ME-0023"))
        {
            // Se guardó en orden
            JOptionPane.showMessageDialog(this.getParent(),"No se pudo cargar la lista de Ultimos Precios","Error en la Carga",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

}
