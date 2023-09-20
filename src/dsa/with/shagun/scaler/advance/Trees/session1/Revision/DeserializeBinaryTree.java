package dsa.with.shagun.scaler.advance.Trees.session1.Revision;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

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

    public TreeNode solve(int[] A) {

        TreeNode root = new TreeNode(A[0]); //root TreeNode

        //To maintain the root nodes, we need queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while(!queue.isEmpty()){

            TreeNode curr = queue.poll();

            //left and right childs
            int left = A[i];
            int right = A[i+1];

            i+=2;

            if(left!=-1){
                curr.left = new TreeNode(left);
                queue.add(curr.left);
            }
            if(right!=-1){
                curr.right = new TreeNode(right);
                queue.add(curr.right);
            }
        }

        return root;
    }
}
