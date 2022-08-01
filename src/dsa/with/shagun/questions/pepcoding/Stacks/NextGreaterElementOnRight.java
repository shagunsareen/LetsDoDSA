package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.*;
import java.util.*;

public class NextGreaterElementOnRight {  //TC : O(2n + 2n) ~ O(n), SC : O(1)

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

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];

        // Approach 1 - without circular array
        /*stack.push(arr[arr.length-1]);
        nge[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            nge[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(arr[i]);
        }*/

        // Approach 2 - with circular array  -- this will cover next greater ele even for ele whose nge is not on right but on their left
        for (int i = 2*n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
                stack.pop();
            }
            if(i<n){
                nge[i] = !stack.isEmpty() ? stack.peek() : -1;
            }
            stack.push(arr[i%n]);
        }
        return nge;
    }
}
