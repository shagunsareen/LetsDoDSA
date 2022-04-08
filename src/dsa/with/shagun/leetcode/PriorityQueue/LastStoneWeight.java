package dsa.with.shagun.leetcode.PriorityQueue;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 1, 8, 1, 4, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        //Here we are using Int Comparator which gives decreasing order as we are doing b-a
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        // Add all the stones to Max.Heap as we need max 2 stones everytime
        for (int i : stones) {
            pq.add(i);
        }

        //Get the max 2 elements as pop returns top element of Max. Heap
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int ans = first - second;
            if (ans != 0)
                pq.add(ans);
        }

        // If there is one element in max. heap then return top element otherwise if there is no element then return zero
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
