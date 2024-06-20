
package yusudoku.logical.checkers;

import yusudoku.logical.Solver;
import yusudoku.puzzle.Puzzle;

/**
 *
 * @author nathan
 */
public class CheckUniqueSolution implements Checker{ 
    //Naive approach to checking if a unique solution exists for a puzzle.
    //This method will MISS rotationally symmetric puzzles!!
    
    private Puzzle puzzle;
    
    public CheckUniqueSolution(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
    
    @Override
    public void check() throws CheckerException{
        Puzzle orientation0 = puzzle.clone();
        Solver solveOrientation0 = new Solver(orientation0);
        if(!solveOrientation0.hasAnySolution())
            throw new CheckerException("Puzzle has no solution!");
        
        Puzzle solvedPuzzle0 = solveOrientation0.getSolution();
        
        Puzzle orientation1 =  puzzle.clone();
        orientation1.rotatePuzzleCCW90();
        Solver solveOrientation1 = new Solver(orientation1);
        Puzzle solvedPuzzle1 = solveOrientation1.getSolution();
        solvedPuzzle1.rotatePuzzleCCW270(); //to line it back up with original for comparison
        
        Puzzle orientation2 =  puzzle.clone();
        orientation2.rotatePuzzleCCW180();
        Solver solveOrientation2 = new Solver(orientation2);
        Puzzle solvedPuzzle2 = solveOrientation2.getSolution();
        solvedPuzzle2.rotatePuzzleCCW180(); //to line it back up with original for comparison
        
        Puzzle orientation3 =  puzzle.clone();
        orientation3.rotatePuzzleCCW270();
        Solver solveOrientation3 = new Solver(orientation3);
        Puzzle solvedPuzzle3 = solveOrientation3.getSolution();
        solvedPuzzle3.rotatePuzzleCCW90(); //to line it back up with original for comparison
        
        if (solvedPuzzle0.equals(solvedPuzzle1) &&
            solvedPuzzle1.equals(solvedPuzzle2) &&
            solvedPuzzle2.equals(solvedPuzzle3)   )
            ;
        else{
            throw new CheckerException("Puzzle has multiple solutions!");
        }
        
    }
}
