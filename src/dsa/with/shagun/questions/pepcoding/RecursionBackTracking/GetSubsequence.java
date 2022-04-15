package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {  //TC : O(n) ,SC : O(1)
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        //Base condition
        if (str.length() == 0) {
            ArrayList<String> blank = new ArrayList<>();
            blank.add("");
            return blank;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> list = gss(ros);

        ArrayList<String> subRes = new ArrayList<>();
        for (String ele : list) {
            subRes.add("" + ele);
        }
        for (String ele : list) {
            subRes.add(ch + ele);
        }
        return subRes;
    }
}
