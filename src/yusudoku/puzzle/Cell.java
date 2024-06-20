
package yusudoku.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author nathan
 */

//Cells make up the 9x9 sudoku puzzle.  Each cell has a value, coordinate pair
//represented by (x,y), and a sudoku index number.
//  "Sudoku index number" definition:  each of the 81 cells of the puzzle are given
//  a unique value from 0 to 80 inclusive, assigned in order from top left corner, 
//  going from left to right, top to bottom.  Top left corner is 0, bottom left
//  corner is 80.  There is a mathematical mapping from the (x,y) coordinate pair 
//  to the sudoku index number--the method sudokuIndex exploits this mapping
//  to provide the sudoku index number.

public class Cell {
    private List<Integer> possibilities = new ArrayList<>(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9}));
    protected int x;
    protected int y;
    private int value;
    
    public Cell(int x, int y) {
        this(x, y, 0); //0 means no value has been assigned to this cell
    }
    
    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int sudokuIndex(){//see note at top for explanation.
        return x * 9 + y;
    }
    
    public List<Integer> getPossible() {
        return possibilities;
    }
    
    public void removePossibility(int value){
        Iterator<Integer> itr = possibilities.iterator();
        while(itr.hasNext()){
            if(itr.next().intValue() == value)
                itr.remove();
        }
    }
    
    public void setPossibilities(List<Integer> poss){
        this.possibilities = poss;
    }
    
    @Override
    public Cell clone(){
        try{
            return new Cell(x, y, value);
        } catch (NullPointerException e){
            return new Cell(x, y, value);
        }
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
