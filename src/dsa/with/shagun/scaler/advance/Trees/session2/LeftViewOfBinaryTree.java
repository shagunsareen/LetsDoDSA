package dsa.with.shagun.scaler.advance.Trees.session2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

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

    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode curr = A;
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(curr);
        queue.offer(dummyNode);

        ArrayList<Integer> ans = new ArrayList();
        ans.add(curr.val);

        while(!queue.isEmpty()){
            //pop the element
            curr = queue.poll();

            if(curr==dummyNode){
                if(queue.peek()!=null){
                    ans.add(queue.peek().val);
                }
                if(!queue.isEmpty()){
                    queue.offer(dummyNode);
                }
            }else{
                // if node has some value
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
        }
        return ans;
    }
}
