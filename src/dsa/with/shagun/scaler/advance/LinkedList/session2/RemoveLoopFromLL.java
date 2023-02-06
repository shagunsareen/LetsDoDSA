package dsa.with.shagun.scaler.advance.LinkedList.session2;

//TC : O(N), SC:O(1)
public class RemoveLoopFromLL {
    class ListNode {

        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A) {

        //Step1 : Detect cycle in linkedlist
        ListNode slow = A;
        ListNode fast = A;
        boolean loop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next; //move sllow by 1 step
            fast = fast.next.next; //move fast by 2 steps
            if (slow == fast) { //meeting point
                //cycle exists because fast moves at twice speed of slow so fast can meet slow only if there is a cycle
                loop = true;
                break;
            }
        }
        //CASE 1 : NO CYCLE - If cycle doesn't exist and we came out of loop because of that
        if (!loop) {
            return A;
        }

        //CASE 2 : CYCLE EXISTS - Make node point to null wherever cycle is starting
        //find the start point of the loop
        fast = A;
        /*while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        //we need to break the node previous to where loop starts from
        ListNode t = fast; //whereever fast is we will start from there
        while(t.next!=fast){
            t=t.next;
        }
        t.next = null;*/
        while (fast.next != slow.next) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = null;  // since we are checking next pointer once slow ptrs next is same as fast that means slow pointer is end of loop make it null
        return A;
    }
}
