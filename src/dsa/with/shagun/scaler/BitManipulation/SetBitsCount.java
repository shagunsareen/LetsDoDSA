package dsa.with.shagun.scaler.BitManipulation;

public class SetBitsCount {
    //Approach 1: convert int to binary and check every bit is set or not

    // Approach 2 : Better
    //since N is an int it will have 32 bits if processor is of 32 bit i.e. range = [0-31]
    public int numSetBits(int A) { //TC : O(1) since iterations are 32
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if (checkBit(A, i) == 1) {
                count++;
            }
        }
        return count;
    }
    //since we need to check bit by bit, if we take AND of bit with 1 then if ans bit =1 meaning bit is set in N else it is unset
    //so to apply same logic for every bit we need to shift each bit to 0th position or we can shift 1 to ith bit
    //if bit is set return 1 else 0
    public int checkBit(int A, int B) {
        return ((A >> B) & 1) == 1 ? 1 : 0;
    }

    //Approach 3 : move every bit 1 by 1 to right and take and with 1, update N after shifting, check till N>0 instead of directly substituting 31
    //TC : O(logN) since >> means dividing by 2 hence how many times we should divide N by2 so that it becomes 1 is logN
   /* while(A>0){
        if((A&1)==1) { //check if 0th bit is set then increase count
            count++;
            A = A>>1;
        }
    }
    return count;*/
}
