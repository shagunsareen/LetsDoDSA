package dsa.with.shagun.scaler.advance.TwoPointer;

import java.util.Arrays;

public class ThreeSum2 {
        public int threeSumClosest(int[] A, int B) {

            long currDiff = 0;
            long minDiff = Integer.MAX_VALUE;
            long resSum = 0;

            //We will use the same concept as used for 2 pointers.
            //Just that here we need to get 3rd number as well hence we need an extra loop for that.

            Arrays.sort(A); // This will make it easy to move pointers when sum > B or <B

            // This is to fix current element as the least element
            for(int i=0; i<A.length; i++){

                //Take 2 pointers for second element and third element
                int j = i+1;
                int k = A.length-1;

                while(j<k){

                    //calculate sum with all the elements
                    long sum = A[i] + A[j] + A[k];

                    currDiff = Math.abs(sum-B);

                    //update minDiff ans resultant sum
                    if(currDiff < minDiff){
                        minDiff = currDiff;
                        resSum = sum;
                    }

                    if(sum==B){
                        return (int) sum;
                    }else if(sum<B){
                        j++;
                    }else{
                        //sum > B
                        k--;
                    }
                }
            }
            return (int) resSum;
        }
}
