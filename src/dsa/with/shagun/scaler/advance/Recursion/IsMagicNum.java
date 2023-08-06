package dsa.with.shagun.scaler.advance.Recursion;

public class IsMagicNum {

    public static void main(String[] args) {
        System.out.println(solve(83557));
    }

    public static int solve(int A) {
        long sum = sumDigit(A);
        if (A < 10) {
            if (A == 1) return 1;
            else return 0;
        }
       return solve((int) sum);
    }

    private static int sumDigit(int A) {
        if (A <= 0) return 0;
        return A % 10 + sumDigit(A / 10);
    }
}
