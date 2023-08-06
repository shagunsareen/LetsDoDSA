package dsa.with.shagun.scaler.advance.LinkedList;

public class DeleteDuplicates {

    class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode A) {

        //check if A is empty
        if (A == null) {
            //System.out.println("List is empty");
            return null;
        }

        //check if there is only element in the list
        if (A.next == null) {
            //System.out.println("List has only 1 element");
            return A;
        } else {
            //let's see if we have duplicates
            ListNode temp = A;  // here A is the head

            while (temp.next != null) {
                //System.out.println("Temp.next is not null");
                //System.out.println("Temp val : "+temp.val + ", Temp.next val :" + temp.next.val);
                if (temp.val == temp.next.val) {
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
                //System.out.println("Temp : "+temp.val + "-" + temp.next.val);
            }
        }
        return A;
    }
}
