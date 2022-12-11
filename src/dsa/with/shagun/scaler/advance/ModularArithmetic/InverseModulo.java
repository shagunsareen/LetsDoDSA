package dsa.with.shagun.scaler.advance.ModularArithmetic;

public class InverseModulo {
    public int solve(int A, int B) {
        return pow(A, B-2, B);
    }

    //AB-2 ≡ A-1 (mod B) where B is prime and A is not a multiple of B.
    public static int pow(int A, int B, int C) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        long ans = pow(A, B / 2, C);  // since power of B is quite large it will result in overflow condition hence pass B as B/2
        ans = (ans*ans)%C;
        if(B%2==1){
            ans = ans*A;
        }
        ans = (ans + C)%C;
        return (int) ans;
    }
}
