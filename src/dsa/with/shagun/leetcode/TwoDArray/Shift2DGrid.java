package dsa.with.shagun.leetcode.TwoDArray;

import java.util.Arrays;
import java.util.List;

public class Shift2DGrid { //TC : O(n*n) SC:O(n*n)
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int total = row * col;
        int[][] ans = new int[row][col];

        k %= total; // This is just to avoid rotations for bigger values of K

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int nrow = i, ncol = j + k;
                if (ncol >= col) {
                    nrow += ncol / col;

                    if (nrow >= row) {
                        nrow %= row;
                    }
                    ncol %= col;
                }

                ans[nrow][ncol] = grid[i][j];
            }
        }
        return (List) Arrays.asList(ans);
    }
}
