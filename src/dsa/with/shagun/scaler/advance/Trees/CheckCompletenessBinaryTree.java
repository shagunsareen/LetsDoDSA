package dsa.with.shagun.scaler.advance.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        TreeNode curr = root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(curr);

        boolean left = false;

        while(!q.isEmpty()){
            curr = q.poll();

            if(curr==null){
                left = true;
            }else{
                if(left){
                    return false;
                }
                q.add(curr.left);
                q.add(curr.right);
            }

        }
        return left;
    }
}
