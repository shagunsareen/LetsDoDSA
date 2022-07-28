package dsa.with.shagun.questions.pepcoding.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParanthesis { // TC : O(n) , because we traverse string of length n as pop and push are O(1)
    // SC : O(1) , because no extra space
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            pushOpeningBracketsToStack(stack, c);
            if (c == ')') {
                if (!checkIfBalanced(stack, '(')) {
                    return;
                }
            } else if (c == '}') {
                if (!checkIfBalanced(stack, '{')) {
                    return;
                }
            } else if (c == ']') {
                if (!checkIfBalanced(stack, '[')) {
                    return;
                }
            }
        }
        checkIsStackEmpty(stack);
    }

    public static boolean checkIfBalanced(Deque<Character> stack, Character charInStr) {
        if (stack.isEmpty() || !stack.peek().equals(charInStr)) {
            System.out.println(false);
            return false;
        } else {
            stack.pop();
            return true;
        }
    }

    public static void checkIsStackEmpty(Deque<Character> stack) {
        System.out.println(stack.isEmpty());
    }

    public static void pushOpeningBracketsToStack(Deque<Character> stack, Character chToPush) {
        if (chToPush == '(' || chToPush == '{' || chToPush == '[') {
            stack.push(chToPush);
        }
    }
}
