package dsa.with.shagun.leetcode.BST;

public class ConvertBSTToGreaterTree { // TC : O(n) because we are traversing it once only ,SC : O(1)
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.value;
            root.value = sum;
            convertBST(root.left);
        }
        return root;
    }
}
