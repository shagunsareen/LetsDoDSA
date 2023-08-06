package dsa.with.shagun.scaler.advance.BitManipulation;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(numSetBits(450676354));
    }

    public static int numSetBits(int A) {
        /* Approach 1 : Iterate for 32 times
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((A>>i & 1)== 1) {
                count += 1;
            }
            System.out.println(i);
        }
        return count;*/

        //Approach 2 : since x&(x-1) will unset the set bit from left hence it can be used to check how many bits are set until A is zero
        int total_ones = 0;
        while (A != 0) {
            // rightmost set bit becomes unset
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
    }
}
