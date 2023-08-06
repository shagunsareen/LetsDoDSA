package dsa.with.shagun.scaler.array.CarryForward;

public class BuyAndSellStockOne {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1}));
        System.out.println(maxProfit(new int[]{1, 4, 5, 2, 4}));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int maxProfit(final int[] A) {
        // Approach 1 : Brute force : TC : O(n2), SC:O(1)
        // For every element check max on right and store maxProfit in variable and take max maxProfit

        //Approach 2 : Carry forward the max value i.e. store valof maxOnRight and calculate difference between current val and maxonRight to get maxProfit
        //  Compare current element val to maxR, if curr elem doesn't have greater ele on right then maxProfit = 0 i.e. maxR = currElement itself otherwise take difference i.e. maxProfit
        int n = A.length;

        if(n==0){
            return 0;
        }

        int maxR = A[n - 1];
        int maxProfit = 0;

        for(int i=n-1; i>=0; i--){
            if(A[i] > maxR){
                maxR = A[i];  // if current ele is greater than right ele then we can sell the stock on the same day itself
            }else{
                maxProfit = Math.max(maxProfit, maxR-A[i]);
            }
        }
        return maxProfit;


        /*int n = A.length;
        if(n==0){
            return 0;
        }
        int maxR = A[n - 1];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            if (A[i + 1] > maxR) { //update rightMax
                maxR = A[i + 1];
            }

            if(maxR < A[i]){
                maxProfit=0;
            }else{
                maxProfit = Math.max(maxProfit, maxR-A[i]);
            }
        }
        return maxProfit;*/
    }
}
