package dsa.with.shagun.scaler.advance.Sorting.session3;

import java.util.HashMap;
import java.util.Map;

public class RadixSort {
    public static void main(String[] args) {
       int[] arr = radixSort(new int[]{361, 432, 12, 78, 500, 112, 2});
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] radixSort(int[] arr) {
        //First get max element so that we know how many digits we need to call count sort
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int exp = 1;
        while (max > 0) {
            max /= 10; // This is to iterate for all the places, i.e. ones ,tens, hundreds etc.
            countSort(arr, exp);
            exp *= 10; // keep on increasing exponential as we need to go from one's place to max digits place
        }

        return arr;
    }

    public static int[] countSort(int[] A, int exp) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[A.length];
        int max = 0; // THIS IS REQUIRED BECAUSE IT WILL HELP US KNOW TILL WHICH ELEMENT WE NEED TO ITERATE THE LOOP LATER TO FILL IN THE ARRAY

        //make a frequency hashmap
        for (int i = 0; i < A.length; i++) {
            map.put((A[i] / exp) % 10, map.getOrDefault(A[i], 0) + 1);
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
