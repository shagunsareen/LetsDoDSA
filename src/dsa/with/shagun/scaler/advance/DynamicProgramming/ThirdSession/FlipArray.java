package dsa.with.shagun.scaler.advance.DynamicProgramming.ThirdSession;

import java.util.Arrays;

public class FlipArray {
    /*int[][] dp;

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A) {

        //First we need sum of entire array so that we know value of sum/2
        int sum = Arrays.stream(A).sum();
        int halfSum = sum/2; // we have to take min number of elements making total sum <= halfSum

        dp = new int[A.length][halfSum+1]; // since we need halfSum with the no. of elements given we are taking second column size to halfSum+1

        //Fill the array with -1
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        //since it is not necessary that the exact half sum is what will give us min. flips,
        //we can try out  all possible sum less than halfSum to see what can give us minFlips and max Sum
        int minAns = 0;
        for(int i=halfSum; i>=1; i--){
            int ans = flipArray(A.length-1, halfSum, A);
            minAns = Math.min(minAns, ans);
        }

        return minAns;
    }

    private int flipArray(int n, int sum, int[] arr){
        //FlipArray(i,j) denotes minimum elements required from 0..i to make sum exactly j.

        //Base case
        if(sum == 0){
            return 0;
        }

        if(n == -1){ // no. of elements used to get sum is full array length
            return arr.length + 1; //Flips cannot be more than arr.length
        }

        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        //either we can skip the element or we can consider the element to flip
        // but before we consider an element we need to check whether the sum required is greater or equal to that element.
        // if sum >= arr[n] then only it can make -sum >0 otherwise -ve sum would be greater than actual sum which is not required

        if(sum - arr[n] >= 0){
            //then check whether skipping the element will give us max -ve sum or considering the element would give us
            dp[n][sum] = Math.min(flipArray(n-1, sum, arr) , flipArray(n-1, sum-arr[n], arr)+1);
        }else{
            dp[n][sum] = flipArray(n-1, sum, arr);
        }

        return dp[n][sum];
    }*/

    public long flipArray(final int[] arr, int n, long[][] dp, int sum) {
        //FlipArray(i,j) denotes minimum elements required from 0  to i to make sum exactly j.
        //Base Case
        if (sum == 0) {
            return 0;
        }
        if (n == -1) {
            return arr.length + 1; //Flips cannot be more than arr.length
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        long ans = 0;
        if (sum - arr[n] >= 0) {
            ans = Math.min(flipArray(arr, n - 1, dp, sum - arr[n]) + 1, flipArray(arr, n - 1, dp, sum));
            //System.out.println("TAKEN : "+ ans + " - "+n+ " - "+sum);
        } else {
            ans = flipArray(arr, n - 1, dp, sum);
            //System.out.println("SKIPPED : "+ ans + " - "+n+ " - "+sum);
        }
        dp[n][sum] = ans;
        return dp[n][sum];
    }

    public int solve(final int[] A) {
        int sum = Arrays.stream(A).sum();
        int halfSum = sum / 2; //We have to take min number of elements making total sum <= halfSum
        long[][] dp = new long[A.length][halfSum + 1];
        for(int i = 0 ; i < dp.length ; ++i){
            Arrays.fill(dp[i],-1);
        }
        for (int i = halfSum; i >= 1; i--){
            int ans = (int) flipArray(A, A.length - 1, dp, i);
            //System.out.println(A.length + " - "+ i + " - "+ans);
            if (ans <= A.length) return ans; //Break if we have an answer close to halfSum
        }
        return -1;

    }
}
