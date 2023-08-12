package dsa.with.shagun.scaler.advance.TwoPointer;

public class ClosestPairFromSortedArrays2 {
            public int[] solve(int[] A, int[] B, int C) {

            // we need to find minDiff from C so that the new sum is closest to the class
            //let's take one element from A
            int i = 0;
            //let's take one element from B
            int j=B.length-1;

            long currDiff = 0;
            long minDiff = Integer.MAX_VALUE;
            int resFirstIndex = Integer.MAX_VALUE;
            int resSecondIndex = Integer.MAX_VALUE;

            while(i < A.length && j>=0){
                long sum = A[i] + B[j];

                currDiff = Math.abs(sum-C);

                //System.out.println("Sum : "+sum + ", currDiff ");

                //update minDiff and update final indexes
                if(currDiff < minDiff ){
                    minDiff = currDiff;
                    resFirstIndex = i;
                    resSecondIndex = j;
                    //System.out.println("First Ele : " +A[i]+ " - , secondEle : "+ A[j]+ ", - Min Diff : "+minDiff + ", - Res index : "+resFirstIndex+ " - , Res index2 : "+ resSecondIndex);
                }else if(currDiff == minDiff){
                    //if there are multiple solutions then since i is going from left to right we won't update i and will consider lower i MAX_VALUE
                    if(resFirstIndex == i){
                        resSecondIndex = j;
                        // we will update j for multiple solutions since j is moving from right to left hence we will get lower value of j later
                    }
                }

                if(sum == C){
                    i++;
                    j--;
                }else if(sum < C){
                    //then we need to get minDiff we need to move pointer to right to get sum closer to C
                    i++;
                }else{
                    j--; // since sum > C and we need to reduce the sum
                }
            }

            return new int[]{A[resFirstIndex], B[resSecondIndex]};
        }
    }
