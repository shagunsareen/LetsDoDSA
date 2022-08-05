package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation { //TC : O(n),SC :O(n)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {

                operands.push(ch - '0');

            } else if ('(' == ch) {

                operators.push(ch);

            } else if (')' == ch) {

                // solve until opening bracket
                while (operators.peek() != '(') {
                    solve(operators, operands);
                }
                operators.pop(); // this will pop the opening bracket inside of which we were solving expression

            } else if ('+' == ch || '-' == ch || '*' == ch || '/' == ch) {

                //check if stack is not empty , check precedence while solving
                while (!operators.isEmpty() && getPrecendence(ch) <= getPrecendence(operators.peek()) && operators.peek() != '(') {
                    solve(operators, operands);
                }
                operators.push(ch);  // the character is being pushed itself now

            }
        }
        // once everything is in place solve the expression now
        while (!operators.isEmpty() && !operands.isEmpty()) {
            solve(operators, operands);
        }

        System.out.println(operands.peek());
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

    public static int perform(int oprnd1, int oprnd2, char oprtr) {
        if (oprtr == '+') {
            return oprnd1 + oprnd2;
        } else if (oprtr == '-') {
            return oprnd1 - oprnd2;
        } else if (oprtr == '*') {
            return oprnd1 * oprnd2;
        } else {
            return oprnd1 / oprnd2;
        }
    }

    public static void solve(Stack<Character> operators, Stack<Integer> operands) {
        char optr = operators.pop();
        int v2 = operands.pop();
        int v1 = operands.pop();  // here ele at lower position in stack is to be considered first because a-b we have to do and not b-a

        int ans = perform(v1, v2, optr);
        operands.push(ans);
    }
}

