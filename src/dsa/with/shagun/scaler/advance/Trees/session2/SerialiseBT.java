package dsa.with.shagun.scaler.advance.Trees.session2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseBT {

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
        TreeNode curr = A;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(curr);

        while(!q.isEmpty()){

            curr = q.poll();

            if(curr!=null){
                list.add(curr.val);
            }else{
                list.add(-1);
                continue; // since curr node is null there won't be left and right hence skip the loop
            }

            //since we have to decode null node also as -1 hence insert every node into queue
            q.add(curr.left);
            q.add(curr.right);
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
