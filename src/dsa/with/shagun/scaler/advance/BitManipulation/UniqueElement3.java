package dsa.with.shagun.scaler.advance.BitManipulation;

public class UniqueElement3 {
    public int[] solve(int[] A) {

        //Step1 : Take XOR of all the elements
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
        }

        //Step2 : xor contains XOR of only 2 unique elements since all other elements would have cancelled to 0 as a^a=0;
        //Check which bit is different in both numbers and split them as per that.
        int bitPos = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(xor, i)) {
                bitPos = i;
                break;
            }
        }

        //Step3: split array based on 'bitPos' position
        int set = 0;
        int unset = 0;
        for (int i = 0; i < A.length; i++) {
            if (checkBit(A[i], bitPos)) { // segregate set bit position elements xor to get one unique element
                set = set ^ A[i];
            } else {
                unset = unset ^ A[i];
            }
        }
        int firstEle = set;
        int secondEle = unset;
        if (set > unset) {
            firstEle = unset;
            secondEle = set;
        }
        return new int[]{firstEle, secondEle};
    }

    //check if bit is set or not
    public static boolean checkBit(int A, int B) {
        return ((A >> B) & 1) == 1;
    }
}
