package dsa.with.shagun.scaler.array.PrefixSum;

public class EquilibriumIndex {

    public int solve(int[] A) {
        /*--------let's construct prefix array since we need left sum and right sum
            left sum = sum from 0 to i-1 ---> prefixSum[i-1]
            right sum = sum from i+1 to N-1 ---> prefixSum[N-1] - prefixSum[i]
       */
        int[] prefixSumArr = new int[A.length];
        prefixSumArr[0] = A[0];

        for (
                int i = 1;
                i < A.length; i++) {  // TC : O(N)
            prefixSumArr[i] = prefixSumArr[i - 1] + A[i];
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int j = 0; j < A.length; j++) {  //TC : O(N)
            if (j == 0) {
                leftSum = 0;
            } else {
                leftSum = prefixSumArr[j - 1];
            }

            if (j == A.length - 1) {
                rightSum = 0;
            } else {
                rightSum = prefixSumArr[A.length - 1] - prefixSumArr[j];
            }

            if (leftSum == rightSum) {
                return j;
            }
        }

        return -1;
        //TC : O(N+N) = O(2N) = O(N)
        //SC : O(N)
    }
}
