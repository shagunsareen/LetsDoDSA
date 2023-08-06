package dsa.with.shagun.scaler.array.CarryForward;

import java.util.ArrayList;

public class LeaderInArray {

    //CAN"T SOLVE THIS PROBLEM WITH ARRAY , USE ARRAYLIST
    //Approach 1 : Brute force
        /* Iterate through each element and compare with rest of element to check which is max
            TC : O(N*N); SC : O(1)
        */
       /* int N = A.length;
        int[] result = new int[A.length];
        int resultIndex=0;
        for(int i=0; i<N-1; i++){ //TC : O(N)
            int max = A[i+1];
            for(int j=i+1; j<N; j++){ //TC : O(N)
                 if(max < A[j]){
                     max = A[j]; // this way we would get max on right of i;
                 }
            }
            if(A[i] > max){ // meaning i is a Leader
                result[resultIndex] = A[i];
                resultIndex++;
            }
        }
        result[resultIndex] = A[N-1]; //Not working since count is less than the array length
        */

    //Approach 2 : Finding max on right from same ele multiple times is repeating iterations over same set of elements.
    // We can calculate max once from right and keep carrying forward the max info to next left elements

/*    int N = A.length;
    int max = A[N-1];
    int[] result = new int[];
    result[0] = A[N-1]; // since last element is already a leader
    int resIndex=1;
        for(int i=N-2; i>=0; i++){
        if(A[i]>max){
            result[resIndex] = A[i];
            max = A[i];
        }
    }

        return result;
}*/

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        //Approach 1 : Brute force
        /* Iterate through each element and compare with rest of element to check which is max
            TC : O(N*N); SC : O(1)
        */
        // int size = A.size();

        // ArrayList<Integer> result = new ArrayList();
        // result.add(A.get(size-1)); // since last elemet is always a leader

        // for(int i=0; i<=size-2; i++){ //TC : O(N)

        //     int max_from_right = A.get(i+1); // consider max on right to be next element of i

        //     for(int j=i+1; j<size; j++){ //TC : O(N)
        //          if(max_from_right < A.get(j)){
        //              max_from_right = A.get(j); // this way we would get max on right of i;
        //          }
        //     }
        //     if(A.get(i) > max_from_right){ // meaning i is a Leader
        //        result.add(A.get(i));
        //     }
        // }

        //Approach 2 : Finding max on right from same ele multiple times is repeating iterations over same set of elements.
        // We can calculate max once from right and keep carrying forward the max info to next left elements
        //TC : O(N) , SC:O(1)

        int size = A.size();

        int max_from_right = A.get(size-1);

        ArrayList<Integer> result = new ArrayList();
        result.add(max_from_right); // since last elemet is always a leader

        for(int i=size-2; i>=0; i--)
        {
            if(A.get(i) > max_from_right)
            {
                result.add(A.get(i));
                max_from_right = A.get(i); // update current max element
            }
        }

        return result;
    }
}
