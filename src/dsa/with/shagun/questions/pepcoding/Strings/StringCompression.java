package dsa.with.shagun.questions.pepcoding.Strings;

import java.util.Scanner;

public class StringCompression {
    public static String compression1(String str) {
        String newStr = String.valueOf(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if (curr != prev) {
                newStr = newStr + curr;
            }
        }

        return newStr;
    }

    public static String compression2(String str) {
        String newStr = String.valueOf(str.charAt(0));
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr != prev) {
                if (count > 1) {
                    newStr += count;
                    count = 1;
                }
                newStr = newStr + curr;
            } else {
                count++;
            }
        }

        //for displaying count of last index
        if(count>1){
            newStr += count;
        }
        return newStr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}
