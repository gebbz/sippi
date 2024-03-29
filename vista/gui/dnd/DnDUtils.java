/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.gui.dnd;

import java.awt.dnd.DnDConstants;

/**
 *
 * @author Administrador
 */
class DnDUtils {
    
  public static String showActions(int action) {
    String actions = "";
    if ((action & (DnDConstants.ACTION_LINK | DnDConstants.ACTION_COPY_OR_MOVE)) == 0) {
      return "None";
    }

    if ((action & DnDConstants.ACTION_COPY) != 0) {
      actions += "Copy ";
    }

    if ((action & DnDConstants.ACTION_MOVE) != 0) {
      actions += "Move ";
    }

    if ((action & DnDConstants.ACTION_LINK) != 0) {
      actions += "Link";
    }

    return actions;
  }

  public static boolean isDebugEnabled() {
    return debugEnabled;
  }

  public static void debugPrintln(String s) {
    if (debugEnabled) {
      System.out.println(s);
    }
  }

  //private static boolean debugEnabled = (System.getProperty("DnDExamples.debug") != null);
  private static boolean debugEnabled = true;
  
}
