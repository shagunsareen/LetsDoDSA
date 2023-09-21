package dsa.with.shagun.scaler.advance.Trees.session2;

import apple.laf.JRSUIUtils;

public class IsBalancedOptimised {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public int isBalanced(TreeNode A) {
        if(getHeightOfTree(A) == -1){
            return 0; // Not a balanced binary tree
        }
        return 1; // It is a balanced binary tree
    }

    public int getHeightOfTree(TreeNode node){
        if(node == null){
            return 0;
        }

        int lh = getHeightOfTree(node.left);
        int rh = getHeightOfTree(node.right);

        //if left subtree or rightsubtree is non balanced then no need to check the other half
        if(lh == -1 || rh == -1){
            return -1;
        }

        if(Math.abs(lh-rh) > 1){ //non balanced
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    //This will take TC : O(N), SC:O(N) since in worst case we can have a skewed tree where we need to traverse all the nodes of the tree
}
