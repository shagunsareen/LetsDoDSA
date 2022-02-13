package dsa.with.shagun.questions.pepcoding.Patterns;

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int first=0;
        int second = 1;
        for (int i=1;i<=num;i++){
            for (int j=1;j<=i;j++){
                System.out.print(first+"\t");
                int sum = first + second;
                first = second;
                second =sum;
            }
            System.out.println();
        }
    }
}
