package dsa.with.shagun.scaler.advance.Trees.session2;

import dsa.with.shagun.scaler.advance.Trees.session3.IsValidBST;

public class MaxSumPathInBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode A) {
        getMaxSum(A);
        return sum;
    }

    private int getMaxSum(TreeNode node) {

        //Base condition
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, getMaxSum(node.left));
        int right = Math.max(0, getMaxSum(node.right));

        sum = Math.max(sum, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
