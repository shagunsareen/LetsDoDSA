package dsa.with.shagun.scaler.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        //System.out.println(solve(46));
        System.out.println(solve(11));
    }

    public static int solve(int A) {
        int sum = 0;
        return sumDigit(A, sum);
    }

    private static int sumDigit(int A, int sum) {
        if(A<=0) return sum;
        sum += A % 10;
        A = A / 10;
        return sumDigit(A, sum);
    }
}
