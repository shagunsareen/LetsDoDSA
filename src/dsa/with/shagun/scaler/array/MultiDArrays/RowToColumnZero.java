package dsa.with.shagun.scaler.array.MultiDArrays;

public class RowToColumnZero
{
    public int[][] solve(int[][] A) {
        int r = A.length;
        int c = A[0].length;

        //Store row and column indexes where we get zero. This will help us to mark entire row and col as zero later
        int[] row = new int[r];
        int[] col = new int[c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(A[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        //Now mark entire row and col as 0 as per stored earlier
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(row[i] == 1 || col[j] == 1){
                    A[i][j]=0;
                }
            }
        }

        return A;
    }
}
