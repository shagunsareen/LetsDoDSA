package dsa.with.shagun.scaler.advance.LinkedList.session2;

public class ReorderList {

    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reorderList(ListNode A) {
        if(A == null || A.next == null){
            return A;
        }

        //to reorder list we need to first split the list into 2 lists, for which we need to find middle middleElement
        ListNode mid = middleElement(A);
        //System.out.println("Middle Element : " +mid.val);

        ListNode secondList = mid.next; //head of the second list
        mid.next = null; //to separate first list and the second list

        //now we have 2 lists, reverse second list
        ListNode secRevList = reverseList(secondList);

        //System.out.println("Reverse List, Head : "+secRevList.val + " , End : "+secondList.val);

        return mergeLists(A, secRevList);
    }

    //find using slow and fast pointer
    private ListNode middleElement(ListNode A){

        ListNode slow = A;
        ListNode fast = A;

        while(fast!=null && fast.next!=null){
            slow = slow.next; //move slow by 1 step
            fast = fast.next.next; //move fast by 2 steps
        }

        return slow; //this is the middle element
    }

    private ListNode reverseList(ListNode A){

        // To reverse we need prev, next and curr pointers
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //we don't have to merge lists in ordered way, so normal merge won't work
    private ListNode mergeLists(ListNode A, ListNode B){
        ListNode f1 = A;
        ListNode f2 = B;
        ListNode p1 = A;
        ListNode p2 = B;

        while(f1!=null && f2!=null){
            p1 = f1;
            p2 = f2;
            f1 = f1.next;
            f2 = f2.next;
            p2.next = p1.next;
            p1.next = p2;
        }

        return A;
    }
}
