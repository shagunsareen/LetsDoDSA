package dsa.with.shagun.scaler.advance.Trees.session5;

import sun.reflect.generics.tree.Tree;

public class SymmetricBT {
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

    public int isSymmetric(TreeNode A) {
        return checkSymmetry(A.left, A.right) ? 1 : 0;
    }

    private boolean checkSymmetry(TreeNode l, TreeNode r) {
        if (l == null && r == null) { // it is symmetric if both nodes are null
            return true;
        }
        if (l == null || r == null) { // one of the child value is null and other has value hence not symmetric
            return false;
        }
        return (l.val == r.val) && checkSymmetry(l.left, r.right) && checkSymmetry(l.right, r.left);
    }
}
