package dsa.with.shagun.scaler.advance.Sorting.session2;

import java.util.Arrays;

public class UniqueElements {
        public int solve(int[] A) {

            //sample array = [ 1, 3, 4, 4, 5, 6]

            //if all elements are unique then no steps are required
            //but if there are duplicates then obviously we need to replace them
            Arrays.sort(A); // TC : O(nlogn)

            int i = 0;
            int n = A.length;
            int steps = 0;

            while(i < n-1){
                /*if(A[i]<A[i+1]){ //nothing to do since these are different }*/

                if(A[i] == A[i+1]){ //since these are same incerement next one
                    steps++;
                    A[i+1]++; //increment value at that index
                }else if(A[i] > A[i+1]){
                    //suppose A[i] = 8, A[i+1] = 4, then make A[i+1] as A[i] + 1 simply to make sure that our current value is greater than the previous value
                    int temp = A[i+1];
                    A[i+1] = A[i] + 1;
                    steps = steps + (A[i+1] - temp);
                }
                i++;
            }

            return steps;
        }
}
