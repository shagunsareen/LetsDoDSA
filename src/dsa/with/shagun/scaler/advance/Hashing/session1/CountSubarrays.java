package dsa.with.shagun.scaler.advance.Hashing.session1;

import java.util.HashMap;
import java.util.HashSet;

public class CountSubarrays {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 1, 3, 4, 5}));
        System.out.println(solve(new int[]{2, 1, 2}));
    }

    public static int solve(int[] A) {

        /*HashSet<Integer> hs = new HashSet<>();
        int i = 0; // left pointer
        int j = 0; // right pointer
        long count = 0;
        long mod = 1000 * 1000 * 1000 + 7;

        while (j < A.length) {
            if (hs.contains(A[j])) { // window has duplicate elements
                hs.remove(A[i]); // remove the duplicate element
                i++; //move left pointer to exclude duplicate element
            } else {
                // if it's not a duplicate element
                hs.add(A[j]);
                count += j - i + 1;
                j++;
            }
        }
        return (int) (count % mod);*/

        /*HashMap<Integer, Integer> hm = new HashMap<>();
        long mod = 1000 * 1000 * 1000 + 7;
        long count = 0; // to get no. of subarrays with unique elements
        int latestDupEleIndex = 0;
        for (int j = 0; j < A.length; j++) {
            //but what if we have duplicates we need to keep track of those where the last duplicate was to exclude those many subarrays from count
            if (!hm.containsKey(A[j])) {
                // element is not present in hashmap ,store index for future purpose
                hm.put(A[j], j);
                count += j + 1; // no. of subarrays in which this element will come
            } else {
                int lastIndexOfCurrEle = hm.get(A[j]);
                // This is required since there can be duplicate different elements after last index of current element. To exclude those elements we need to compare this
                latestDupEleIndex = Math.max(latestDupEleIndex, lastIndexOfCurrEle);
                // if element is already there, then subtract no. of subarrays that can be contructed with that index
                count += (j + 1) - (latestDupEleIndex + 1);
            }
        }
        */

        HashMap<Integer, Integer> hm = new HashMap<>();
        long mod = 1000 * 1000 * 1000 + 7;
        long count = 0; // to get no. of subarrays with unique elements
        int i = 0;
        int j=0;

        while(j<A.length){
            if (!hm.containsKey(A[j])) {
                hm.put(A[j], j);
                count += j - i + 1;
                j++;
            } else {
                //decrease window size
                hm.remove(A[i]);
                i++;
                /*while (hm.containsKey(A[j])) { // till duplicate ele is not removed from window increment j
                    hm.remove(A[i]);
                    i++;
                }*/
            }
        }
        return (int) (count % mod);
    }
}
