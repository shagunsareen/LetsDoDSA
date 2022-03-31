package dsa.with.shagun.leetcode.BinarySearch;

//TC : N*Log(S) where N is no. of elements traversed to get count of subarrays and log(S) for BS
//SC : O(1) as no extra space is used.

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        // To apply Binary Search, we need to have low and high .
        // To get min sum we can have one element in one sub-array which can have maxvalue so that sum of second subarray is of min value

        int low = 0;
        int high = 0;
        int ans = 0;
        for (int element : nums) {
            low = Math.max(element, low);
            high = high + element;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getValidSubArrayCount(mid, nums) <= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int getValidSubArrayCount(int mid, int[] arr) {
        int count = 1;  // there will be minimum one subarray hence count =1
        int totalRunningSum = 0;
        for (int ele : arr) {
            if (totalRunningSum + ele <= mid) {
                totalRunningSum += ele;
            } else {
                count++;
                totalRunningSum = ele;
            }
        }
        return count;
    }
}
