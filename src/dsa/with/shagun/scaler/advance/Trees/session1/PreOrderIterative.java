package dsa.with.shagun.scaler.advance.Trees.session1;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderIterative {
    ArrayList<Integer> resList = new ArrayList<>();

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

    //Approach 2 : Iterative - Node Left Right
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A == null) return resList;

        TreeNode curr = A;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);

        while(!stack.isEmpty()){

            curr = stack.pop();
            resList.add(curr.val);

            //push right child first so that left child is processed first
            if(curr.right!=null){
                stack.push(curr.right);
            }

            if(curr.left!=null){
                stack.push(curr.left);
            }
        }
        return resList;
    }
}
