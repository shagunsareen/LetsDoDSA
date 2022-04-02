package dsa.with.shagun.leetcode.TwoPointer;

public class ValidPalindromeTwo {  //TC : O(N) because we just check N/2 times as we have two pointers from each side.
    // Also, if we find indifferent characters then we just check ones of calling checkPalindrome condition.
    // Even if first and last characters are different, checkPalindrome would run for N/2 times. Hence, overall TC : O(N) and SC :O(1)

    public static void main(String[] args) {
        System.out.println(validPalindrome("abcxa"));
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) { //since when start == end that means it is a palindrome hence not including start==end
            if (s.charAt(start) != s.charAt(end)) {
                //Found a mismatched pair -- try both deletions
                return (checkPalindrome(s, start, end - 1) || checkPalindrome(s, start + 1, end));
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
