package dsa.with.shagun.questions.pepcoding.Strings;

import java.util.Scanner;

public class PalindromeSubstrings {
    public static void solution(String str) {
        //find all substrings
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String ss = str.substring(i, j);
                if(isPalindrome(ss)){
                    System.out.println(ss);
                }
            }
        }
    }

    public static boolean isPalindrome(String str) {
        //find palindromic substrings
        int i = 0;
        int j = str.length() - 1;
        while(i<=j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}
