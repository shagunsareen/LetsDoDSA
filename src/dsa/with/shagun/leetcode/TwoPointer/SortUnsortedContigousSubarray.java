package dsa.with.shagun.leetcode.TwoPointer;

public class SortUnsortedContigousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
    }

    public static int findUnsortedSubarray(int[] nums) {

        //--Initial Thinking but this fails if input array is [1,3,2,2,2]
        /*int n = nums.length;
        int l = 0;
        int r = 0;

        // get min. index of subarray
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) { // if left element is greater than right element
                l = i;
                break;
            }
        }
        for (int j = n - 1; j > 0; j--) {
            if (nums[j] < nums[j - 1]) {  // if right element is less than left element
                r = j;
                break;
            }
        }
        return r - l > 0 ? r - l + 1 : 0;*/


        //Right Approach : --> Find max and min element in the subarray so that we can get exact length of subarray
        int n = nums.length;
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // get min. index of subarray
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) { // if left element is greater than right element this can be min. element of subarray
                min = Math.min(min, nums[i + 1]);
            }
        }
        for (int j = n - 1; j > 0; j--) {
            if (nums[j] < nums[j - 1]) {  // if right element is less than left element this can be max. element of subarray
                max = Math.max(max, nums[j - 1]);
            }
        }

        // Now that we have min. element and max. element of the subarray find at which index this has to be inserted
        for (l = 0; l < n - 1; l++) {
            if (min < nums[l])
                break;
        }

        for (r = n - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}
