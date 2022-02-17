package dsa.with.shagun.questions.pepcoding.Functions;

import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2){
        int diff = 0;
        int power = 0;
        int borrow = 0;
        while (n2 > 0) {
            int rem1 = n1 % 10;
            int rem2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;

            int diffOfRem =0;
            rem2 = rem2 + borrow;
            if(rem1 > rem2){
                diffOfRem = b + rem2 - rem1;
                borrow=-1;
            }else{
                borrow=0;
                diffOfRem = rem2 - rem1;
            }

            diff = (int) (diff + (diffOfRem) * Math.pow(10, power));
            power++;

        }
        return diff;
    }
}
