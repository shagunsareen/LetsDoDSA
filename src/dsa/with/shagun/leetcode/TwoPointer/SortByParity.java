package dsa.with.shagun.leetcode.TwoPointer;

import java.util.Arrays;

public class SortByParity {  // TC : O(n) SC : O(1)
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0,1})));
    }
    public static int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

            while(i<j){

                if(nums[i]%2!=0 && nums[j]%2==0){  // if left element is odd and right element is even then swap the values
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
                if(nums[i]%2==0){ // if even is on left keep it as left itself
                    i++;
                }
                if(nums[j]%2!=0){ // if odd is at right keep it at right itself
                    j--;
                }
            }
            return nums;
        }
}
