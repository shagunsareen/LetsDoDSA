package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int sp = num / 2;
        int digToPrint = 1;
        int startingValue = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            int valToPrint=startingValue;
            for (int j = 1; j <= digToPrint; j++) {
                System.out.print(valToPrint + "\t");
                if (j <= digToPrint / 2) {
                    valToPrint++;
                } else {
                    valToPrint--;
                }
            }
            if (i <= num / 2) {
                digToPrint += 2;
                sp--;
                startingValue++;
            } else {
                digToPrint -= 2;
                sp++;
                startingValue--;
            }
            System.out.println();
        }
    }
}
