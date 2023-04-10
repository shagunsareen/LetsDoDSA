package dsa.with.shagun.scaler.array.MultiDArrays;

public class AreMatricesSame {
    public int solve(int[][] A, int[][] B) {
        int r = A.length;
        int c = A[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(A[i][j]!=B[i][j]){
                    return 0;
                }
            }
        }

        return 1;
    }
}
