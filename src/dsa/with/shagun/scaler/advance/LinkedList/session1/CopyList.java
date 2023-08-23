package dsa.with.shagun.scaler.advance.LinkedList.session1;

public class CopyList {

     // Definition for singly-linked list with a random pointer
     class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
      };

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            addNodes(head);
            setRandom(head);
            return extractCopy(head);
        }

        private RandomListNode extractCopy(RandomListNode head){
            //RandomListNode original = head;
            RandomListNode copy = head.next;
            RandomListNode temp = copy;

            //while(original!=null && copy!=null){
            while(copy!=null){
                //original.next = original.next !=null ? original.next.next : original.next;
                copy.next = copy.next != null ? copy.next.next : copy.next;
                copy = copy.next;
                //original = original.next;
            }

            return temp;
        }

        private void setRandom(RandomListNode head){
            while(head!=null){
                head.next.random = head.random != null ? head.random.next : head.random;
                head = head.next.next;
            }
        }

        private void addNodes(RandomListNode head){
            while(head!=null){
                RandomListNode x = new RandomListNode(head.label); //creating a new node
                x.next = head.next;
                head.next = x;
                head = x.next;
            }
        }
    }
}
