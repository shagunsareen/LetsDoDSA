package dsa.with.shagun.scaler.advance.Queue.Revision;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {

        //Approach 1 : Find max of each subarray of size B but this will take TC: O(n*b), where n are the number of subarrays and b is the window size

        //Approach 2 : We need to know what was the max for the last window and we need previous window elements and incoming window elements, to keep all this we can use double ended deque so that we can maintain an order as to when what was the max value
        //Delete the elements smaller than the current element from the deque. Keep the max elements in the queue
        //Insert the incoming elements at the end of the queue and delete elements from the start of the queue if those are outgoing elements
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[A.length - B + 1];

        //let's check for first window
        for(int i=0; i<B; i++){

            //remove the smaller elements from the queue if the current element is greater since that will be max
            while(!deque.isEmpty() && deque.peekLast() <= A[i]){
                deque.pollLast();
            }

            deque.addLast(A[i]); // once all smaller elements are removed let's push the current element

            //edge case , if B is more than the length of the window
            if(i == A.length-1){
                return new int[]{deque.peekFirst()};
            }
        }

        //store the ans for first window
        if(!deque.isEmpty()){
            ans[0] = deque.peekFirst();
        }


        //let's check for the other windows now
        for(int i=1; i <= A.length-B; i++){

            //check for outgoing element, if that was the max element then delete it from the queue
            if(!deque.isEmpty() && deque.peekFirst() == A[i - 1]){
                deque.pollFirst();
            }

            //check for the incoming element, if in queue we have smaller elements then delete those
            while(!deque.isEmpty() && deque.peekLast() < A[i + B - 1]){
                deque.pollLast();
            }

            deque.addLast(A[i+B-1]); //add the incoming element

            if(!deque.isEmpty()){
                ans[i] = deque.pollFirst();
            }
        }

        return ans;
    }
}
