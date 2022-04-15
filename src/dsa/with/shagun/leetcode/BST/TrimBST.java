package dsa.with.shagun.leetcode.BST;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;  //Base condition

        if (root.value >= low && root.value <= high) { //lies in the range then we will go through its left and right side
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        } else if (root.value < low) { // obviously elements on left side of root will be lower than root.value and since root.val < low hence left side elements won't lie in the range
            return trimBST(root.right, low, high);
        } else if (root.value > high) {
            return trimBST(root.left, low, high);
        }
        return root;
    }
}
