package dsa.with.shagun.scaler.advance.Trees.session2;

import java.util.LinkedList;
import java.util.Queue;

public class DeserialiseBT {

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

        // Since first val of array would be a root TreeNode
        TreeNode root = new TreeNode(A[0]);

        //Since we need to maintain root nodes
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i=1;

        // let's traverse through queue to assign left and right child nodes
        while(!queue.isEmpty()){

            //root node
            TreeNode curr= queue.poll();

            if(curr==null){
                continue;
            }

            //left and right child
            int left = A[i];
            int right = A[i+1];

            i+=2;

            //attach left node
            if(left!=-1){
                curr.left = new TreeNode(left);
            }else{
                curr.left = null;
            }

            //attach right node
            if(right!=-1){
                curr.right = new TreeNode(right);
            }else{
                curr.right = null;
            }

            queue.add(curr.left);
            queue.add(curr.right);
        }

        return root;
    }
}
