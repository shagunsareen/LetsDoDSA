package dsa.with.shagun.leetcode.TwoDArray;

public class RotateImage {   // TC: O(n2)
    public void rotate(int[][] matrix) {
        //Rotate by diagonal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Rotate by middle column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (matrix[0].length)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1] = temp;
            }
        }
    }
}
