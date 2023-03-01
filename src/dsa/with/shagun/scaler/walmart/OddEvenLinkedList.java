package dsa.with.shagun.scaler.walmart;

public class OddEvenLinkedList {

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    
    public ListNode oddEvenList(ListNode head) {
        ListNode oddH = null;
        ListNode oddT = null;
        ListNode evenH = null;
        ListNode evenT = null;

        int nodeCount = 1;

        while(head!=null){
            //append odd nodes
            if(nodeCount%2!=0){
                if(oddH == null){
                    oddH = head;
                    oddT = head;
                }else{
                    oddT.next = head;
                    oddT = oddT.next;
                }
            }else{
                //append even nodes
                if(evenH == null){
                    evenH = head;
                    evenT = head;
                }else{
                    evenT.next = head;
                    evenT = evenT.next;
                }
            }
            head = head.next;
            nodeCount++;
        }

        // if there are no odd nodes
        if(oddH == null){
            return evenH;
        }

        // if there are no even nodes
        if(evenH == null){
            return oddH;
        }

        // combine even list to odd list
        oddT.next = evenH;
        evenT.next = null;
        return oddH;
    }
}
