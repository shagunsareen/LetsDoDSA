package dsa.with.shagun.scaler.advance.Recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(solve(123));
    }

    static int sum = 0;

    public static int solve(int A) {
        sumOfDigits(A);
        return sum;
    }

    public static void sumOfDigits(int A) {
        if (A <= 0) {
            return;
        }
        sum += A % 10;
        A = A / 10;
        sumOfDigits(A);
    }
}
