package dsa.with.shagun.scaler.advance.Trees.session5;

public class kthSmallestElementInBST {

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

    int res = Integer.MIN_VALUE;
    int count = 0;

    public int kthsmallest(TreeNode A, int B) {
        count = B;
        inorderTraversal(A);
        return res;
    }

    private void inorderTraversal(TreeNode A) {
        if (A == null) {
            return;
        }

        inorderTraversal(A.left);
        count--;
        if (count == 0) {
            res = A.val;
        }
        inorderTraversal(A.right);
    }
}
