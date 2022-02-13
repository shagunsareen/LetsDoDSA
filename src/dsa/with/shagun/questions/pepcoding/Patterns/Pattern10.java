package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int is = -1;
        int os = num / 2;

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= os; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for (int j = 1; j <= is; j++) {
                System.out.print("\t");
            }
            if (i > 1 && i < num) {
                System.out.print("*\t");
            }
            if (i <= num / 2) {
                os--;
                is += 2;
            } else {
                os++;
                is -= 2;
            }
            System.out.println();
        }

    }
}
