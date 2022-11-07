package dsa.with.shagun.scaler.Strings;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solve(new int[]{6, 3, 3, 6, 7, 8, 7, 3, 7})));
        System.out.println(Arrays.toString(solve(new int[]{10, 9, 8 })));
    }

    public static int[] solve(int[] A) {
        // get max. ele of array so that freq array length can be
        //TC : O(N), SC:O(1)
        int n = A.length;
        int mx = -1;
        for(int i = 0 ; i < n ; i++){
            mx = Math.max(mx, A[i]);
        }

        //create a frequency array with length of max ele +1 as we need to store each ele to it's corresponding index.
        //ex:  max ele is 10 to store it at 10 we need to have index 10
        //TC : O(N), SC:O(N)
        int[] freq = new int[mx + 1];
        for(int i = 0 ; i < n ; i++){
            freq[A[i]] += 1;
        }


        //iterate over freq array to print each ele same number of times as it's frequency
        //TC : O(N), SC:O(1)  Since we are printing n ele in total hence freq is O(N)
        int k = 0;
        for(int i = 0 ; i <= mx ; i++){
            for(int j = 0 ; j < freq[i] ; j++){
                A[k] = i;
                k++;
            }
        }
        return A;
        // Total TC : O(N+N+N) = O(N),SC: O(N)

        //DIDN'T WORK
        /*//TC : O(N), SC:O(N)
        //freqMap
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        //frequency hashmap of arr elements TC: O(N), SC: O(N)
        for (int i = 0; i < A.length; i++) {
            freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
        }

        int index = 0;
        for (int i = 1; i < freqMap.size(); i++) {
            for (int j = 0; j < freqMap[i]; j++) {  // this is to print ele 'k' number of times where k is freq of that ele
                A[index] = i+1;
                index++;
            }
        }
        return A;*/
    }
}
