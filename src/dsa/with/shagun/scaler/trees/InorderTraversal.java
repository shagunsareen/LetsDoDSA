package dsa.with.shagun.scaler.trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class InorderTraversal {

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

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        result = new ArrayList<>();
        inorder(A);
        return result;
    }

    private void inorder(TreeNode A) {
        //Base condition
        if (A == null) return;

        inorder(A.left);
        result.add(A.val);
        inorder(A.right);
    }
}
