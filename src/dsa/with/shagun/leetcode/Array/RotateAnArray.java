package dsa.with.shagun.leetcode.Array;

//Q:189
public class RotateAnArray {
    public void reverse(int[] a, int i, int j) {
        int li = i;
        int ri = j;
        int temp = 0;
        while (li < ri) {
            temp = a[ri];
            a[ri] = a[li];
            a[li] = temp;

            li++;
            ri--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k < 0) {
            k += nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k , nums.length - 1);
    }
}
