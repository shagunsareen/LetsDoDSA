package dsa.with.shagun.scaler.BitManipulation;

public class ToggleBit {
    public int solve(int A, int B) {

        //approach 1
        if (((A >> B) & 1) == 1) { // bit is set
            return A - (1 << B);
        } else { //bit is unset
            return A + (1 << B);
        }

        //approach 2 - use XOR
        //return A^(1<<B);
    }
}
