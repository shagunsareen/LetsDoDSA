package dsa.with.shagun.scaler.BitManipulation;

public class SetBitInN {
    public int solve(int A, int B) {
        if(A==B){ // when bits to set are same
            return 1<<A;  // if we left shift a number 'a' N times it is equal to a*2^N. As 'a' here is 1 , we can write 2^N as 1<<N
        }else{
            return (1<<A) + (1<<B);  // since 2^A and 2^B has to be set in the ans
        }
    }
}
