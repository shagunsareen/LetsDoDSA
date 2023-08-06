package dsa.with.shagun.scaler.advance.Trees.session2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

// Just store the first element of a level in hashmap
public class TopViewOfBinaryTree {

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

    class Pair{
        int level;
        TreeNode node;

        Pair(TreeNode node, int level){
            this.level = level;
            this.node = node;
        }
    }
    public ArrayList<Integer> solve(TreeNode A) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        TreeNode curr = A;

        // store all the nodes with level of that node in the queue
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(curr, 0));

        while(!queue.isEmpty()){

            Pair pair = queue.remove();
            curr = pair.node;
            int currVal = curr.val;
            int level = pair.level;

            minIndex = Math.min(minIndex, level);
            maxIndex = Math.max(maxIndex, level);

            //Only store one value for the one particular level
            if(!map.containsKey(level)){
                map.put(level, currVal);
            }

            //insert left and right nodes of a tree into the queue
            if(curr.left!=null){
                queue.offer(new Pair(curr.left, level-1));
            }
            if(curr.right!=null){
                queue.offer(new Pair(curr.right, level+1));
            }
        }

        for(int i=minIndex; i<=maxIndex; i++){
            ans.add(map.get(i));
        }
        return ans;
    }

}
