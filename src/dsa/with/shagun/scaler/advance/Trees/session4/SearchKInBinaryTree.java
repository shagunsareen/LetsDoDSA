package dsa.with.shagun.scaler.advance.Trees.session4;

import dsa.with.shagun.scaler.advance.Trees.session3.BinarySearchTree;

public class SearchKInBinaryTree {

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

    // Search in binary tree not binary search tree
    // Since we need to find K we should use PreOrderTraversal where Root is first then Left and Right
    public boolean searchInBT(TreeNode root, int k){
        //base condition
        if(root == null){
            return false;
        }

        if(root.val == k){
            return true;
        }
        if(searchInBT(root.left, k) || searchInBT(root.right, k)){
            return true;
        }else{
            return false;
        }
    }

    //TC : since we can go on traversing all the nodes till we get target hence TC : O(N)
    //SC : O(H) i.e. height of binary tree
}
