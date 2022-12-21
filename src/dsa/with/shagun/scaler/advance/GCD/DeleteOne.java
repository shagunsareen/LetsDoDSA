package dsa.with.shagun.scaler.advance.GCD;

public class DeleteOne {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{12, 15, 18}));
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int[] suffixGCD(int[] A) {  //TC : NLogN
        int n = A.length;
        int[] suf = new int[n];
        int g = 0;
        for (int i = n - 1; i >= 0; i--) {
            g = gcd(g, A[i]);
            suf[i] = g;
        }
        return suf;
    }

    public static int[] prefixGCD(int[] A) { //TC : NLogN
        int n = A.length;
        int[] pfGCD = new int[n];
        int pf = 0;
        for (int i = 0; i < n; i++) {
            pf = gcd(pf, A[i]);
            pfGCD[i] = pf;
        }
        return pfGCD;
    }

    public static int solve(int[] A) {
        /*int n = A.length, ans = 1;
        // suf stores the suffix gcd of the array
        int[] suf = suffixGCD(A);
        int curGcd = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                ans = Math.max(ans, gcd(suf[i + 1], curGcd));
            else
                ans = Math.max(ans, curGcd);
            curGcd = gcd(curGcd, A[i]);
        }
        return ans;*/


        // suf stores the suffix gcd of the array
        int[] suf = suffixGCD(A);
        //pf stores the prefix gcd of the array
        int[] pf = prefixGCD(A);

        int maxGCD = 1;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxGCD = Math.max(gcd(0, suf[i + 1]), maxGCD);
            } else if (i == n - 1) {
                maxGCD = Math.max(gcd(pf[i - 1], 0), maxGCD);
            } else {
                maxGCD = Math.max(gcd(pf[i - 1], suf[i + 1]), maxGCD);
            }
        }
        return maxGCD;
    }
}
