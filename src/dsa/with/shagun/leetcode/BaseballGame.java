package dsa.with.shagun.leetcode;

import java.util.Stack;

public class BaseballGame {  //TC : O(n) SC : O(n)
    public static void main(String[] args) {
        //System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] ops) {
        //Not possible to do with array as we don't have fixed no. of input elements.
/*        int sum = 0;
        int previous = 0;
        int[] ans = new int[ops.length];
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                previous = Integer.parseInt(ops[i - 1]);
                sum -= previous;
                ans[i - 1] = Integer.parseInt("");
            } else if (ops[i].equals("D")) {
                previous = Integer.parseInt(ops[i - 1]);
                sum += 2 * previous;
                ans[i] = 2 * previous;
            } else if (ops[i].equals("+")) {
                previous = Integer.parseInt(ops[i - 1]);
                int secondPrevious = Integer.parseInt(ops[i - 2]);
                int sumEle = previous + secondPrevious;
                sum += sumEle;
                ans[i] = sumEle;
            } else {
                ans[i] = Integer.parseInt(ops[i]);
            }
        }*/

        //Approach 2
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String s : ops) {
            if (s.equals("C")) {
                int removedElement = stack.pop();
                sum -= removedElement;
            } else if (s.equals("D")) {
                int newElement = 2 * stack.peek();
                stack.push(newElement);
                sum += newElement;
            } else if (s.equals("+")) {
                int previous = stack.pop();
                int secondPrevious = stack.pop();
                int sumEle = previous + secondPrevious;
                stack.push(secondPrevious);
                stack.push(previous);
                stack.push(sumEle);
                sum += sumEle;
            } else {
                int el = Integer.parseInt(s);
                stack.push(el);
                sum += el;
            }
        }
        return sum;

        //Optimised with Java 8 features
       /* for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                int previous = stack.pop();
                int sumEle = previous + stack.peek();
                stack.push(previous);
                stack.push(sumEle);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        return stack.stream().mapToInt(n -> n).sum();*/
    }
}
