package dsa.with.shagun.scaler.advance.Stack;

import java.util.Stack;

/*
You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is string A.



Output Format
Return the final string.



Example Input
Input 1:

 A = abccbc
Input 2:

 A = ab


Example Output
Output 1:

 "ac"
Output 2:

 "ab"


Example Explanation
Explanation 1:

Remove the first occurrence of same consecutive characters. eg for a string "abbc",
the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "ac".
Explanation 2:

 No removals are to be done.
 */
public class DoubleCharacterTrouble {

    public static void main(String[] args) {
        System.out.println(solve("abccbc"));
        System.out.println(solve("ab"));
        System.out.println(solve("aba"));
    }

    public static String solve(String A) {

        //Approach : For every element in string, compare it to stack's top. If it's same remove it else push it
        //TC : O(N+N), SC :O(N+N)
        Stack<Character> stack = new Stack<>();

        for (char ch : A.toCharArray()) {
            //If top element is empty or it is NOT same as the incoming one then push the element to stack
            /*if (stack.empty()) {
                stack.push(ch);
            } else {
                if (stack.peek() != ch) {
                    stack.push(ch);
                } else {
                    //if top element is same as incoming character
                    stack.pop();
                }
            }*/
            if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
            } else stack.push(ch);
        }


        StringBuilder str = new StringBuilder();
        /*if (stack.empty()) {
            return "";
        }
        for (int i = stack.size(); i > 0; i--) {
            str.append(stack.pop());
        }*/
        while (!stack.empty()) {
            str.append(stack.peek());
            stack.pop();
        }
        return str.reverse().toString();
    }
}
