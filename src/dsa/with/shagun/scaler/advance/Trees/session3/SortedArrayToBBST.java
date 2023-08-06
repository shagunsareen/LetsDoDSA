package dsa.with.shagun.scaler.advance.Trees.session3;

public class SortedArrayToBBST {

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

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {
        return constructBBST(A, 0, A.length-1);
    }

    private TreeNode constructBBST(int[] A, int start, int end){

        // Base condition
        if(start > end){
            return null;
        }

        // since array is sorted and since we need equal height on both sides,
        // we need equal number of elements on left and right side hence take middle element as root
        int mid = (start + end)/2;

        TreeNode root = new TreeNode(A[mid]);

        // get left BBST
        root.left = constructBBST(A, start, mid-1);
        root.right = constructBBST(A, mid+1, end);

        return root;
    }
}
