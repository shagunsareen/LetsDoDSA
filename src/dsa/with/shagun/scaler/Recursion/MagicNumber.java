package dsa.with.shagun.scaler.Recursion;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(solve(83557));
        System.out.println(solve(1291));
    }

    public static int solve(int A) {
        if (A < 10) {
            if (A == 1) return 1;
            else return 0;
        }
        long sum = sumDigit(A);
        return solve((int) sum);
    }

    private static int sumDigit(int A) {
        if (A <= 0) return 0;
        return A % 10 + sumDigit(A / 10);
    }

    //Efficient Approach:
    //
    //There is also a shortcut method to verify Magic Number.
    //The function will determine if the remainder of dividing the input by 9 is 1 or not.
    //If it is 1, then the number is a magic number.
    //The divisibility rule of 9 says that a number is divisible by 9 if the sum of its digits is also divisible by 9.
    //Therefore, if a number is divisible by 9, then, recursively, all the digit sums are also divisible by 9.
    //The final digit sum is always 9. An increase of 1 in the original number will increase the ultimate value by 1, making it 10, and the ultimate sum will be 1, thus verifying that it is a magic number.

    /*if(A%9 == 1){
        return 1;
    }
        return 0;*/
}
