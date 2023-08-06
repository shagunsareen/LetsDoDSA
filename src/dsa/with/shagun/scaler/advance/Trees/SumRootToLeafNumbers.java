package dsa.with.shagun.scaler.advance.Trees;

public class SumRootToLeafNumbers {

    /*Definition for
    a binary
    tree node.*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;
    String str = "";

    public int sumNumbers(TreeNode root) {
        return calculateSum(root, str, 0);
    }

    private int calculateSum(TreeNode root, String path, int sum) {

        if (root == null) {
            return 0;
        }

        //check if it's leaf node
        if (root.left == null && root.right == null) {
            String leafPath = path + root.val;
            sum = Integer.parseInt(leafPath);
            return sum;
        }

        path += root.val;

        return calculateSum(root.left, path, sum) + calculateSum(root.right, path, sum);
    }
}
