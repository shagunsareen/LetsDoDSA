package dsa.with.shagun.scaler.array.BitManipulations;

public class InterestingArray {

    public static void main(String[] args) {
        solve(new int[]{9, 17});
    }

    public static String solve(int[] A) {
        int countOddEle = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) countOddEle++;
        }

        if (countOddEle % 2 == 1) {
            return "No";
        } else {
            return "Yes";
        }
    }
}
