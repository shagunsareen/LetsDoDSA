package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i=1;i<=num;i++){
            for (int j=1;j<=num;j++){
                if(j>num-i){
                    System.out.print("*");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
