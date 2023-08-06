package dsa.with.shagun.scaler.advance.Trees.session5;

import dsa.with.shagun.scaler.advance.Trees.session3.SortedArrayToBBST;

public class IdenticalTree {

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


    public int isSameTree(TreeNode A, TreeNode B) {

        if(A == null && B == null){
            return 1;
        }
        if((A == null && B != null) || (A != null && B == null)){
            return 0;
        }
        if(A.val != B.val){
            return 0;
        }

        if((isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right)==1)){
            return 1;
        }
        return 0;
    }
}
