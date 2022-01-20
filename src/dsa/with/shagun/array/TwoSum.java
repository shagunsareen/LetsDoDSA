package dsa.with.shagun.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /** Brute Force - TC : O(n2) SC : O(1) **/
    /*public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return result = new int[]{i, j};
                }
            }
        }
        return result;
    }*/

    /**
     * O(n) using Map TC : O(n) SC : O(n)
     **/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{5, 6, 4, 6}, 9);
        if (result.length != 0) {
            System.out.println(result[0] + "-" + result[1]);
        }
    }
}
