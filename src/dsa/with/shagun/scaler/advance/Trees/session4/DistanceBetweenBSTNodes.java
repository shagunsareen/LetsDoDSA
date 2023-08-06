package dsa.with.shagun.scaler.advance.Trees.session4;

public class DistanceBetweenBSTNodes {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.val= x;
            left = null;
            right = null;
        }
    }

    public int solve(TreeNode A, int B, int C) {
        TreeNode lca = searchInBST(A,B,C);
        return getNodesDistance(lca, B) + getNodesDistance(lca, C);
    }

    private TreeNode searchInBST(TreeNode A, int B, int C){
        if(A==null){
            return null;
        }

        if(B < A.val && C < A.val){
            return searchInBST(A.left, B, C);
        }
        if(B > A.val && C > A.val){
            return searchInBST(A.right,B, C);
        }

        return A;
    }

    private int getNodesDistance(TreeNode root, int k){
        if(root==null){
            return 0;
        }

        if(k == root.val){
            return 0;
        }

        if(k < root.val){
            return 1 + getNodesDistance(root.left, k);
        }else{
            return 1 + getNodesDistance(root.right, k);
        }
    }
}
