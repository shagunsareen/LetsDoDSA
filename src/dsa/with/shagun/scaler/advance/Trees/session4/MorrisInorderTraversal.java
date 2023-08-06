package dsa.with.shagun.scaler.advance.Trees.session4;

import java.util.ArrayList;

public class MorrisInorderTraversal {
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

    ArrayList<Integer> result = new ArrayList<>();

    //Morris Inorder Traversal
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode curr = A;

        while (curr != null) {
            if (curr.left == null) {  // if left child is null
                result.add(curr.val);
                curr = curr.right;
            } else { //if left child is not null
                TreeNode t = curr.left;

                while (t.right != null && t.right != curr) {
                    t = t.right;
                }

                if (t.right == null) {//create the link as it is not present
                    t.right = curr;
                    curr = curr.left;
                }

                if (t.right == curr) {//remove the link as it is already present
                    t.right = null;
                    result.add(curr.val);
                    curr = curr.right; // since we have already traversed left and created link after that
                }

            }
        }
        return result;
    }
}