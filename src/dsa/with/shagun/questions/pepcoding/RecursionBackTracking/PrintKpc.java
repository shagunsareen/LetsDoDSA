package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintKpc {

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str, "");
    }

    public static void printKPC(String str, String asf) {
        //Base condition
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        String firstStr = codes[ch - '0'];
        for (char ele : firstStr.toCharArray()) {
            printKPC(ros, asf + ele);
        }
    }

}
