package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostAndPrefixConversions {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> operators = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')) {

                prefix.push(ch + "");
                postfix.push(ch + "");

            } else if ('(' == ch) {

                operators.push(ch);

            } else if (')' == ch) {

                // solve until opening bracket
                while (operators.peek() != '(') {
                    solve(operators, prefix, postfix);
                }
                operators.pop(); // this will pop the opening bracket inside of which we were solving expression

            } else if ('+' == ch || '-' == ch || '*' == ch || '/' == ch) {

                //check if stack is not empty , check precedence while solving
                while (!operators.isEmpty() && getPrecendence(ch) <= getPrecendence(operators.peek()) && operators.peek() != '(') {
                    solve(operators, prefix, postfix);
                }
                operators.push(ch);  // the character is being pushed itself now

            }
        }
        // once everything is in place solve the expression now
        while (!operators.isEmpty() && !prefix.isEmpty() && !postfix.isEmpty()) {
            solve(operators, prefix, postfix);
        }
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    public static int getPrecendence(char optr) {
        int priority = 0;
        if ('+' == optr || '-' == optr) {
            priority = 1;
        } else if ('*' == optr || '/' == optr) {
            priority = 2;
        }
        return priority;
    }

    public static void solve(Stack<Character> operators, Stack<String> prefix, Stack<String> postfix) {
        char optr = operators.pop();
        String preV2 = prefix.pop();
        String preV1 = prefix.pop();  // here ele at lower position in stack is to be considered first because a-b we have to do and not b-a

        String preVal = optr + preV1 + preV2;
        prefix.push(preVal);

        String postV2 = postfix.pop();
        String postV1 = postfix.pop();  // here ele at lower position in stack is to be considered first because a-b we have to do and not b-a

        String postVal = postV1 + postV2 + optr;
        postfix.push(postVal);
    }
}

