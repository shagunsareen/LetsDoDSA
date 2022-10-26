package dsa.with.shagun.scaler.array.BitManipulations;

public class SubArrWithBitwiseOrOne {
    public static void main(String[] args) {
        System.out.println(solve(3, new int[]{1,0,1}));
    }

    public static long solve(int A, int[] B) {
        int last = 0;
        long ans = 0;
        for (int i = 0; i < A; i++) {
            if (B[i] == 1) last = i + 1;
            ans += last;
        }
        return ans;
    }
}
