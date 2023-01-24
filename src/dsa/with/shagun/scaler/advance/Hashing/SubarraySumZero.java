package dsa.with.shagun.scaler.advance.Hashing;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumZero {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{-1, 1};
        int[] c = new int[]{96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93,
                5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33,
                -12, -94, -80, -71, 48, -93, 62};

        //System.out.println(solve(a));
        //System.out.println(solve(b));
        System.out.println(solve(c));
    }

    public static int solve(int[] A) {

        //Bruteforce : For every subarray check if sum is equal to zero
        //TC : O(N2), SC:O(1)

        //Better solution : Prefix array
        //TC :O(N), SC:O(N+N),for prefix array and hashmap
        int[] pf = new int[A.length];
        pf[0] = A[0];

        //if first element itself is zero then return ans
        if (A[0] == 0) {
            return 1;
        }
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] + A[i];

            if (pf[i] == 0) {
                return 1;
            }
        }
        //if there is no direct subarray where we are getting sum as 0 ,
        // we need to check subarrays where sum is same which means elements between them sum up to 0

        // insert elements to hashmap
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < pf.length; i++) {
            if (hs.contains(pf[i])) {
                //if prefix sum already exists, this means when i - hs.get(pf[i]) index subarrays would sum up to 0
                return 1;
            } else {// if prefix sum is not present add it
                hs.add(pf[i]);
            }
        }
        return 0;
    }
}
