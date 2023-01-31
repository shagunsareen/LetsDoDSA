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
        int left = 0;
        int size = A.length();
        int right = size - 1;
        int count = 0;
        /*while (left < right) {
            if (A.charAt(left) != A.charAt(right)) {
                count = A.length()-1;
                return count;
            } else {
                left++;
                right--;
            }
        }
        if (left == right && A.charAt(left) != A.charAt(left - 1)) {
            count++;
        }*/
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
    }
}
