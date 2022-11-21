package dsa.with.shagun.scaler.trees;

import java.util.ArrayList;

public class PostorderTraversal {
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

    ArrayList<Integer> result;

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        result = new ArrayList<>();
        postorder(A);
        return result;
    }

    private void postorder(TreeNode A) {
        //Base condition
        if (A == null) return;

        postorder(A.left);
        postorder(A.right);
        result.add(A.val);
    }
}
