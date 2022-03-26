package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintIncreasing {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        printIncreasing(scn.nextInt());
    }

    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
    }
}
