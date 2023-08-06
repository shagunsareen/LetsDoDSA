package dsa.with.shagun.scaler.BitManipulation;

public class CheckBit {

    //since we need to check bit by bit, if we take AND of bit with 1 then if ans bit =1 meaning bit is set in N else it is unset
    //so to apply same logic for every bit we need to shift each bit to 0th position or we can shift 1 to ith bit
    //if bit is set return 1 else 0
    public int solve(int A, int B) {
        return ((A >> B) & 1) == 1 ? 1 : 0;
    }
}
