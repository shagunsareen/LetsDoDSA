package dsa.with.shagun.scaler.advance.Trees.session4;

import java.util.HashSet;

public class CommonNodesInTwoBST {

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
    HashSet<Integer> set = new HashSet<>();
    int sum = 0;
    int mod = 1000000000+7;

    public int solve(TreeNode A, TreeNode B) {

        //traverse and store all nodes of first treein hashset
        inorder(A);
        getCommonSumNodes(B);
        return sum % mod;
    }

    private void inorder(TreeNode A){
        if(A==null){
            return;
        }

        inorder(A.left);
        set.add(A.val);
        inorder(A.right);
    }

    private void getCommonSumNodes(TreeNode B){
        if(B==null){
            return;
        }

        getCommonSumNodes(B.left);
        if(set.contains(B.val)){
            sum = (sum % mod + B.val % mod)%mod;
        }
        getCommonSumNodes(B.right);
    }
}
