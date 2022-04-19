package dsa.with.shagun.leetcode.BST;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestInBST {

    // Approach 1 ---- TC:O(N) SC : O(N)
    /*public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.value);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }*/

    // Approach 2 : TC worst case if kth element is last element in the tree : O(N), SC : O(N)
/*    public static int res=0;
    public static int count=0;

    public static void inorder(TreeNode root) {
        if (root.left != null) inorder(root.left);
        count--;
        if (count == 0) {
            res = root.value;
        }
        if (root.right != null) inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }*/

    //Approach 3 : TC : O(H) ,SC :O(H) where H is the height of the tree,In worst case i.e. skewed tree this will also lead to O(N)
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.value;
            root = root.right;
        }
    }

}
