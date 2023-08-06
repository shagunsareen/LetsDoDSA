package dsa.with.shagun.scaler.advance.BinarySearch.session3;

import java.util.Arrays;

public class CowsAndStalls {
    public static void main(String[] args) {
        //System.out.println(solve(new int[]{1, 2}, 2));
        //System.out.println(solve(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(solve(new int[]{5, 17, 100, 11 }, 2));
    }

    /* Given an array of integers A of size N where each element of the array represents the location of the stall and
     an integer B which represents the number of cows.
     Return the largest minimum distance possible among the cows.
     */
    public static int solve(int[] A, int B) {

        //Binary Search on  distance between cows
        // l - min. distance btw cows i.e. adjacent distance, r - max. distance btw cows i.e. distance between first and last cow
        //range -[l r]

        Arrays.sort(A);
        int ans = 0;
        int l = minAdjacentDistanceBtwCows(A);
        int r = A[A.length - 1] - A[0];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            //check if mid as min. distance is possible to place B cows
            if (checkMidDistFeasibility(A, B, mid)) {
                //since we need to maximize min. distance we would move to right position
                ans = mid;
                l = mid + 1;
            } else {
                // if min. distance is not possible as mid then we have to check for values lesser than mid
                r = mid - 1;
            }
        }

        return ans;
    }

    private static boolean checkMidDistFeasibility(int[] a, int b, int mid) {
        int cowPos = 0;
        b--;
        for (int i = 1; i < a.length; i++) {//we will check value at each stall whether it equals mid calculated
            if (a[i] - a[cowPos] >= mid) {
                b--;
                cowPos = i;
            }
        }

        if (b <= 0) {
            return true;
        }
        return false;
    }

    private static int minAdjacentDistanceBtwCows(int[] a) {
        int minAdjDist = a[1] - a[0];
        for (int i = 1; i < a.length - 1; i++) {
            int adjDis = Math.abs(a[i + 1] - a[i]);
            minAdjDist = Math.min(adjDis, minAdjDist);
        }
        return minAdjDist;
    }
}
