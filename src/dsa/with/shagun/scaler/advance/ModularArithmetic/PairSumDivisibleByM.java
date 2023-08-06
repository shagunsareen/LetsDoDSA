package dsa.with.shagun.scaler.advance.ModularArithmetic;

public class PairSumDivisibleByM {
    public int solve(int[] A, int B) {
        int n = A.length;
        long mod = (long) (1e9 + 7);
        long cnt[] = new long[B];
        // cnt[i] stores the count of elements such that their modulo k equals i
        for (int x : A) cnt[x % B]++;
        long ans = cnt[0] * (cnt[0] - 1) / 2;
        for (int i = 1, j = B - 1; i <= j; i++, j--) {
            if (i == j)
                ans = (ans + cnt[i] * (cnt[i] - 1) / 2) % mod;
            else
                ans = (ans + cnt[i] * cnt[j]) % mod;
        }
        return (int) ans;
    }
}
