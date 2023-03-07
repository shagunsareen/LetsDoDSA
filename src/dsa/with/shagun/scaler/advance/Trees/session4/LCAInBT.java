package dsa.with.shagun.scaler.advance.Trees.session4;

import java.util.ArrayList;

public class LCAInBT {

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

    //LCA - Lowest Common Ancestor i.e. deepest node which is common to both nodes p and q
    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        // Step1 : Get path of node A
        boolean a = searchAndGetPath(A, B, path1);

        //Step2 : Get path of node B
        boolean b = searchAndGetPath(A, C, path2);

        if (a == false || b == false) {
            return -1;
        }

        // since both nodes are present hence both the nodes are populated
        int p1 = path1.size() - 1;
        int p2 = path2.size() - 1;
        int lca = 0;
        // for(int i =0; i<path1.size(); i++){
        //     System.out.println("Path1: " + path1.get(i));
        // }

        //  for(int i =0; i<path2.size(); i++){
        //     System.out.println("Path2 : " +path2.get(i));
        // }
        while (p1 >= 0 && p2 >= 0 && path1.get(p1).equals(path2.get(p2))) {
            lca = path1.get(p1);
            p1--;
            p2--;
        }
        return lca;
    }

    private boolean searchAndGetPath(TreeNode root, int k, ArrayList<Integer> list) {
        //Base condition
        if (root == null) {
            return false;
        }

        if (root.val == k) {
            list.add(root.val);
            return true;
        }

        //Traverse left and right to get
        if (searchAndGetPath(root.left, k, list) || searchAndGetPath(root.right, k, list)) {
            list.add(root.val);
            return true;
        } else {
            return false;
        }
    }

}
