
package yusudoku;

import javax.swing.SwingUtilities;
import yusudoku.gui.windows.WelcomeWindow;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WelcomeWindow());
    }
    
}
