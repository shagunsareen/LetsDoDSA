package dsa.with.shagun.scaler.advance.TwoPointer;

public class ThreeSum {
    public static void main(String[] args) {
        //System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        //System.out.println(threeSumClosest(new int[]{1, 2, 3}, 6));
        System.out.println(threeSumClosest(new int[]{
                -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4,
                -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6,
                3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0,
                -4, -3, 1, 6, -3}, -1));
    }

    public static int threeSumClosest(int[] A, int B) {
        //This approach won't work since one out of three pointers is always stuck and is not moving
        /*int i = 0;
        int j = 1;
        int k = 2;

        long res = 0;
        long sum = 0;
        long diff;
        long minDiff = Integer.MAX_VALUE;

        while (i < A.length && j < A.length && k < A.length) {

            sum += A[i] + A[j] + A[k];  //add 3 elements

            if (sum == B) {
                return (int) sum;
            } else if (sum > B) {
                diff = sum - B;

                if (diff < minDiff) {  //whatever best we had till now we will compare this with that and update res accordingly
                    minDiff = diff;
                    res = sum;
                }

                // remove leftmost element
                sum -= A[i];
                i++;  // increment smallest element since with that we are not able to get closest sum to B
            } else {
                // sum<B
                diff = B - sum;

                if (diff < minDiff) {
                    minDiff = diff;
                    res = sum;
                }

                //add next element
                k++;
                //sum += A[k];
            }
        }
        return (int) res;*/

        //APPROACH : Instead the approach to be used is fix one variable and use 2 pointer for rest of the elements

        //TC :O(n2),SC:O(1)
        long diff = 0;
        long res =0;
        long minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) { // this pointer will move
            int j = i + 1;
            int k = A.length - 1;

            while (j < k) {
                long sum = A[i] + A[j] + A[k];
                diff = Math.abs(sum-B);
                if (diff < minDiff) {  //whatever best we had till now we will compare this with that and update res accordingly
                    minDiff = diff;
                    res = sum;
                }

                if (sum == B) {
                    return B;
                } else if (sum > B) {
                    k--; // since sum>B decrement rightPointer
                }else{
                    j++; // since sum<B increment leftPointer
                }
            }
        }
        return (int) res;
    }

}
