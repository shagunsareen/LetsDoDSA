package dsa.with.shagun.questions.pepcoding.Functions;

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b){
        int power =0;
        int newNum = 0;
        while(n>0){
            int rem = n % 10;
            newNum = newNum + (int)(rem * Math.pow(b,power));
            n = n / 10;
            power++;
        }
        return newNum;
    }
}
