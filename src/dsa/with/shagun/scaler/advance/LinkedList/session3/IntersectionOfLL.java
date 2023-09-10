package dsa.with.shagun.scaler.advance.LinkedList.session3;

import java.util.HashSet;

public class IntersectionOfLL {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode A, ListNode B) {

        //Approach 1 : Put nodes of one list into a hashset
        //and check for other list if any node is already present in hashset or not
        //TC : O(N+M), SC:O(N) since we only store fist nodes elements into the hashset

        /*ListNode head1 = A;
        HashSet hs = new HashSet();

        while(head1!=null){
            hs.add(head1);
            head1 = head1.next;
        }

        ListNode head2 = B;

        //check if B list nodes are present in hashset or not
        while(head2!=null){
            if(hs.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }

        //if we didn't get the node yet then return null
        return null;
        */

        // Approach 2 : Move both pointers till both ptrs are same.
        // Since pointer of smaller list will reach null before of larger list by diff = LengthLar-LengthSmall,
        // Larger pointer will be behind of smaller pointer by diffX. Reset smallerPtr to head of largerList so that
        // till largerPointer reaches null, smallerPtr reaches at the same length where largerPtr is now.
        // Hence now when they move they will reach the intersection point at the same time.
        // Either both pointers will reach the same intersection point or both will reach null.

        //TC :O(2N), SC:O(1)
        ListNode head1 = A;
        ListNode head2 = B;

        while(head1!=head2){
            head1 = (head1 == null) ? B : head1.next;
            head2 = (head2 == null) ? A : head2.next;
        }

        return head1; // since even if both reach null then we can return either of the nodes, or if they reach same node then also we can return either of the nodes
    }
}
