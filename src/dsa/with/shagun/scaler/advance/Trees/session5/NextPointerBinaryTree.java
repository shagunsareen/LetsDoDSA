package dsa.with.shagun.scaler.advance.Trees.session5;

public class NextPointerBinaryTree {
    class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int x) {
            val = x;
            left = null;
            right = null;
            next = null;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode curr_depth = root;

        while(curr_depth.left!=null){// traverse levels
            TreeLinkNode curr_level = curr_depth;

            while(curr_level!=null){
                curr_level.left.next = curr_level.right;
                if(curr_level.next!=null){ // move to right
                    curr_level.right.next = curr_level.next.left;
                }
                curr_level = curr_level.next;
            }
            curr_depth = curr_depth.left; //move to next level
            //System.out.println("node value : "+t.val);
        }
    }
}
