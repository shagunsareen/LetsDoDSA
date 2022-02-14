package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int sp = 2 * num - 3;
        int st = 1;

        for (int i = 1; i <= num; i++) {
            int startingValue = 1;
            int val = startingValue;
            for (int j = 1; j <= st; j++) {
                System.out.print(val + "\t");
                val++;
            }
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            if (i == num) {
                val--;
                st--;
            }
            for (int j = 1; j <= st; j++) {
                val--;
                System.out.print(val + "\t");
            }

            st++;
            sp -= 2;

            System.out.println();
        }
    }
}
