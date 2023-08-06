package dsa.with.shagun.scaler.advance.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] res = slidingMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : res) {
            System.out.println(i);
        }
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] slidingMaximum(final int[] A, int B) {

        //Approach 1 : For every subarray of size k , get max of each subarray. Slide window and get max of each window
        //TC : O(N*k) since we will have to iterate k elements to get max for N subarrays

        //Approach 2 : Since we can see that moving to next window excludes previous element and includes next element,
        // This type of removal and insertion can be done by Dequeue.
        // Hence, we will maintain a DECREASING MONOTONIC DOUBLE ENDED queue
        // this will contain all possible elements which can be max for the window. In case current element is greater than last element in the queue then remove ele from queue
        // since that can't be max for window. Remove all smaller elements from the queue and push the current element if no more smaller elements are left in the queue
        // Return FRONT OF THE QUEUE AS MAX for the window.
        // Also, if the PREVIOUS ELEMENT TO BE REMOVED is present at front remove that as it is not required anymore.

        //Incase window size is greater than array length
        //TC : O(N),SC:O(N)

        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[A.length - B + 1];

        //Process first window of size k
        for (int i = 0; i < B; i++) {
            //remove smaller elements from deque
            while (!deque.isEmpty() && deque.peekLast() <= A[i]) {
                deque.pollLast();
            }
            deque.addLast(A[i]);  // once all the smaller elements are removed then push the current element
            if (i == A.length - 1) {  // if B>A.length
                return new int[]{deque.peekFirst()};
            }
        }

        if (!deque.isEmpty()) {
            ans[0] = deque.peekFirst();
        }

        //now process all other windows
        for (int i = 1; i <= A.length - B; i++) {
            //remove previous element -outgoing element
            if (!deque.isEmpty() && deque.peekFirst() == A[i - 1]) {
                deque.pollFirst();
            }

            //i-1 is removed, i+k-1 is added in window
            while (!deque.isEmpty() && deque.peekLast() < A[i+B-1]) {
                deque.pollLast();
            }
            deque.addLast(A[i+B-1]);  // once all the smaller elements are removed then push the current element


            if (!deque.isEmpty()) {
                ans[i] = deque.peek();
            }
        }
        return ans;
    }
}
