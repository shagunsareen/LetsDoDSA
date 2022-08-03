package dsa.with.shagun.questions.pepcoding.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestAreaHistogram {  //TC : O(n) +O(n) +O(n) ~O(n) (each for right smaller ele loop, left smaller ele loop, max area loop)
    //SC : O(n) considering only arrays used to store right boundary and left boundary
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] rb = new int[arr.length]; // next smaller ele index on right
        Stack<Integer> rbStack = new Stack<>(); // to store smallest ele on right at any given point
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!rbStack.isEmpty() && arr[i] <= arr[rbStack.peek()]) {
                rbStack.pop(); // remove all the larger elements from stack as we don't need that
            }
            rb[i] = rbStack.isEmpty() ? arr.length : rbStack.peek();
            rbStack.push(i);
        }

        int[] lb = new int[arr.length]; //next smaller ele index on left
        Stack<Integer> lbStack = new Stack<>(); // to store smallest ele on left at any point
        for (int i = 0; i <= arr.length - 1; i++) {
            while (!lbStack.isEmpty() && arr[i] <= arr[lbStack.peek()]) {
                lbStack.pop(); // remove all the larger elements from stack as we don't need that
            }
            lb[i] = lbStack.isEmpty() ? -1 : lbStack.peek();
            lbStack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);
    }
}
