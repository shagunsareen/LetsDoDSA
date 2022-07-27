package dsa.with.shagun.questions.pepcoding.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {   //TC : O(n), SC : O(n)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                if (stack.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        System.out.println(false);
    }
}
