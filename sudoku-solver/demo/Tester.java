/*
* Modified by @xbowery on 12/2/2021
*/

package demo;

import util.*;


public class Tester {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 0, 0, 0, 5, 0, 0, 0},
                {5, 0, 0, 7, 0, 0, 0, 0, 2},
                {0, 0, 0, 2, 0, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 1, 0, 0, 0, 0, 0, 8, 7},
                {0, 0, 7, 0, 6, 0, 0, 1, 0},
                {0, 5, 0, 4, 0, 0, 0, 0, 0},
                {3, 4, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 6, 3, 0, 5}};
        System.out.println("ORIGINAL PUZZLE : ");
        Solver.printOriginal(arr, arr.length);
        Solver.Sudoku(arr);
        System.out.println("AFTER SOLVING : ");
        Solver.printFinal(arr, arr.length);

    }
}
