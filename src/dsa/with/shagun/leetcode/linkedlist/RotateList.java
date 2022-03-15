package dsa.with.shagun.leetcode.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        ListNode newHead;

        //get length of the list
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        //to minimize rotations if k > length
        k %= len;
        tail.next = head;

        for (int i = 0; i < len - k; i++) {
            tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;

        return newHead;
    }
}
