package dsa.with.shagun.scaler.LinkedList;

public class PrintLinkedList {  //TC : O(N), SC :O(1)
    public void solve(ListNode A) {
        ListNode temp = A;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
            System.out.println();
    }

    //Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
