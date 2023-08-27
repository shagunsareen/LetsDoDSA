package dsa.with.shagun.scaler.advance.LinkedList.session2;

public class AddTwoNumsInList {
    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        //Iterate over both the linkedlist to add nodes one by one
        int carry = 0;
        ListNode dummy = new ListNode(0); //this is to return new list basically new list head
        ListNode temp = dummy; //this is to iterate over new list

        //Iterate if any of given node is available to add
        while( A!=null || B!=null || carry !=0 ){
            int sum = 0; //since sum is representing each new node value

            if(A!=null){
                sum += A.val;
                A = A.next;
            }

            if(B!=null){
                sum += B.val;
                B=B.next;
            }

            sum += carry; //add the previous carry
            carry = sum / 10; //calculate the new carry after adding both numbers and prev carry

            //create a new node with latest sum calculated
            ListNode node = new ListNode(sum%10);
            temp.next = node; //added new node to the linkedlist
            temp = temp.next; // moved pointer ahead to attach next new node here
        }

        return dummy.next; //since first node we created ourself it is not the part of answer;
    }
}
