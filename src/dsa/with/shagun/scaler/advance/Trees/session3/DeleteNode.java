package dsa.with.shagun.scaler.advance.Trees.session3;

public class DeleteNode {

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

    public TreeNode solve(TreeNode A, int B) {
        return deleteNode(A, B);
    }

    private TreeNode deleteNode(TreeNode node, int B){
        TreeNode root = node;

        //Base condition
        if(root==null){
            return null;
        }

        //check if any node with value B is present or not
        if(root.val == B){
            // check if node to be deleted is a leaf node , single child node or double child node

            // **** Leaf Node ****
            if(root.left == null && root.right == null){
                root = null;
            }  //**** 1 child node ****
            else if(root.left==null){
                root = root.right;  //assign right child if left child is not present
            }
            else if(root.right == null){
                root = root.left;
            }else{
                // **** 2 child nodes ****
                // Attach either max of Left Subtree and delete max  OR attach min of RST and delete int
                TreeNode max = getLSTMax(root.left);  // since we need to chose such a node so that all other left subtree nodes are lesser than that,we chose max of LST
                root.val = max.val;  // replace root node with max value
                root.left =  deleteNode(root.left, max.val);  // delete max value from left subtree as it is already root node now
            }
        }else if(root.val < B){
            root.right = deleteNode(root.right, B);
        }else{
            root.left = deleteNode(root.left, B);
        }
        return root;
    }

    private TreeNode getLSTMax(TreeNode node){
        //since max of LST will always be on the right let's traverse RST till we reach leaf node.
        //**** MAX/MIN will always be LEAF NODE if children are not null ****
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
}
