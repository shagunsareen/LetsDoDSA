package dsa.with.shagun.scaler.advance.Sorting.session1;

import java.util.Arrays;

public class MaxMod {
    public static void main(String[] args) {
        //System.out.println(solve(new int[]{1, 2, 44, 3}));
        System.out.println(solve(new int[]{1, 2, 3, 3}));
    }

    public static int solve(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int max = A[N - 1];
        int secondMax = A[N - 2]; // default value let's consider whatever is second last digit after sorting is second max

        //EDGE CASE : when last 2 digits are same then max element still remains last but secondMax element will not be secondlast element
        //In such case we need to find index where second last element is not same as the last element
        for (int i = N - 2; i >= 0; i--) {
            if (A[i] != max) {
                secondMax = A[i];
                break;
            }
        }
        return secondMax % max;
    }
}
