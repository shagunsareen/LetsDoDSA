package dsa.with.shagun.scaler.array.MultiDArrays;

public class AddMatrices {
    public int[][] solve(int[][] A, int[][] B) {

        int r = A.length;
        int c = A[0].length;
        int[][] res = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                res[i][j] = A[i][j] + B[i][j];
            }
        }

        return res;
    }
}
