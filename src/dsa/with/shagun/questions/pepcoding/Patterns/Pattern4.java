package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i=0;i<=num-1;i++){
            for (int j=1;j<=num;j++){
                if(j<=i) {
                    System.out.print("\t");
                }else{
                System.out.print("*\t");}
            }
            System.out.println();
        }
    }
}
