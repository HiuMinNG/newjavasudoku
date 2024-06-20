
package yusudoku;

import javax.swing.SwingUtilities;
import yusudoku.gui.windows.WelcomeWindow;

/**
 *
 * @author nathan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WelcomeWindow());
    }
    
}
