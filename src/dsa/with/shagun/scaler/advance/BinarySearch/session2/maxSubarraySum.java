package dsa.with.shagun.scaler.advance.BinarySearch.session2;

public class maxSubarraySum {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 2, 5, 4, 6, 3, 7, 2},20));
    }

    // return max K such that max. subarray sum of length k<=B
    //TC : O(NlogN) where N is for getting subarray sum and logN for binary search on length K values
    public static int solve(int[] A, int B) {
        int l = 0;
        int n = A.length;
        int r = n - 1;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;  // This is the length of subarray that we need to take the sum of i.e.k
            if (maxSubArrSum(A, mid) <= B) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else { // this is when sum > B
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int maxSubArrSum(int[] A, int k) {
        int n = A.length;
        int sum = 0; //first iterate and get sum of first subarray
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += A[i];
            maxSum = sum;
        }

        //now let's get sum of each subarray with length k and return max sum
        int start = 1;
        int end = k;
        while (start <= n - k && end <= n - 1) {
            sum = sum - A[start - 1] + A[end];
            start++;
            end++;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
