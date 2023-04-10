package dsa.with.shagun.scaler.array.MultiDArrays;

public class MatrixScalarProduct {
    public int[][] solve(int[][] A, int B) {

        int r = A.length;
        int c = A[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                A[i][j] = B*A[i][j];
            }
        }

        return A;
    }
}
