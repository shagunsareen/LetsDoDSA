package dsa.with.shagun.scaler.advance.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:
It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints
1 <= A <= 100000

Input Format
The only argument given is an integer A.

Output Format
Return a string that denotes the Ath Perfect Number.

Example Input
Input 1: A = 2
Input 2: A = 3

Example Output
Output 1: 22
Output 2: 1111

Example Explanation
Explanation 1:
First four perfect numbers are:
1. 11 2. 22 3. 1111 4. 1221

Explanation 2:
First four perfect numbers are:
1. 11 2. 22 3. 1111 4. 1221
 */
public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println(solve(3));
        System.out.println(solve(2));
    }

    public static String solve(int A) {
        //Approach 1: If we go by linear approach to check all even digit
        // numbers which can be perfect numbers then for 4th perfect number we will have to do 1221 iterations which is not feasible
        //Hence, we should think of some data structure which can reduce time complexity

        //Approach 2 : Since all perfect numbers will be of length even hence if we get half of number the other half we can concatenate by reversing it. Since it's a palindrome
        //Hence if we take 1 n 2 in the queue then we just have to concatenate 1 and 2 with further numbers and create aa' where a is number and a' is reverse of the number.
        //TC : O(A), SC:O(A+2),here 2 is for 1 and 2 which we have inserted
        Deque<String> deque = new ArrayDeque<String>();
        deque.offer("1"); // INSERT AT THE TAIL
        deque.offer("2"); // INSERT AT THE TAIL

        //Now poll head of queue one by one and generate combinations and ans String
        StringBuilder str = null;

        // If A is 1 no need to process further logic
        if (A == 1 && !deque.isEmpty()) {
            return deque.peek() + (new StringBuilder(deque.peek()).reverse());
        }

        // if A > 1
        while (A > 0) {
            str = new StringBuilder("");

            String element = deque.getFirst(); //peekFirst and peek throws an exception if the deque is empty but this doesn't
            deque.offer(element + "1");
            deque.offer(element + "2");

            str.append(deque.peek() + (new StringBuilder(deque.getFirst()).reverse()));
            deque.remove(); // REMOVE FROM FRONT --this is different from poll as this doesn't throw an exception if queue is empty
            A--;
        }

        return str.toString();
    }
}
