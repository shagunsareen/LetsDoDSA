package dsa.with.shagun.scaler.advance.LinkedList.session1;

public class RemoveNthNode {
        public ListNode removeNthFromEnd(ListNode A, int B) {

            if (A == null) {
                return null;
            }

            //Find the node to be removed from the front as we can't move from backward to the front
            // To find that get the length of the linkedlist
            ListNode head = A;
            ListNode temp = head;
            int len = 0;

            while (temp != null) {
                temp = temp.next;
                len++;
            }

            //if length is smaller than B then delete first node
            if (B >= len) {
                return A.next;
            } else {
                //calculate which node is to be deleted from back and get index from the front for that
                int traverse = len - B - 1;  // len = 5, B =2, traverse 5-2-1= 2 steps
                temp = A; //re-initialise the pointer to head of the linkedlist

                while (traverse > 0 && temp.next != null) {
                    temp = temp.next;
                    traverse--;
                }

                temp.next = temp.next.next;
            }
            return head;
        }
}
