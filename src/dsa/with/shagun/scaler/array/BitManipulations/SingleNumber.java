package dsa.with.shagun.scaler.array.BitManipulations;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2, 3, 1}));
    }

    public static int singleNumber(final int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }
}
