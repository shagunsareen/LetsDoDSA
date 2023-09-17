package dsa.with.shagun.scaler.advance.Queue.Revision;

import java.util.ArrayDeque;
import java.util.Deque;

public class PerfectNumbers {
    public String solve(int A) {

        //insert 1 and 2 to the queue so that we can take the reverse of them and then create a new number out of them
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("1");
        deque.offer("2");

        if(A==1){
            return deque.peek() + (new StringBuilder(deque.peek()).reverse());
        }

        StringBuilder str = null;

        while(A > 0){
            //store the resultant string/perfect number into this string
            str = new StringBuilder("");

            //this is the way to generate next element with the help of the current top element of the queue
            String firstEle = deque.peek();
            deque.offer(firstEle + "1");
            deque.offer(firstEle + "2");

            str.append(deque.peek() + (new StringBuilder(deque.peek()).reverse())); // this generates the actual perfect number
            deque.remove(); //this removes the first element of the deque.
            A--;
        }

        return str.toString();
    }
}
