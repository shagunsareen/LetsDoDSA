package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintEncodings {  // TC : O(2n) SC : O(n)

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chCode = ch - '0';
                char code = (char) ('a' + chCode - 1); // since 1 --> a , 2-->b hence whatever int digit we add it will be +1 but we want to add value to 'a' hence a+6 should be 'f'which means we need to subtract 1 from final thing
                System.out.println(asf + code);
            }
        } else { //pick one digit and evaluate that and pick other combinations as well
            char ch = str.charAt(0);
            String roq = str.substring(1);
            if (ch == '0') {
                return;
            } else {
                int chCode = ch - '0';
                char code = (char) ('a' + chCode - 1);
                printEncodings(roq, asf + code);
            }
            //this is when the length of rest of string/ques is 2 or more
            String ch12 = str.substring(0, 2);
            String roq12 = str.substring(2);

            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncodings(roq12, asf + code);
            }
        }
    }
}
