package dsa.with.shagun.scaler.advance.Trees.session3;

public class IsValidBST2 {
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

    //since we need to check whether for every node LST & RST is a BST or not, without storing data we should know in which range the node should lie
    //if node lies in the range then it's valid
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue){
        if(root == null) return true;

        //check if current node is BST or not
        if(root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

}
