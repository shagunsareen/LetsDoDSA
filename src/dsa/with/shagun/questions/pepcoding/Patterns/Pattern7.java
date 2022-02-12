package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int st =1;
        int sp=num-1;

        for (int i=num;i>0;i--){
            for (int j=sp;j>=i;j--){
                System.out.print("\t");
            }
            System.out.print("*");
            System.out.println();
        }
    }
}
