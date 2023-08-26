package dsa.with.shagun.scaler.advance.LinkedList.session2;

public class SwapAdjacentNodesInList {

    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode A) {
        return reversePairs(A);
    }

    private ListNode reversePairs(ListNode A){
        //if list the empty or has only 1 element
        if(A == null || A.next == null){
            return A;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode head = A;
        ListNode curr = head;
        int count = 1;

        while(curr!=null && count <= 2){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next!=null){
            head.next = reversePairs(next); //next will be the start of next list to be reversed
        }

        return prev; //head of the reversed list
    }
}
