package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintDecreasing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        printDecreasing(scn.nextInt());
    }

    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);
    }
}
