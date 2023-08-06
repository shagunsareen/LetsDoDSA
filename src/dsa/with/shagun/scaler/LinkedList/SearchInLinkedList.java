package dsa.with.shagun.scaler.LinkedList;

public class SearchInLinkedList { //TC : O(N), SC: O(1)
    public int solve(PrintLinkedList.ListNode A, int B) {
        PrintLinkedList.ListNode temp = A;
        while (temp != null) {
            if(temp.val == B){
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
}
