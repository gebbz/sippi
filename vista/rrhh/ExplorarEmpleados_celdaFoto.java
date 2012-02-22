/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package vista.rrhh;

import java.awt.Color;
import java.awt.Graphics;
import modelo.Empleado;
import util.imagenes.GestorImagenes;

/**
 *
 * @author Administrador
 */
public class ExplorarEmpleados_celdaFoto extends javax.swing.JPanel {

     private GestorImagenes gestorImagenes;
    
    
    /** Creates new form explorarCotizaciones_celda */
    public ExplorarEmpleados_celdaFoto() {
        initComponents();
        gestorImagenes=new GestorImagenes(); 
    }
    public void setEmpleado(Empleado emp)
    {
        gestorImagenes.setImagenBlob(emp.getImagen());
    }

    
    public GestorImagenes getGestorImagenes() {
        return gestorImagenes;
    }

    public void setEmpleado(GestorImagenes ge) {
        this.gestorImagenes=ge;
        
    }
    
@Override
public void paint(Graphics page)
{
    super.paint(page);
    gestorImagenes.cargarImagenEnPanelAjustandoTamano(panelFoto, true);
}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFoto = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(72, 72));

        panelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFoto.setPreferredSize(new java.awt.Dimension(52, 52));

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    


    public void setSelected(boolean flag)
    {
        if(flag)
        {
            this.setBackground(new Color(112,112,112));
        }
        else
        {
            this.setBackground(new Color(245,252,255));
        }
    }

   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelFoto;
    // End of variables declaration//GEN-END:variables

}
