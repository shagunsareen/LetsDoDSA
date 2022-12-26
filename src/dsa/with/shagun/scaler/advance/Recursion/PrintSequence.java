package dsa.with.shagun.scaler.advance.Recursion;

public class PrintSequence {
    public static void main(String[] args) {
        System.out.println(solve(3));
    }

    public static int solve(int A) {
        if (A == 0 || A == 1) {
            return 1;
        }
        if (A == 2) {
            return 2;
        }
        return solve(A - 1) + solve(A - 2) + solve(A - 3) + A;
    }
}
