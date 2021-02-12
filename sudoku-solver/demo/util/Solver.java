/*
* Modified by @xbowery on 12/2/2021
*/

package util;

public class Solver {
    public static int[] NotAssigned(int[][] arr) { // To check for positions of unassigned position
        int[] na = new int[2];
        na[0] = -1;
        na[1] = -1;
 
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (arr[row][col] == 0) {
                    // get the position of the unassigned position
                    na[0] = row;
                    na[1] = col;
                    return na;
                }
            }
        }

        // return (-1, -1) if all rows and columns are filled
        return na;
    }

    // 3 conditions to check: Number not in row, number not in column, number not in 3x3 box

    public static boolean inRow(int[][] grid, int row, int num) { // check if number is already present in row
        for (int i = 0; i < grid[row].length; i++) {
            if (grid[row][i] == num) {
                // return false if number is already in row
                return false;
            }
        }
        return true;
    }

    public static boolean inColumn(int[][] grid, int col, int num) { // check if number is already used in column
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][col] == num) {
                // return false if number is already in column
                return false;
            }
        }
        return true;
    }

    public static boolean inBox(int[][] grid, int row, int col, int num) { // check if number is already used in box
        for (int i = (row / 3) * 3; i < ((row / 3) * 3) + 3; i++) { // get the start of the row index (multiple of 3)
            for (int j = (col / 3) * 3; j < ((col / 3) * 3) + 3; j++) { // get the start of the col index (multiple of 3)
                if (grid[i][j] == num) {
                    // return false if number is already in box
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] grid, int row, int col, int num) {
        return (inRow(grid, row, num) && inColumn(grid, col, num) && inBox(grid, row, col, num));
    }

    public static boolean Sudoku(int[][] grid) { // Backtracking Algorithm
        int[] na = NotAssigned(grid); // initialise the unassigned grid and find the empty values in the grid
        if (na[0] == -1) {
            // return true when all grids are filled in.
            return true;
        }
    
        int row = na[0];
        int col = na[1];
    
        // Set the limit of the range of numbers from 1 to 9
        for (int num = 1; num <= 9; num++) {
            // Check if grid is valid
            if (isValid(grid, row, col, num)) {
                // If valid, set the position with the correct number
                grid[row][col] = num;
                boolean check = Sudoku(grid); // Recursive method to check whether the whole grid has been set (no empty values in the grid)
                if (check == true) {
                    return true;
                }
                grid[row][col] = 0; // Set it to empty and reset the grid position if the conditions do not meet
            }
        }
        return false; // to allow the recursiveness of this method to allow all positions in the grid to be filled.
    }

    public static void printOriginal(int[][] arr, int N) {// prints the original sudoku before solving
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                if(arr[i][j]==0){
                    System.out.print(" " + "-"
                            + " ");
                }
                else {
                    System.out.print(" " + arr[i][j]
                            + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printFinal(int[][] arr, int N) {// prints the final sudoku after solving
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------|---------|----------");
            }
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + arr[i][j]
                        + " ");
            }
            System.out.println();
        }
    }
}
