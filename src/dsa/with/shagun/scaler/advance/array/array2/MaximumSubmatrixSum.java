package dsa.with.shagun.scaler.advance.array.array2;

public class MaximumSubmatrixSum {
    public long solve(int[][] A) {

        /* Approach 1 : For all possible submatrices and find sum for each matrix.
            No. of submatrices = ((N+1)N*M(m+1))/4 ~ O(N^2*M^2)
            Time taken to go through each submatrix and calculate sum :O(NM)
            Total TC : O(N^3*M^3),SC : O(1)

           Approach 2 : We can calculate sum using prefixRowSumColumnSumMatrix
           No. of submatrices = ((N+1)N*M(m+1))/4 ~ O(N^2*M^2)
           TC for prefix sum : O(NM), Total TC : O(N^3*M^3),SC : O(1)SC:O(NM)

           Approach 3 : Since we know we need to find max submatrix , and since it's sorted can we assume max. element would be always at BR corner
           To include that element in our submatrix one end would always be BR corner, hence reducing M^2 in total TC for BR options
           TC : O(NM)*O(1) + O(NM), SC:O(NM)
         */

        int n = A.length;
        int m = A[0].length;
        int x2 = n - 1;
        int y2 = m - 1;
        long ans = 0;
        long sum = 0;

        //Step1 : This is important since if last element i.e. the maximum is negative there is no point to include more elements as they will lesser than that.
        if(A[x2][y2] < 0 ) return A[x2][y2];

        //Step2 : Construct Prefix Sum
        long[][] psum = getPrefixSumMatrix(A);

        //Step3 : Take all possible TopLeft elements and keep BR fixed and calculate max sum
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                // These will give all possible TL cordinates
                sum = getSumOfSubmatrix(k, x2, l, y2, psum);
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public long getSumOfSubmatrix(int x1, int x2, int y1, int y2, long[][] psum) {

        long sum = 0;

        sum += psum[x2][y2];

        if (x1 > 0) {
            sum -= psum[x1 - 1][y2];
        }

        if (y1 > 0) {
            sum -= psum[x2][y1 - 1];
        }

        if (x1 > 0 && y1 > 0) {
            sum += psum[x1 - 1][y1 - 1];
        }
        return sum;
    }

    private long[][] getPrefixSumMatrix(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        long[][] psum = new long[n][m];

        //Row wise Prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    psum[i][j] = A[i][j];
                } else {
                    psum[i][j] = psum[i][j - 1] + A[i][j];
                }
            }
        }

        //Column wise prefix sum
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                psum[i][j] = psum[i - 1][j] + psum[i][j];
            }
        }
        return psum;
    }
}
