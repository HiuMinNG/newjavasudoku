
package yusudoku.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import yusudoku.gui.windows.ApplicationWindow;
import yusudoku.gui.windows.MainPuzzleWindow;
import yusudoku.gui.windows.UserInputPuzzleWindow;

/**
 *
 * @author nathan
 */
public class WelcomeMenuButtonListener implements ActionListener{
    private MenuOperation operation;
    private ApplicationWindow window;
    
    public WelcomeMenuButtonListener(MenuOperation operation, ApplicationWindow window){
        this.operation = operation;
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int choice; //for yes/no warning messages
        switch (operation){
            case NEW:
                choice = userOrComputer();
                window.getFrame().dispose();
                if (choice == 0)//user selected
                    SwingUtilities.invokeLater(new UserInputPuzzleWindow());
                else
                    SwingUtilities.invokeLater(new MainPuzzleWindow());
        } 
    }
    
    public int userOrComputer(){
        Object[] options = { "User", "Computer" };
        String message = "Will the user provide the puzzle, or should the computer do it?";
        int choice = JOptionPane.showOptionDialog(null, message, "Question",JOptionPane.DEFAULT_OPTION, 
                                                  JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return choice;
    }
}
