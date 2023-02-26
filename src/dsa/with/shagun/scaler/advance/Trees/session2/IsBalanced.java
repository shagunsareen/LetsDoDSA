package dsa.with.shagun.scaler.advance.Trees.session2;

public class IsBalanced {

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

    public int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }

        int leftH = height(A.left);
        int rightH = height(A.right);

        if (Math.abs(leftH - rightH) > 1) {
            return 0;
        }
        if ((isBalanced(A.left) == 1) && (isBalanced(A.right) == 1)) {
            return 1;
        }

        return 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
}
