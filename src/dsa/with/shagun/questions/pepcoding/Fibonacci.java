package dsa.with.shagun.questions.pepcoding;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int first  =  0;
        int second =  1;
        System.out.println(first);
        System.out.println(second);
        int result;
        for (int i = 3; i<=num ; i++){
            result = first + second;
            System.out.println(result);
            first = second;
            second = result;
        }
    }
}
