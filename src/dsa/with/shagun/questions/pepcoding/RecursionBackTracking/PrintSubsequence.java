package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintSubsequence {  //TC : O(2^n) , SC:O(1) but for every stage at present only (n+1) levels are covered hence n*(n+1) chars instead of 2^(n-1) * n
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSS(str, "");
    }

    public static void printSS(String str, String ans) {
        //Base condition
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String roq = str.substring(1);

        printSS(roq, ans+ch);
        printSS(roq, ans+"");
    }

}
