package dsa.with.shagun.scaler.advance.DynamicProgramming.SecondSession;

public class NDigitNumBottomUp {
    public int solve(int A, int B) {

        //BOTTOM UP APPROACH
        // We know that if digit is 1 and sum <=9 then it is possible i.e. we return 1 else let it be as is
        // We will add up this count returned from all possibilities at each place of number and store that count in dp array so that it can be used for future purpose

        if(A==0){
            return 0;
        }

        int mod = 1000000007;

        int[][] dp = new int[A+1][B+1];

        //since we have just 1 deduction that if digit is 1 then sum can be between 1 to 9. We are filling those values as 1
        for(int sum=1; sum<=9 && sum<=B; sum++){
            dp[1][sum] = 1;
        }

        //for rest of the possibilities we use iterative method
        for(int digit = 2; digit < dp.length; digit++){
            for(int sum = 1; sum < dp[0].length; sum++){

                //for each cell, we have to see what if we take each possible digit
                for(int choice=0; choice<=9; choice++){
                    if(sum >= choice){
                        dp[digit][sum] = (dp[digit][sum]%mod +  dp[digit-1][sum-choice]%mod)%mod;
                    }
                }
            }
        }
        return dp[A][B]%mod;
    }
}
