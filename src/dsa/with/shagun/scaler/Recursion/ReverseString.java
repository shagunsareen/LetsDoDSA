package dsa.with.shagun.scaler.Recursion;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(reverse(0, str.length() - 1, str.toCharArray()));
    }

    private static String reverse(int start, int end, char[] ch) {
        if (start >= end) return String.valueOf(ch);
        swap(start, end, ch);
        return reverse(start + 1, end - 1, ch);
    }

    private static void swap(int start, int end, char[] ch) {
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
    }
}
