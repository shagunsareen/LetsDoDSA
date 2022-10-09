package dsa.with.shagun.scaler.array.SubArrays;

public class MaximumSubArrayEasy {
    public static void main(String[] args) {

        System.out.println(maxSubarray(5,7,new int[]{ 3, 8, 8, 9, 7 }));
    }

    public static int maxSubarray(int A, int B, int[] C) {

       /* Approach 1 : //construct prefix sum array
        int[] pf = new int[A];
        pf[0] = C[0];

        for(int i=1; i<A; i++){  // TC: O(N)
            pf[i] = pf[i-1] + C[i];
        }

        int sum = 0;
        int max = 0;
        for(int s=0;s<A;s++){ // fix start
            for(int e=s; e<A;e++){  // fix end
                if(s==0){
                    sum = pf[e];
                }else{
                    sum = pf[e] - pf[s -1];
                }

                if(sum>max && sum<=B){
                    max = sum;
                }
            }
           return max; // TC : O(N2),SC: O(N)
        }*/

        //Approach 2: Carry forward sum value , TC :O(N2), SC :O(1)
        int max = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C[j];
                if (sum <= B)
                    max = Math.max(max, sum);
                else break;
            }
        }
        return max;
    }
}
