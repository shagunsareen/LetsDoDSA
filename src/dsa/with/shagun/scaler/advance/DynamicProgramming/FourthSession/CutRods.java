package dsa.with.shagun.scaler.advance.DynamicProgramming.FourthSession;

public class CutRods {

    public int solve(int[] A) {


        //take dp array to store max value a length of rod i can have with 1 to j options
        //dp[i][j] will store max value we can have for length i rod that can be achieved if we choose 1 to j options

        int n = A.length;
        int[][] dp = new int[n + 1][n + 1];

        //since for i=0 , value will be 0 for all options we consider
        //since for j=0, value will be 0 for any length rod we have to achieve hence make these 0

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        //now for all rest of length rods we need to fill values
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {  // since for values which are greater than i, we can't consider j values hence loop runs only till i
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - j][j] + A[j - 1]); //since price of length n is stored at n-1 index hence j-1 is used to access A array
            }
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[n][n];
    }
}

