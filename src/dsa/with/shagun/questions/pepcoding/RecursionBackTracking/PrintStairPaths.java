package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintStairPaths {  // TC : O(3^n) ,SC : O(1) as no extra space is required, space complexity is constant. However, if we consider the space taken by the recursion call stack, then space complexity will be O(n) as the maximum depth of the recursion stack at any point can be equal to the length of the numeric string.
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        //Base condition
        if (n == 0) {
            System.out.println(path);
            return;
        } else if (n < 0) {
            return;
        }

        printStairPaths(n - 1, path + "1");
        printStairPaths(n - 2, path + "2");
        printStairPaths(n - 3, path + "3");
    }

}
