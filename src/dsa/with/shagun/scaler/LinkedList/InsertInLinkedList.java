package dsa.with.shagun.scaler.LinkedList;


class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class InsertInLinkedList {
    public static void main(String[] args) {
        solve(new ListNode(7), 5, 7);
    }

    public static ListNode solve(ListNode A, int B, int C) {
        ListNode temp = A;
        ListNode newNode = new ListNode(B);

        if (temp == null) {  //Case 1 :-----------> List is empty, insert at start
            //insert node at zeroth index
            A = newNode; //i.e. head will point to first node i.e new node
        }
        if (temp != null) { //Case 2 :-----------> List is not empty, index is 0 so, insert at start
            if (C == 0) {
                // i.e. there is already a node at zeroth index
                newNode.next = A; // link newNode with node at 0th index
                A = newNode;  //update the head
            } else {//Case 3 :-----------> List is not empty, insert at given index and if index is more than length insert at tail of the list
                for (int i = 0; i < C - 1; i++) {
                    if (temp.next == null) {
                        break;
                    }
                    temp = temp.next;
                }
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return A;

        //Solution Approach  : ListNode n = new ListNode(B);
        //        if (C <= 0){
        //            n.next = A;
        //            return n;
        //        }
        //
        //        int i = 0;
        //        ListNode temp = A;
        //        while (i < C-1 && temp.next != null){
        //            i += 1;
        //            temp = temp.next;
        //        }
        //
        //        n.next = temp.next;
        //        temp.next = n;
        //        return A;
    }
}
