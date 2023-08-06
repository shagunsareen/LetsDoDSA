package dsa.with.shagun.scaler.BitManipulation;

public class UnsetBit {
    public static void main(String[] args) {
        System.out.println(solve(13,2));
    }
    public static int solve(int A, int B) {
        if(((1<<B) & A)!=0){ //if bit would have been 1 in given Num then answer can't be 0. It will be 2^N but if bit is 0 then AND with anything will be zero
            return A - (1<<B);
        }
        return A;
    }
}
