package dsa.with.shagun.scaler.array.PrefixSum;

public class RangeSumQuery {
    public long[] rangeSum(int[] A, int[][] B) {

       /* Approach 1 -- 0 indexed. Take each array as it is , just take L R decrement 1 to refer to actual indexes

               //create prefix sum array
                int[] pf = new int[A.length];
                pf[0] = A[0]; // since prefix sum for zero remains same as array value

                for(int j = 1; j<A.length; j++){  //TC : O(N)
                    pf[j] = pf[j-1] + A[j];
                }

                long[] result = new long[B.length];

                for(int i = 0; i<B.length; i++){  //TC : O(B.length)
                    int L = B[i][0];
                    int R = B[i][1];

                    if(L-1 == 0){
                        result[i] = pf[R-1];
                    }else{
                        result[i] = pf[R-1] - pf[L-1-1];
                    }
                }
                return result;   // Total TC : O(N+B.length) , SC : O(N);*/

             //Approach 2 : 1-indexed (create both arrays as 1-indexed and take L R as it is)
            //create prefix sum array
            long[] pf = new long[A.length+1];  // since A is 1-indexed

            for(int j = 1; j<A.length+1; j++){  //TC : O(N)
                pf[j] = pf[j-1] + A[j-1];  // j-1 to not skip value at 0th position
            }

            long[] result = new long[B.length];

            for(int i = 0; i<B.length; i++){  //TC : O(B.length)
                int L = B[i][0];
                int R = B[i][1];

                result[i] = pf[R] - pf[L-1];
            }
            return result;   // Total TC : O(N+B.length);
        }
}
