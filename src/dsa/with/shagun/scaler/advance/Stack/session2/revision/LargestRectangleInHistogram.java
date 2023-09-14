package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] A) {

        //Consider every element as height of the rectangle and then check till where can this rectangle be explanded
        //To maintain it for every element, we need to find prevSmallerIndex and nextSmallerIndex for every element.
        //Then we will calculate the area on the basis of prevSmallerIndex and nextSmallerIndex.
        int maxArea = 0;

        int[] left = prevSmallerIndex(A);
        int[] right = nextSmallerIndex(A);

        for(int i=0; i<A.length; i++){

            int height = A[i];
            int width = right[i] - left[i] - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public int[] prevSmallerIndex(int[] A){
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[A.length];

        Arrays.fill(ans, -1); // set -1 if no value lesser than current ele would be present

        for(int i=0; i<A.length; i++){

            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop(); //delete all greater elements until we reach smaller element
            }

            if(!stack.isEmpty() && A[stack.peek()] < A[i]){
                ans[i] = stack.peek();
            }

            // store the index and not the element
            stack.push(i);
        }

        return ans;
    }

    public int[] nextSmallerIndex(int[] A){

        Stack<Integer> stack = new Stack<Integer>();

        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, A.length);  //since we are taking smaller index on the right hence non acceptable index is array's length

        for(int i=n-1; i>=0; i--){

            while(!stack.isEmpty() && A[stack.peek()] >= A[i]){
                stack.pop(); //until we get the smaller element
            }

            if(!stack.isEmpty() && A[stack.peek()] < A[i]){
                ans[i] = stack.peek(); //we got the smaller index
            }

            stack.push(i); //store the index and not the element
        }

        return ans;
    }
}
