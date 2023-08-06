package dsa.with.shagun.scaler.advance.LinkedList.session2;

public class MergeSortedLists {
    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //TC : O(A+B), SC:O(1)
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // Pre-checks, check if any of the list is null we don't have to compare then and return other list
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        // Step1 : Initialise head ptr, h1 and h2
        ListNode head = null;
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode prev = null;

        //Set head to smaller first element among both lists as we need sorted list
        if (A.val <= B.val) {
            h1 = A;
            h2 = B;
        } else {
            h1 = B;
            h2 = A;
        }

        head = h1;
        prev = h1;
        h1 = h1.next;  // move to next element to compare with h2 list

        while (h1 != null && h2 != null) {
            //compare which is smaller element and attach it to prev element hence we require prev as well to track last element
            if (h1.val <= h2.val) {
                prev.next = h1;
                prev = h1;
                h1 = h1.next;
            } else {
                prev.next = h2;
                prev = h2;
                h2 = h2.next;
            }
        }

        //if any one of the list gets over append other list as is
        if (h1 == null) {
            prev.next = h2;
        } else {
            prev.next = h1;
        }

        return head;
    }
}
