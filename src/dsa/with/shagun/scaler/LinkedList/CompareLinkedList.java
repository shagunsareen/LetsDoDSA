package dsa.with.shagun.scaler.LinkedList;

public class CompareLinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int solve(ListNode A, ListNode B) {
        ListNode one = A;
        ListNode two = B;

        while (one != null && two != null) {
            if (one.val != two.val) {
                return 0;
            } else {
                one = one.next;
                two = two.next;
            }
        }
        return 1;
    }
}
