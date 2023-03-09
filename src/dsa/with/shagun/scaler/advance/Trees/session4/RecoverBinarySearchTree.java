package dsa.with.shagun.scaler.advance.Trees.session4;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
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

    ArrayList<Integer> inorderList;
    ArrayList<Integer> result;

    public ArrayList<Integer> recoverTree(TreeNode A) {
        int firstNode = Integer.MIN_VALUE;
        int secondNode = Integer.MIN_VALUE;
        boolean swappedPair = false;

        inorderList = new ArrayList<>();
        result = new ArrayList<>();

        getInorder(A);

        for(int i=0; i<inorderList.size()-1; i++){
            if(inorderList.get(i) > inorderList.get(i+1)){
                //System.out.println(inorderList.get(i) + "-" + inorderList.get(i+1));
                if(firstNode == Integer.MIN_VALUE){
                    firstNode = inorderList.get(i);
                }
                secondNode = inorderList.get(i+1);
            }
        }

        result.add(secondNode);
        result.add(firstNode);
        return result;
    }

    private void getInorder(TreeNode A){ // LDR
        if(A==null){
            return;
        }

        getInorder(A.left);
        inorderList.add(A.val);
        getInorder(A.right);
    }
}
