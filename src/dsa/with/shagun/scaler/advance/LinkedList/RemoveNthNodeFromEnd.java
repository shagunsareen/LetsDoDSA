package dsa.with.shagun.scaler.advance.LinkedList;

public class RemoveNthNodeFromEnd {
    class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode head = A;
        ListNode temp = head;

        if (A == null) {
            return null;
        }

        int length = 0;
        //get length of linkedlist
        if (head != null) {
            while (temp.next != null) {
                length++;
                temp = temp.next;
            }
            length++;
        }

        //as per length delete node now from start
        /*if (length == 0) {
            return null;
        } else if (B > length) {//delete first element of the list B>length of the list

            //check if there is only element in list
            if (length == 1) {
                head = null; //remove the only element in the list
            } else {
                head = head.next; //move head so that first element itself is removed
            }
        } else {//if B<=length
            if (B == length) { // delete first element
                if (length == 1) {//delete first element
                    head = null;
                } else {
                    head = head.next;
                }
            }*/
        if (B >= length) {  // when length of LL and B are same that means if we take Bth element from end it would be first element, hence move head to next i.e. A.next
            return A.next;
        } else {
            ListNode temp2 = head;
            int traverse = length - B; //since we will move from start to end
            int steps = traverse;
            while (traverse > 1 && temp2.next != null) {
                traverse--;
                temp2 = temp2.next;
            }
            if (steps == length - 1) {
                temp2.next = null;
            } else {
                temp2.next = temp2.next.next;
            }
        }
        return head;
    }
}
