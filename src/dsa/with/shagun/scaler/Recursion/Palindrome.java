package dsa.with.shagun.scaler.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(solve("naman"));
        System.out.println(solve("strings"));
    }
    public static int solve(String A) {
        return palindrome(A, 0, A.length() - 1);
    }

    // 1 means palindrome,0 means not palindrome
    private static int palindrome(String A, int start, int end) {
        if (start > end) return 1;

        if (A.charAt(start) == A.charAt(end)) {
            if (palindrome(A, start + 1, end - 1) == 1)
                return 1;
        } else {
            return 0;
        }
        return 0;
    }
}
