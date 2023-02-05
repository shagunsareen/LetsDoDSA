package dsa.with.shagun.scaler.advance.LinkedList.session2;

public class SortLinkedListWithMergeSort {

    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode A) {

        //check if list is empty or has only 1 element, no need to sort
        if (A == null) {
            return null;
        }
        if (A.next == null) {
            return A;
        }

        //Find middle element to divide the list into 2 lists
        ListNode mid = middleEle(A);
        //System.out.println("Mid Element : " + mid.val);

        ListNode h2 = mid.next; //set head of second list
        mid.next = null; //end first list

        //System.out.println("New List head :"+h2.val);

        //Divide l1 = head to mid, l2 = mid+1 to end
        ListNode t1 = sortList(A); //first sorted list
        ListNode t2 = sortList(h2); //second sorted list

        return mergeTwoLists(t1,t2); // merge 2 sorted lists
    }

    private ListNode middleEle(ListNode A) {

        ListNode slow = A;
        ListNode fast = A;

        if (fast.next != null && fast.next.next == null) { // list.size = 2 then return middle element and not (n/2+1)th element
            return slow;
        }

        //For odd no. of elements, fast.next=null
        //For even no. of elements, fast=null
        //return slow.val;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

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
