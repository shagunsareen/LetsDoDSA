package dsa.with.shagun.scaler.array.MultiDArrays;

public class ColumnSum {
    public static void main(String[] args) {
        solve(new int[][]{{1, 2, 3, 4},
                           {5, 6, 7, 8},
                            {9, 2, 3, 4}});
    }

    public static int[] solve(int[][] A) {
        int N = A[0].length; //columns
        int M = A.length; //rows

        int[] sumArr = new int[N];

        for(int c=0; c<N; c++){
            for(int r=0; r<M; r++){
                sumArr[c] = sumArr[c] + A[r][c];
            }
        }
        return sumArr;  // TC : O(N*M),SC : O(N)
    }
}
