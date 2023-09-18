package dsa.with.shagun.scaler.advance.Trees.session1.Revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
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

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();

        TreeNode curr = A;
        TreeNode dummy = new TreeNode(-1);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(curr); //root node
        queue.add(dummy); //delimeter node

        while(!queue.isEmpty()){

            curr = queue.poll(); // this deletes the front of the Queue

            if(curr == dummy){
                //means one level is over
                res.add(level);
                level = new ArrayList<>();  // define a new list for the new level
                if(!queue.isEmpty()){
                    queue.add(dummy); //insert dummy node at the end
                }
            }else{
                level.add(curr.val); // add the curr element to the current level list

                //insert the children of curr node into the queue to define the next level
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }
        return res;
    }
}
