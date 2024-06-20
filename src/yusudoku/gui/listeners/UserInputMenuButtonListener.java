
package yusudoku.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import yusudoku.gui.windows.ApplicationWindow;
import yusudoku.gui.windows.MainPuzzleWindow;
import yusudoku.logical.checkers.CheckGivensAreValidNumbers;
import yusudoku.logical.checkers.CheckGivensCompliance;
import yusudoku.logical.checkers.CheckUniqueSolution;
import yusudoku.logical.checkers.Checker;
import yusudoku.logical.checkers.CheckerException;
import yusudoku.puzzle.Puzzle;

/**
 *
 * @author nathan
 */
public class UserInputMenuButtonListener implements ActionListener{
    private MenuOperation operation;
    private ApplicationWindow window;
    
    public UserInputMenuButtonListener(MenuOperation operation, ApplicationWindow window){
        this.operation = operation;
        this.window = window;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JLabel statusMessage = (JLabel)window.getMenuPanel().getComponent(0);
        
        int choice; //for yes/no warning messages
        switch (operation){
            case CLEAR:
                choice = confirm("Are you sure you want to clear your progress?");
                if (choice == 0)//0 means yes
                     window.clearPuzzlePanel();
                break;
            case DONE:
                Puzzle puzzle = window.readPuzzlePanel();
                try{
                    //Check that all entries are valid sudoku values
                    Checker validValues = new CheckGivensAreValidNumbers(window.getPuzzlePanel());
                    validValues.check();
                    
                    //check if enough givens
                    if (window.countFilled() < 17) //research suggests min givens is 17
                        throw new CheckerException("Solvable puzzles require 17 or more givens!");
                    
                    //check if sudoku rules are followed:
                    //only one value in each row, column, and group
                    Checker givensCompliance = new CheckGivensCompliance(puzzle);
                    givensCompliance.check();
                    
                    //check if puzzle has a unique solution
                    Checker uniqueSolution = new CheckUniqueSolution(puzzle);
                    uniqueSolution.check();
                } catch (CheckerException e){
                    statusMessage.setText(e.getMessage());
                    break;
                }
                
                //puzzle is valid, let's proceed!
                window.getFrame().dispose();
                SwingUtilities.invokeLater(new MainPuzzleWindow(puzzle));
                break;
        } 
    }
    
    public int confirm(String message){
        Object[] options = { "Yes", "No" };
        int choice = JOptionPane.showOptionDialog(null, message, "Warning",JOptionPane.DEFAULT_OPTION, 
                                                  JOptionPane.WARNING_MESSAGE, null, options, options[1]);
        return choice;
    }
    
    
    
}
