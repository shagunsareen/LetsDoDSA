package dsa.with.shagun.scaler.trees;

import java.util.ArrayList;

public class PreOrderTraversal {

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

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        result = new ArrayList<>();
        preorder(A);
        return result;
    }

    private void preorder(TreeNode A) {
        //Base condition
        if (A == null) return;

        result.add(A.val);
        preorder(A.left);
        preorder(A.right);
    }

}
