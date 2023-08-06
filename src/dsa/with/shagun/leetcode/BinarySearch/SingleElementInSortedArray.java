package dsa.with.shagun.leetcode.BinarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if(mid==0 && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            if(mid==nums.length-1 && nums[mid] != nums[mid-1]){
                return nums[mid];
            }

            if (mid > 0 && mid < nums.length - 1 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            //move mid to it's 1 occurance
            if (nums[mid] == nums[mid - 1]) {
                mid = mid - 1;
            }

            if (mid % 2 == 0) {
                low = mid + 2;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
