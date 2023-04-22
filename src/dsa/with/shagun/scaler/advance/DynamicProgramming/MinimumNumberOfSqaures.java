package dsa.with.shagun.scaler.advance.DynamicProgramming;

public class MinimumNumberOfSqaures {
    //Approach : Iterative without dp table
    /*int count = Integer.MAX_VALUE;

    public int countMinSquares(int A) {

        if(A==0){
            return 0;
        }

        for(int j=1; j*j<=A; j++){ // loop will go until square of  loop var is less than number itself
            count = Math.min(count, countMinSquares(A-j*j)+1);
        }

        return count;
    }*/

    //Iterative with dp table
    //Approach : Iterative with dp table
    public int countMinSquares(int n) {
        int[] dp = new int[n + 1];

        // simple base case assignment
        dp[0] = 0;
        dp[1] = 1;

        //finding optimal answer for every 2<=i<=N in bottom-up manner
        for (int i = 2; i <= n; i++) {

            //for i answer will be always less than equal to i.
            //maximum possible number of squares : i = (1^1+1^1+1^1+.....+1^1, i times)
            dp[i] = i;

            //Now identify from which number we have to make a direct jump to N so that the required answer is minimised.
            //do this by considering every possible direct jump
            //number of iterations will be <= sqrt(i)
            for (int x = 1; x * x <= i; x++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
            }
        }

        //here we get our optimal answer
        return dp[n];
    }

    //Approach2 : with dp table , TC : O(N*rootN), SC:O(N+N) N for dp table and N for recursion array
    /*int[] dp;
    int ans = Integer.MAX_VALUE;

    public int countMinSquares(int A){
        dp = new int[A+1];  //because we would need N+1 spaces to store fibonacci values

        //initial value of each element is -1
        for(int i=0; i<=A; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        return getMinSquareCount(A);
    }

    private int getMinSquareCount(int A){
        if(A==0){
            return 0;
        }
        if(A==1){
            return 1;
        }

        if(dp[A]==Integer.MAX_VALUE){// we have not stored the value yet

            for(int j=1; j*j<=A; j++){ // loop will go until square of  loop var is less than number itself
                ans = Math.min(ans, getMinSquareCount(A-j*j)+1);
            }
            dp[A] = ans;
        }
        return dp[A];
    }*/
}
