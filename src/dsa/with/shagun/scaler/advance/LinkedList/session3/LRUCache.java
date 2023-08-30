package dsa.with.shagun.scaler.advance.LinkedList.session3;

import java.util.HashMap;

public class LRUCache {

        int limit;
        HashMap<Integer, Node> hm;  // first param : key , second param : Node of the linkedlist
        Node head;
        Node tail;

        class Node{
            int key;  // since we have to update the key everytime when we delete or add an element to the cache
            int data;
            Node prev;
            Node next;

            Node(int key, int value){
                this.data = value;
                this.key = key;
            }
        }

        public Solution(int capacity) {
            this.limit = capacity;
            hm = new HashMap();

            head = new Node(-1, 0);
            tail = new Node(-1, 0);

            head.next = tail;
            tail.prev = head; //this is to create a double linkedlist so atleast we need 2 nodes to do so
        }

        //when we get any element it will be accessed again then it should be deleted from previous position
        //and inserted again at the last
        public int get(int key) {
            if(hm.containsKey(key)){
                Node currentNode = hm.get(key);
                delete(currentNode);
                insertAtLast(currentNode);

                return currentNode.data; //return the value of the key since it exists
            }
            return -1;
        }

        //here we have to check whether key is already present or not. If it is present then delete and insertat last
        //else check limit and insert at the last
        public void set(int key, int value) {
            if(hm.containsKey(key)){
                Node existingNode = hm.get(key);
                delete(existingNode);
            }else{
                //if it is not already present check if the cache limit has reached
                if(hm.size() == limit){
                    //delete first node of the hashmap and then insert new node
                    delete(head.next); //since head was pointing to tail but now we are inserting nodes before tail
                }
            }

            Node nn = new Node(key, value);
            insertAtLast(nn);
        }

        private void delete(Node currentNode){
            hm.remove(currentNode.key);
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            //now both the links are created
        }

        private void insertAtLast(Node currentNode){
            hm.put(currentNode.key, currentNode);
            currentNode.prev = tail.prev;
            currentNode.next = tail;
            tail.prev.next = currentNode;
            tail.prev = currentNode;
        }
    }
}
