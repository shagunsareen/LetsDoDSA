package dsa.with.shagun.scaler.advance.Stack.session2;

import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreater(int[] A) {
        //use stack to store the next greater element as we move from right to left
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //since for the rightmost element there is no next greater element

        int[] ans = new int[A.length];

        for(int i=A.length-1; i>=0; i--)
        {

            //pop the smaller elements from the stack and push the next greater element
            while(!stack.empty() && stack.peek() <= A[i])
            { //pop the smaller element
                stack.pop();
            }

            //once it has come out means it has greater element in the stack hence update it as our ans
            ans[i] = !stack.empty() ? stack.peek() : -1;

            //push the current element
            stack.push(A[i]);
        }

        return ans;
    }
}
