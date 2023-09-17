package dsa.with.shagun.scaler.advance.Queue.Revision;

//https://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1


public class QueueUsingLinkedList {

    /*The structure of the node of the queue is */

class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

    class MyQueue
    {
        QueueNode front, rear;

        //Function to push an element into the queue.
        void push(int a)
        {
            //Element in the queue is pushed at rear end i.e. at the tail
            //Check if the list is empty then this will be the first node else attach it after tail
            QueueNode newNode = new QueueNode(a); //new node
            if(front == null){
                front = newNode;
                rear = newNode;
            }else{
                rear.next = newNode;
                rear = rear.next;
            }
        }

        //Function to pop front element from the queue.
        int pop()
        {
            //In Queue we will pop from the front, so check if there is any element at the front or not
            if(front == null){
                return -1;
            }

            QueueNode temp = front;
            front = front.next; //move the head pointer forward

            if(front == null){
                rear = null; //make rear also null if front is null after deletion
            }

            return temp.data;
        }
    }
}
