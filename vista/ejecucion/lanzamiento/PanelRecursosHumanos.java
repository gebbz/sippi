/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ejecucion.lanzamiento;

import controlador.ejecucion.lanzamiento.GestorVentanaLanzamiento;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import util.NTupla;
import util.TablaUtil;
import vista.util.MyComboBoxEditor;

/**
 *
 * @author Administrador
 */
public class PanelRecursosHumanos extends javax.swing.JPanel {

    public static final int TABLA_RRHH_COLUMNA_NOMBRE = 0;
    public static final int TABLA_RRHH_COLUMNA_HSN = 1;
    public static final int TABLA_RRHH_COLUMNA_HS50 = 2;
    public static final int TABLA_RRHH_COLUMNA_HS100 = 3;
    public static final int TABLA_RRHH_COLUMNA_ESTADO = 4;
    public static final int TABLA_RRHH_COLUMNA_SELECCION = 5;
    
    private static final int TABLA_DEFAULT_ALTO = 25;    
        
    private GestorVentanaLanzamiento gestor;
    
    /**
     * Creates new form PanelRecursosHumanos
     */
    public PanelRecursosHumanos(GestorVentanaLanzamiento gestor) {
        this.gestor = gestor;
        initComponents();
        initTabla();
        cargarDatosTablaParaObra();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRRHH = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        tblRRHH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del empleado", "Horas Normales", "Horas 50%", "Horas 100%", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRRHH.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblRRHH);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRRHH;
    // End of variables declaration//GEN-END:variables

    private void initTabla() {
        tblRRHH.setRowHeight(TABLA_DEFAULT_ALTO);
        DefaultTableModel modelo = (DefaultTableModel) tblRRHH.getModel();

        // Ancho de Columnas
        int anchoColumna = 0;
        TableColumnModel modeloColumna = tblRRHH.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < tblRRHH.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            switch (i) {
                case TABLA_RRHH_COLUMNA_NOMBRE:
                    anchoColumna = 300;
                    break;
                case TABLA_RRHH_COLUMNA_HSN:
                    anchoColumna = 100;
                    break;
                case TABLA_RRHH_COLUMNA_HS50:
                    anchoColumna = 100;
                    break;
                case TABLA_RRHH_COLUMNA_HS100:
                    anchoColumna = 100;
                    break; 
                case TABLA_RRHH_COLUMNA_ESTADO:
                    anchoColumna = 200;
                    break;                        
                case TABLA_RRHH_COLUMNA_SELECCION:
                    anchoColumna = 50;
                    break;
            }
            columnaTabla.setPreferredWidth(anchoColumna);
            columnaTabla.setWidth(anchoColumna);
        } 
    }
    
    /**
     * Pide al gestor que busque todos los datos de los empleados que van a 
     * trabajar en esta obra y su estado.
     */
    private void cargarDatosTablaParaObra() {
        List<NTupla> tuplas = gestor.llenarTablaPanelRRHH();
        DefaultTableModel modelo = (DefaultTableModel)tblRRHH.getModel();
        TablaUtil.vaciarDefaultTableModel(modelo);
        
        for (int i = 0; i < tuplas.size(); i++) {
            NTupla nTupla = tuplas.get(i);
            Object[] fila = new Object[6];
            fila[TABLA_RRHH_COLUMNA_NOMBRE] = nTupla;
            
                String[] data = (String[]) nTupla.getData();
            
                fila[TABLA_RRHH_COLUMNA_HSN] = data[0];
                fila[TABLA_RRHH_COLUMNA_HS50] = data[1];
                fila[TABLA_RRHH_COLUMNA_HS100] = data[2];
                fila[TABLA_RRHH_COLUMNA_ESTADO] = data[3];

                fila[TABLA_RRHH_COLUMNA_SELECCION] = false;
                
            modelo.addRow(fila);
        }
    }    
}
