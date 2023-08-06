package dsa.with.shagun.scaler.array.SlidingWindow;

public class SubArrSumK {

    public static void main(String[] args) {
        System.out.println(solve(new int[] {6, 3, 3, 6, 7, 8, 7, 3, 7 }, 2, 10));
    }

    public static int solve(int[] A, int B, int C) {

        int n = A.length;
        int present =0;

        // Find subarrays of length B first, start will range from 0 to n-B , end will range from B-1 to n-1
        int sum = 0;
        //get sum of first subarray
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        present =  checkSum(sum, C);
        if(present ==1){
            return present;
        }

        int start = 1;
        int end = B ;
        while (start <= n - B && end <= n - 1) {
            // n-B-0+1 = n-B+1 iterations i.e. n-B+1 subarrays of length B exists
            // now let's get sum of these subarrays

            //Approach 1 : Brute force -- iterate over each subarray and get sum then see if it's equal to C or not TC :  O(N2) N from outer loop and inner loop
            //Approach 2 : Prefix Sum -- construct sum and then see if sum is equal to C , TC : O(N) but SC: O(N)
            //Approach 3 : Carry Forward with sliding window , sum = sum - arr[start -1] + arr[end], TC : O(N), SC :O(1)

            //now get sum of all other subarrays
            sum = sum - A[start - 1] + A[end];
            start++;
            end++;

            present = checkSum(sum, C);
            if(present ==1){
                return present;
            }
        }
        return 0;
    }

    private static int checkSum(int sum, int C) {
        if (sum == C) {
            return 1;
        }
        return 0;
    }
}

