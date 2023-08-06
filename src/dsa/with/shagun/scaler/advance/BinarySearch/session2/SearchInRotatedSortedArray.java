package dsa.with.shagun.scaler.advance.BinarySearch.session2;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 3;
        System.out.println("The index in which the number is present is " + search(arr, target));
    }

    // return index of target if found else return -1
    private static int search(int[] arr, int target) {

        //Approach 1 : Linear Search ,TC :O(N),SC:O(1)

        //Approach 2 : Binary Search, since array is sorted in two halves as array is rotated around some pivot point
        //TC : O(logN), SC:O(1)
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;

            //Step1 : If arr[l...mid] first subarray is sorted, we can apply binary search in left space
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && arr[mid] >= target) { //i.e. target lies in this range
                    high = mid - 1;
                } else {
                    low = mid + 1; // search in other half if target is not on left
                }
            } else {
                //right is sorted
                if (arr[high] >= target && arr[mid] <= target) { // i.e. target lies in right search space
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
}
