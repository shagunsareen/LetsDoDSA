package dsa.with.shagun.scaler.advance.Trees.session1.Revision;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
    /**
     * Definition for binary tree */
      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }
      }

    public class Solution {
        public ArrayList<Integer> postorderTraversal(TreeNode A) {

            ArrayList<Integer> resList = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(A);
            TreeNode node;

            while(!stack1.isEmpty()){
                node = stack1.pop();

                stack2.push(node);

                if(node.left!=null){
                    stack1.push(node.left);
                }
                if(node.right!=null){
                    stack1.push(node.right);
                }
            }

            while(!stack2.isEmpty()){
                node = stack2.pop();
                resList.add(node.val);
            }

            return resList;
        }
    }

}
