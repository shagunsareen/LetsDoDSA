package dsa.with.shagun.scaler.advance.Trees.session2;

public class DiameterOfBinaryTree {

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

    int dia = -1;

    public int solve(TreeNode A) {
        getHeight(A);
        return dia;
    }

    private int getHeight(TreeNode node){
        if(node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        dia = Math.max(dia, left+right);

        return 1 + Math.max(left, right);
    }
}
