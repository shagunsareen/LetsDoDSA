package dsa.with.shagun.leetcode.TwoDArray;

import java.util.Scanner;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int x = scn.nextInt();
        System.out.println(searchMatrix(arr, x));
    }

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

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

       /* Approach 2
         TC = O(log(n*m) since binary search is done on a matrix with n*m elements Hence log of total elements ,
         SC : O(1)
       */
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[mid / m][mid % m]) {
                return true;
            } else if (target > matrix[mid / m][mid % m]) {
                low = mid + 1;
            } else {
                high = low - 1;
            }
        }
        return false;
    }
}
