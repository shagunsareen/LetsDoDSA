package dsa.with.shagun.scaler.advance.Trees.session1.Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

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
    public int[] solve(TreeNode A) {

        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = A;

        queue.add(curr);

        while(!queue.isEmpty()){
            curr =  queue.poll();

            if(curr==null){
                list.add(-1);
            }else{
                list.add(curr.val);
                queue.add(curr.left);  //even if it is null we will add it in the queue so that in list we read it as -1
                queue.add(curr.right);
            }
        }

        int[] res = new int[list.size()];

        for(int i = 0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
