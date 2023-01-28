package dsa.with.shagun.scaler.advance.Hashing.session2;

import java.util.HashMap;
import java.util.HashSet;

/*
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).

1 <= N <= 105

0 <= A[i], B[i] <= 109


Input 1:

 A = [1, 1, 2]
 B = [1, 2, 1]

Input 2:

 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]

Output 1: 1
Output 2: 6
 */
public class CountTriangles {

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2};
        int[] B = new int[]{1, 2, 1};
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int[] B) {

        //approach 1 : if we fix  all three points then since it's right angled triangle, one side || to x-axis and one side || to y-axis i.e. x1=x2 ,y1=y2
        //TC: O(n3)-- not optimal for large range

        //approach 2 : If we fix 2 points such that x1!=x2 and y1!=y2 such that it is hypotenuse point because if x1=x2 or y1=y2 then these are points on same axis we don't need that
        // Once 2 points are fixed, we will find third point which can be x1y2 and x2y1. If we have this in hashmap or hashset then we can count triangle as 1

        //approach 3 : If we fix just 1 point (x1,y1), that is we consider every point in input as first point and find other two points
        // We need to find 2 other points x1y2 and x2y1 i.e. we need to have frequency of x1 and y1 to calculate how many triangles can be formed
        // it would be freq(x1)*freq(y1) since these many combinations we have to make a triangle.
        //TC: O(n),SC:O(n)

        HashMap<Integer, Integer> xFreq = new HashMap<>();
        HashMap<Integer, Integer> yFreq = new HashMap<>();
        long count = 0;

        //Step1: Let's create frequency map for both x-axis point and y-axis point
        for (int i = 0; i < A.length; i++) {
            xFreq.put(A[i], xFreq.getOrDefault(A[i], 0) + 1);
            yFreq.put(B[i], yFreq.getOrDefault(B[i], 0) + 1);
        }

        //Step2 : Fix first point and see how many rectangles can be made from that
        for (int i = 0; i < A.length; i++) {
            // First point co-ordinates
            int x1 = A[i];
            int y1 = B[i];

            //check freq of x1 and y1 excluding current element in respective maps and get ans;
            int x1Freq = xFreq.get(x1) - 1;
            int y1Freq = yFreq.get(y1) - 1;

            count += x1Freq * y1Freq;
        }

        return (int) count;
    }

}
