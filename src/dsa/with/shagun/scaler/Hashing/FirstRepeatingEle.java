package dsa.with.shagun.scaler.Hashing;

import java.util.HashMap;

public class FirstRepeatingEle {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{10, 5, 3, 4, 3, 5, 6}));
        System.out.println(solve(new int[]{6, 10, 5, 4, 9, 120}));
    }

    public static int solve(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        //frequency hashmap of arr elements TC: O(N), SC: O(N)
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        //since hm doesn't reserve the insertion order we can't pick the first ele from hm with fre=1
        //so we need to iterate over array to get first non-repeating ele, TC : O(N), SC:O(1)
        for(int i=0;i<A.length;i++){
            if(hm.get(A[i])>1){
                return A[i];
            }
        }
        return -1;
    }
}
