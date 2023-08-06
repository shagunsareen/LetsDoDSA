package dsa.with.shagun.scaler.advance.DynamicProgramming.ThirdSession;

import java.util.Arrays;

public class ZeroOneKnapsack {
    int[][] dp;

    public int solve(int[] A, int[] B, int C) {

        //A : values, B: weights, C : max. capacity
        //State is f(no.of objects, weight) i.e. dp[n+1][w+1]
        int n = A.length;

        dp = new int[n+1][C+1];

        // update every cell with -1 so that we know this value is already calculated or not
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return getMaxSum(n,C,n-1, n-1, A, B);
    }

    private int getMaxSum(int numObjLeft , int weightLeft, int valIndex, int weightIndex, int[] valArr, int[] weightArr){
        //Base case
        if(numObjLeft == 0 || weightLeft <= 0){
            return 0;
        }

        //if we already have value calculated then return that
        if(dp[numObjLeft][weightLeft] != -1){
            return dp[numObjLeft][weightLeft];
        }

        //we either pick an element or we skip that element.
        //If element is picked then 1.no. of objects left is deducted 2. it's weight is deducted from max capacity 3. its value is added to ans being returned.
        //If element is not picked then only no. of objects left is deducted
        if(weightLeft >= weightArr[weightIndex]){
            dp[numObjLeft][weightLeft] = Math.max(getMaxSum(numObjLeft-1, weightLeft, valIndex-1, weightIndex-1, valArr, weightArr) ,
                    getMaxSum(numObjLeft-1, weightLeft-weightArr[weightIndex], valIndex-1, weightIndex-1, valArr, weightArr)
                            + valArr[valIndex]);

            //System.out.println(" numObjLeft : "+numObjLeft+",weightLeft : "+weightLeft+", ANS : "+dp[numObjLeft][weightLeft]);
        }else{
            dp[numObjLeft][weightLeft] = getMaxSum(numObjLeft-1, weightLeft, valIndex-1, weightIndex-1, valArr,weightArr);
        }

        return dp[numObjLeft][weightLeft];
    }
}
