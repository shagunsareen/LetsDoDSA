package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreater(int[] A) {

        //next greater element to a number will -1 for the last element, stack will store nge in it
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        //Create an answer array to store result
        int n = A.length;
        int[] res = new int[n];

        for(int i=n-1; i>=0; i--){

            //if stack top is lesser then pop those till greater element is found
            while(!stack.isEmpty() && stack.peek() <= A[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }

            stack.push(A[i]); //we will insert the current element into the stack because
        }

        return res;
    }
}
