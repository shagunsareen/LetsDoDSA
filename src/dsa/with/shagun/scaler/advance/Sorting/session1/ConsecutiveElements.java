package dsa.with.shagun.scaler.advance.Sorting.session1;

import java.util.Arrays;

public class ConsecutiveElements {
    public int solve(int[] A) {
        Arrays.sort(A);  // this will sort it in increasing order
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] != 1) {
                return 0;
            }
        }
        return 1;
    }
}
