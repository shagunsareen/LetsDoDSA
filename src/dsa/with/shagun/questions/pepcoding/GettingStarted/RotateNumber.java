package dsa.with.shagun.questions.pepcoding.GettingStarted;

import java.util.Scanner;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //number
        int k = scn.nextInt(); //rotations

        int count = 0;
        int temp = n;

        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        k = k % count; // this is if k>n
        if (k < 0) {
            k = k + count;
        }
        int rot = 0;
        int rem = n % (int) Math.pow(10, k);
        int div = n / (int) Math.pow(10, k);
        rot = rem * (int) Math.pow(10, count - k) + div;
        System.out.println(rot);
    }
}
