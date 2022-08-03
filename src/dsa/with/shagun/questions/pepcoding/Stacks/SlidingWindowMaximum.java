package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        //Find next greater element for every element
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();  //remove elements smaller in stack compared to array ele
            }

            nge[i] = stack.isEmpty() ? arr.length : stack.peek();  // because we need to tell that nge if not present for ele is out of the window
            stack.push(i);
        }

        int j = 0; // this is used to hop from one nge to next nge
        for (int i = 0; i <= arr.length - k; i++) {
            if (j < i) {
                j = i;
            }

            while (nge[j] < i + k) { //check if nge is outside the window if yes then current ele is nge
                j = nge[j];
            }
            System.out.println(arr[j]);
        }
    }
}
