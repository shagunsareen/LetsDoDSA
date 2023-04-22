package dsa.with.shagun.scaler.advance.DynamicProgramming;

public class MaXSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[] B = new int[m];

        //Convert 2D matrix to 1D matrix taking max of elements in same column since we can't take adjacent elements and we need max sum hence taking 1 out of both makes sense
        for(int j=0; j<m; j++){
            B[j] = Math.max(A[0][j], A[1][j]);
            //System.out.println(" j : "+j + " - "+B[j]+" - length : "+B.length);
        }

        //Now we have 1D array , we need to make sum max out of this Now
        int[] dp = new int[m];


        if(B.length == 1){
            return B[0];
        }

        if(B.length > 1){
            dp[0] = B[0];
            dp[1] = Math.max(dp[0], B[1]);
        }

        //System.out.println(dp[0] + " - " +dp[1]  + " - "+dp.length);

        //Now either we can select an element or we can ignore an element so that max sum is maintained
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], B[i]+dp[i-2]);
            //System.out.println("i: " +dp[i]);
        }

        return dp[m-1];
    }
}
