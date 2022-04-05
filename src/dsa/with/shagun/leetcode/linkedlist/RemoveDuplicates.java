package dsa.with.shagun.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyNode = new ListNode(0, head);

        ListNode previous = dummyNode;

        while(head!=null)
        {
            if(head.next !=null && head.val == head.next.val)
            {
                while(head.next!=null && head.val == head.next.val)
                {
                    head = head.next;
                }

                previous.next = head.next;
            }
            else
            {
                previous = previous.next;
            }

            head = head.next;
        }

        return dummyNode.next;
    }
}
