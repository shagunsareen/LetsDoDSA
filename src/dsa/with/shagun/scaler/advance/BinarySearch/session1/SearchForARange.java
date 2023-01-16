package dsa.with.shagun.scaler.advance.BinarySearch.session1;

public class SearchForARange {
    //Return an array of size 2, such that the first element = starting position of B in A
    // and the second element = the ending position of B in A if B is not found in A return [-1, -1].
    public static void main(String[] args) {
        int[] arr = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] searchRange(final int[] A, int B) {
        //Approach 1 : Apply Linear Search & update starting index and ending index into 2 variables or return -1,-1 if not found
        //TC :O(N),SC:O(1)

        //Approach 2: Binary search to take TC : O(logn), SC:O(1)
        if (A.length == 1) {
            return new int[]{0, 0};
        }
        /*int l = 0;
        int r = A.length - 1;
        int firstIndex = -1;
        int lastIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid] == B) {
                firstIndex = mid;
                lastIndex = mid;

                // if left side same element is there then we can update firstIndex
                while (mid >= 0 && A[mid] == A[mid - 1]) {
                    //run loop to reach leftmost element index
                    firstIndex = Math.min(firstIndex, mid - 1);
                    mid--;
                }

                //if right side samee element is there then we can update lastIndex
                while (mid < A.length - 1 && A[mid] == A[mid + 1]) {
                    //run loop to reach leftmost element index
                    lastIndex = Math.max(lastIndex, mid + 1);
                    mid++;
                }

            } else if (A[mid] > B) {
                //go left
                r = mid - 1;
            } else {
                // when A[mid] < B
                //go right
                l = mid + 1;
            }
        }
        return new int[]{firstIndex, lastIndex};*/

        return new int[]{floorOfElement(A, B), ceilingOfElement(A, B)};
    }

    public static int floorOfElement(int[] A, int k) {
        //Approach 1 : Iterate over the array and compare if the element is <=k and keep updating ans with possible options
        // TC : O(N), SC:O(1)

        //Approach 2: Binary Search TC : O(logN) , SC: O(1)
        int l = 0;
        int r = A.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] > k) {
                //ignore right, go to left as we need floor which is element <= k
                r = mid - 1;
            } else if (A[mid] < k) {
                // ignore left, go to right
                l = mid + 1;
            } else if (A[mid] == k) {
                r = mid - 1;// since we need to find smallest index of the floor element so there can be a possiblity that more same ele can be present on left
                ans = mid; // since this is one of the possible ans and we will keep updating it if we get better ans
            }
        }
        return ans;
    }

    public static int ceilingOfElement(int[] A, int k) {
        //Approach 1 : Iterate over the array and compare if the element is >=k and keep updating ans with possible options
        // TC : O(N), SC:O(1)

        //Approach 2: Binary Search TC : O(logN) , SC: O(1)
        int l = 0;
        int r = A.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] > k) {
                //ignore right, go to left as we need ceiling which is smallest element >= k
                r = mid - 1;
            } else if (A[mid] < k) {
                // ignore left, go to right
                l = mid + 1;
            } else if (A[mid] == k) {
                ans = mid; //this can be one possible ans
                l = mid + 1;
            }
        }
        return ans;
    }
}
