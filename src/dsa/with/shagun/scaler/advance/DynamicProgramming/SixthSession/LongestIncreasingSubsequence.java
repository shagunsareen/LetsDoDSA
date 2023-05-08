package dsa.with.shagun.scaler.advance.DynamicProgramming.SixthSession;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {

        int n = A.length;
        //Initialise dp array with 1 since every digit will be a subsequence in itself
        int[]  lis = new int[n];
        Arrays.fill(lis, 1);

        //For every element check on it's left if digit is smaller that means lis[smaller] + 1 = lis[current]
        for(int i=0; i<n; i++){
            //check on it's left
            for(int j=0; j<i; j++){
                //check if current ele is greater than elements on left than it can be a LIS
                if(A[i] > A[j]){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        //Get the max value of the lis from lis array
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(lis[i]> max){
                max = lis[i];
            }
        }

        return max;
    }
}
