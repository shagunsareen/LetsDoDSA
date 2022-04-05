package dsa.with.shagun.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodesInLL {  // TC: O(n) as we are traversing n elements in one pass. SC: O(1) as ListNodes are of constant space
    public ListNode swapNodes(ListNode head, int k) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while (k - 1 != 0) {  //If we need to cover K distance we need to move k-1 times since we are already pointing to head at first place
            ptr1 = ptr1.next;
            k--;
        }

        ListNode first = ptr1; // store the first index whose value will be swapped

        while (ptr1.next != null) { // move till ptr reaches end. At that point, ptr2 will be kth distance far from the end.
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ListNode second = ptr2; //store the second index whose value will be swapped

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
