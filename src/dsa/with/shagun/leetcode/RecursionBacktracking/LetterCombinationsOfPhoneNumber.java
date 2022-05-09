package dsa.with.shagun.leetcode.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfPhoneNumber {
    static String[] codes = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        letterCombinations(str);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        helper(digits, ans, "");
        return ans;
    }

    private static void helper(String digits, List<String> ans, String currentString) {
        if(digits.length()==0){
            ans.add(currentString);
            System.out.println(currentString);
            return;
        }
        char ch = digits.charAt(0);
        String ros = digits.substring(1);

        String firstStr = codes[ch - '0'];
        for (char c : firstStr.toCharArray()) {
            helper(ros, ans, currentString + c);
        }
    }
}
