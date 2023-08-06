package dsa.with.shagun.scaler.Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(solve(4));
    }
    public static int solve(int A) {
        //edge case
        if (A == 0) return 0;

        //Base condition
        if(A == 1) return 1;

        //main logic
        return solve(A - 1) * A;
    }
}
