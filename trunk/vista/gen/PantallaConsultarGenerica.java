/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pantallaConsultar.java
 *
 * Created on 06-ago-2010, 15:44:11
 */

package vista.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.hibernate.Session;
import util.HibernateUtil;
import util.Tupla;
import vista.interfaces.ICallBackGen;
import vista.reportes.ReportDesigner;

/**
 *
 * @author Administrador
 */
public abstract class PantallaConsultarGenerica extends javax.swing.JInternalFrame {

    private Class entidad;
    private HashMap<String,String> columnas;
    
    private String nombreOrigenCallback = "";
    private ICallBackGen origenCallback = null;
    
    private String filtroActivo;
    
    /** Creates new form pantallaConsultar */
    public PantallaConsultarGenerica(Class entidad) {
        
        this.entidad = entidad;
                
        filtroActivo = new String();
        
        initComponents();
        initConfig();
        habilitarVentana();
    }

    public PantallaConsultarGenerica(Class entidad,String filtoActivo) {
        this.entidad = entidad;                
        this.filtroActivo = filtoActivo;
        initComponents();
        initConfig();
        habilitarVentana();
    }    
    
    private void habilitarVentana()
    {
        cargarDatosIniciales();        
    }

    private void cargarDatosIniciales()
    {
        // Limpio el modelo Anterior
        ArrayList<ArrayList<Tupla>> data = new ArrayList<ArrayList<Tupla>>();
        
        // Cargo los datos iniciales de la tabla
        try{
            Session sesion= HibernateUtil.getSession();
            sesion.beginTransaction();
                List lista=null;
                // CREO LA CONSULTA, CON O SIN FILTROS
                if(getFiltrosActivos().isEmpty())
                {
                    if(!this.filtroActivo.isEmpty())
                    {
                        lista = sesion.createQuery("FROM "+this.entidad.getSimpleName()+" WHERE "+this.filtroActivo).list();
                    }
                    else
                    {
                        lista = sesion.createQuery("FROM "+this.entidad.getSimpleName()).list();
                    }
                }
                else
                {
                    lista = sesion.createQuery("FROM "+this.entidad.getSimpleName()+" WHERE "+getFiltrosActivos()).list();
                }
                for (int i = 0; i < lista.size(); i++) 
                {
                    Object obj = lista.get(i);
                    // Reflexiono un poco
                    Iterator it = getColumnas().iterator();
                    
                    ArrayList<Tupla> fila = new ArrayList<Tupla>();
                    
                    while (it.hasNext()) {
                        String e[] = (String[])it.next();
                        System.out.println(e[0] + " " + e[1]);
                        
                            java.lang.reflect.Method method; 
                            try 
                            { 
                                method = obj.getClass().getMethod((String)e[0]);
                                try { 
                                    String result = (String) String.valueOf(method.invoke(obj));
                                    System.out.println("Resultado Reflection: "+result);
                                    
                                    java.lang.reflect.Method methodGetId = obj.getClass().getMethod("getId");
                                    String id = (String) String.valueOf(methodGetId.invoke(obj));
                                    
                                    fila.add(new Tupla(Integer.parseInt(id), result));
                                    
                                }  catch (Exception ex) 
                                {
                                    System.out.println("No se pudo ejecutar el método");
                                    fila.add(new Tupla(-1,"---"));
                                } 
                                
                            } 
                            catch (Exception ep) { 
                                System.out.println("No se encontro el metodo");
                            }
                    }
                    data.add(fila);

                }
            sesion.getTransaction().commit();
        } catch (Exception ex)
        {
            System.out.println("No se pudo abrir la sesion");
        }
        
        // Armo el modelo
        
        DefaultTableModel modelo = new DefaultTableModel(parseData(data), parseColumNames()) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
        tblLista.setModel(modelo);
        
        // Muestro la cantidad de Ocurrencias
        mostrarCantidadFilas();
        
    }

