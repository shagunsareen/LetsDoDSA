package dsa.with.shagun.scaler.advance.StringPattern;

import java.util.Arrays;
import java.util.Collections;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(solve("hello world"));
    }

    public static String solve(String A) {

        //approach 1: split and store
        //TC : O(N+N), SC:O(N)
        String[] words = A.split(" ");
        String res = "";
        String res2 = "";
        for (int i = words.length - 1; i >= 0; i--) {
            res += words[i] + " ";
        }

        //return res;

        //approach 2 : split and join
        String[] words2 = A.trim().split(" ");  // TC : O(N), SC : O(N)
        Collections.reverse(Arrays.asList(words2));
        res2 = String.join(" ", words2);

        //return res2;

        //approach 3 : java streams
        /*return Arrays.stream(A.split(" "))
                .map(String::trim)
                .filter(word -> !word.isEmpty())
                .reduce((word1, word2) -> word2 + " "+ word1)
                .orElse("");
         */

        //approach 4 : two pointers
        String[] words3 = A.trim().split("\\s");
        int i = 0;
        int j = words3.length - 1;
        while (i <= j) {
            String temp = words3[i];
            words3[i] = words3[j];
            words3[j] = temp;

            i++;
            j--;
        }

        //return String.join(" ", words3);  // join should not be used as it takes more time


        //approach --- two pointers ,TC: O(N),SC:O(N)
        StringBuilder result = new StringBuilder();
        int left = A.length() - 1;
        while (left >= 0) {

            //traverse from right to left since it skips one iteration over whole string
            while (left >= 0 && A.charAt(left) == ' ') {
                left--;
            }

            int right = left; // this is end of the word

            // Decreasing left until we find space
            while (left >= 0 && A.charAt(left) != ' ') {
                left--;
            }

            //Append the word
            if (result.length() == 0) {
                //if it's first word we don't need space before that
                result.append(A.substring(left + 1, right + 1));
            } else {
                result.append(" " + A.substring(left + 1, right + 1));
            }
        }
        return result.toString();
    }
}
