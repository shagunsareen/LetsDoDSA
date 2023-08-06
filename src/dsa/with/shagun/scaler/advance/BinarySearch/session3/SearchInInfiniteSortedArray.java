package dsa.with.shagun.scaler.advance.BinarySearch.session3;

//TC :O(logN + logN) = O(logN), SC:O(1)
public class SearchInInfiniteSortedArray {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        System.out.println(findBoundsForBinarySearch(arr, 130));
    }

    private static int findBoundsForBinarySearch(int[] arr, int key) {
        int l = 0;
        int h = 1;
        while (arr[h] < key) { // i.e. it's not correct range and we need to find range
            l = h;  //update low as previous high
            h = 2 * h;  // update high exponentially so that we can get search space in logn time
            if (2 * h > arr.length - 1) {
                h = arr.length - 1;
            } else {
                h = 2 * h;
            }
        }
        return binarySearch(arr, l, h, key);
    }

    //since it's an infinite array hence we don't have bounds of the array , hence we have bounds low and high as parameters
    public static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
