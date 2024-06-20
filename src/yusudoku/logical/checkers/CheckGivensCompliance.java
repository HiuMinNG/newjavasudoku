
package yusudoku.logical.checkers;

import yusudoku.puzzle.Cell;
import yusudoku.puzzle.Puzzle;
import static yusudoku.logical.Solver.modFloor;

/**
 *
 * @author nathan
 */
public class CheckGivensCompliance implements Checker{
    private Puzzle puzzle;
    
    public CheckGivensCompliance(Puzzle puzzle){
        this.puzzle = puzzle;
    }
    
    @Override
    public void check() throws CheckerException{
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                int value = puzzle.getCellValue(i, j);
                if (value > 0){
                    if (rowHasMoreThanOneOf(i, value))
                        throw new CheckerException("One or more rows violates Su Doku rules.");
                    if (colHasMoreThanOneOf(j, value))
                        throw new CheckerException("One or more columns violates Su Doku rules.");
                    if (groupHasMoreThanOneOf(puzzle.getCell(i, j), value))
                        throw new CheckerException("One or more groups violates Su Doku rules.");
                }
            }
    }
    
    public boolean rowHasMoreThanOneOf(int row, int value){
        int counter = 0;
        for (int j = 0; j < 9; j++)
            if ( puzzle.getCellValue(row, j) == value)
                counter++;
        return counter > 1;
    }
    
    public boolean colHasMoreThanOneOf(int col, int value){
        int counter = 0;
        for (int i = 0; i < 9; i++)
            if ( puzzle.getCellValue(i, col) == value)
                counter++;
        return counter > 1;
    }
    
    public boolean groupHasMoreThanOneOf(Cell cell, int value){
    // Cell is in one of 9 different 3x3 groups.  We check all cells in cell's 
    // corresponding group to see if the query value is in one of them.
    
        // first we map cell's coordinates to the starting coordinates of our
        // group's top left member:
        int groupRowStart = modFloor(cell.getX(), 3);
        int groupColStart = modFloor(cell.getY(), 3);

        int counter = 0;
        for (int i = groupRowStart; i != groupRowStart + 3; i++)
            for (int j = groupColStart; j != groupColStart + 3; j++)
                if (puzzle.getCellValue(i, j) == value)
                    counter++;
        return counter > 1;
    }
}
