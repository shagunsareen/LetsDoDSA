package dsa.with.shagun.scaler.advance.Trees;

import java.util.HashMap;

//TC : O(N) --> construct tree, construct hashmap
//SC : O(N) --> constuct tree, recurstion stack ,hashmap
public class BinaryTreeFromInorderAndPreOrder {
    HashMap<Integer, Integer> hm = new HashMap<>();

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
        int preStart = 0;
        int preEnd = A.length - 1;
        int inStart = 0;
        int inEnd = B.length - 1;
        for (int i = 0; i < B.length; i++) {
            hm.putIfAbsent(B[i], i);
        }
        return constuctTree(A, B, preStart, preEnd, inStart, inEnd);
    }

    public TreeNode constuctTree(int[] preOrder, int[] inOrder, int s1, int e1, int s2, int e2) {
        //Base condition
        if (s1 > e1 || s2 > e2) {
            return null;
        }

        //Step1 : Get the first element of preorder as this will be the root
        TreeNode root = new TreeNode(preOrder[s1]);

        //Step2 : Find the index of this root in inorder array as it will give us LST and RST
        // Step2.1 : Find index using loop
        //Step2.2 : Use hashmap store element of inorder alongwith index of that element

        int indexR = hm.get(root.val);  //get index of root element from inorder

        //Step3 : Now get indexes of Left Subtree and Right Subtree
        int elementsInLst = indexR - s2;  // indexR-1-s2+1
        root.left = constuctTree(preOrder, inOrder, s1 + 1, s1 + elementsInLst, s2, indexR - 1);
        root.right = constuctTree(preOrder, inOrder, s1 + elementsInLst + 1, e1, indexR + 1, e2);
        return root;
        /*for (int i = 0; i < inOrder.length; i++) { //This will take O(N) for every root node. We can search using hashmap
            if (inOrder[i] == root.val) {
                indexR = i;
            }
        }*/
    }
}
