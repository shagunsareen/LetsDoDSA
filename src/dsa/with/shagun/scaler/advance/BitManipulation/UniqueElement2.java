package dsa.with.shagun.scaler.advance.BitManipulation;

public class UniqueElement2 { // every element appears thrice ,only one element appears once
    public int singleNumber(final int[] A) {

        //Approach 1 : check for every element freq is 3 or not TC :O(n2), SC :O(1)

        //Approach 2 : keep freq in hashmap and check which elements freq is not 3,TC: O(n),SC:O(n)

        //Approach 3 : Sort array and check freq. If ele is not same as prev ele then check what is the freq of that ele, TC:O(nlogn), SC:O(1)

        //Approach 4 : use bits of numbers to see which position bit doesn't have exact multiple of 3 i.e. since if a bit is set then it would be set in 3 numbers so it should be divisible by 3. If it's not divisible then unique element bit is set otherwise unset.

        int uniqueEle = 0;
        //Step1 : int can have 32 bits
        for (int i = 0; i < 32; i++) {
            int count = 0;
            //Step2 : for every element in array check ith bit is set or not
            for (int j = 0; j < A.length; j++) {
                if (checkBit(A[j], i)) {
                    count += 1; // increment count when bit is set
                }
            }

            //Step3 : check if bit is set in unique ele or not
            if (count % 3 == 1) { //meaning we have ith bit set in unique element, hence set it
                uniqueEle = uniqueEle | (1 << i);
            }
        }
        return uniqueEle;
    }

    //check if bit is set or not
    public static boolean checkBit(int A, int B) {
        return ((A >> B) & 1) == 1;
    }
}
