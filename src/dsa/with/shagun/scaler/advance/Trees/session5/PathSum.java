package dsa.with.shagun.scaler.advance.Trees.session5;

public class PathSum {
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

    public int hasPathSum(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }

        //Base condition
        if (A.left == null && A.right == null) { // it's a leaf node
            return B - A.val == 0 ? 1 : 0;
        }

        if ((hasPathSum(A.left, B - A.val) == 1) || (hasPathSum(A.right, B - A.val) == 1)) {
            return 1;
        }
        return 0;
    }
}
