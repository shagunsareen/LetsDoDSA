package dsa.with.shagun.scaler.advance.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopes {

    //TC : insert - NlogN, getMin - N*O(1), delete - NlogN
    //Total TC : Nlogn +N
    //SC : O(N)
    public int solve(ArrayList<Integer> A) {
        int sum = 0;

        //Step1: Insert all elements in the heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(A);

        while (minHeap.size() >= 2) {
            int firstMin = minHeap.poll();
            int secondMin = minHeap.poll();
            sum += firstMin + secondMin;
            minHeap.add(firstMin + secondMin);
        }
        return sum;
    }
}
