package dsa.with.shagun.scaler.advance.GCD;

public class EnumeratingGCD {
    public String solve(String A, String B) {

        //Step1: check if A equals B, if both are same then GCD is the same number
        if(A.equals(B))
            return A;
        else{
            //Step 2 : if A is not equal to B, i.e. suppose if B=A+1 then if A-(A+1) = 1 i.e. two consecutive numbers can have 1 as GCD , hence 1 would be the greatest divisor among all elements
            return "1";
        }
    }
}
