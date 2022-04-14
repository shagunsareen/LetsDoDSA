package dsa.with.shagun.leetcode.BST;

public class SearchInBinarySearchTree {  //TC : O(logN) because we are traversing one side each time //SC : O(n) because of skewed BST
    public TreeNode searchBST(TreeNode root, int val) {
        //Approach 1 : recursive
        if (root == null || root.value == val) {
            return root;
        }
        return val < root.value ? searchBST(root.left, val) : searchBST(root.right, val);

        //Apprach 2 :iterative   SC :O(1)
       /* while(root!=null && root.value!=val){
            return val < root.value ? searchBST(root.left, val) : searchBST(root.right, val);
        }
        return root;*/
    }
}

class TreeNode {
    int value;
    dsa.with.shagun.leetcode.BST.TreeNode left;
    dsa.with.shagun.leetcode.BST.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.value = val;
    }

    TreeNode(int val, dsa.with.shagun.leetcode.BST.TreeNode left, dsa.with.shagun.leetcode.BST.TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }
}
