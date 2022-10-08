package dsa.with.shagun.scaler.array.CarryForward;

public class ClosestMinMax {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{ 814, 761, 697, 483, 981 , 483, 981}));
    }

    public static int solve(int[] A) {

        //Approach 1 : Brute force , TC: O(N*N) , SC: O(1)

        //Find the min and max element of the subarray
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){  // TC : O(N)
            if(A[i] > max){
                max = A[i];
            }else if(A[i] < min){
                min = A[i];
            }
        }

        if(min==max){
            return 1;
        }

        //Now, we need to find subarray that contains this min and max element
        int minSubArrLength = A.length;
/*        for(int j = 0; j<A.length; j++){
            if(A[j] == min){ // if we get min element first lets find max element on the right now
                for(int k = j+1 ; k<A.length; k++){
                    if(A[k] == max){
                        minSubArrLength = Math.min(minSubArrLength, k-j+1);//TC: O(1)
                        break;
                    }
                }
            }else if(A[j] == max){
                for(int k = j+1 ; k<A.length; k++){
                    if(A[k] == min){
                        minSubArrLength = Math.min(minSubArrLength, k-j+1);//TC: O(1)
                        break;
                    }
                }
            }
        }*/

        //Approach2
        int min_index = -1;
        int max_index = -1;

        for(int j=0; j<A.length; j++){ //TC : O(N)
            if(A[j] == min){
                min_index = Math.max(min_index,j);
            }
            if(A[j] == max){
                max_index = Math.max(max_index, j);
            }

            if(min_index != -1 && max_index != -1){  // because we don't want to calculate length of subarray when there is no change in min & maxIndex because we have not got min or max in that case
                int length = Math.abs( max_index - min_index) + 1;
                minSubArrLength = Math.min(minSubArrLength, length);
            }
        }


        return minSubArrLength;
    }
}
