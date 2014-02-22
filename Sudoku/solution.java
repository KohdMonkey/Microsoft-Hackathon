/*
@author Tuan A. Tran
*/
import java.util.*;
import java.io.*;
import java.util.Map;

public class Sample {
		

    /**
      Solves sudoku puzzle using recursion
      @param i the row index
      @param j the column index
      @param cells the 2d array representing the puzzle
      @return true if the puzzle can be solved, false otherwise
    */ 
    static boolean solve(int i, int j, int[][] cells) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return true;
        }
        
        //If the cell is already filled!
        if (cells[i][j] != 0) 
            return solve(i+1,j,cells);

             
        for (int val = 1; val <= 9; ++val) {
            if (legal(i,j,val,cells)) {
                cells[i][j] = val;
                if (solve(i+1,j,cells))
                    return true;
            }
        }
        cells[i][j] = 0; 
        return false;
    }//end funct

    
    /**
      checks whether a move being made is valid
      @param i the row index
      @param j the column index
      @param val the value to be placed at that position
      @param cells the 2d array representing the puzzle
      @return true if the move can be made, false otherwise
    */
    static boolean legal(int i, int j, int val, int[][] cells) {
        //if the row already contains that value
        for (int k = 0; k < 9; ++k)  
            if (val == cells[k][j])
                return false;
        
        //if the column already contains that value
        for (int k = 0; k < 9; ++k) 
            if (val == cells[i][k])
                return false;

        int boxRowOffset = (i / 3)*3; //if row index = 8, 8/3 = 2 * 3 = 6.
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k)
            for (int m = 0; m < 3; ++m)
                if (val == cells[boxRowOffset+k][boxColOffset+m])
                    return false;
        return true; 
    }//end function

    /**
      Parses an array of input strings into an integer grid for the puzzle
      @param puzzle the strings that make up the sudoku puzzle read from input
      @return 2d integer array of the sudoku puzzle. 
    */
    static int[][] parseSudoku(String[] puzzle) {
        int[][] board = new int[9][9]; // default 0 vals
        int length = puzzle[0].length(); //only need to get the length once
        String temp = "";
        int j;//column index
        int x;//string position index
        for (int i = 0; i < 9; i++) {
            x = 0;
            j = 0;
        	while(x <= length){
        		temp = puzzle[i].substring(x, x + 1);        		
        		if(temp.charAt(0) != 'x'){
        			board[i][j] = Integer.parseInt(temp);
        		}
        		j++;
        		x += 2;
        	}        	
        }
        return board;
    }//end funct
	
    
    
    /**
      writes the solved sudoku puzzle back onto a file
      @param solution the solved sudoku puzzle
      @param writer the PrintWriter object created in main
    */
    static void writeMatrix(int[][] solution, PrintWriter writer) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                writer.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0)  writer.print("| ");
                writer.print(solution[i][j] == 0 ? " " : Integer.toString(solution[i][j]));
                writer.print(' ');
            }
            writer.println("|");
        }
        writer.println(" -----------------------");
    }
    
    
    
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt");
		
		int i;
		boolean moreMatrices = true; 
		
		String[] inputPuzzle = new String[9];
		int[][] sudoku;
		String temp = ""; 
		
		do{
			for(i = 0; i < 9; i++){
				inputPuzzle[i] = reader.readLine();				
			}			
			
			sudoku = parseSudoku(inputPuzzle);
			
			if (solve(0,0,sudoku))   
	           writeMatrix(sudoku, writer);
	       else
	           writer.println("NO SOLUTION");
			
			temp = reader.readLine();
			if(temp == null)
				moreMatrices = false;			
		}while(moreMatrices);
		writer.close();
	}//end main
}//end class
