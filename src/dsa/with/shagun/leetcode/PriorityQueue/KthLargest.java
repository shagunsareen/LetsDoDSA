package dsa.with.shagun.leetcode.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargest { //TC : O(N * LogK) because we are adding N elements in a heap of size k. As removing top element is of complexity O(1) hence max if k is 1 then N-k elements have to  eb removed to get heap of size k i.e. O(n) +nlogk ~= nlogk
    // SC : O(k)
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
