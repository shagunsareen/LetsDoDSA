package dsa.with.shagun.scaler.advance.Sorting.session1;

import java.util.Arrays;

public class ChocolateDistribution {
    public int solve(int[] A, int B) {

        int n = A.length;

        //if students are greater than the no. of packets then return 0
        if(B > n || B == 0){
            return 0;
        }

        //Sort the array
        Arrays.sort(A); // TC : O(nlogn)

        //Now we need to get diff for that we need min and max in a window

        int left = 0;
        int right = B-1;
        int minDiff = Integer.MAX_VALUE;

        //supposing that B students gets first B packets and moving window further of size B, where A[right] is max in the window and A[left] is min
        while(right < n){
            minDiff = Math.min(minDiff, A[right] - A[left]);
            left++;
            right++;
        }

        return minDiff;
    }
}
