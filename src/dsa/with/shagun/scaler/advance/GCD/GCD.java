package dsa.with.shagun.scaler.advance.GCD;

public class GCD { // TC : O(log2^max(a,b))
    public static void main(String[] args) {
        System.out.println(gcd(4, 6));
        System.out.println(gcd(6, 7));
    }

    public static int gcd(int A, int B) {
        if (B == 0) return A;
        //return gcd(A%B, B); // if we do this then a !> b and mod value won't become zero anytime.
        return gcd(B, A % B);
    }
}
