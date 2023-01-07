package dsa.with.shagun.scaler.advance.Combinatorics;

public class Combination1 {
    public static void main(String[] args) {
        System.out.println(solve(38, 5, 81));
       // System.out.println(solve(3, 2, 33));
    }

    public static int solve(int A, int B, int C) {
        // return (fact(A) / (fact(A - B) * fact(B))) % C;
        /* This is the wrong way as when we have to do division in modular arithmetic then
        we have to use "MULTIPLICATIVE MODULO INVERSE" i.e. (1/b)%m = b^(m-2)%m i.e. mmi of b
        Now to calculate power,we have to use BINARY EXPONENTIATION method
         */
        long fact[] = new long[1000005];
        fact[0] = 1;
        for (int i = 1; i <= A; i++) {
            fact[i] = (i * fact[i - 1]) % C;
        }
        long ans = fact[A];
        long fr = bipow((int)fact[B], C-2, C);
        long fnr = bipow((int)fact[A-B], C-2,C);
        ans = (ans*fr)%C;
        ans = (ans*fnr)%C;
        return (int)ans;
    }

    public static long bipow(int A, int N, int C) {
        //Base condition
        if (A == 0)
            return 0;
        if (N == 0)
            return 1;
        long ans = bipow(A, N / 2, C);
        ans = (ans * ans) % C;
        if (N % 2 == 1)
            ans = (ans * A);
        ans = (ans + C) % C;
        return ans;
    }

}
