package dsa.with.shagun.scaler.advance.LinkedList;

public class ReverseLinkedList {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //TC :O(N), SC:O(1)
    public ListNode reverseList(ListNode A) {
        ListNode head = A; //head node
        ListNode temp = head;  //temp node that points to head

        ListNode prev = null; // previous node to which we will attach new nodes

        //now attach every node one by one to prev and move head forward to go to next node
        while (temp != null) {
            head = temp.next; // to keep track of leftover list to reverse
            temp.next = prev; //attached one node to reversed list
            prev = temp; // new head of reversed list is updated
            temp = head; // next node which is to be attached is updated
        }
        return prev;
    }
}
