package dsa.with.shagun.scaler.Hashing;

import java.util.Arrays;

public class SubarraySumZero {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solve(new int[]{-1, 1}));
    }

    public static int solve(int[] A) {

        //prefix sum array
        long[] preSumArr = new long[A.length];
        preSumArr[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            //check if original arr has any ele as 0 because that means we have subarray with sum 0
            if (A[i] == 0) {
                return 1;
            }
            preSumArr[i] = preSumArr[i - 1] + A[i];
        }

        //IDEA : if prefix sum array has repeating elements then it has a subarray with sum==0
        // If it has any prefixsum value as 0 then also it has subarray with sum=0
        //if original array has any ele as0 then also it has subarray with sum=0

        //check if preSumArr has repeating ele or not
        if (Arrays.stream(preSumArr).distinct().count() != A.length)
            return 1;
        //check if prefixsumarr has any ele as 0
        if (Arrays.stream(preSumArr).filter(i -> i == 0).count() > 0) {
            return 1;
        }
        return 0;
    }
}
