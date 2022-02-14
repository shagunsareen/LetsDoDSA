package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i=1;i<=10;i++){
            System.out.print(num+" * "+i+" = "+num*i);
            System.out.println();
        }
    }
}
