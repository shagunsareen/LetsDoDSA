package dsa.with.shagun.scaler.advance.TwoPointer;

public class CountRectangles {

    /*
    Given a sorted array of distinct integers A and an integer B,
    find and return how many rectangles with distinct configurations can be created using elements of this array as length
    and breadth whose area is lesser than B.
    (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)

    1 <= |A| <= 100000
    1 <= A[i] <= 109
    1 <= B <= 109

    The first argument given is the integer array A.
    The second argument given is integer B.

    Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).
    */

    public int solve(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        long count = 0;
        long mod = 1000000007;
        while (l < A.length && r >= 0) {
            long area = ((long) A[l] * A[r]) % mod;
            if (area < B) {
                //all elements between this range will have lesser area
                int eleInRange = r - l + 1;  // this will include rectangle with  l*l dimensions as well
                long pairs = 2L * eleInRange - 1;// since we don't want to include l*l twice, here 2L means long data type 2
                count += pairs;
                count %= mod;
                l++;
            } else {
                r--;
            }
        }
        return (int) (count % mod);
    }
}
