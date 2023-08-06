package dsa.with.shagun.scaler.advance.DynamicProgramming.ThirdSession;

import java.util.Arrays;

public class UnboundedKnapsack {
    int[][] dp;
    public int solve(int A, int[] B, int[] C) {

        //A : knapsack weight, B: value, C : weight
        //State is f(no.of objects, weight) i.e. dp[n+1][w+1]
        int n = B.length;

        dp = new int[n+1][A+1];

        //update every cell with -1
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return getMaxSum(n, A, C, B, n-1, n-1);
    }

    private int getMaxSum(int objLeft, int weightLeft, int[] wArr, int[] vArr, int vIndex, int wIndex){

        if(objLeft == 0|| weightLeft==0){
            return 0;
        }

        if(dp[objLeft][weightLeft] != -1){
            return dp[objLeft][weightLeft];
        }

        // either we can select an integer or we can ignore an integer
        // we will calculate sum for both scenarios and see which is maximum
        if(weightLeft >= wArr[wIndex])
        {
            dp[objLeft][weightLeft] = Math.max(getMaxSum(objLeft-1, weightLeft, wArr, vArr, vIndex-1, wIndex-1),  // didn't select curr ele
                    getMaxSum(objLeft, weightLeft-wArr[wIndex], wArr, vArr, vIndex, wIndex)  //selected curr ele
                            + vArr[vIndex]);  // value of curr ele added if it is selected
        }else{
            dp[objLeft][weightLeft] = getMaxSum(objLeft-1, weightLeft, wArr, vArr, vIndex, wIndex);
        }

        return dp[objLeft][weightLeft];
    }
}
