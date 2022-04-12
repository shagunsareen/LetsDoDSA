package dsa.with.shagun.leetcode.TwoDArray;

import java.util.Arrays;

public class GameOfLife {  //TC : O(n*n) SC:O(1)
    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(gameOfLife(new int[][]{{1, 1}, {1, 0}})));
    }

    public static int[][] gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[] x = {1, 1, 0, -1, -1, -1, 0, 1};   // x-axis values
        int[] y = {0, 1, 1, 1, 0, -1, -1, -1};   // y-axis values

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int ones = 0;
                for (int k = 0; k < 8; k++) { // To check zeros count and ones count in all the 8 directions for an element
                    int ni = i + x[k];
                    int nj = j + y[k];
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 3) {
                            ones++;
                        }
                    }
                }

                //update game board checking the values of neighbours
                if (board[i][j] == 1) {
                    //check no. of ones and zeros to update cell
                    if (ones < 2 || ones > 3) {
                        board[i][j] = 3; // Update value to 3 instead of 0 i.e. 1-->3 instead of 1-->0 because we have work in same array
                        //meaning initial value was 1 wherever 3 is updated
                    }
                } else {
                    if (ones == 3) {
                        board[i][j] = 2; // Update value to 2 instead of 1 i.e. 0-->2 instead of 0-->1 because we have to work in same array
                        //meaning initial value was 0 wherever 2 is updated
                    }
                }
            }
        }

        //Reverting intermittent values to zero and one
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
        return board;
    }
}