    private void setCantidadResultados(int cant)
    {
        lblCantResultados.setText("Cantidad de Resultados: "+cant);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLista = new javax.swing.JTable();
        lblCantResultados = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnVerDetalles = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar ...");

        txtBuscar.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscar.setText("Buscar...");
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search.png"))); // NOI18N

        tblLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Legajo", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblListaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblLista);

        lblCantResultados.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblCantResultados.setText("Cantidad: ");

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/refresh.png"))); // NOI18N
        btnRefrescar.setToolTipText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/block.png"))); // NOI18N
        btnSeleccionar.setText("Cerrar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnVerDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/search_page.png"))); // NOI18N
        btnVerDetalles.setText("Ver Detalles");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/print.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCantResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addGap(133, 133, 133)
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerDetalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnRefrescar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantResultados)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnVerDetalles)
                    .addComponent(btnImprimir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked

        if(txtBuscar.getText().equals("Buscar..."))
        {
            txtBuscar.setText("");
        }

    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        activarFiltrosTabla();
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
//        {
//            // LANZO EL BUSCAR
//            activarFiltrosTabla();
//        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarDatosIniciales();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void tblListaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaMouseReleased
    
       if(tblLista.getSelectedRow()!=-1)
       {
           if (evt.getClickCount() == 2)
            {
               int id = getIDfromFila(tblLista.getSelectedRow());
               abrirEntidad(id);
            }
        }
    }//GEN-LAST:event_tblListaMouseReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

        // Veo si hay que seleccionar una fila
        if(!this.nombreOrigenCallback.isEmpty() && this.origenCallback!=null)
        {
            // Busco algun ID en la fila != -1
            if(tblLista.getSelectedRow()!=-1)
            {
                int id = getIDfromFila(tblLista.getSelectedRow());
                if(id!=-1)
                {
                    this.origenCallback.actualizar(id,this.nombreOrigenCallback,this.entidad);
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(new JInternalFrame(),"No se pudo encontrar el ID de la Fila","Error!",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(new JInternalFrame(),"Debe seleccionar al menos una fila!","Atención!",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            this.dispose();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
       if(tblLista.getSelectedRow()!=-1)
       {
          int id = getIDfromFila(tblLista.getSelectedRow());
          abrirEntidad(id);
       }
       else
       {
        JOptionPane.showMessageDialog(new JInternalFrame(),"Debe seleccionar al menos una Fila!","Atención!",JOptionPane.INFORMATION_MESSAGE);                   
       }
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
        // Recopilo los datos
        DefaultTableModel modelo = (DefaultTableModel)tblLista.getModel();
        
        String [][] datos = new String[modelo.getRowCount()][modelo.getColumnCount()];
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            for (int j = 0; j < modelo.getRowCount(); j++) {
                
                String dato = String.valueOf(modelo.getValueAt(j, i));
                datos[j][i] = dato;
            }
        }
        
        String[] columnas = new String[getColumnas().size()];
        for (int i = 0; i < getColumnas().size(); i++) {
            String[] data = getColumnas().get(i);
            columnas[i] = data[1];
        }
        
        imprimir(getNombreVentana(),columnas,datos);
        
        JOptionPane.showMessageDialog(new JInternalFrame(),"Generando el Reporte\nPor favor aguarde...!","Atención!",JOptionPane.INFORMATION_MESSAGE,new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/32x32/promotion.png")));                   
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * Setea el nombre de las columnas y el correspondiente getter de la entidad
     * que los va a llenar, el formato es:
     * [getter][nombre de la columna]
     * @return 
     */
    protected ArrayList<String[]> getColumnas()
    {
        return new ArrayList<String[]>();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantResultados;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void initConfig() {
        // Pongo el nombre a la ventana
        this.setTitle(getNombreVentana());
        // Pinto y seteo el estado de los componentes y botones
        setEstadoInicial();
        // Si hay pintado segun criterio lo hago
        initColorCriteria();
    }
    
    protected String getNombreVentana()
    {
        return generarNombreVentana();
    }
    
    private String generarNombreVentana()
    {
        // Seteo el nombre de la ventana
        String nombre = this.entidad.getSimpleName();
        // WORKARROUND para este asco nombre
        if(nombre.equals("PlanificacionXXX"))
        {
            nombre = "Planificación";
        }
        return ("Listado: "+nombre);        
    }
    
    protected Object[] parseColumNames()
    {
        ArrayList<String> lista = new ArrayList<String>();
        
        for (int i = 0; i < getColumnas().size(); i++) {
            String[] col = (String[])getColumnas().get(i);
            System.out.println("[DEBUG] Agrego a la columnas: " + col[1]);
            lista.add((String)col[1]);
        }
        
        Object[] columns = new Object[lista.size()];
        for (int i = 0; i < lista.size(); i++) 
        {
            String s = lista.get(i);
            columns[i] = s;
        }
        
        return columns;
    }

    private Object[][] parseData(ArrayList<ArrayList<Tupla>> data) {

        int a = 0;
        
        if(data!=null)
            a = data.size();
        
        int b = 0;
        
        if(data.size()>0 && data.get(0)!=null)
            b=data.get(0).size();
        
        System.out.println("[DEBUG] Cantidad de Filas: "+a);    
        System.out.println("[DEBUG] Cantidad de Columbas: "+b);
        
        Object[][] fila = new Object[a][b];
        
        for (int i = 0; i < data.size(); i++) {
            ArrayList<Tupla> arrayList = data.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                Tupla d = arrayList.get(j);
                fila[i][j] = d;
            }
        }
       
        return fila;
    }

    private void mostrarCantidadFilas() {
        lblCantResultados.setText("Cantidad: "+tblLista.getRowCount());
    }

    protected void activarFiltrosTabla()
    {
           TableRowSorter<TableModel> modeloOrdenado;

           modeloOrdenado = new TableRowSorter<TableModel>(tblLista.getModel());
           tblLista.setRowSorter(modeloOrdenado);
        
           String[] cadena=txtBuscar.getText().split(" ");
           List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
           for (int i= 0; i < cadena.length; i++)
           {
             filters.add(RowFilter.regexFilter("(?i)" + cadena[i]));
           }
            
           RowFilter<Object,Object> cadenaFilter = RowFilter.andFilter(filters);           
           modeloOrdenado.setRowFilter(cadenaFilter);
           
           mostrarCantidadFilas();
    }
    
    public void setSeleccionarEnabled(ICallBackGen origen, String nombre)
    {
        this.nombreOrigenCallback = nombre;
        this.origenCallback = origen;
        
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setEnabled(true);
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/accept.png")));
    }

    private void setEstadoInicial() {
        btnSeleccionar.setEnabled(true);
        btnSeleccionar.setText("Cerrar");
    }

    protected void abrirEntidad(int id) {
        JOptionPane.showMessageDialog(new JInternalFrame(),"En Contrucción!","Atención!",JOptionPane.INFORMATION_MESSAGE);        
    }
    
    protected String getColumnaId()
    {
        return "";
    }
    
    private int getIDfromFila(int fila)
    {
        
        fila = tblLista.convertRowIndexToModel(fila);
        
        DefaultTableModel modelo = (DefaultTableModel)tblLista.getModel();
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            int id=((Tupla)(tblLista.getModel().getValueAt(fila, 0))).getId();      
            if(id!=-1)
            {
                return id;
            }
        }
        return -1;
    }

    /**
     * Activa el Coloreado de Celdas segun los datos que esta contenga, el filtro
     * el del tipo:
     * [Nombre de Columna][Dato][Color]
     * @return 
     */
    protected ArrayList<String[]> getColumnColorCriteria()
    {
        return new ArrayList<String[]>();
    }

    private void initColorCriteria() {
        tblLista.setDefaultRenderer(Object.class,new PantallaConsultarGenericaCellRenderer(getColumnColorCriteria(),getColumnas()));
    }
    
    /**
     * Comportamiento del botón Imprimir
     * @param nombre
     * @param columnas
     * @param datos 
     */
    protected void imprimir(String nombre,String[]columnas, String[][] datos)
    {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("NOMBRE",nombre);
        params.put("DATOS",datos);
        params.put("NOMBRE_COLUMNAS",columnas);
        
        try {
            PantallaConsultarGenericaImprimir ci = new PantallaConsultarGenericaImprimir();
            ci.setNombreReporte(nombre);
            ci.setNombreArchivo("Listado",ReportDesigner.REPORTE_TIPO_LISTADOS);
            ci.makeAndShow(params);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JInternalFrame(),"Se produjo un error al generar el Reporte\nIntentelo nuevamente.","Error!",JOptionPane.INFORMATION_MESSAGE);
        } 
    }
    
    /**
     * Retorna una condicion WHERE de HSQL para filtrar desde el vamos los datos
     * que serán mostrados en el listado.
     * @return 
     */
    protected String getFiltrosActivos()
    {
        return "";
    }

    public void setFiltroActivo(String filtroActivo) {
        this.filtroActivo = filtroActivo;
    }
    
    
}
