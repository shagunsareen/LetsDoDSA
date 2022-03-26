package dsa.with.shagun.questions.pepcoding.Strings;

import java.util.Scanner;

public class PermutationsOfString {
    public static void solution(String str) {
        int n = str.length();
        int f = factorial(n);
        for (int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for (int div = n; div >= 1; div--) {
                int remainder = temp % div;
                int quotient = temp / div;

                System.out.print(sb.charAt(remainder));
                sb.deleteCharAt(remainder);

                temp = quotient;
            }
            System.out.println("");
        }
    }

    private static int factorial(int length) {
        int fact = 1;
        for (int i = 2; i <= length; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }
}
