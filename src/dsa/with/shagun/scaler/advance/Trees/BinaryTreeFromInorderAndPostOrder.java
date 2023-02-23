package dsa.with.shagun.scaler.advance.Trees;

import java.util.HashMap;

public class BinaryTreeFromInorderAndPostOrder {
    HashMap<Integer, Integer> hm = new HashMap();

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

    public TreeNode buildTree(int[] A, int[] B) {
        int postStart = 0;
        int postEnd = B.length - 1;
        int inStart = 0;
        int inEnd = A.length - 1;

        //Store index of every element of inorder in hashmap
        for (int i = 0; i < A.length; i++) {
            hm.putIfAbsent(A[i], i);
        }
        return constructTree(A, B, postStart, postEnd, inStart, inEnd);
    }

    public TreeNode constructTree(int[] A, int[] B, int postStart, int postEnd, int inStart, int inEnd){

        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        //Get root node from postorder
        TreeNode root = new TreeNode(B[postEnd]);

        //Find index of this root node in inorder array
        int indexR = hm.get(root.val);

        // Now get LST and RST
        root.left=constructTree(A, B, 0, indexR-1, inStart, indexR-1);
        root.right=constructTree(A, B, indexR, postEnd-1, indexR+1, inEnd);

        return root;
    }
}
