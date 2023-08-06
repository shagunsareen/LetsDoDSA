package dsa.with.shagun.scaler.advance.DynamicProgramming;

public class Stairs {

    public int climbStairs(int A) {
        long mod = 1000000007;
        long first = 1;
        long second = 2;
        long third = 0;

        if (A <= 2) {
            return A;
        }

        for (int i = 3; i <= A; i++) {
            third = (first % mod + second % mod) % mod;
            first = second;
            second = third;
            //System.out.println("Third : "+third);
        }
        return (int) (third % mod);
    }
}
