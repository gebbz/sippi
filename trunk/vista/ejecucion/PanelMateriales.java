package vista.ejecucion;

import controlador.ejecucion.GestorEjecucion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Ejecucion;
import modelo.EjecucionXMaterial;
import util.NTupla;
import vista.util.*;


/**
 *
 * @author Iuga
 */
public class PanelMateriales extends javax.swing.JPanel{

    public static final int TABLA_MATERIALES_COLUMNA_MATERIAL = 0;
    public static final int TABLA_MATERIALES_COLUMNA_TAREA = 1;
    public static final int TABLA_MATERIALES_CANTIDAD_PLANIFICADA = 2;
    public static final int TABLA_MATERIALES_CANTIDAD_USADA = 3;
    public static final int TABLA_MATERIALES_PRECIO_REAL = 4;
    private static final int TABLA_DEFAULT_ALTO = 25;      
    private GestorEjecucion gestor;
    private DefaultTableModel model;
    private List<Object> listaMateriales;
    boolean filtroBuscarActivado;
    
    
    public PanelMateriales(GestorEjecucion gestor) {
        this.gestor = gestor;
        initComponents();
        initTabla();
        filtroBuscarActivado=false;
        habilitarVentana();
        cambiarSegunEstadoEjecucion();
    }
    
    private void cambiarSegunEstadoEjecucion() {
        if(gestor.getEstadoEjecucion().equals(Ejecucion.ESTADO_CREADA)){
            // CREADA
            enablearComponentes(true);
            
        }else{
            // CANCELADA y FINALIZADA
            enablearComponentes(false);
        }
    }       
    
    private void habilitarVentana() {
        cargarMateriales();
        activarFiltrosTabla();
    }
    public void activarFiltrosTabla()
    {
         TableRowSorter<TableModel> modeloOrdenado;
            modeloOrdenado = new TableRowSorter<TableModel>(model);
            tblMateriales.setRowSorter(modeloOrdenado);
        

        if(filtroBuscarActivado)
        {
           String[] cadena=txtBuscar.getText().split(" ");
           List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
           for (int i= 0; i < cadena.length; i++)
           {
             filters.add(RowFilter.regexFilter("(?i)" + cadena[i]));
           }
            
           RowFilter<Object,Object> cadenaFilter = RowFilter.andFilter(filters);           
           modeloOrdenado.setRowFilter(cadenaFilter);

        }
       


    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateriales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        tblMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tarea", "Cantidad planificada", "Cantidad a usar", "Precio Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMateriales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblMateriales);
        tblMateriales.getColumnModel().getColumn(3).setCellEditor(new IntegerEditor(0,2147483647));
        tblMateriales.getColumnModel().getColumn(4).setCellEditor(new FloatEditor(0f,2147483647f));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search.png"))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscar.setText("Buscar...");
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked

        if(txtBuscar.getText().equals("Buscar...")) {
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained

        if(txtBuscar.getText().equals("Buscar...")) {
            txtBuscar.setText("");
            txtBuscar.setForeground(Color.BLACK);
            filtroBuscarActivado=true;
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if(txtBuscar.getText().equals("")) {
            txtBuscar.setText("Buscar...");
            txtBuscar.setForeground(Color.GRAY);
            filtroBuscarActivado=false;
        } else {
            filtroBuscarActivado=true;}
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        activarFiltrosTabla();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    //Sale una bendicion al tipo q implemento la clase q solciono muchos problemas
    Action accionSobreCelda = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            TableCellListener tcl = (TableCellListener)e.getSource();
            int fila = tcl.getRow();
            int columna = tcl.getColumn();
            
            DefaultTableModel modeloTabla = (DefaultTableModel)tblMateriales.getModel();
            EjecucionXMaterial material = (EjecucionXMaterial)((NTupla)modeloTabla.getValueAt(fila, 0)).getData();
            
            switch(columna)
            {
                case TABLA_MATERIALES_CANTIDAD_USADA:
                    Integer valorCant = (Integer) tcl.getNewValue();
                    material.getMaterialCotizacion().setCantidad(valorCant);
                    material.setCantidad(valorCant);
                    break;
                case TABLA_MATERIALES_PRECIO_REAL:
                    Float valor = (Float) tcl.getNewValue();
                    material.getMaterialCotizacion().setPrecioUnitario(Double.valueOf(valor));
                    break;                
                default:
                    Logger.getLogger(PanelRecursosHumanos.class.getName()).log(Level.SEVERE, "ERROR EN LOS INDICES DE LAS COLUMAS DE LA TABLA");
                    mostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "ALGO SALIO MAL");
                    break;
                        
            }  
            if(columna!=TABLA_MATERIALES_CANTIDAD_USADA && columna!=TABLA_MATERIALES_PRECIO_REAL)
            {       Logger.getLogger(PanelMateriales.class.getName()).log(Level.SEVERE, "ERROR EN LOS INDICES DE LAS COLUMAS DE LA TABLA");
                    mostrarMensaje(JOptionPane.ERROR_MESSAGE, "Error", "ALGO SALIO MAL");
                        
            }  
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMateriales;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    
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
    
     private void initTabla() {
        tblMateriales.setRowHeight(TABLA_DEFAULT_ALTO);
       tblMateriales.setDefaultRenderer(Object.class,new EditableCellTableRenderer());
        // Ancho de Columnas
        int anchoColumna = 0;
        TableColumnModel modeloColumna = tblMateriales.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < tblMateriales.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            switch (i) {
                case TABLA_MATERIALES_COLUMNA_MATERIAL:
                    anchoColumna = 230;
                    break;
                case TABLA_MATERIALES_COLUMNA_TAREA:
                    anchoColumna = 230;
                    break;
                case TABLA_MATERIALES_CANTIDAD_PLANIFICADA:
                    anchoColumna = 130;
                    break;
                case TABLA_MATERIALES_CANTIDAD_USADA:
                    anchoColumna = 130;
                    break;
            }
            columnaTabla.setPreferredWidth(anchoColumna);
            columnaTabla.setWidth(anchoColumna);
        } 
        cambiarTamCabeceraTablas();
        TableCellListener tcl = new TableCellListener(tblMateriales, accionSobreCelda);
    }
     
     private void cambiarTamCabeceraTablas()
    {
        Font fuente = new Font("Verdana", Font.PLAIN, 9);
        JTableHeader th1;
        th1 = tblMateriales.getTableHeader();
        th1.setFont(fuente); 
        
              
    }
    
     
    private void cargarMateriales()
    {
        
        listaMateriales=gestor.getListaMateriales();
       
        model = (DefaultTableModel) tblMateriales.getModel();
        
        model.setRowCount(0);
        for (Object detalle : listaMateriales)
        {
            Object[] obj=(Object[])detalle;
            model.addRow( obj );
        }
       
        tblMateriales.setModel(model);
    

    }

    public void actualizar() {
        cargarMateriales();
    }

    private void enablearComponentes(boolean b) {
        tblMateriales.setEnabled(b);
    }

    
}
