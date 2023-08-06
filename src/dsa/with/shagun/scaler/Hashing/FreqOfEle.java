package dsa.with.shagun.scaler.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class FreqOfEle {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(solve(new int[]{ 6, 3, 3, 6, 7, 8, 7, 3, 7 }, new int[]{10,9,8})).toArray());
    }

    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        //frequency hashmap of arr elements TC: O(N), SC: O(N)
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        //getting fre for B.length queries TC : O(B.length*1), SC :O(1)
        int[] ans = new int[B.length];
        for(int i=0; i<B.length; i++){
            if(hm.containsKey(B[i])){ // this is required to avoid null pointer exception since there can be queries which are not present in array as ele
                ans[i] = hm.get(B[i]);
            }
        }

        return ans;
    }
}
