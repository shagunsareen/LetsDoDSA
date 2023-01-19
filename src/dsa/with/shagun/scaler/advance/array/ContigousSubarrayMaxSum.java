package dsa.with.shagun.scaler.advance.array;

public class ContigousSubarrayMaxSum {

    public int maxSubArray(final int[] A) {

        /*
        // Approach 1 : construct prefix sum array

        int[] pf = new int[A.length];
        pf[0] = A[0];

        for (int i = 1; i < A.length; i++) {  // TC: O(N)
            pf[i] = pf[i - 1] + A[i];
        }

        int sum = 0;
        int max = 0;
        for (int s = 0; s < A.length; s++) { // fix start
            for (int e = s; e < A.length; e++) {  // fix end
                if (s == 0) {
                    sum = pf[e];
                } else {
                    sum = pf[e] - pf[s - 1];
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max; // TC : O(N2),SC: O(N)
        */

        //Approach 2 : Using carry forward
        /*
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) { // sum variable will carry forward the value to next subarray so that sum can be calculated
                sum += A[j];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max; //TC: O(N2), SC: O(1) But this approach gives time limit exceeded error
         */

        //Approach 3 : Kadane's Algo TC: O(N), SC :O(1)
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;  // since sum can be negative as well if all the elements are negative

        for (int i = 0; i < A.length; i++) {
            currSum += A[i];  // keep on adding elements to a variable to get sum of elements of subarray

            if (maxSum < currSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {  // since we don't want to include negative elements in sum because max. subarray sum
                currSum = 0;
            }
        }

        return maxSum;
    }
}
