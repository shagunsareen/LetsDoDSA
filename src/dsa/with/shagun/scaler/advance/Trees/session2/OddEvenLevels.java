package dsa.with.shagun.scaler.advance.Trees.session2;

import java.util.ArrayDeque;
import java.util.Queue;

public class OddEvenLevels {

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
        public Pair(TreeNode node, int level){
            this.node=node;
            this.level=level;
        }
    }

    public int solve(TreeNode A) {
        TreeNode curr = A;

        int sumOdd = 0;
        int sumEven =0;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(curr, 1));

        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            curr = pair.node;
            int level = pair.level;

            if(level%2==0){
                //even level
                sumEven += curr.val;
            }else{
                sumOdd += curr.val;
            }

            if(curr.left!=null){
                queue.offer(new Pair(curr.left, level-1));
            }
            if(curr.right!=null){
                queue.offer(new Pair(curr.right, level+1));
            }
        }
        return sumOdd-sumEven;
    }
}
