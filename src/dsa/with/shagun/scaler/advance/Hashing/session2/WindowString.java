package dsa.with.shagun.scaler.advance.Hashing.session2;

/*
* Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
Note:If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )

Problem Constraints
1 <= size(A), size(B) <= 106

Input Format
The first argument is a string A.
The second argument is a string B.

Output Format
Return a string denoting the minimum window.

Example Input
Input 1:
A = "ADOBECODEBANC"
B = "ABC"

* Input 2:
A = "Aa91b"
B = "ab"

* Example Output
Output 1: "BANC"
Output 2: "a91b"

* Example Explanation
Explanation 1: "BANC" is a substring of A which contains all characters of B.
Explanation 2: "a91b" is the substring of A which contains all characters of B.
*
* */
public class WindowString {
    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        System.out.println(minWindow(A, B));
    }

    public static String minWindow(String A, String B) {
        int[] freqB = new int[128];  // since size of the ASCII values goes till 127
        int[] freqA = new int[128];
        int l = 0;
        int r = 0;
        int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;

        //Step1 : Get frequency array of B
        for (int i = 0; i < B.length(); i++) {
            freqB[B.charAt(i)]++;
        }

        //Step2 : Traverse the whole array A and compare frequency arrayA with that of B if it matches then shrink window else expand window
        //Store minLength, minStart, minEnd index once freqA matches freqB

        while (l < A.length()) {
            //now compare freqA and freqB
            if (compare(freqA, freqB)) {
                // if it is true, get min Length and minstart and minEnd index
                int length = r - l + 1;
                if (length < minLength) {
                    minLength = length;
                    minL = l;
                    minR = r;
                }
                //shrink window since we need to get minLength
                freqA[A.charAt(l)]--;
                l++;
            } else {
                if (r >= A.length()) {
                    break;
                }
                freqA[A.charAt(r)]++;
                r++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : A.substring(minL, minR);
    }

    private static boolean compare(int[] freqA, int[] freqB) {
        for (int i = 0; i < 128; i++) {
            if (freqA[i] < freqB[i]) { // when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
                return false;
            }
        }
        return true;
    }
}
