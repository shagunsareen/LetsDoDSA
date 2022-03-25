package dsa.with.shagun.questions.pepcoding.Strings;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

    private static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c > 'a' && c < 'z') {
                char uc = (char) ('A' + c - 'a');
                sb.setCharAt(i, uc);
            } else if (c > 'A' && c < 'Z') {
                char lc = (char) ('a' + c - 'A');
                sb.setCharAt(i, lc);
            }
        }
        return sb.toString();
    }
}
