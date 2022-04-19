package dsa.with.shagun.leetcode.BST;

public class RecoverBST {   //TC : O(N) SC : O(logN) where n is depth of the tree
    /*public static int swapCount =0;

    public void recoverTree(TreeNode root) {
        int temp = 0;
        if (root == null) return;
        if (root.value < root.left.value) {
            temp = root.value;
            root.value = root.left.value;
            root.left.value = temp;
            swapCount++;
        }
        if(swapCount==0){
            recoverTree(root.left);
            recoverTree(root.right);
        }
    }*/

    private TreeNode prev = null;
    private TreeNode one = null;
    private TreeNode two = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = one.value;
        one.value = two.value;
        two.value = temp;
    }

    private void inorder(TreeNode curr) {
        if (curr == null) return;
        //Inorder Traversal ---> Left Root Right
        inorder(curr.left);

        // this is dip condition
        if (prev != null && prev.value > curr.value) {
            if (one == null) {
                one = prev;
            }
            two = curr;
        }
        prev= curr;
        inorder(curr.right);
    }

}
