package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for (int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                if(j==num-i+1 || i==j){
                    System.out.print("*\t");
                }else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
