package dsa.with.shagun.scaler.advance.LinkedList.session3;

import java.util.List;

public class LongestPalindromicLL {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }

    int result = 0;

    public int solve(ListNode A) {

        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;

            //get the count of even length linkedlist and odd length linkedlist
            result = Math.max(result, 2*count(prev, next) + 1); //here +1 is done for the current node, ODD LENGTH LINKEDLIST
            result = Math.max(result, 2*count(curr, next)); // EVEN LENGTH LINKEDLIST
            prev = curr;
            curr = next;
        }
        return result;
    }

    //get count of equal pairs in both the lists
    private int count(ListNode backward, ListNode forward){
        int count = 0;

        while(backward!=null && forward!=null){

            if(backward.val == forward.val){
                count++;
            }else{
                break;
            }

            backward = backward.next;
            forward = forward.next;
        }

        return count;
    }
}
