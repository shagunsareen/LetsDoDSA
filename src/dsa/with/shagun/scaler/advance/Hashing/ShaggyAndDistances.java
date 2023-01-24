package dsa.with.shagun.scaler.advance.Hashing;

import java.util.HashMap;

public class ShaggyAndDistances {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{7, 1, 3, 4, 1, 7}));
        System.out.println(solve(new int[]{1,1}));
    }

    public static int solve(int[] A) {
        // Brute force : Check for every pair |i-j| if 2 elements are equal. TC : O(n2), SC:O(1)

        // Optimised : Using hashing to store last latest index as we need to track min. diff between indexes.
        // Whenever we want to track indexes wecan go with hashing.
        HashMap<Integer, Integer> hm = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(A[i])) {
                int lastIndex = hm.get(A[i]);
                if (Math.abs(lastIndex - i) < minLen) {  // if current pair of indexes have lesser length than earlier pair then update minLength ans update indexes  also
                    minLen = Math.abs(lastIndex - i);
                }
            }

            hm.put(A[i], i); // Key - element , Value - latest index of element in array
        }
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}
