package dsa.with.shagun.scaler.advance.Queue.Revision;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNonRepeatingChar {
    public String solve(String A) {
        //To check whether a character is non-repeating we need to check the frequency of each character so we maintain a frequency array
        int[] freqArray = new int[26];

        Deque<Character> deque = new ArrayDeque<>();

        StringBuilder str = new StringBuilder();

        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            freqArray[ch - 'a']++; //this is to store the frequency of a character

            if(freqArray[ch - 'a'] == 1){
                // if the frequency is 1 then this can be the non-repeating char till a certain point
                deque.offer(ch);
            }

            //delete the elements with more frequency than 1
            while(freqArray[deque.peek() - 'a'] > 1 && !deque.isEmpty()){
                deque.pop();
            }

            if(!deque.isEmpty()){
                str.append(deque.peek());
            }else{
                str.append("#");
            }
        }

        return str.toString();
    }
}
