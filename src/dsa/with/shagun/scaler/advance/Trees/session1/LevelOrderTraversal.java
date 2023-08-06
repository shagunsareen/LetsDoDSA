package dsa.with.shagun.scaler.advance.Trees.session1;

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
            left = null;
            right = null;
        }
    }

    //Since we need to print children of a node in a particular order,
    // we will push nodes in a queue and then push it's children
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();

        TreeNode curr = A;
        TreeNode t = new TreeNode(Integer.MAX_VALUE);
        TreeNode t1 = new TreeNode(-1);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(curr);
        queue.add(t);

        while (!queue.isEmpty()) {
            curr = queue.poll(); //poll current element

            if (curr == t) {
                value = null;
                if (!queue.isEmpty()) {
                    queue.add(t); // INSERT Null once you pop null. Only insert if there is something in queue.
                }
            } else {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(curr.val);
                if (curr.left != t1) {
                    queue.add(curr.left);
                }
                if (curr.right != t1) {
                    queue.add(curr.right);
                }
            }
            ans.add(value);
        }
        return ans;
    }
}
