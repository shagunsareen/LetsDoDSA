package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixEvalAndConversion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> postfixEval = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            //NOTE : In post fix there won't be any opening closing brackets because operators are already in order at the last so no need to check precedence of operators
            if ('+' == ch || '-' == ch || '*' == ch || '/' == ch) {
                    solve(ch, infix, prefix, postfixEval);
            }else{
                    infix.push(ch + "");
                    prefix.push(ch + "");
                    postfixEval.push(ch - '0');
            }
        }
        System.out.println(postfixEval.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
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

    public static void solve(Character ch, Stack<String> infix, Stack<String> prefix, Stack<Integer> postFixEval) {
        String inV2 = infix.pop();
        String inV1 = infix.pop();  // here ele at lower position in stack is to be considered first because a-b we have to do and not b-a

        String inVal = '(' + inV1 + ch + inV2 + ')';
        infix.push(inVal);

        String preV2 = prefix.pop();
        String preV1 = prefix.pop();  // here ele at lower position in stack is to be considered first because a-b we have to do and not b-a

        String preVal = ch + preV1 + preV2;
        prefix.push(preVal);

        Integer i2 = postFixEval.pop();
        Integer i1 = postFixEval.pop();
        int ans = perform(i1, i2, ch);
        postFixEval.push(ans);
    }
}
