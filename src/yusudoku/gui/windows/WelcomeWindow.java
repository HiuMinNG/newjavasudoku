
package yusudoku.gui.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import yusudoku.gui.listeners.MenuOperation;
import yusudoku.gui.listeners.WelcomeMenuButtonListener;

/**
 *
 * @author nathan
 */
public class WelcomeWindow extends ApplicationWindow{
    
    @Override
    public void createPuzzlePanel() {
        //Following Block puts message into cells
        char[] welcomeMessage = "WELCOMETOYUSUDOKU!".toCharArray();
        int[] welcomeIndices = new int[] {10,11,12,13,14,15,16,30,31,45,46,47,48,49,50,51,52,53};
        Map<Integer, Character> indexToChar = new HashMap<Integer, Character>();
        for (int i = 0; i < welcomeIndices.length; i++)
            indexToChar.put(welcomeIndices[i], welcomeMessage[i]);
        
        //create the actual puzzle panel with the message from above
        JPanel panel = new JPanel(new GridLayout(9, 9));
        JTextField cell;
        Character cellValue;
        Border border;
        for (int i = 0; i < 81; i++){
            cellValue = indexToChar.get(i);
            
            if (cellValue != null){//something to put in the cell
                cell = new JTextField(cellValue + "");
                cell.setFont(new Font("SansSerif", Font.BOLD, 20));
                cell.setEnabled(false);
                cell.setDisabledTextColor(Color.RED);
            }
            else{//nothing to put in the cell
                cell = new JTextField();
                cell.setEnabled(false);
            }
            
            cell.setHorizontalAlignment(JTextField.CENTER);
            border = BorderFactory.createMatteBorder(CellBorder.Top(i), 
                                                     CellBorder.Left(i),
                                                     CellBorder.Bottom(i),
                                                     CellBorder.Right(i), 
                                                     Color.BLACK);
            cell.setBorder(border);
            panel.add(cell);
        }
        super.puzzlePanel = panel;
    }
    
    @Override
    public void createMenuPanel() {
        //New Puzzle
        JPanel menuPanel = new JPanel(new GridLayout(2, 1));
        JLabel welcomeMessage = new JLabel("Let's play some YuSuDoKu!");
        menuPanel.add(welcomeMessage);
        
        JButton newpuzzle = new JButton("New Puzzle");
        newpuzzle.addActionListener(new WelcomeMenuButtonListener(MenuOperation.NEW, this));
        menuPanel.add(newpuzzle);
        
        super.menuPanel = menuPanel;
    }
}
