package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        int st =num/2 +1;
        int sp = 1;
        for (int i=1;i<=num;i++){
            for (int k=1;k<=st;k++){
                System.out.print("*\t");
            }
            for (int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            for (int k=1;k<=st;k++){
                System.out.print("*\t");
            }
            if(i<=num/2){
                st--;
                sp+=2;
            }else{
                st++;
                sp-=2;
            }
            System.out.println();
        }
    }
}
