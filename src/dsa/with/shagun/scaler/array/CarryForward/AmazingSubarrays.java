package dsa.with.shagun.scaler.array.CarryForward;

import java.util.HashSet;

public class AmazingSubarrays {
    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }
    public static int solve(String A) {

        // System.out.println(A.length());

        if (A.length() == 0) {
            return 0;
        }

        int count = 0;

        //Store vowels in a hashset
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        //We can skip step of storing vowels in hashset and have if conditions instead

        /*if (A.charAt(i) == 'A' || A.charAt(i) == 'E' || A.charAt(i) == 'I' || A.charAt(i) == 'O'
                || A.charAt(i) == 'U' || A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i'
                || A.charAt(i) == 'o' || A.charAt(i) == 'u') */

        //if the curr ele is vowel then get no. of ele on right which gives subarrays starting with vowel i.e. (n-i)
        for (int i = 0; i < A.length(); i++) {
            if (set.contains(A.charAt(i))) {
                count = (count + A.length() - i)%10003;
            }
        }
        return count%10003;
    }
}
