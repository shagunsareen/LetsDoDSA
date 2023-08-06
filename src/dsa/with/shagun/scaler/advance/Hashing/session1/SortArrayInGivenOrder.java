package dsa.with.shagun.scaler.advance.Hashing.session1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//TC: O(NlogN) and SC: O(M)
/*
Given two arrays of integers A and B, Sort A in such a way that the relative order
among the elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.
* */
public class SortArrayInGivenOrder {
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);

        ArrayList<Integer> ar2 = new ArrayList();
        ar2.add(5);
        ar2.add(4);
        ar2.add(2);

        solve(ar, ar2);
    }

    static class sortOrder implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (hm.containsKey(o1) || hm.containsKey(o2)) {
                return hm.getOrDefault(o1, 0) - hm.getOrDefault(o2, 0);
            }
            return o1 - o2;
        }
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int m = B.size();
        for (int i = 0; i < m; i++) {
            hm.put(B.get(i), i - m);
        }
        Collections.sort(A, new sortOrder());
        hm.clear();
        return A;
    }
}
