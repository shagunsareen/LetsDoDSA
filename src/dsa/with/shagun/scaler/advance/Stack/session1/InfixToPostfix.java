package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        //System.out.println(solve("x^y/(a*z)+b"));
        System.out.println(solve("a+b*(c^d-e)^(f+g*h)-i"));
    }

    //TC :O(N),SC:O(N)
    public static String solve(String A) {

        // Step1 : Put order in hashmap for operators
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('(', -1);
        hm.put('^', 3);
        hm.put('/', 2);
        hm.put('*', 2);
        hm.put('+', 1);
        hm.put('-', 1);

        // Append all alphabets to ans string
        StringBuilder str = new StringBuilder();

        //Stack is required to keep the track of history of operators
        Stack<Character> stack = new Stack<>();

        for (char ch : A.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                str.append(ch);
            }
            if (ch == '(') {
                stack.push(ch);
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                if (stack.empty() || stack.peek() == '(') {
                    stack.push(ch);
                } else {
                    //operator in stack is of higher precedence than current operator
                    while (!stack.empty() && hm.get(stack.peek()) >= hm.get(ch)) {
                        str.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            if (ch == ')') {
                while (stack.peek() != '(') {
                    str.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }
}
