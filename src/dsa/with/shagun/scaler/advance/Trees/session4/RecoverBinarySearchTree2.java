package dsa.with.shagun.scaler.advance.Trees.session4;

import java.util.ArrayList;

public class RecoverBinarySearchTree2 {

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
    int firstNode = Integer.MIN_VALUE;
    int secondNode = Integer.MIN_VALUE;
    TreeNode prevNode = null;

    public ArrayList<Integer> recoverTree(TreeNode A) {

        checkSwappedNodes(A);
        result = new ArrayList<Integer>();
        result.add(secondNode);
        result.add(firstNode);
        return result;
    }

    private void checkSwappedNodes(TreeNode A){ // LDR
        if(A==null){
            return;
        }

        checkSwappedNodes(A.left);

        if(prevNode!=null){ // we already have first prev value so compare it with next node
            if(prevNode.val > A.val){
                if(firstNode==Integer.MIN_VALUE){ //this is the first pair that we got then update first pair values
                    firstNode = prevNode.val;
                }
                secondNode = A.val;
            }
        }
        prevNode = A; //setting first prev value when we reach left most condition

        checkSwappedNodes(A.right);
    }
}
