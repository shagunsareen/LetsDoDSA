package dsa.with.shagun.scaler.advance.array.array2;

public class SubMatrixSubQueries {
    public static void main(String[] args) {
        solve(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 2}, new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 3});
    }

    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

       /* //column prefix matrix
        for (int i = 0; i < A.length; i++) { //rows
            for (int j = 1; j < A[0].length; j++) { //columns
                A[i][j] += A[i][j - 1];
            }
        }

        //row prefix matrix
        for (int j = 0; j < A[0].length; j++) { //rows
            for (int i = 1; i < A.length; i++) { //columns
                A[i][j] += A[i - 1][j];
            }
        }

        //TC : O(M*N) -->creating prefix matrix for column sum and then row sum

        //Now let's get sum for the queries given with TL and BR
        int ans[] = new int[B.length];
        double mod = Math.pow(10, 9) + 7;
        for (int k = 0; k < B.length; k++) { // these are for iterating over every query
            int r1 = B[k] - 1;
            int r2 = D[k] - 1;
            int c1 = C[k] - 1;
            int c2 = E[k] - 1;

            //now that we have Top Left and Bottom Right corners let's take sum of rectangles
            int sum = 0;
            sum += A[r2][c2];

            if (r1 > 0) {
                sum -= A[r1 - 1][c2];
            }
            if (c1 > 0) {
                sum -= A[r2][c1 - 1];
            }
            if (r1 > 0 && c1 > 0) {
                sum += A[r1 - 1][c1 - 1];
            }
            ans[k] = (int)(((sum % mod)+mod)%mod);

        }
        //TC : O(Q) ---> for processing Q queries to get sum of submatrix. Total TC : O(M*N + Q)
        //SC : O(1) -->since we are not using any extra space
        return ans;
*/

        int n = A.length;
        int m = A[0].length;
        int mod = 1000000007;

        long psum[][] = new long[n][m];

        //Row wise Prefix sum

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    psum[i][j] = A[i][j];
                }else{
                    psum[i][j] = psum[i][j-1] + A[i][j];
                }

            }
        }

        //Column wise prefix sum

        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                psum[i][j] = psum[i-1][j]+ psum[i][j];
            }
        }

        int [] subMatrixSum = new int[B.length];
        //Solving the query

        for(int i =0;i<B.length;i++){
            //Top left
            int x1 = B[i] -1;
            int y1 = C[i] -1;

            //Bottom Right
            int x2 = D[i] -1;
            int y2 = E[i] -1;

            long sum =0;

            sum += psum[x2][y2];

            if(x1>0){
                sum -= psum[x1-1][y2];
            }

            if(y1>0){
                sum -= psum[x2][y1-1];
            }

            if(x1>0 && y1>0){
                sum += psum[x1-1][y1-1];
            }

            subMatrixSum[i] = (int)(((sum % mod)+mod)%mod);
        }

        return subMatrixSum;
    }
}
