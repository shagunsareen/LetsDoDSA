package dsa.with.shagun.scaler.advance.LinkedList;

public class KReverseLinkedList {

    class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode A, int B) {
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode prevTail = null;

        ListNode curr = A;
        while (curr != null) {
            ListNode prev = null;
            ListNode next = null;
            newTail = curr;

            for (int i = 0; i < B; i++) {
                next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }

            if (newHead == null) {
                newHead = prev;
            }
            else {
                prevTail.next = prev;
            }

            prevTail = newTail;
        }

        return newHead;
    }
}
