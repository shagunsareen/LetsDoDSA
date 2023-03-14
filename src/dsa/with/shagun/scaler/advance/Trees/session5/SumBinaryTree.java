package dsa.with.shagun.scaler.advance.Trees.session5;

public class SumBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    class Pair {
        int sum;
        boolean status;

        Pair(int sum, boolean status) {
            this.sum = sum;
            this.status = status;
        }
    }

    public int solve(TreeNode A) {
        if (getSubtreeSum(A).status) { // if status of the whole tree comes out to be true, then
            return 1;
        }
        return 0;
    }

    private Pair getSubtreeSum(TreeNode root) { // Postorder traversal because we need leftsum , rightsum then at last we will check root node val
        Pair pair = new Pair(0, true);

        //empty tree
        if (root == null) {
            return pair;
        }

        Pair left = getSubtreeSum(root.left);
        Pair right = getSubtreeSum(root.right);

        //check status of left subtree and right subtree, if it's false return
        if ((!left.status) || (!right.status)) {
            pair.status = false;
            return pair;
        }

        pair.sum = root.val + left.sum + right.sum;

        //check for leaf node or when sum is equal to leftSum and rightSum
        if ((root.left == null && root.right == null) || (root.val == left.sum + right.sum)) {
            return pair;
        }

        pair.status = false;
        return pair;
    }
}
