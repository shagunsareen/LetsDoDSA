package dsa.with.shagun.scaler.advance.Stack.session2;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given an array of integers A.

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
 */
public class MaxMinSubarraySum {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 7, 3, 8}));
    }

    public static int solve(int[] A) {
        //Step1 : Get how many starting points we can have where current ele is max and how many ending points for subarray we can have where current ele is max
        //Similarly get for min element ,multiplied by current element given CONTRIBUTION of that element in sum value
        int mod = 1000 * 1000 * 1000 + 7;
        long sum = 0;
        long Cimax;
        long Cimin;
        int[] s1max;
        int[] e1max;
        int[] s1min;
        int[] e1min;
        if (A.length == 1) return A[0];

        // Get prevGreaterElement to get no. of subarrays with si of subarrays with A[i] as max
        s1max = prevGreaterIndex(A);
        // Get nextGreaterElement to get no. of subarrays with ei of subarrays with A[i] as max
        e1max = nextGreaterIndex(A);

        // Get prevSmallerElement to get no. of subarrays with si of subarrays with A[i] as min
        s1min = prevSmallerIndex(A);
        // Get nextSmallerElement to get no. of subarrays with ei of subarrays with A[i] as min
        e1min = nextSmallerIndex(A);

        for (int i = 0; i < A.length; i++) {
            //here i is current element,
            // s1max = left index where element is greater than current element ,
            // e1max = right index where element is greater than current element

            //Cimax = ((i - (s1max[i] + 1)) - 1) * ((e1max[i] - 1 - i) - 1);
            Cimax = (long) (i - s1max[i]) * (e1max[i] - i);
            long currentMaxContri = (Cimax * A[i]) % mod;

            //here i is current element ,
            // s1min = left index where element is SMALLER than current element ,
            // e1min = right index where element is SMALLER than current element
            //Cimin = ((i - (s1min[i] + 1)) - 1) * ((e1min[i] - 1 - i) - 1);

            Cimin = (long) (i - s1min[i]) * (e1min[i] - i);
            long currentMinContri = (Cimin * A[i]) % mod;

            sum = (sum % mod + (currentMaxContri % mod - currentMinContri % mod) % mod) % mod;
        }

        return (int) ((sum + mod) % mod);
    }

    public static int[] prevSmallerIndex(int[] A) { // TC : O(N), SC:O(N)

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[A.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < A.length; i++) {

            while (!stack.empty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (!stack.empty() && A[stack.peek()] < A[i]) {
                ans[i] = stack.peek();
            }

            // since our current element can be ans for other elements push it into the stack
            stack.push(i);
        }

        return ans;
    }

    public static int[] nextSmallerIndex(int[] A) { // TC : O(N), SC:O(N)
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[A.length];
        Arrays.fill(ans, A.length);

        for (int i = A.length - 1; i >= 0; i--) {

            // if stack top element is greater than curr element iterate till last of stack until we get smaller element
            while (!stack.empty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            // if in stack we got the nearest smaller element then assign it as our ans
            if (!stack.empty() && A[stack.peek()] < A[i]) {
                ans[i] = stack.peek();
            }

            // since our current element can be ans for other elements push it into the stack
            stack.push(i);
        }

        return ans;
    }


    public static int[] prevGreaterIndex(int[] A) { // TC : O(N), SC:O(N)

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[A.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < A.length; i++) {

            while (!stack.empty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (!stack.empty() && A[stack.peek()] > A[i]) {
                ans[i] = stack.peek();
            }

            // since our current element can be ans for other elements push it into the stack
            stack.push(i);
        }

        return ans;
    }


    public static int[] nextGreaterIndex(int[] A) { // TC : O(N), SC:O(N)
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[A.length];
        Arrays.fill(ans, A.length);

        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.empty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (!stack.empty() && A[stack.peek()] > A[i]) {
                ans[i] = stack.peek();
            }

            // since our current element can be ans for other elements push it into the stack
            stack.push(i);
        }

        return ans;
    }
}
