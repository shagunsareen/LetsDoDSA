package dsa.with.shagun.scaler.advance.Trees.session3;

public class BinarySearchTree {

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

    public int solve(TreeNode A, int B) {
        if(A == null){
            return 0;
        }
        if (A.val == B) {
            return 1;
        } else if (A.val < B) {
            return solve(A.right, B);
        } else {
            return solve(A.left, B);
        }
    }
}
