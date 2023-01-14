package dsa.with.shagun.scaler.advance.BinarySearch.session2;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(36));
    }

    //TC : O(logN),SC:O(1)
    public static int sqrt(int A) {
        //Approach 1 : Normal square root function, TC: O(RootN), SC:O(1)

        //Approach 2 : Binary Search , then call floor of element if sqrt we can't get
        int l = 1; // since we are dividing mid by A so if mid =0 in case when A is 0 then divide by zero exception occurs
        int r = A;
        int ans = 0; // if A is 0 output should be  0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid <= A / mid) { // to avoid overflow of mid, we take this instead of mid*mid==A
                l = mid + 1;
                ans = mid;
                //return ans; // i.e. this is the square root of given number
            } else if (mid > A / mid) {
                //go to left
                r = mid - 1;
            } /*else {
                //mid*mid<A this can be a possible answer if it's not an exact square root
                ans = mid;
                l = mid + 1;
            }*/
        }
        return ans;
    }
}
