package dsa.with.shagun.scaler.advance.Trees.session2;

import java.util.*;

public class ZigZagOrderTraversal {

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

    // LevelOrderTraversal -- insert elements in list until we reach dummyNode.
    // Once we reach dummyNode we check the reverse flag and reverse the list. Reset list for next level and toggle reverse flag for next level.
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        TreeNode curr = A;
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);
        boolean reverse = false;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(curr);
        queue.add(dummyNode);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            curr = queue.remove();

            if (curr == dummyNode) {
                if (reverse){
                    Collections.reverse(list);
                }
                ans.add(list);
                list = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(dummyNode);
                }
                if(reverse){
                    reverse = false;
                }else{
                    reverse = true;
                }
            } else {
                list.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
}
