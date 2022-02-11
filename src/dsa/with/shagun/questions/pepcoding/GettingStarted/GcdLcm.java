package dsa.with.shagun.questions.pepcoding.GettingStarted;

import java.util.Scanner;

public class GcdLcm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();

        int onum1 = num1;
        int onum2 = num2;

        while(num1 % num2!=0){
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        System.out.println(num2);
        int lcm = (onum1 * onum2) / num2;
        System.out.println(lcm);
    }
}
