package dsa.with.shagun.leetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> freqStackMap;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        freqStackMap = new HashMap<>();
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) +1);
        int currFreq = freq.get(val);
        maxFreq  = Math.max(maxFreq, currFreq);

        Stack<Integer> stack = freqStackMap.getOrDefault(currFreq, new Stack<>());
        stack.push(val);
        freqStackMap.put(currFreq, stack);
    }

    public int pop() {
        int elemPopped = freqStackMap.get(maxFreq).pop();
        freq.put(elemPopped, freq.get(elemPopped) -1);

        if(freqStackMap.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return elemPopped;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());  // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());  // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());
    }
}
