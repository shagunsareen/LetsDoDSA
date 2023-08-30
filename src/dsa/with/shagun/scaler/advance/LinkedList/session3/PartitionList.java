package dsa.with.shagun.scaler.advance.LinkedList.session3;

public class PartitionList {

    class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode first = new ListNode(-1); //initial node in the first list
    ListNode second = new ListNode(-1); //initial node in the second list

    ListNode head1 = first;
    ListNode head2 = second;

    public ListNode partition(ListNode A, int B) {

        //We can create 2 lists one which will have lesser than B nodes,
        //other one will have greater than equal to B node values
        //Let's take 2 heads of the lists first

        ListNode curr = A;

        while (curr != null) {
            if (curr.val < B) {
                //attach it to the first node
                head1.next = curr;
                head1 = head1.next;
            } else {
                //attach it to the second node
                head2.next = curr;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        head2.next = null;
        head1.next = second.next;
        return first.next;
    }
}
