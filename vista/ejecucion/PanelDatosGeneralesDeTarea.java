/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * editarCotizacion_Descripcion.java
 *
 * Created on 06-jun-2011, 10:22:15
 */
package vista.ejecucion;

import controlador.ejecucion.GestorEjecucion;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Ejecucion;
import modelo.TareaEjecucion;
import util.ColorUtil;
import util.NTupla;
import util.Tupla;
import vista.interfaces.ICallBack_v3;

/**
 *
 * @author Administrador
 */
public class PanelDatosGeneralesDeTarea extends javax.swing.JPanel implements ICallBack_v3 {

    private boolean FLAG_ESTA_EDITANDO;
    private GestorEjecucion gestor;

    /**
     * Creates new form editarCotizacion_Descripcion
     */
    public PanelDatosGeneralesDeTarea(GestorEjecucion gestor) {
        FLAG_ESTA_EDITANDO = false;
        this.gestor = gestor;
        initComponents();
        initComboEstado();
        initComboTipoTarea();
        initDatosTarea();
        initCombosFechas();
        cambiarSegunEstadoEjecucion();
        FLAG_ESTA_EDITANDO = true;
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
        txtObservaciones = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        dcFechaFin = new com.toedter.calendar.JDateChooser();
        cmbTipoTarea = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setRows(5);
        txtObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtObservacionesFocusLost(evt);
            }
        });
        txtObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObservacionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtObservaciones);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Observaciones");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Fecha de Inicio:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha de Fin:");

        cmbTipoTarea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoTareaItemStateChanged(evt);
            }
        });
        cmbTipoTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoTareaActionPerformed(evt);
            }
        });
        cmbTipoTarea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbTipoTareaFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Estado:");

        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        cmbEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbEstadoFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/iconos/var/16x16/accept.png"))); // NOI18N
        jButton1.setText("Aceptar Cambios");
        jButton1.setToolTipText("Confirmar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(cmbTipoTarea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipoTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtObservacionesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionesFocusLost
    }//GEN-LAST:event_txtObservacionesFocusLost

    private void cmbTipoTareaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTipoTareaFocusLost
    }//GEN-LAST:event_cmbTipoTareaFocusLost

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        
    }//GEN-LAST:event_txtNombreKeyReleased

    private void cmbTipoTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoTareaActionPerformed
    }//GEN-LAST:event_cmbTipoTareaActionPerformed

    private void txtObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionesKeyReleased
    }//GEN-LAST:event_txtObservacionesKeyReleased

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void cmbTipoTareaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoTareaItemStateChanged
    }//GEN-LAST:event_cmbTipoTareaItemStateChanged

    private void cmbEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbEstadoFocusLost
    }//GEN-LAST:event_cmbEstadoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try{
            
            if (FLAG_ESTA_EDITANDO) {
                Tupla tp = (Tupla) cmbTipoTarea.getModel().getSelectedItem();
                gestor.actualizarTipoTarea(tp);
            }

            gestor.actualizarObservacionesTarea(txtObservaciones.getText());
            gestor.actualizarNombreTarea(txtNombre.getText());

            gestor.actualizarFechaInicioTarea(dcFechaInicio.getDate());
            gestor.actualizarFechaFinTarea(dcFechaFin.getDate());

            if (FLAG_ESTA_EDITANDO) {
                Tupla tpe = (Tupla) cmbEstado.getModel().getSelectedItem();
                gestor.actualizarEstadoTarea(tpe);
            }
            
            mostrarMensaje(JOptionPane.INFORMATION_MESSAGE,"Exito!","Cambios aplicados correctamente");
            
        }catch(Exception e){
            mostrarMensaje(JOptionPane.ERROR_MESSAGE,"Error!","Se produjo un error al Aplicar los cambios");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbTipoTarea;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables

//    public void mostrarDatos(String nombre, String tipoTarea, Date fechaInicio, Date fechaFin, String observaciones)
//    {
//        if(nombre!=null)
//        {
//            txtNombre.setText(nombre);
//        }
//        if(tipoTarea!=null)
//        {
//            cmbTipoTarea.setSelectedItem(tipoTarea);
//        }
//        if(fechaInicio != null)
//        {
//            dcFechaInicio.setDate(fechaInicio);
//        }
//        if(fechaFin != null)
//        {
//            dcFechaFin.setDate(fechaFin);
//        }
//        if(observaciones!=null)
//        {
//            txtObservaciones.setText(observaciones);
//        }            
//    }
    public void agregarElementoAlCombo(String nombre) {
        this.cmbTipoTarea.addItem(nombre);
    }

    /*private void actualizarFechas(){
        
     Calendar fInicio = Calendar.getInstance();
     fInicio.setTime(dcFechaInicio.getDate());
     fInicio.set(Calendar.HOUR,21);
     fInicio.set(Calendar.MINUTE,0);
     fInicio.set(Calendar.SECOND,0);
     fInicio.set(Calendar.MILLISECOND,0);
        
     Calendar fFin = Calendar.getInstance();
     fFin.setTime(dcFechaFin.getDate());
     fFin.set(Calendar.HOUR,21);
     fFin.set(Calendar.MINUTE,0);
     fFin.set(Calendar.SECOND,0);
     fFin.set(Calendar.MILLISECOND,0);      
        
     gestor.actualizarFechaInicio(fInicio.getTime());
     gestor.actualizarFechaFin(fFin.getTime());
     }
    
     private void addListenerToDateChooser(JDateChooser chooser){
     chooser = dcFechaFin;
     chooser.getDateEditor().addPropertyChangeListener(
     new PropertyChangeListener() {
     @Override
     public void propertyChange(PropertyChangeEvent e) {
     if ("date".equals(e.getPropertyName())) {
     actualizarFechas();
     }
     }
     });
     this.add(chooser);
     }*/
    public void actualizar() {
        initDatosTarea();
        cambiarSegunEstadoEjecucion();
    }

    private void initDatosTarea() {
        NTupla datos = gestor.getDatosTareaSeleccionada();
        if (datos == null) {
            // Desactivo los componentes
            cambiarComponentesDeLaVentana(false);
        } else {
            // Activo los componentes
            cambiarComponentesDeLaVentana(true);
            txtNombre.setText(datos.getNombre());

            Object[] data = (Object[]) datos.getData();

            String observaciones = (String) data[4];
            txtObservaciones.setText(observaciones);

            Date fechaIni = (Date) data[2];
            dcFechaInicio.setDate(fechaIni);
            Date fechaFin = (Date) data[3];
            dcFechaFin.setDate(fechaFin);

            int idTipoTarea = (Integer) data[0];
            for (int i = 0; i < cmbTipoTarea.getItemCount(); i++) {
                Tupla tp = (Tupla) cmbTipoTarea.getItemAt(i);
                if (tp.getId() == idTipoTarea) {
                    cmbTipoTarea.setSelectedIndex(i);
                }
            }

            String estado = (String) data[1];
            for (int i = 0; i < cmbEstado.getItemCount(); i++) {
                Tupla tp = (Tupla) cmbEstado.getItemAt(i);
                if (tp.getId() == TareaEjecucion.getIdEstadoSegunNombre(estado)) {
                    cmbEstado.setSelectedIndex(i);
                }
            }
        }
    }

    /**
     * Muestra un mensaje
     *
     * @param tipo
     * @param titulo
     * @param mensaje
     */
    public void mostrarMensaje(int tipo, String titulo, String mensaje) {
        JOptionPane.showMessageDialog(this.getParent(), mensaje, titulo, tipo);
    }

    /**
     * Inicializa el Combo de Estado
     */
    private void initComboEstado() {
        cmbEstado.removeAllItems();
        cmbEstado.addItem(new Tupla(TareaEjecucion.ESTADO_ID_NUEVA, getNombreEstadoTarea(TareaEjecucion.ESTADO_NUEVA, TareaEjecucion.ESTADO_COLOR_NUEVA)));
        cmbEstado.addItem(new Tupla(TareaEjecucion.ESTADO_ID_CANCELADA, getNombreEstadoTarea(TareaEjecucion.ESTADO_CANCELADA, TareaEjecucion.ESTADO_COLOR_CANCELADA)));
        cmbEstado.addItem(new Tupla(TareaEjecucion.ESTADO_ID_COMPLETA, getNombreEstadoTarea(TareaEjecucion.ESTADO_COMPLETA, TareaEjecucion.ESTADO_COLOR_COMPLETA)));
        cmbEstado.addItem(new Tupla(TareaEjecucion.ESTADO_ID_ENESPERA, getNombreEstadoTarea(TareaEjecucion.ESTADO_ENESPERA, TareaEjecucion.ESTADO_COLOR_ENESPERA)));
        cmbEstado.addItem(new Tupla(TareaEjecucion.ESTADO_ID_ENPROGRESO, getNombreEstadoTarea(TareaEjecucion.ESTADO_ENPROGRESO, TareaEjecucion.ESTADO_COLOR_ENPROGRESO)));
        cmbEstado.addItem(new Tupla(TareaEjecucion.ESTADO_ID_IMPEDIMENTO, getNombreEstadoTarea(TareaEjecucion.ESTADO_IMPEDIMENTO, TareaEjecucion.ESTADO_COLOR_IMPEDIMENTO)));
    }

    /**
     * Retorna la cadena formateada y coloreada lista para mostrar
     *
     * @param estado
     * @param color
     * @return
     */
    private String getNombreEstadoTarea(String estado, Color color) {
        String texto = "<HTML><span color='" + ColorUtil.encodeRGB(color) + "'>" + estado + "</span>";
        return texto;
    }

    private void initComboTipoTarea() {
        cmbTipoTarea.removeAllItems();
        List<Tupla> tipos = gestor.cargarTiposDeTarea();
        for (int i = 0; i < tipos.size(); i++) {
            Tupla tp = tipos.get(i);
            cmbTipoTarea.addItem(tp);
        }
    }

    private void cambiarComponentesDeLaVentana(boolean flag) {
        txtNombre.setEnabled(flag);
        cmbTipoTarea.setEnabled(flag);
        cmbEstado.setEnabled(flag);
        dcFechaInicio.setEnabled(flag);
        dcFechaFin.setEnabled(flag);
        txtObservaciones.setEnabled(flag);
    }

    private void initCombosFechas() {

//        // Trigger para la Fecha de Inicio
//        dcFechaInicio.addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent e) {
//                if (FLAG_ESTA_EDITANDO && "date".equals(e.getPropertyName())) {
//                    try {
//                        gestor.actualizarFechaInicioTarea((Date) e.getNewValue());
//                    } catch (IllegalArgumentException ex) {
//                        dcFechaInicio.setDate((Date) e.getOldValue());
//                        mostrarMensaje(JOptionPane.INFORMATION_MESSAGE, "Atención!", ex.getMessage());
//                    }
//                }
//            }
//        });

//        // Trigger para la Fecha de Fin
//        dcFechaFin.addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent e) {
//                if (FLAG_ESTA_EDITANDO && "date".equals(e.getPropertyName())) {
//                    try {
//                        gestor.actualizarFechaFinTarea((Date) e.getNewValue());
//                    } catch (IllegalArgumentException ex) {
//                        dcFechaFin.setDate((Date) e.getOldValue());
//                        mostrarMensaje(JOptionPane.INFORMATION_MESSAGE, "Atención!", ex.getMessage());
//                    }
//                }
//            }
//        });
    }

    private void cambiarSegunEstadoEjecucion() {
        if (gestor.getEstadoEjecucion().equals(Ejecucion.ESTADO_CREADA)) {
            // CREADA
            enablearComponentes(true);

        } else {
            // CANCELADA y FINALIZADA
            enablearComponentes(false);
        }
    }

    private void enablearComponentes(boolean b) {
        txtNombre.setEnabled(b);
        cmbTipoTarea.setEnabled(b);
        cmbEstado.setEnabled(b);
        dcFechaInicio.setEnabled(b);
        dcFechaFin.setEnabled(b);
        txtObservaciones.setEnabled(b);
    }

    @Override
    public void actualizar(int id, String flag, boolean exito, Object[] data) {
        actualizar();
    }
}
