package dsa.with.shagun.scaler.advance.LinkedList.session2;

import java.util.List;

public class MiddleEleOfLL {

    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int solve(ListNode A) {
        //Approach 1: To find length of LL and find size+1/2 then traverse till middle element
        //TC :O(2N), SC:O(1) here we will traverse LL twice

        //Approach 2: Fast and slow pointers where slow moves 1 steps and fast moves 2 steps
        //By the time fast reaches end, the slow pointer would be at half the distance i.e. middle of LL

   /*     ListNode slow = A;
        ListNode fast = A;

        if (fast.next != null && fast.next.next == null) { // list.size = 2
            return slow.next.val;
        }

        while (fast.next != null) { //list.size > 2
            slow = slow.next;
            fast = fast.next.next;
            if (fast.next == null) {
                return slow.val;
            }
            if (fast.next.next == null) {
                return slow.next.val;
            }
        }

        return A.val; // list.size = 1*/


        //More readable form of code
        ListNode slow = A;
        ListNode fast = A;

        //For odd no. of elements, fast.next=null
        //For even no. of elements, fast=null
        //return slow.val;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }
}
