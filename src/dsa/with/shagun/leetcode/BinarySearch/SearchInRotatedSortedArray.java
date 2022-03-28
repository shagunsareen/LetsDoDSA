package dsa.with.shagun.leetcode.BinarySearch;

public class SearchInRotatedSortedArray { // TC : O(logn) because of binary search //SC : O(1) because no extra space

    public static void main(String[] args) {
        //System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                // this is to check the duplicates as they will not let us decide in which area the target
                // lies hence we will change left and right and will get new mid
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {   // left area ex : [4560123] target = 5
                //check  if target lies in left area or not
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]) { //right area  ex : [4560023] target = 3
                //check  if target lies in right area or not
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
