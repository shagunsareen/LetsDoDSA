package dsa.with.shagun.scaler.advance.Queue.Revision;

import java.util.Stack;

public class ImplementQueuesUsingStack {
    class MyQueue {

        Stack<Integer> frontStack;
        Stack<Integer> rearStack;

        public MyQueue() {
            frontStack = new Stack<Integer>();
            rearStack = new Stack<Integer>();
        }

        public void push(int x) {

            //we have to pop the element from front so there we need first element inserted to be available first to be    deleted. To do so we need to re-order elements in front queue everytime anything is pushed to rear queue.

            //APPROACH
            // move data from front to rear queue anytime when we have to insert an element to rear queue.
            // This is done to maintain the order once new element is inserted
            while(!frontStack.isEmpty()){
                rearStack.push(frontStack.pop());
            }

            //once all the elements are inserted to rear stack now insert the new element
            rearStack.push(x); // inserting the element to the rear end of the queue

            //now we need to move all these elements to the front queue so that we have elements to delete in correct order
            while(!rearStack.isEmpty()){
                frontStack.push(rearStack.pop());
            }
        }

        public int pop() {
            return frontStack.pop();
        }

        public int peek() {
            return frontStack.peek();
        }

        public boolean empty() {
            //check if both the stacks are empty or not
            if(frontStack.isEmpty()){
                return true;
            }
            return false;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
