package dsa.with.shagun.scaler.advance.DynamicProgramming.SecondSession;

import java.util.Arrays;

public class UniquePathsTopDown {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] A) {

        //TOP DOWN APPROACH
        int n = A.length;
        int m = A[0].length;

        dp = new int[n][m];

        //fill array with -1
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return getUniquePaths(n-1, m-1, n, m,  A);
    }

    private int getUniquePaths(int row, int col, int rowLength, int colLength,  int[][] A){
        //System.out.println("Row : "+row+ " - "+" , Col : "+col);

        // incase if value is already calculated
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        if(A[row][col] == 1){ // i.e. this is an obstacle
            return 0;
        }

        if(row==0 && col==0){//since we have reached 0,0 from n,m hence mark it as 1
            return 1;
        }

        if(row == 0){
            return dp[row][col] = getUniquePaths(row, col-1, rowLength, colLength, A);
        }
        if(col == 0){
            return dp[row][col] = getUniquePaths(row-1, col, rowLength, colLength,  A);
        }

        return dp[row][col] = getUniquePaths(row-1, col, rowLength, colLength,  A) + getUniquePaths(row, col-1, rowLength, colLength, A);
    }


    //Bottom up
    /*

     public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length, m = A[0].length;
        return ways(A,n,m);
    }
        public int ways(int[][] A,int n,int m){
            int[][] dp = new int[n][m];
            if(A[0][0] == 1){
                dp[0][0] = 0;
            }
            else{
                dp[0][0] = 1;
            }

            //Setting 1st row
            for(int i=1;i<n;i++){
                if(A[i][0] == 1) {
                    dp[i][0] = 0;
                    }
                else{
                     dp[i][0] = dp[i-1][0];
                }
            }

            //Setting 1st coloumn
            for(int j=1;j<m;j++){
                if(A[0][j] == 1){
                    dp[0][j] = 0;
                }
                else{
                    dp[0][j] = dp[0][j-1];
                }
            }

            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(A[i][j] == 1){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i][j-1] + dp[i-1][j];
                    }
                }
            }
            return dp[n-1][m-1];
        }
    }
     */
}
