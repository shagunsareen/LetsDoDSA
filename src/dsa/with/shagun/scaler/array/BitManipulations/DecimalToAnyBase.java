package dsa.with.shagun.scaler.array.BitManipulations;

import java.util.Optional;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        System.out.println(solve(0,3));
    }

    public static int solve(int A, int B) {
        StringBuilder ansStr = new StringBuilder();
        int rem = 0;
        if(A==0) // IMPORTANT EDGE CASE
            return 0;

        while(A>0){
            rem = A%B;
            A = A/B;
            ansStr.append(rem);
        }

        return Integer.parseInt(ansStr.reverse().toString());
    }
}
