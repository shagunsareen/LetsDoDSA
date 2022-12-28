package dsa.with.shagun.scaler.advance.array;

public class RainWaterTrapping {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2}));
        System.out.println(trap(new int[]{1, 2}));
    }

    public static int trap(final int[] A) {

        //Solution 1 : Using prefix leftMax and suffix  RightMax array TC : O(N) , SC:O(2N)
        int units = 0;
        int N = A.length;
        /*int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        leftMax[0] = 0;
        rightMax[N - 1] = 0;

        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
        }

        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
        }

        for (int i = 0; i < A.length; i++) {
            units += Math.max(Math.min(leftMax[i], rightMax[i]) - A[i], 0); // taking max with 0 just to avoid -ve height buildings where no water can be stored
        }*/


        //Approach 2 : Using two pointer approach,SC : O(1), TC: O(N)
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            if (A[left] <= A[right]) {
                if (A[left] >= maxLeft) {
                    maxLeft = A[left];
                } else {
                    units += maxLeft - A[left];
                }
                left++;
            } else {
                if (A[right] >= maxRight) {
                    maxRight = A[right];
                } else {
                    units += maxRight - A[right];
                }
                right--;
            }
        }

        return units;
    }

}
