package dsa.with.shagun.scaler.Recursion;

public class Fibonacci {

    //fibonacci is formed by adding n-1 and n-2 ele for nth fibonacci number
    public static int findAthFibonacci(int A) {

        //Base condition
        if (A == 0) return 0;
        if (A == 1 || A == 2) return 1;

        //Main logic
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
