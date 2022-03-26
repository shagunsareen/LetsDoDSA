package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PowerLogarithmic {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println(power(scn.nextInt(), scn.nextInt()));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int val = power(x, n / 2) * power(x, n / 2);
        if (n % 2 == 1) {
            val = x * val;
        }
        return val;
    }
}
