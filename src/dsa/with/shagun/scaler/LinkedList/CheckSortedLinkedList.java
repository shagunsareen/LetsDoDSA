package dsa.with.shagun.scaler.LinkedList;

public class CheckSortedLinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int solve(ListNode A) {
        ListNode temp = A;
        while (temp.next != null) {
            if(temp.val > temp.next.val){
                return 0;
            }
            temp = temp.next;
        }
        return 1;
    }
}
