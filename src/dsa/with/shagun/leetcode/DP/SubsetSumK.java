package dsa.with.shagun.leetcode.DP;

public class SubsetSumK {
        /* Approach 1 : Memoization
    static int[][] dp;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        dp = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        //memoization should happen from top to down meaning from start to base case
        return isSubsetSum(arr, k, n-1);
    }

    private static boolean isSubsetSum(int[] arr, int target, int index){
        //if we have reached the target
        if(target == 0){
            return true;
        }

        if(index < 0){
            return false;
        }

        //or if we have reached 0th row and target is same as element value then its true
        if(index == 0 && arr[index] == target)
        {
            return true;
        }

        if(dp[index][target] != -1){
            return dp[index][target] == 0 ? false : true;
        }

        //either take the element or not take the element
        boolean taken = false;

        if(arr[index] <= target){
            taken = isSubsetSum(arr, target-arr[index], index-1);
        }

        boolean notTaken = isSubsetSum(arr, target, index-1);

        dp[index][target] = (taken || notTaken) ? 1 : 0;
        return taken || notTaken;
    }*/

    //Approach : Tabulation
    /*static boolean[][] dp;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        dp = new boolean[n][k+1];

        //base case : we can always have target as 0 by not choosing any element from array so mark all elements from arr table as true
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }


        //fill initial col
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }

        //check the params index and target and see till where it goes
        for(int index = 1; index < n; index++){
            for(int target = 1; target <= k; target++){

                boolean taken = false;

                if(arr[index] <= target){
                    taken = dp[index - 1][target-arr[index]]; //This means we check if prev index has leftover target or not
                }

                boolean notTaken = dp[index-1][target];

                dp[index][target] = taken || notTaken;
            }
        }

        //we need to check if using all elements do we have target sum as required and if its true then it is possible
        return dp[n-1][k];
    }*/

    static boolean[] prev;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        prev = new boolean[k+1];  //only stores target values

        prev[0] = true;

        //fill initial col
        if(arr[0] <= k){
            prev[arr[0]] = true;
        }

        //check the params index and target and see till where it goes
        for(int index = 1; index < n; index++){

            boolean[] curr = new boolean[k+1]; //since k+1 cols we need in an array
            curr[0] = true;
            for(int target = 1; target <= k; target++){

                boolean taken = false;

                if(arr[index] <= target){
                    taken = prev[target-arr[index]]; //This means we check if prev index has leftover target or not
                }

                boolean notTaken = prev[target];

                curr[target] = taken || notTaken;
            }
            prev = curr;
        }

        //we need to check if using all elements do we have target sum as required and if its true then it is possible
        return prev[k];
    }
}
