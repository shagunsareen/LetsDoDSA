package dsa.with.shagun.leetcode.TwoDArray;

public class SearchInSortedMatrix2 {
    // In this question since rows and columns both are sorted hence we can't consider it as a sorted 1D Matrix and Binary Search can't be applied
    //Hence, we go with divide and conquer

    public static boolean searchMatrix(int[][] matrix, int target) {
        //Approach 1  : TC = O(n+m) SC : O(1)
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
