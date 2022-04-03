package dsa.with.shagun.leetcode.Array;

import java.util.Arrays;

public class NextPermutation {  // TC : O(n). For loop runs for n times, again for loop runs for n times, to reverse also it runs N times.O(n) +O(n)+O(n)
    //SC :O(1)
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 4, 3, 5})));
    }

    public static int[] nextPermutation(int[] nums) {
        //if (nums == null || nums.length <= 1) return;
        int indx1 = nums.length - 1;
        int indx2 = nums.length - 1;

        //Getting index of element to be swapped
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                indx1 = i - 1;
                break;
            } else {
                indx1--;
            }
        }

        if (indx1 >= 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[indx1] < nums[i]) {
                    indx2 = i;
                    break;
                } else {
                    indx2--;
                }
            }
            swap(nums, indx1, indx2);
        }
        reverse(nums, indx1 + 1, nums.length - 1);
        return nums;
    }

    private static void reverse(int[] nums, int i, int i1) {
        while (i < i1) {
            swap(nums, i++, i1--);
        }
    }

    private static void swap(int[] nums, int indx1, int indx2) {
        int temp = nums[indx1];
        nums[indx1] = nums[indx2];
        nums[indx2] = temp;
    }

    //Solution 2
/*    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        //Getting index of element to be swapped
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int i1) {
        while (i < i1) {
            swap(nums, i++, i1--);
        }
    }

    private void swap(int[] nums, int indx1, int indx2) {
        int temp = nums[indx1];
        nums[indx1] = nums[indx2];
        nums[indx2] = temp;
    }*/
}
