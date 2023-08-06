package dsa.with.shagun.scaler.advance.BinarySearch.session1;

public class PeakElement {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4,5}));
        System.out.println(solve(new int[]{5,17,100,11}));
        System.out.println(solve(new int[]{1, 1000000000, 1000000000}));
    }

    public static int solve(int[] A) {
        //Approach 1 : Linear search , check if arr[i-1]>arr[i]<arr[i+1]
        //TC : O(N),O(1)

        //Approach 2 : Binary Search, TC : O(logN), O(1)
        int n = A.length;
        if(n==1){
            return A[0];
        }
        if ((A[0] > A[1])) {
            return A[0];
        } else if (A[n - 1] > A[n - 2]) {
            return A[n - 1];
        }

        int l = 1; //since 0th element is already checked
        int r = n - 2;  // since last element is already checked

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid - 1] <= A[mid] && A[mid] >= A[mid + 1]) {  //_<_>_ peak element
                return A[mid];
            } else if (A[mid-1] < A[mid] && A[mid] < A[mid + 1]) { //_<_<_  increasing ,go to right since left condition is matching we need to find ele > right
                //go right
                l = mid + 1;
            } else { // (A[mid-1] > A[mid])
                // _>_>_ go left since right condition is matching we need to find left condition where ele > left
                // _>_<_ we can go anyside since one of the conditions are matching
                r = mid - 1;
            }
        }
        return -1;
    }
}
