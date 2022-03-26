package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println(factorial(scn.nextInt()));
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
