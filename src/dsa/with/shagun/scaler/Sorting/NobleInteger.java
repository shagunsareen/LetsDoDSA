package dsa.with.shagun.scaler.Sorting;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args) {
        //System.out.println(solve(new int[]{1,1,3,3}));
        System.out.println(solve(new int[]{3, 2, 1, 3}));
    }

    //Total TC : O(nlogn+n)
    public static int solve(int[] A) {
        Arrays.sort(A); // increasing order--O(nlogN)

        int count = 0;
        int ans = -1;
        int n = A.length - 1;
        if (A[n] == 0) { // since no ele greater than last ele would exist and if ele itself is 0 then it's a noble integer
            ans++;
        }
        for (int i = n - 1; i >= 0; i--) { // TC : O(n)
            //greatest element is at the right-most position so elements greater than ith ele is elements on it's right
            if (A[i] != A[i + 1]) {
                count = n - i;
            }
            if (A[i] == count) { // i.e. increase noble integer count when condition satisfies
                ans++;
            }
        }
        return ans > 0 ? 1 : -1;
    }
}
