package dsa.with.shagun.scaler.advance.ModularArithmetic;

public class ABModulo {

    public static void main(String[] args) {
        System.out.println(solve(5,10));
    }

    public static int solve(int A, int B) {
        int maxFactor = Integer.MIN_VALUE;
        // (A%M -B%M + M)%M = M%M i.e. (A-B)%M = 0, now A-B factors should give ans as 0.
        for (int i = 1; i*i <= Math.abs(A - B); i++) {
            if ( Math.abs(A - B) % i == 0) {  // check if i is factor of A-B
                int compare = Math.max(i,  Math.abs(A-B)/i);
                maxFactor = Math.max(maxFactor, compare);
            }
        }
        return maxFactor;

        //alternatively Math.abs(A-B) is the max value for M where both would be equal
    }
}
