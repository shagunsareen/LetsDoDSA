package dsa.with.shagun.leetcode.DataStructuresImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    class MyStack {
        // Approach 1 : TC : push ->O(n), pop ->O(1), SC : O(n)
        /*Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList();
            q2 = new LinkedList();
        }

        public void push(int x) {
            // insert new element to q2
            q2.add(x);

            // insert all elements of q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.remove();  // remove will not throw exception if queue is empty
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }*/

        //Approach 2 : TC :O(1) ,SC : O(1) using single queue
        Queue<Integer> q1;

        public MyStack() {
            q1 = new LinkedList();
        }

        public void push(int x) {
            q1.add(x);
            int s = q1.size();
            while (s > 1) { // because q1.size ==1 will anyways return same element which we want to pop or get the value of
                q1.add(q1.remove()); //  --> this will remove element at head of queue and insert it at the end of the queue.
                s--;
            }
        }

        public int pop() {
            return q1.remove();  // remove will not throw exception if queue is empty
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
