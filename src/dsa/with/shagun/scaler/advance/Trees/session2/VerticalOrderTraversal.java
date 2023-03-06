package dsa.with.shagun.scaler.advance.Trees.session2;

import javafx.util.Pair;

import java.util.*;

public class VerticalOrderTraversal {

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

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        //Level Order Traversal
        TreeNode curr = A;
        int minVerticalIndex = Integer.MAX_VALUE;
        int maxVerticalIndex = Integer.MIN_VALUE;

        // we will store all the nodes in a queue in a Pair<Node_Val, Level>
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(curr, 0));  // Pair key : root val , Pair value : Index

        //Store nodes of each level in a map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList();

        while(!queue.isEmpty()){
            Pair p =  queue.remove();
            curr = p.node;
            int currVal = p.node.val;
            int level = p.level;

            minVerticalIndex = Math.min(level, minVerticalIndex);
            maxVerticalIndex = Math.max(level, maxVerticalIndex);

            if(!map.containsKey(level)){
                ArrayList<Integer> verticalList = new ArrayList<>();
                verticalList.add(currVal);
                map.put(level, verticalList);
            }else{
                map.get(level).add(currVal);
            }

            // List<Integer> nodesList = map.get(level);
            // nodesList.add(currVal);
            // map.put(level, nodesList);

            if(curr.left != null){
                queue.offer(new Pair(curr.left, level-1));  // left node will have 1 level lesser
            }if(curr.right != null){
                queue.offer(new Pair(curr.right, level+1));  // right node will have 1 level greater
            }
        }

        for(int i=minVerticalIndex; i<=maxVerticalIndex; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
