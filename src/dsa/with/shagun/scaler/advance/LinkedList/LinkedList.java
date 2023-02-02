package dsa.with.shagun.scaler.advance.LinkedList;

public class LinkedList {
    static Node head = null;
    static int length = 0;

    static class Node {
        public int val;
        public Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    public static void insert_node(int position, int value) {
        if (position <= 0) return;

        Node n = new Node(value);

        if (head == null || position == 1) {//insert at start
            n.next = head; //insert at start
            head = n; //update head
        } else if (position == length + 1) {//insert at end
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;

        } else if (position > 1 && position <= length) {//insert in between
            int location = 1;
            Node temp = head;

            while (location < position - 1 && temp.next != null) {
                temp = temp.next;
                location++;
            }

            n.next = temp.next;
            temp.next = n;
        } else {
            return;
        }
        length++;
    }

    public static void delete_node(int position) {
        // if it's an invalid position or list has no node
        if (position <= 0 || position > length || length == 0) {
            return;
        }

        //if we need to delete only node in the list meaning first node
        if (position == 1) {//delete first element
            if (head != null) {
                head = head.next;
            } else {
                return;
            }
        } else if (position == length) {//delete last element
            Node temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;

        } else if (position > 1 && position < length) {
            Node temp = head;
            //if we have to delete node anywhere else
            int location = 1;
            while (location < position - 1) {
                temp = temp.next;
                location++;
            }
            temp.next = temp.next.next;
        } else {
            return;
        }
        length--;
    }

    public static void print_ll() {
        if (length == 0) {
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }
}
