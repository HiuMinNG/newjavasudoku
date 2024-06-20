
package yusudoku.logical.checkers;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nathan
 */
public class CheckGivensAreValidNumbers implements Checker{
    private JPanel puzzlePanel;
    
    public CheckGivensAreValidNumbers(JPanel puzzlePanel){
        this.puzzlePanel = puzzlePanel;
    }
    
    @Override
    public void check() throws CheckerException{
        JTextField textFieldCatcher;
        for (Component c : puzzlePanel.getComponents()){
            textFieldCatcher = (JTextField)c;
            if (!textFieldCatcher.getText().equals(""))//not looking at blanks
                if (!textFieldCatcher.getText().matches("[1-9]")) //only want valid sudoku entries
                    throw new CheckerException("Only 1,2,3,4,5,6,7,8,9 are valid entries!");
        }
    }
}
