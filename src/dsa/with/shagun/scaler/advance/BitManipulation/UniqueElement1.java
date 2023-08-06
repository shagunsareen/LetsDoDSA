package dsa.with.shagun.scaler.advance.BitManipulation;

public class UniqueElement1 {
    public int singleNumber(final int[] A) { //TC : O(N), SC:O(1)
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor = A[i] ^ xor;
        }
        return xor;
    }
}
