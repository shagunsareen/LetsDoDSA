package dsa.with.shagun.leetcode.Stack;

import java.util.Stack;

public class ScoreOfParenthesis {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("((()))"));
    }

    public static int scoreOfParentheses(String s) {

        //Approach 1  : TC : O(N) ,SC :O(N)
        /*Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;*/

        //------ Optimised Approach :  SC :O(1)
        int depth = 0;
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }
            if (i>0 && s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                    score = score + (int)Math.pow(2,depth);
            }
        }
         return score;
    }
}
