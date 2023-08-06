package dsa.with.shagun.scaler.advance.TwoPointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public int maxArea(int[] A) {

        //approach 1: check for all pairs of walls TC: O(n2), SC:O(1) --non efficient

        //approach 2 : have prefix leftmax and suffix rightmax array to store leftmax and rightmax at every point
        // length = 1 by default , width  = min(leftmax, rightmax)-A[i]
        //TC : O(N),SC:O(2N)


        //approach 3 : Two pointer approach , TC: O(N), SC:O(1)
        int i = 0;
        int j = A.length - 1;
        long maxArea = Integer.MIN_VALUE;

        while (i <= j) {
            int height = Math.min(A[i], A[j]);  // since height we can take as min because water won't be trappedover min. height
            int width = j - i; // distance between both walls

            long area = height * width;
            maxArea = Math.max(area, maxArea);  //updating maxArea

            //since we should keep height with max value for rest of iterations as it might give greater area
            if (A[i] > A[j]) {
                j--;
            } else {
                i++;
            }
        }

        return (int) maxArea;
    }
}
