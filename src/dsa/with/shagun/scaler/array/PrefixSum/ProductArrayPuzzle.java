package dsa.with.shagun.scaler.array.PrefixSum;

public class ProductArrayPuzzle {
    public int[] solve(int[] A) {

        //Approach 1: Using division operator
       /* int product = 1;
        int[] res = new int[A.length];

        //find product of all the elements
        for(int i=0; i<A.length; i++){
            product *= A[i];
        }

        //find product array where ith element = product / ith element
        for(int j=0; j<A.length; j++){
            res[j] = product/A[j];
        }

        return res;
        */

        //Approach 2 : Without using division operator , using prefix sum concept
        // We need left product array and right product array, and resultant array
        int n = A.length;
        int[] leftProdArr = new int[n];
        int[] rightProdArr = new int[n];
        int[] res = new int[n];

        leftProdArr[0] = A[0];

        for(int i=1; i<n; i++){
            leftProdArr[i] = leftProdArr[i-1]*A[i];
        }

        rightProdArr[n-1] = A[n-1];
        for(int i=n-2; i>=0; i--){
            rightProdArr[i] = rightProdArr[i+1]*A[i];
        }

        //get product arr val for each element
        for(int i=0; i<n; i++)
        {
            if(i==0){
                res[i] = rightProdArr[i+1];
            }else if(i==n-1){
                res[i] = leftProdArr[i-1];
            }else{
                res[i] = leftProdArr[i-1]*rightProdArr[i+1];
            }
        }
        return res;
    }
}
