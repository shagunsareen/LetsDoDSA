package dsa.with.shagun.scaler.advance.Stack;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(solve("{([])}"));
    }

    public static int solve(String A) {
        Stack<Character> stack = new Stack<Character>();

        for (char ch : A.toCharArray()) {

            if (!stack.empty() && stack.peek() == '{' && ch == '}'
                    || !stack.empty() && stack.peek() == '(' && ch == ')'
                    || !stack.empty() && stack.peek() == '[' && ch == ']') {
                stack.pop();
            } else {
                //either stack is empty or characters don't match
                stack.push(ch);
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
