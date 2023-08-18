package dsa.with.shagun.scaler.advance.LinkedList.session1;

class ListNode{
    public int val;
    public ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {

        ListNode head = A;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null){ // we have to connect last node so we will process till we reach the point where current.next is null
            next = curr.next; //move next ref to next ListNode so that we don't miss start of the list
            curr.next = prev; //connecting current node to prev node
            prev = curr; //moving prev node
            curr = next; //moving curr node
        }

        //move head to prev since the last node connected will have prev pointing to int
        head = prev;
        return head;
    }
}
