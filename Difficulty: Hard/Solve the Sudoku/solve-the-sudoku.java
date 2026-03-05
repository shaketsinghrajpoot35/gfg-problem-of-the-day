import java.util.*;

class Solution {
    
    boolean isSudokuSolve = false;
    
    public void backtrack(int row, int col, int n, int[][] mat,
                          Set<Integer>[] rows,
                          Set<Integer>[] cols,
                          Set<Integer>[] boxes){
        
        int cell = mat[row][col];
        
        // Case 1: Cell already filled
        if(cell != 0){
            
            if(row == n-1 && col == n-1){
                isSudokuSolve = true;
                return;
            }
            
            else if(col == n-1){
                backtrack(row+1, 0, n, mat, rows, cols, boxes);
            } 
            
            else{
                backtrack(row, col+1, n, mat, rows, cols, boxes);
            }

            return;   // IMPORTANT
        } 
        
        // Case 2: Empty cell
        else{
            
            for(int d = 1; d <= 9; d++){
                
                if(rows[row].contains(d)) continue;
                if(cols[col].contains(d)) continue;
                
                int boxIdx = 3*(row/3) + (col/3);
                if(boxes[boxIdx].contains(d)) continue;
                
                // Place digit
                mat[row][col] = d;
                
                rows[row].add(d);
                cols[col].add(d);
                boxes[boxIdx].add(d);
                
                // Move to next cell
                if(row == n-1 && col == n-1){
                    isSudokuSolve = true;
                }
                
                else if(col == n-1){
                    backtrack(row+1, 0, n, mat, rows, cols, boxes);
                } 
                
                else{
                    backtrack(row, col+1, n, mat, rows, cols, boxes);
                }
                
                // If solution found stop recursion
                if(isSudokuSolve) return;
                
                // Backtrack
                mat[row][col] = 0;
                rows[row].remove(d);
                cols[col].remove(d);
                boxes[boxIdx].remove(d);
            }
        }
    }
        
    
    public void solveSudoku(int[][] mat) {
        
        isSudokuSolve = false;
        
        int n = mat.length;
        
        @SuppressWarnings("unchecked")
        Set<Integer>[] rows = (Set<Integer>[]) new HashSet[n];
        @SuppressWarnings("unchecked")
        Set<Integer>[] cols = (Set<Integer>[]) new HashSet[n];
        @SuppressWarnings("unchecked")
        Set<Integer>[] boxes = (Set<Integer>[]) new HashSet[n];
        
        for(int i = 0; i < n; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        // Initialize sets with existing numbers
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                
                int cell = mat[i][j];
                
                if(cell != 0){
                    
                    rows[i].add(cell);
                    cols[j].add(cell);
                    
                    int boxIndex = 3*(i/3) + (j/3);
                    boxes[boxIndex].add(cell);
                }
            }
        }
        
        backtrack(0, 0, n, mat, rows, cols, boxes);
    }
}