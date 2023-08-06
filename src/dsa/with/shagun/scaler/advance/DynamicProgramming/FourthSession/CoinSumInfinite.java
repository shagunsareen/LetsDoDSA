package dsa.with.shagun.scaler.advance.DynamicProgramming.FourthSession;

import java.util.Arrays;

public class CoinSumInfinite {
    int[][] dp;
    int mod = 1000007;

    public int coinchange2(int[] A, int B)
    {
        int n = A.length;
        dp = new int[B+1][n+1];  // will store no. of ways to get sum B with choice of coins n

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return getWaysCount(B, n, A)%mod;
    }

    private int getWaysCount(int sum, int index, int[] coinArr){

        //base case
        if(sum==0 && index==0){
            return 1;
        }

        // if sum is achieved
        if(sum == 0){
            return 1;
        }

        //if no coin is picked and coinIndex goes negative
        if(index <= 0){
            return 0;
        }

        if(dp[sum][index] != -1){
            return dp[sum][index];
        }

        if(sum >= coinArr[index-1]){
            dp[sum][index] = getWaysCount(sum, index-1, coinArr)%mod + getWaysCount(sum-coinArr[index-1], index, coinArr)%mod;
        }else{
            dp[sum][index] = getWaysCount(sum, index-1, coinArr)%mod;
        }

        return dp[sum][index]%mod;
    }
}
