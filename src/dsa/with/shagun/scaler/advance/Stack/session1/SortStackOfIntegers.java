package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.Stack;

public class SortStackOfIntegers {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        int[] res = solve(a);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] solve(int[] A) {

        //Suppose array length = N
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {  //TC : O(N), SC:O(N)
            stack.push(A[i]);
        }

        Stack<Integer> res = SortStackUsingAnotherStack.stackSort(stack);
        int[] resArr = new int[res.size()];

        int numOfEle = res.size();
        for (int i = 0; i < numOfEle; i++) { //TC : O(N), SC:O(N)
            resArr[i] = res.pop();
        }

        return resArr;
        //TC : O(2N+2M), SC:O(2N+2M)  -- Merging 2 sorted stacks into 1 stack
        //TC : O(NLogN), SC:O(N/2)  -- Dividing 2 stacks logN t
        //TC : O(N+N), SC:O(N+N) -- For converting array into stack and stack into array
    }
}
