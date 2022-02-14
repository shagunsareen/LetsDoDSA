package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class PatternInvertedHourGlass {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int sp = 0;
        int st = num;
        for (int i = 1; i <= num; i++) {

            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= st; j++) {
                if (i < num && i > num / 2 && j > 1 && j < st) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            if (i <= num / 2) {
                sp++;
                st -= 2;
            } else {
                sp--;
                st += 2;
            }
            System.out.println();
        }
    }
}
