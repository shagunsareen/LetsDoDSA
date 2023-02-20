package dsa.with.shagun.scaler.advance.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeInorderTraversal {

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

    //we have taken a STACK to store all the elements which we will traverse one by one so that if we reach null then we can come back to
    //previous node and move to it's right
    public ArrayList<Integer> inorderTraversal(TreeNode A) { //Left Data Right

        TreeNode curr = A;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) { // GO TILL LEFT IS NULL
                stack.push(curr);
                curr = curr.left;
            }
            //since curr is null let's make previous node as curr
            curr = stack.peek();
            ans.add(curr.val); // PRINT DATA
            stack.pop(); //POP ELEMENT

            //GO RIGHT
            curr = curr.right;
        }
        return ans;
    }
}
