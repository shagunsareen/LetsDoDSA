package dsa.with.shagun.leetcode.PriorityQueue;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        //this is to store numbers as key and freq as it's elements
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // To get top k freq elements we need to get max freq on the top and return corresponding elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 1; i <= k; i++) {
            ans[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return ans;
    }
}
