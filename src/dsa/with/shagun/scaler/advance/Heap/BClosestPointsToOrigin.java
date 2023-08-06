package dsa.with.shagun.scaler.advance.Heap;

import java.util.PriorityQueue;

public class BClosestPointsToOrigin {

    //TC : O(N*logB) , SC : O(B)
    public int[][] solve(int[][] A, int B) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>
                ((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        // if b<a then this is increasing order which is opposite of required. hence return -1
        // if b>a then this is decreasing order which is correct order .hence return 1

        //add all elements and start popping when size of maxHeap > B so that we should delete max element
        for (int[] a : A) {
            maxHeap.add(a);

            if (maxHeap.size() > B) {
                maxHeap.poll(); //remove the max value
            }
        }

        int[][] res = new int[B][2];

        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }

        return res;
    }
}