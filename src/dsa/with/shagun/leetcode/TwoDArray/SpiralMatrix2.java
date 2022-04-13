package dsa.with.shagun.leetcode.TwoDArray;

import java.util.Arrays;

public class SpiralMatrix2 {  //TC : O(n*n) , SC: O(1)
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rs = 0;
        int cs = 0;
        int re = n - 1;
        int ce = n - 1;
        int start = 1;
        int end = n * n;

        while(start<=end){
            //top wall
            for (int i = cs; i <= ce && start <= end; i++) {
                matrix[rs][i] = start;
                start++;
            }
            rs++;

            //right wall
            for (int i = rs; i <= re && start <= end; i++) {
                matrix[i][ce] = start;
                start++;
            }
            ce--;

            //bottom wall
            for (int i = ce; i >= cs && start <= end; i--) {
                matrix[re][i] = start;
                start++;
            }
            re--;

            //left wall
            for (int i = re; i >= rs && start <= end; i--) {
                matrix[i][cs] = start;
                start++;
            }
            cs++;
        }
        return matrix;
    }
}
