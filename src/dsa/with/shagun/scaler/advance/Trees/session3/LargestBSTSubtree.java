package dsa.with.shagun.scaler.advance.Trees.session3;

public class LargestBSTSubtree {

    boolean isBST = true;
    int maxSizeBST = Integer.MIN_VALUE;

    public int solve(TreeNode A) {
        travel(A);
        return maxSizeBST;
    }

    //postOrderTraversal
    private Pair travel(TreeNode root) {
        //base case
        if (root == null) {
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Pair left = travel(root.left); //will give maxSizeBST of LST
        Pair right = travel(root.right); //will give maxSizeBST of RST

        //check if root is BST or not
        if (root.val <= left.max || root.val >= right.min) {
            isBST = false;
        }

        //now we have to return maxSizeBST value for the upper parent nodes
        if (isBST) {
            maxSizeBST = Math.max(maxSizeBST, left.size + right.size + 1);
        }

        return new Pair(Math.min(left.min, root.val), Math.max(right.max, root.val), left.size + right.size + 1);
    }

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

    class Pair {
        int min;
        int max;
        int size;

        Pair(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
}
