package dsa.with.shagun.scaler.array.MultiDArrays;

public class MainDiagonalSum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[][] A) {
        int sum = 0;

        for(int row=0; row<A.length; row++){ // TC : O(N), SC:O(1)
            int col = row;
            sum += A[row][col];
        }
        return sum;
    }
}
