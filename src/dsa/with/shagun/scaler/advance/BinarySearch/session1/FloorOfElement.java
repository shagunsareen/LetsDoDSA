package dsa.with.shagun.scaler.advance.BinarySearch.session1;

//floor of the element is the greatest element <= k
public class FloorOfElement {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{-5,2,3,6,9,10,11,14,18}, 8));
    }

    public static int solve(int[] A, int k) {
        //Approach 1 : Iterate over the array and compare if the element is <=k and keep updating ans with possible options
        // TC : O(N), SC:O(1)

        //Approach 2: Binary Search TC : O(logN) , SC: O(1)
        int l = 0;
        int r = A.length - 1;
        int ans = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] > k) {
                //ignore right, go to left as we need floor which is element <= k
                r = mid - 1;
            } else if (A[mid] < k) {
                // ignore left, go to right
                l = mid + 1;
                ans = A[mid]; // since this is one of the possible ans and we will keep updating it if we get better ans
            } else if (A[mid] == k) {
                return k;
            }
        }
        return ans;
    }
}
