package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Stack;

public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {
        //We need to find prevSmaller that means we need to have all prev elements with us at every point, so let's go for Stacks

        //store initial prev smaller element as -1
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int[] res = new int[A.length];

        for(int i=0; i<A.length; i++){

            //check if the stack top is lesser than the stack top then we already have our ans
            if(stack.peek() < A[i]){
                res[i] = stack.peek();
            }else{
                // if the stack peek is greater than we pop all the greater elements from the stack until we get a smaller element
                // than the current one
                while(stack.peek() >= A[i]){
                    stack.pop();
                }
                res[i] = stack.peek(); //since we have reached the smaller element this is our answer
            }

            stack.push(A[i]);
        }

        return res;
    }
}
