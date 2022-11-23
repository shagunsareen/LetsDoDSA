package dsa.with.shagun.scaler.trees;

public class LeftLeaveSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
/*
    static int sum;

    public static int solve(TreeNode A) {
        return getSum(A, false, sum);
    }

    private static int getSum(TreeNode A, boolean isLeft, int sum) {
        if (A == null) return 0;

        //check whether this node is a leaf node and isLeft
        if (A.left == null && A.right == null && isLeft) {
            sum += A.val;
        }

        getSum(A.left, true, sum);
        getSum(A.right, false, sum);
        return sum;
    }*/

    public int solve(TreeNode A) {
        return getSum(A, false);
    }

    private int getSum(TreeNode A, boolean isLeft) {
        if (A == null) return 0;

        //check whether this node is a leaf node and isLeft
        if (A.left == null && A.right == null && isLeft){
            return A.val;
        }

        return getSum(A.left, true) + getSum(A.right, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right = new TreeNode(49);
        root.right.left = new TreeNode(23);
        root.right.right = new TreeNode(52);
        root.right.right.left = new TreeNode(50);
        System.out.println(solve(root));
    }
}
