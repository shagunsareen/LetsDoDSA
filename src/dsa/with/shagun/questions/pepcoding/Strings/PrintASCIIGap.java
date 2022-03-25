package dsa.with.shagun.questions.pepcoding.Strings;

import java.util.Scanner;

public class PrintASCIIGap {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            char prev = str.charAt(i -1);
            int gap = c - prev;
            sb.append(gap);
            sb.append(c);
        }
        return sb.toString();  // SC : O(n) : for taking stringbuilder and then converting it to string
                              // TC : O(n) : for loop runs for n times and append to sb is of constant time i.e.O(1)
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
