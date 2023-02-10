package dsa.with.shagun.scaler.advance.Stack;

import java.util.Objects;
import java.util.Stack;

/*
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.



Problem Constraints
1 <= N <= 105



Input Format
The only argument given is string array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
    9
Output 2:
    6


Example Explanation
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public static int evalRPN(String[] A) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (!Objects.equals(A[i], "+")
                    && !Objects.equals(A[i], "-")
                    && !Objects.equals(A[i], "*")
                    && !Objects.equals(A[i], "/")) {
                stack.push(A[i]);
            } else {
                if (stack.size() > 1) {
                    int operand2 = Integer.parseInt(stack.pop());
                    int operand1 = Integer.parseInt(stack.pop());
                    int result = 0;
                    switch (A[i]) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            result = operand1 / operand2;
                            break;
                        default:
                            break;
                    }
                    stack.push(String.valueOf(result));
                }
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
