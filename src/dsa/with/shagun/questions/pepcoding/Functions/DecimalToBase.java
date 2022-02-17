package dsa.with.shagun.questions.pepcoding.Functions;

import java.util.Scanner;

public class DecimalToBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        int power =0;
        int newNum = 0;
        while(n>0){
            int rem = n % b;
            newNum = newNum + (int)(rem * Math.pow(10,power));
            n = n / b;
            power++;
        }
        return newNum;
    }
}
