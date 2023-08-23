package dsa.with.shagun.scaler.advance.LinkedList.session1;

public class RemoveDuplicates {
        public ListNode deleteDuplicates(ListNode A) {

            //check if the list is empty
            if(A == null){
                return null;
            }

            //check if the list has only 1 element
            if(A.next == null){
                return A;
            }

            ListNode temp = A;

            //check for duplicates and skip duplicates if present
            while(temp.next != null){
                if(temp.val == temp.next.val){
                    //skip next element
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }

            return A;
        }
}
