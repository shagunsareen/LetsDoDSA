package dsa.with.shagun.scaler.array.InterviewQuestions.Two;

public class SumOfEvenIndices
{
    public int[] solve(int[] A, int[][] B) {
        int[] res = new int[B.length];

        //Construct a prefix even indices array
        int[] prefixEven = new int[A.length];
        prefixEven[0] = A[0];

        for(int i=1; i<A.length;i++){
            if(i%2==0){ // it is an even index
                prefixEven[i] = prefixEven[i-1] + A[i];
            }else{
                prefixEven[i] = prefixEven[i-1];
            }
        }

        //for all the queries calculate the sum
        for(int j=0; j<B.length; j++){
            if(B[j][0]==0){
                res[j] = prefixEven[B[j][1]];
            }else{
                res[j] = prefixEven[B[j][1]] - prefixEven[B[j][0]-1];
            }
        }

        return res;
    }
}
