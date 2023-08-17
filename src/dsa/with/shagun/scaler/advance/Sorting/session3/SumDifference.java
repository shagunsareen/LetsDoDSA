package dsa.with.shagun.scaler.advance.Sorting.session3;

import java.util.Arrays;

public class SumDifference {
    public int solve(int[] A) {

        Arrays.sort(A);

        int mod = 1000000007;
        int n = A.length;

        long ans = 0;
        long maxSum = 0;
        long minSum = 0;

        for(int i=0; i<A.length; i++){

            //get the max contribution by taking maxSum of all max elements in all subsequences
            maxSum = (maxSum % mod + (long)(A[i] * (Math.pow(2, i)) % mod) % mod) % mod;

            minSum = (minSum % mod + (long)(A[i] * (Math.pow(2, n-i-1)) % mod) % mod) % mod;
        }

        return (int) (maxSum - minSum + mod) % mod;
    }
}
