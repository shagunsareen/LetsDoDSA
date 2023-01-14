package dsa.with.shagun.scaler.advance.BinarySearch.session1;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        solve(new int[]{1, 1, 2, 2, 3});
    }

    public static int solve(int[] A) {

        //Approach 1 :  Linearly iterate over each array and take initial count to be 2 then check if arr[i]!=arr[i+1] and count!=0 then return i'
        //TC :O(N), SC :O(1)

        //Approach 2 : Create frequency hashmap and whichever will have frequency as 1 return that.
        //TC : O(N), SC:O(N)

        //Approach 3 : Binary Search
        //TC : O(NlogN), SC:O(1)

        int l = 0;
        int r = A.length - 1;

        if (A[0] != A[1]) {
            return A[0]; // if 1st element itself is target
        }
        if (A[r] != A[r - 1]) {
            return A[r]; // if last element itself is target
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if ((mid == 0 || A[mid] != A[mid - 1]) && (mid == (A.length - 1) || A[mid] != A[mid + 1])) {
                // i.e. to check if element we are searching for is at mid only
                return A[mid];
            }
            if (A[mid] == A[mid - 1]) {
                if (mid % 2 == 0) {
                    // i.e. if we have even index then 0 to n is n-0+1 elements i.e. odd no. of elements are including mid,
                    // but if left element is same then leftover elements are odd-leftEle = odd elements i.e one element must be single
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (A[mid] != A[mid - 1]) {
                if (mid % 2 == 0) {
                    // i.e. if we have even index then 0 to n is n-0+1 elements i.e. odd no. of elements are including mid,
                    // but if left element is NOT same then elements excluding mid are even elements no element would be single hence search in other direction
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            /*if (A[mid] == A[mid - 1]) { //let's move to 1st occurance of element
                mid -= 1;
            }
            //since 1st occurance of elements on left of unique element is always at even index
            //check if mid is even index or odd and move accordingly
            if (mid % 2 == 0) {
                //means we are at left of mid and we need to go right to meet unique element
                l = mid + 1;
            } else {
                r = mid - 1;
            }*/
        }
        return -1;
    }
}
