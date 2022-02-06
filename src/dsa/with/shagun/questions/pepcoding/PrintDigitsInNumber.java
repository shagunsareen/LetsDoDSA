package dsa.with.shagun.questions.pepcoding;

import java.util.Scanner;

public class PrintDigitsInNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int temp =  num;
        int count=0;
        while (temp!=0){
            temp = temp/10;
            count++;
        }
        int div = (int)Math.pow(10, count-1);
        while(div!=0){
            int digit = num / div;
            System.out.println(digit);
            num = num % div;
            div = div /10;
        }
    }
}
