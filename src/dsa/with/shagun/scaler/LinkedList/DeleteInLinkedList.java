package dsa.with.shagun.scaler.LinkedList;

public class DeleteInLinkedList { //TC : O(N), SC : O(1)
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A, int B) {
        ListNode temp = A;
        if (A != null) {
            if (B == 0) {
                A = temp.next;
            }else{
                for (int i = 0; i < B - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
        }
        return A;
    }
}
