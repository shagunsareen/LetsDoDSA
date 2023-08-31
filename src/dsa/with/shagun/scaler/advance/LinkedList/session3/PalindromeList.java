package dsa.with.shagun.scaler.advance.LinkedList.session3;

public class PalindromeList {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }

    public int lPalin(ListNode A) {
        ListNode first = A;

        //Step1 : find the mid of the linkedlist
        ListNode mid = mid(A);

        //Step2 : reverse linkedlist from mid.next;
        ListNode second = reverseLL(mid.next);

        //Step3 : compare both lists to check if it is a palindrome or not
        while(second != null){
            //compare both values
            if(first.val != second.val){
                return 0;
            }

            //if curr values are equal then move ahead
            first = first.next;
            second = second.next;
        }

        return 1;
    }

    private ListNode mid(ListNode A){
        ListNode slow = A;
        ListNode fast = A;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLL(ListNode A){

        ListNode prev = null;
        ListNode next = null;

        ListNode curr = A;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }

        return prev;
    }
}
