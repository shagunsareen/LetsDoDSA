package dsa.with.shagun.scaler.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctEle {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 4, 3, 6, 6}));
        System.out.println(solve(new int[]{3, 3, 3, 9, 0, 1, 0}));
    }

    public static int solve(int[] A) {

        //Approach 1: TC:O(N), SC:O(N)
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<A.length; i++){
            hs.add(A[i]);  // since hashset doesn't allow duplicates to be inserted all ele which will be in hashset are unique
        }
        return hs.size();

        //Approach 2: using java 8 streams functions.This internally uses hashset which has same TC :O(N)
        // return (int)Arrays.stream(A).distinct().count();
    }
}
