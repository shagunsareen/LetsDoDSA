package dsa.with.shagun.scaler.advance.Trees.session3;

public class BSTNodesInaRange {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    public int solve(TreeNode A, int B, int C) {
        return nodesInRange(A,B,C);
    }

    private int nodesInRange(TreeNode A, int B, int C){
        if(A==null){
            return 0;
        }

        if(B <= A.val && C >= A.val){
            return 1 + nodesInRange(A.left, B, C) + nodesInRange(A.right, B, C);
        }else{
            return nodesInRange(A.left, B, C) + nodesInRange(A.right, B, C);
        }
    }
}
