package dsa.with.shagun.scaler.advance.BinarySearch.session2;

public class LocalMinima {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{9, 8, 7, 3, 6, 4, 1, 5, 7}));
    }

    public static int solve(int[] A) {

        //Approach 1 : Linear search , check if arr[i-1]>arr[i]<arr[i+1]
        //TC : O(N),O(1)

        //Approach 2 : Binary Search, TC : O(logN), O(1)
        int n = A.length;

        if (A[0] < A[1]) {
            return 0;
        } else if (A[n - 1] < A[n - 2]) {
            return n - 1;
        }

        int l = 1; //since 0th element is already checked
        int r = n - 2;  // since last element is already checked

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {  //_>_<_
                return mid;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) { //_>_>_  decreasing ,go to right since left condition is matching we need to find mid<mid+1 on right
                //go right
                l = mid + 1;
            } else { // (A[mid] > A[mid - 1]) {//_<_>_ or _<_<_ since right condition is matching we need to find left condition where mid-1>mid
                //go left
                r = mid - 1;
            }
        }
        return -1;
    }
}