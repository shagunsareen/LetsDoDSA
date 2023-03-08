package dsa.with.shagun.scaler.advance.Trees.session4;

public class LCAInBST {
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

    public int solve(TreeNode A, int B, int C) {
        //base condition
        if(A==null){
            return 0;
        }

        if(B<A.val && C<A.val){
            return solve(A.left, B, C);
        }
        if(B>A.val && C>A.val){
            return solve(A.right, B, C);
        }

        return A.val;
    }
}
