package dsa.with.shagun.scaler.advance.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

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

    //We need to print element just before NULL from queue as that would be the last element on that level meaning righmost element
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode curr = A;
        TreeNode dummyNode = new TreeNode(Integer.MAX_VALUE);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(curr);
        queue.offer(dummyNode);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(curr.val);

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr == dummyNode) { // if the current  node is dummyNode then we need to print previous element from the NULL
                if (!queue.isEmpty()) {
                    queue.offer(dummyNode);  // add dummyNode at the back once it's popped
                }
                if (queue.peek() != null) {
                    ans.add(queue.peek().val);
                }
            } else {
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }
        return ans;
    }

    /*
    ---- if peek element is not null then add val to the ans -- LEFT VIEW -- as this is first element of the level
    if (queue.peek() != null) {
        ans.add(queue.peek().val);

    }*/
}
