package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class TargetSumSubsets { //TC : O(2n) This time complexity is exponential because for each state, 2 recursion calls are made.
                                //SC : O(1) is recursive stack is not to be considered
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        printTargetSumSubsets(arr, 0, null, 0, target);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        //Base condition
        if (idx == arr.length) {
            if (sos == tar) {
                System.out.println(set + ".");
            }
            return;
        }

        //edge case condition --if sum is greater than target then anyways we don't need that subset
        if (sos > tar) {
            return;
        }

        // consider that first element is counted in subset
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);

        //consider first element is not counted in subset
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}
