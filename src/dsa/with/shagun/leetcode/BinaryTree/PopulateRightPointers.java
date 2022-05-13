package dsa.with.shagun.leetcode.BinaryTree;

public class PopulateRightPointers { //TC :O(N) , SC : O(1)
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                // if there is no right node then ask parent to get the next node
                root.left.next = findNext(root);
            }
        }
        if (root.right != null) {
            root.right.next = findNext(root);
        }

        root.right = connect(root.right);  // connect right ones before left because left node needs to point to right node
        root.left = connect(root.left);

        return root;
    }

    private Node findNext(Node root) {
        while (root.next != null) {
            root = root.next;
            if (root.left != null) {
                return root.left;
            }
            if (root.right != null) {
                return root.right;
            }
        }
        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
