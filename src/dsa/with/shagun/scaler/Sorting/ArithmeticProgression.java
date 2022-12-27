package dsa.with.shagun.scaler.Sorting;

import java.util.Arrays;

public class ArithmeticProgression {
    public int solve(int[] A) {
        Arrays.sort(A); // This is required since [3,5,1] if not sorted will not form AP but if it is sorted it will form AP
        int diff = Math.abs(A[1] - A[0]);
        for (int i = 1; i <= A.length - 1; i++) {
            if (A[i + 1] - A[i] != diff) {
                return 0;
            }
        }
        return 1;
    }
}
