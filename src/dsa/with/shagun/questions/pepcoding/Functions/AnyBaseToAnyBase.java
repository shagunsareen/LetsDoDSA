package dsa.with.shagun.questions.pepcoding.Functions;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int d = getValueByBase(n, sourceBase, destBase);
        System.out.println(d);
    }

    public static int getValueByBase(int n, int src, int dest) {
       return convertDecimalToAnyBase(convertAnyBaseToDecimal(n,src),dest);
    }

    public static int convertAnyBaseToDecimal(int n, int b){
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

    public static int convertDecimalToAnyBase(int n, int b) {
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
