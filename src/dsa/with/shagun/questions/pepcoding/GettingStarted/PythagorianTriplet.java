package dsa.with.shagun.questions.pepcoding.GettingStarted;

import java.util.Scanner;

public class PythagorianTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int num3 = scn.nextInt();

        int max = num1;
        if(num2 >= max){
            max = num2;
        }
        if (num3 >= max){
            max = num3;
        }

        if(max == num1){
            System.out.println((num2 * num2 + num3 * num3) == num1 * num1);
        }
        if(max == num2){
            System.out.println((num1 * num1 + num3 * num3) == num2 * num2);
        }
        if(max == num3){
            System.out.println((num2 * num2 + num1 * num1) == num3 * num3);
        }

    }
}
