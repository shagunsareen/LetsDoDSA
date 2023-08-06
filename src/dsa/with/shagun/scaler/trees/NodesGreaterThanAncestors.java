package dsa.with.shagun.scaler.trees;

public class NodesGreaterThanAncestors {
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

    public class Solution {
        int max = 0;
        int count = 0;

        public int solve(TreeNode A) {
           return checkMax(A, max);
        }

        private int checkMax(TreeNode A, int max) {
            if(A == null) return count;
            if (A.val > max) {
                count++;
            }
            checkMax(A.left, Math.max(A.val, max));
            checkMax(A.right, Math.max(A.val, max));
            return count;

        }
    }
}
