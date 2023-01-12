package dsa.with.shagun.scaler.advance.BinarySearch.session1;

public class SortedInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1}, 1));
    }

    public static int searchInsert(int[] A, int B) {

        //Approach 1 : Search B in entire array and return index.If index is not found then track index where it can lie between
        //TC : O(N), SC :O(1)

        //Approach 2 : Binary Search TC : O(logn), SC : O(1)
        int l = 0;
        int r = A.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] > B) {
                //ignore right, go to left
                r = mid - 1;
            } else if (A[mid] < B) {
                // ignore left, go to right
                l = mid + 1;
            } else if (A[mid] == B) {
                return mid;
            }
        }
        return l;
    }
}
