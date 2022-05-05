package dsa.with.shagun.leetcode.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MaxNumOfKSumPairs {  //TC : O(n), SC: O(n)
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();  // to store elements and it's frequency
        int count = 0; // as we need to return no. of operations that can be performed

        for (int x : nums) {
            int res = k - x;
            if (map.containsKey(res)) { // increment count if we found sum pair, check freq of element if it is 1 then remove otherwise decrement by 1
                count++;
                int freq = map.get(res);
                if (freq == 1) { // one match is found hence remove the element from map
                    map.remove(res);
                } else {
                    map.put(res, freq - 1);  // if more such element is present then decrement the frequency by 1
                }
            } else { // if we don't get the pair then insert element in map with updated frequency
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        return count;
    }
}
