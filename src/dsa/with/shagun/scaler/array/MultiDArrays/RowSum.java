package dsa.with.shagun.scaler.array.MultiDArrays;

public class RowSum {
    public int[] solve(int[][] A) {

        int N = A[0].length; //columns
        int M = A.length; //rows

        int[] rowSumArr = new int[M];

        for(int r=0; r<M; r++){
            int rowSum =0;
            for(int c=0; c<N; c++){
                rowSum += A[r][c];
            }
            rowSumArr[r] = rowSum;
        }
        return rowSumArr;  // TC : O(N*M), SC: O(M)
    }
}
