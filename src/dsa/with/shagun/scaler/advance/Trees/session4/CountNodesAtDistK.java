package dsa.with.shagun.scaler.advance.Trees.session4;

public class CountNodesAtDistK {

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

    public int countNodesAtDistK(TreeNode root, int k) {

        //base condition
        if (root == null) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        // count nodes from left and right
        return countNodesAtDistK(root.left, k - 1) + countNodesAtDistK(root.right, k - 1);
    }
}
