package dsa.with.shagun.scaler.advance.Stack.session2.revision;

import java.util.Stack;

public class AllSubarrays {
    public int solve(int[] A) {

        //Brute Force : Check for all subarray max and second max, to iterate over all subarrays
        //TC : O(n2), To find max out of that subarray will be another O(n)
        //Overall this would be TC:O(n3) hence this is not the best Solution

        //Approach 2 : Use stacks to store max and second max. If any greater element occurs delete the smaller ones since for upcoming subarrays new incoming element would act as a max or second max element

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<A.length; i++){
            while(!stack.isEmpty()){
                //calculate the XOR now since now we have 2 elements one in the stack and other in the array
                ans = Math.max(ans, stack.peek() ^ A[i]);
                if(stack.peek() > A[i]){
                    break;
                }
                stack.pop();
            }
            stack.push(A[i]);
        }
        return ans;
    }
}
