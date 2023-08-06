package dsa.with.shagun.scaler.advance.Stack.session1;

import java.util.Stack;

public class CheckTwoBracketExpressions {
    public static void main(String[] args) {
        System.out.println(solve("-(a+b+c)", "-a-b-c"));
    }

    public static int solve(String A, String B) {

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        buildFreqArray(A, freqA);
        buildFreqArray(B, freqB);

        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) {
                return 0;
            }
        }
        return 1;
    }

    static void buildFreqArray(String str, int[] freqArray) {
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);  //by default positive sign is considered

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (i != 0 && ch == '(') { //push next global sign
                char ch1 = str.charAt(i - 1);
                if (ch1 == '-') { //when global operator is negative, signs become opposite
                    stack.push(!stack.peek());
                } else { // when global operator is positive , signs remain same
                    stack.push(stack.peek());
                }
            } else if (ch == ')') {  //end of previous global sign, hence pop it.
                stack.pop();
            } else if (i == 0 && ch >= 97 && ch <= 122) {  //evaluating first alphabet
                freqArray[ch - 'a'] = 1;
            } else if (ch >= 97 && ch <= 122) {//evaluating alphabets
                char ch1 = str.charAt(i - 1);
                if (ch1 == '-') {
                    if (Boolean.FALSE.equals(stack.peek())) {
                        freqArray[ch - 'a'] = 1;
                    }
                } else {
                    if (Boolean.TRUE.equals(stack.peek())) {
                        freqArray[ch - 'a'] = 1;
                    }
                }
            }
        }
    }
}
