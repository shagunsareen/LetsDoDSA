package dsa.with.shagun.scaler.advance.ModularArithmetic;

public class PowerFuncModulo {
    public static void main(String[] args) {
        pow(-1,1,20);
    }
    public static int pow(int A, int B, int C) {
        /*long ans = 1;  // since A ranges between -10^9 to 10^9 hence,multiplying A multiple times will go out of range for int  hence take long
        for (int i = 1; i <= B; i++) {
            ans = (ans%C * A%C + C) % C;
        }
        return (int) ans;*/

        //TC : O(nlogn) , SC : O(1)
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
