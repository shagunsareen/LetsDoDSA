package dsa.with.shagun.scaler.LinkedList;

public class SearchEleInLL {
    public int solve(ListNode A, int B) {
        ListNode temp = A;
        if (temp != null && B == 0)
            return A.val;
        else {
            for (int i = 0; i <= B - 1; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
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
