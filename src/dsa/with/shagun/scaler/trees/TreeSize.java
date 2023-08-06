package dsa.with.shagun.scaler.trees;

public class TreeSize {
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

    public int solve(TreeNode A) {
        if(A==null) return 0;
        return solve(A.left) + solve(A.right) + 1;
    }
}
