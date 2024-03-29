package vista.gui;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Descripción:
 * @version 1.0
 * @author Iuga
 * @cambios
 * @todo
 */

public class IconCellRenderer extends DefaultTableCellRenderer {

    /**
     * Acá redefinimos como se muestra, vemos q ahora lo forzamos a
     * trabajar con JLabel, pero si no lo es, por ejemplo un String
     * igual lo muestro llamando a Super
     */
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column)
    {
        if(value instanceof JLabel)
        {
            JLabel label = (JLabel)value;
            label.setOpaque(true);
            fillColor(table,label,isSelected);
            return label;
        }
        else
        {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
     }

    /**
     * Este método es para que pinte el fondo del JLabel cuando
     * lo seleccionamos para que no quede en blanco, desentonando
     * con el resto de las celdas que no son JLabel
     */
    public void fillColor(JTable t,JLabel l,boolean isSelected ){
        //setting the background and foreground when JLabel is selected
        if(isSelected){
            l.setBackground(t.getSelectionBackground());
            l.setForeground(t.getSelectionForeground());
        }
        else{
            l.setBackground(t.getBackground());
            l.setForeground(t.getForeground());
        }
    }

}
