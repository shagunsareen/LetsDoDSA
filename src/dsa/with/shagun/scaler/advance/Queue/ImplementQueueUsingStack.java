package dsa.with.shagun.scaler.advance.Queue;

import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    ImplementQueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //enqueue to insert the element into the queue
    public void enqueue(int element) {
        //Pushing element to top of stack
        stack1.push(element);
    }

    //delete first element pushed i.e. in queue FIFO that is first element pushed is the first element to be deleted so that is at the bottom of the stack
    public void dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return;
        }

        //Push all elements from Stack1 to stack2
        if (!stack1.isEmpty()) {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }

            // now that stack1 has only 1 element this is the element to be removed
            stack1.pop();
        }

        //move all elements from stack2 to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
