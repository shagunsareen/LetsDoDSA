package dsa.with.shagun.scaler.advance.Queue;

import java.util.*;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println(solve(new String("abadbc")));
        System.out.println(solve(new String("abcabc")));
    }
    //TC : O(N), SC:O(N)
    public static String solve(String A) {
        int[] freqArr = new int[26];

        //To know which char is non-repeating at every point we need to store order in which we have non-repeating elements
        // i.e. if we are inserting a then how freq of a is changing and which is the new non-repeating element we should know
        //This can be done using dequeue since we need to insert current element in dequeue if it's freq ==1 and delete element whose freq>1
        Deque<Character> dequeue = new ArrayDeque<>();
        //Since we need StringBuilder to store ans
        StringBuilder str = new StringBuilder();

        //Get frequency of each element
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            freqArr[ch - 'a']++;

            //add character to the dequeue if it's freq is 1 meaning it can be first non repeating char
            if (freqArr[ch - 'a'] == 1) {
                dequeue.offer(ch);
            }

            //we are checking for first non repeating char in dequeue, if freq > 1 pop all these repeating chars
            while (!dequeue.isEmpty() && freqArr[dequeue.peek() - 'a'] > 1) {
                dequeue.poll();
            }

            if (dequeue.isEmpty()) {
                str.append("#");
            } else {
                str.append(dequeue.peek());
            }
        }
        return str.toString();
    }
}
