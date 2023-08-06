package dsa.with.shagun.scaler.advance.TwoPointer;

public class ThreePointerArray {

    public int minimize(final int[] A, final int[] B, final int[] C) {
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr3 = 0;
        long ans = Integer.MAX_VALUE;

        while (ptr1 < A.length && ptr2 < B.length && ptr3 < C.length) {
            long a = Math.abs(A[ptr1] - B[ptr2]);
            long b = Math.abs(B[ptr2] - C[ptr3]);
            long c = Math.abs(C[ptr3] - A[ptr1]);

            //since we need to minimize max so we will not increase max ptr instead we will increase min pointer
            long max = Math.max(Math.max(a, b), c);
            ans = Math.min(max, ans);  //keep updating max ans in ans variable

            if (A[ptr1] <= B[ptr2] && A[ptr1] <= C[ptr3]) {
                ptr1++;
            } else if (B[ptr2] <= C[ptr3] && B[ptr2] <= A[ptr1]) {
                ptr2++;
            } else {
                ptr3++;
            }

        }
        return (int) ans;
    }
}
