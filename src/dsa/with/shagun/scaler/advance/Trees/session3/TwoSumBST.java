package dsa.with.shagun.scaler.advance.Trees.session3;

import java.util.HashSet;

public class TwoSumBST {

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

    HashSet<Integer> hs = new HashSet<>();
    int res = 0;

    public int t2Sum(TreeNode A, int B) {
        getSum(A,B);
        return res;
    }


    private void getSum(TreeNode A,int B){
        if(A == null){
            return ;
        }

        int y = B-A.val;

        if(hs.contains(y)){
            res = 1;
        }else{
            hs.add(A.val);
        }

        getSum(A.left, B);
        getSum(A.right, B);
    }

}
