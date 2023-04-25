package dsa.with.shagun.scaler.advance.DynamicProgramming.SecondSession;

public class NDigitNumbers {
    public int solve(int A, int B) {
        //A - no. of digits, B - expected sum of the digits
        //CHECK OPTIONS :  present at each place to fill the digits with. Since we can fill a place with 0-9 we have to iterate with a loop considering every digit at a place and get the check if it helps to get desired sum
        // TOP DOWN -----> Recursive approach where we will call f(n-1, s-d) and this will go till n=1. Each recursive call will return 1 or 0 and it is stored in ans and summed up for every digit possible for that place
        // BOTTOM UP -----> Iterative approach where we get consider that for n=0 ans =0, n=1 ans=1,for others we consider all options for f(n-1 ,sum-d) until sum > d
        // BASE CASES ------> for n=1 and n=0 cover base cases


        //*********** TOP DOWN APPROACH ***********

        int[][] dp = new int[A+1][B+1]; //since there are n*s posibilities hence we need to store that many values for which we require 2D matrix

        //initialise value of each element as -1 this will help us to track whether value is already calculated or not
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        // for(int i=1; i<=A; i++){
        //     dp[A][0] = 0;  // if required sum is 0 then return 0
        // }

        // for(int i=0; i<=B; i++){
        //     dp[0][i] = 0;  // if no. of digits is 0 then return 0
        // }

        // for(int i=1; i<=9; i++){
        //     if(i < dp.length){
        //         dp[1][i] = 1;   // when required sum if between 1 to 9 then return 1
        //     }
        // }

        // for(int i=10; i<=B; i++){
        //     dp[1][i] = 0;  // when with 1 digit sum is not achievable

        // }

        return getRes(A,B, dp);
    }
    int mod = (int)1e9+7;

    private int getRes(int A, int B, int[][] dp){

        if(A==0 && B==0){
            dp[A][B] = 1;
            return 1;
        }

        if(A<=0 || B<=0) return 0;

        if(A==1 && B <=9){
            dp[A][B] = 1;
            return 1;
        }

        if(dp[A][B] != -1){ // if ans is already calculated
            return dp[A][B];
        }

        int ans =0;
        for(int d=0; d<=9; d++){ // since we can have either of the 9 digits at one place
            if(B > d){
                ans = (ans%mod + getRes(A-1, B-d, dp)%mod)%mod;
            }
        }

        dp[A][B] = ans%mod;
        return dp[A][B]%mod;
    }
}
