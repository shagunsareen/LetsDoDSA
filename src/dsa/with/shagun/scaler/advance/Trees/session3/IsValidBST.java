package dsa.with.shagun.scaler.advance.Trees.session3;

import java.util.ArrayList;

public class IsValidBST {
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

    public int isValidBST(TreeNode A) {
        getInorder(A);
        return checkIncreasingInorder(result);
    }

    //check if inorder traversal is increasing or not
    //TC: O(N), SC :O(N)
    private int checkIncreasingInorder(ArrayList list) {
        if (list.size() == 1) {
            return 1;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int second = (int) list.get(i + 1);
            int first = (int) list.get(i);
            if (second <= first) {
                return 0;
            }
        }
        return 1;
    }

    // get inorder traversal : TC :O(N), SC:O(H)
    private void getInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        getInorder(root.left);
        result.add(root.val);
        getInorder(root.right);
    }

}
