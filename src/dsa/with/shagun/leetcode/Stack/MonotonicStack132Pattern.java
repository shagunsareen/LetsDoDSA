package dsa.with.shagun.leetcode.Stack;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Stack;

public class MonotonicStack132Pattern {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3, 1, 4, 2}));
    }

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        //Approach 1: Brute Force , TC:O(n3) , SC : O(1)   --> lead to time limit exceeded error hence not the best solution
        /*for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;*/

        //Approach 2:  Better TC:O(n2) , SC : O(1) --> lead to time limit exceeded error hence not the best solution
        /*int minElement = nums[0];

        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (minElement < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
                minElement = Math.min(minElement, nums[j]); //because ith element should be less than jth element
            }
        }
        return false;*/

        //Approach 3 : whenever we want to store previous element we use stack, TC : O(n) ,SC : O(n)
        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < secondMax)
                return true; // if we get a num which is lesser than second max then it satisfies our condition 132 patter.
            while (!stack.isEmpty() && nums[i] > stack.peek()) {  // if stack top is lesser than ele then we have max ele updated & second max also updated. Also delete top as we have more greater value than that
                secondMax = Math.max(secondMax, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
