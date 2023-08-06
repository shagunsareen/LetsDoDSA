package dsa.with.shagun.scaler.LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n = new ListNode(5);
        ListNode two = new ListNode(6);
        n.next= two;
        solve(n);
    }

    public static void solve(ListNode A) {
        ListNode temp = A;
        printNode(temp);
        System.out.println();
    }


    public static void printNode(ListNode node) {
        if (node.next == null) {
            System.out.print(node.val + " ");
            return;
        }
        printNode(node.next);
        System.out.print(node.val + " ");
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
