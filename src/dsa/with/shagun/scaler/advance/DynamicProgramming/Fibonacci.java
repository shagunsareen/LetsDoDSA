package dsa.with.shagun.scaler.advance.DynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fibonacci(num));
    }

    static int[] dp;
    private static int fibonacci(int num){
        dp = new int[num+1];  //because we would need N+1 spaces to store fibonacci values

        //initial value of each element is -1
        for(int i=0; i<=num; i++){
            dp[i] = -1;
        }

        return getFibonnaci(num);
    }

    private static int getFibonnaci(int num){
        //Approach 1 : Memoization : DP with recursion + memory
        //TC : O(N+1)*O(1) i.e. no. of subproblems*time taken for each subproblem

       /* if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }

        if(dp[num] == -1){  // check if dp table already has value then don't calculate it again
            dp[num] = getFibonnaci(num-1) + getFibonnaci(num-2);
        }
        */

        //Approach 2 : Tabulation : DP with iteration + memory
        //TC : O(N), SC:O(N)
        /*dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=num; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[num];
        */

        //Approach 3 : Array not required, take 3 variables
        //TC : O(N), SC:O(1)
        int a = 0;
        int b = 1;
        int c = 0;

        if(num == 0){
            return a;
        }
        if(num == 1){
            return b;
        }
        for(int i=2; i<=num; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
