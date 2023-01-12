package dsa.with.shagun.scaler.advance.BinarySearch.session1;

public class FirstOccuranceOfElement {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{-5, 2, 3, 6, 8, 8, 8, 9, 10, 11, 14, 18}, 8));
    }

    public static int solve(int[] A, int k) {
        //Approach 1 : Iterate over the array and compare and get first occurance of an element
        // TC : O(N), SC:O(1)

        //Approach 2: Binary Search TC : O(logN) , SC: O(1)
        int l = 0;
        int r = A.length - 1;
        int ans = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] > k) {
                //ignore right, go to left
                r = mid - 1;
            } else if (A[mid] < k) {
                // ignore left, go to right
                l = mid + 1;
            } else if (A[mid] == k) {
                // we are not sure whether this is the first occurance of the element or we have more elements on left side.
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
}
