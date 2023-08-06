package dsa.with.shagun.scaler.advance.StringPattern;

public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("abc"));
        System.out.println(solve("aa"));
        System.out.println(solve("aaaaa"));
        System.out.println(solve("banana"));
        System.out.println(solve("amoa"));
    }

    public static int solve(String A) {
        /*Approach 1: Two pointers , TC : O(N), SC:O(1)

        int left = 0;
        int size = A.length();
        int right = size - 1;
        int count = 0;

        boolean isMatched = false;
        while (left <= right) {
            if (A.charAt(left) != A.charAt(right)) {
                if (isMatched) {
                    left = 0;
                    isMatched = false;
                    count = size - 1 - right;
                    continue;
                }
                count++;
                right--;
            } else { // if they match then move pointers ahead
                left++;
                right--;
                isMatched = true;
            }
        }
        return count;
         */

        //approach : LPS array

        //Step1 : Concatenate string with special character and reverse of string
        StringBuilder strBldr = new StringBuilder();
        strBldr.append(A);
        strBldr.append("$");
        strBldr.append(new StringBuilder(A).reverse());

        //Step2 : Generate LPS array of the string
        int[] lps = new int[strBldr.length()];
        lps[0] = 0;

        char[] ch = strBldr.toString().toCharArray();
        for (int i = 1; i < strBldr.length(); i++) {
            int x = lps[i - 1];

            while (ch[i] != ch[x]) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }

            lps[i] = x + 1;
        }

        return A.length() - lps[strBldr.length() - 1];
    }
}
