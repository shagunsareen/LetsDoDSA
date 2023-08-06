package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.Stack;

/*
Given 2 sorted stacks merge them into 1 sorted stack
 */
public class MergeStacks {

    public static void main(String[] args) {
        Stack<Integer> sa = new Stack<>();
        sa.push(15);
        sa.push(10);
        sa.push(5);
        sa.push(3);
        Stack<Integer> sb = new Stack<>();
        sb.push(9);
        sb.push(7);
        sb.push(6);
        sb.push(4);
        sb.push(2);
        Stack<Integer> res = mergeStacks(sa, sb);
        while (!res.empty()) {
            System.out.println(res.pop());
        }
    }

    public static Stack<Integer> mergeStacks(Stack<Integer> s1, Stack<Integer> s2) {

        Stack<Integer> s3 = new Stack<>();
        Stack<Integer> s4 = new Stack<>();

        // Compare top of two stacks, pop smaller element and push into new stack. Do this until either of stack is empty
        while (!s1.empty() && !s2.empty()) {  //TC : O(s1.length+s2.length),SC: O(s1.length+s2.length)
            if (s1.peek() < s2.peek()) {
                s3.push(s1.pop());
            } else {
                s3.push(s2.pop());
            }
        }

        //if s2 is exhausted and s1 elements are left in stack push these into new stack
        while (!s1.empty()) {
            s3.push(s1.pop());
        }
        //if s1 is exhausted and s2 elements are left in stack push these into new stack
        while (!s2.empty()) {
            s3.push(s2.pop());
        }

        //since stack is LIFO order to be sorted is reverse ,hence take 1 more stack and push elements from top to bottom
        while (!s3.empty()) { //TC : O(s1.length+s2.length),SC: O(s1.length+s2.length)
            s4.push(s3.pop());
        }

        return s4; //Total TC: O(2*s1.length+2*s2.length), SC: O(2*s1.length+2*s2.length)
        //TC :O(2N+2M), SC:O(2N+2M)
    }


}
