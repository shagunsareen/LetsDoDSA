package dsa.with.shagun.leetcode.BST;

import sun.reflect.generics.tree.Tree;

public class IncreasingBST {  //TC : O(N) because we traverse each node exactly once SC : O(H)  ---where H is height of the tree
    TreeNode head, tail;

    public TreeNode increasingBST(TreeNode root) {
        head = null;
        tail = null;
        inorder(root);
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        //In-order traversal i.e. Left Data Right
        inorder(root.left);

        //processing over data
        TreeNode nn = new TreeNode(root.value);
        if (head == null) {
            head = nn;
            tail = nn;
        } else {
            tail.right = nn;
            tail=nn;
        }
        inorder(root.right);
    }
}
