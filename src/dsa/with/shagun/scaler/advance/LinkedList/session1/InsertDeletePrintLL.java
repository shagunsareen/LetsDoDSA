package dsa.with.shagun.scaler.advance.LinkedList.session1;

public class InsertDeletePrintLL {

    static Node head = null;
    static int length = 0;

    //Node class implementation
    static class Node{
        int value;
        Node next;

        Node(int val){
            this.next = null;
            this.value = val;
        }
    }

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        //shall we insert node on the basis of position
        if(position < 0 || position > length+1){ //out of bounds don't insert a node
            return;
        }

        Node n = new Node(value); //insert this node

        if(position == 1){ //insert at the start of linkedlist
            n.next = head;
            head = n; //move head to first node
        }else{
            Node temp = head;

            //traverse till 1 point before where we have to insert
            for(int i=1; i<position-1; i++){
                temp = temp.next;
            }

            n.next = temp.next;
            temp.next = n;
        }
        length++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position < 0 || position > length + 1){
            return;
        }

        if(position == 1){
            //return head.next
            head = head.next; //since we need to skip first element
        }else{
            Node temp = head;

            //traverse till we reach pos-1
            for(int i=1; i<position-1; i++){
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }
        length--;
    }

    public static void print_ll() {
        // Output each element followed by a space
        if(length == 0){
            return;
        }

        Node temp = head;
        while(temp.next!= null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.print(temp.value);
    }
}
