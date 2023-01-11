package dsa.with.shagun.scaler.advance.Sorting.session3;

import java.util.HashMap;
import java.util.Map;

public class CountSort { // TC : O(N+N)= O(N) , SC :O(Range i.e. max-min+1)
    public static void main(String[] args) {
        //int[] arr = solve(new int[]{5, 3, 4, 2, 1, 1, 1, 2, 5, 4, 4, 2, 1, 3, 3, 5});
        int[] arr = solve(new int[]{6, 3, 3, 6, 7, 8, 7, 3, 7});
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //Count Sort should be used when we know the range of integers within which all elements are. If range is too high count sort should not be used
    public static int[] solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[A.length];
        int max = 0; // THIS IS REQUIRED BECAUSE IT WILL HELP US KNOW TILL WHICH ELEMENT WE NEED TO ITERATE THE LOOP LATER TO FILL IN THE ARRAY

        //make a frequency hashmap
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            max = Math.max(max, A[i]);
        }

        int index = 0;
        //Iterate over hashmap elements as these are all distinct elements
        for (int j = 0; j <= max; j++) {
            if (map.containsKey(j)) {
                for (int freq = 0; freq < map.get(j); freq++) {
                    arr[index] = j;
                    index++;
                }
            }
        }

        return arr;
    }
}
