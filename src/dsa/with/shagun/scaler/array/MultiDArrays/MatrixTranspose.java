package dsa.with.shagun.scaler.array.MultiDArrays;

public class MatrixTranspose {
    public static void main(String[] args) {
        solve(new int[][]{{1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12}
                        });
    }

    public static int[][] solve(int[][] A) {
        /*int n = A.length;

        //printing lower triangular matrix
        for(int i=0; i<n; i++){ // rows
            for(int j=0; j<i; j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;*/

       /* int n = A.length;
        int m = A[0].length;

        int[][] result = new int[n][n];

        //printing lower triangular matrix
        for(int i=0; i<n; i++){ // rows
            for(int j=0; j<i; j++){
                result[j][i] = A[i][j];
                result[i][j] = A[j][i];
            }
        }
        return result;*/

        int row = A.length;
        int col = A[0].length;

        int[][] ans = new int[col][row];
        //because transpose is changing column to row and row to column. The no. of columns in initial array would now be number of rows in new array
        //and number of rows in initial array would be number of columns in new array.
        // Since in new array rows can go till number of cols in old array so we take outer loop as col.
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++)
                ans[i][j] =  A[j][i];
        }
        return ans;
    }
}
