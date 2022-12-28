package dsa.with.shagun.scaler.advance.array;

public class MaxElementOnLeft {

    public static void main(String[] args) {

        getMaxEleOnLeft(new int[]{10,15,17,3,13});
    }

    public static int[] getMaxEleOnLeft(int[] arr) {
        int[] maxEleOnLeftArr = new int[arr.length];

        maxEleOnLeftArr[0]=0; // since for first element there would not be any element on left

        for (int i = 1; i < arr.length; i++) {
            maxEleOnLeftArr[i]= Math.max(maxEleOnLeftArr[i-1], arr[i-1]);
        }
        return maxEleOnLeftArr;
    }
}
