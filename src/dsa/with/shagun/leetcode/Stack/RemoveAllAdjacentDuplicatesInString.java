package dsa.with.shagun.leetcode.Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {//TC : O(n) = SC
    class Node {
        int freq;
        char data;

        Node(int f, char d) {
            this.data = d;
            this.freq = f;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();

        //store element and it's freq in stack. As we need to compare adjacent element we need stack and not MAP i.e. we need freq of b=3 when bbb together and not when bbob are together
        for (char c : s.toCharArray()) {

            //check if stack is empty and element is equal to top of stack or not
            if (!stack.isEmpty() && stack.peek().data == c) {
                // increment freq
                Node rv = stack.pop();
                rv.freq += 1;
                stack.push(rv);
            } else { // not equal to top hence insert
                stack.push(new Node(1, c));
            }

            //check if freq is equal to k then pop
            if (!stack.isEmpty() && stack.peek().freq == k) {
                stack.pop();
            }
        }

        //Now that you have traversed all chars check if stack has anything. If yes then return reverse string
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node rv = stack.pop();
            while (rv.freq > 0) {
                builder.append(rv.data);
                rv.freq--;
            }
        }

        return builder.reverse().toString();
    }
}
