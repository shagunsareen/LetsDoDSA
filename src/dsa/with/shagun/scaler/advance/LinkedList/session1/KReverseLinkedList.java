package dsa.with.shagun.scaler.advance.LinkedList.session1;

public class KReverseLinkedList {
        public ListNode reverseList(ListNode A, int B) {
            return reverse(A, B);
        }

        //this will return reversed head which we need to connect to prev head
        private ListNode reverse(ListNode A, int B){
            ListNode curr = A;
            ListNode next = null;
            ListNode prev = null;
            int count = B;

            //reverse B elements in a list
            while(curr!=null && count > 0){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count--;
            }

            if(next!=null){
                A.next = reverse(next, B);  // next will be at the head of new list hence start new list reversal from that point, it will return the prev post reversal as that would be the head of reversed list
            }

            return prev; // prev will be head of the reversed linked list
        }
}
