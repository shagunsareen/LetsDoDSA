package dsa.with.shagun.scaler.Recursion;

public class PowerFunc {
    public static void main(String[] args) {
        //System.out.println(pow(-1, 1, 20)); //19
        //System.out.println(pow(213, 231, 1)); //0
        //System.out.println(pow(-1, 2, 20)); //1
        System.out.println(pow(71045970, 41535484, 64735492)); //1

    }


    public static int pow(int A, int B, int C) {
        //approach 1 : failed with stack overflow error
        /*long p = pow(A,B-1,C)%C;
        long res =  (p*(A%C))%C;
        return  (int) res + C;*/

        //approach 2 : failing for one test case
        //Base condition
        /*if (B == 0) return 1 % C;
        long p = pow(A, B / 2, C);
        int res = 0;
        if (B % 2 == 0) {
            res = (int) (((p * p) % C)); // since even powers will make negative int to positive hence no addition of C is required in this case
        } else {
            res = A < 0 ? (int) (((p * p * A) % C) + C) : (int) ((p * p * A) % C);
        }
        return res;*/

        // Approach 3 -- Solution approach
        //Base condition
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        long ans = pow(A, B / 2, C);
        ans = (ans * ans) % C;
        if (B % 2 == 1)
            ans = (ans * A);
        ans = (ans + C) % C;
        return (int) ans;

    }
}
