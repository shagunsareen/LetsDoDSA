package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.*;
import java.util.*;

public class StockSpan { //TC :O(n(),SC :O(n) for storing ans

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        int[] span = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // it will store indexes and first element will always have value 1 because we don't have any prior day to consider span.
        span[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }
        return span;
    }

}
