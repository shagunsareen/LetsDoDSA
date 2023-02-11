package dsa.with.shagun.scaler.advance.Stack.session2;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of the largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        //System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        //System.out.println(largestRectangleArea(new int[]{2}));
        System.out.println(largestRectangleArea(new int[]{90, 58, 69, 70, 82, 100, 13, 57, 47, 18}));
    }

    public static int largestRectangleArea(int[] A) { // TC : O(N), SC:O(N)
        // height of rectangle will be one of the height of histogram only
        // Take every element as height and we can go to left till we have same height or more height. Once we get lesser height we will stop there
        //Similarly for right, until we reach height < current element we continue
        int maxArea = 0;
        //Step1 : NearestSmallerOnLeft
        int[] smallerLeft = prevSmallerIndex(A);
        //Step2 : NearestSmallerOnRight
        int[] smallerRight = nextSmallerIndex(A);

        for (int i = 0; i < A.length; i++) {
            int height = A[i];
            //Step3: calculating area with all these parameters
            int left = smallerLeft[i];
            int right = smallerRight[i];

            int width = right - left - 1;

            maxArea = Math.max(height * width, maxArea);
        }

        return maxArea;
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

}
