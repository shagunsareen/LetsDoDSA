package dsa.with.shagun.leetcode.TwoPointer;

public class ContainerWithMostWater {  //TC : O(n) SC : O(1)
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int area = (Math.min(height[left], height[right])) * (right - left); // area = length * breadth . Consider min height of left and right because otherwise water will flow out
            ans = Math.max(area, ans);

            if (height[left] <= height[right]) { // If left vertical line value is lesser than there is no meaning considering it rather take right value to get max area
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
