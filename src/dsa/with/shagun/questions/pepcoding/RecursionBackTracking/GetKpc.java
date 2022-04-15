package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKpc { //TC : O(N) ,SC :O(1)
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(getKPC(str));
    }

    public static ArrayList<String> getKPC(String str) {
        //Base condition
        if (str.length() == 0) {
            ArrayList<String> blank = new ArrayList<>();
            blank.add("");
            return blank;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        String firstStr = codes[ch - '0'];
        ArrayList<String> list = getKPC(ros); //return all combinations till last character entered by user except first

        ArrayList<String> res = new ArrayList<>();
        for (char ele : firstStr.toCharArray()) {
            for (String laterCombinations : list) {
                res.add(ele + laterCombinations);  //combine first digits characters to rest of the combinations to get the result
            }
        }
        return res;
    }

}
