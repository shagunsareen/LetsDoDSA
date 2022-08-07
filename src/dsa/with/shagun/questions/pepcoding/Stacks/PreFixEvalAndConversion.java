package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//Note: If Prefix is given then order is followed from right to left as operator on right would have been resolved first. Operand on right would be considered op1 and not left one
public class PreFixEvalAndConversion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Integer> preFixEval = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            //NOTE : In post fix there won't be any opening closing brackets because operators are already in order at the last so no need to check precedence of operators
            if ('+' == ch || '-' == ch || '*' == ch || '/' == ch) {
                solve(ch, infix, postfix, preFixEval);
            } else {
                infix.push(ch + "");
                postfix.push(ch + "");
                preFixEval.push(ch - '0');
            }
        }
        System.out.println(preFixEval.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
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

    public static void solve(Character ch, Stack<String> infix, Stack<String> postfix, Stack<Integer> preFixEval) {
        String inV1 = infix.pop();
        String inV2 = infix.pop();

        String inVal = '(' + inV1 + ch + inV2 + ')';
        infix.push(inVal);

        String preV1 = postfix.pop();
        String preV2 = postfix.pop();

        String preVal = preV1 + preV2 + ch;
        postfix.push(preVal);

        Integer i1 = preFixEval.pop();
        Integer i2 = preFixEval.pop();
        int ans = perform(i1, i2, ch);
        preFixEval.push(ans);
    }
}
