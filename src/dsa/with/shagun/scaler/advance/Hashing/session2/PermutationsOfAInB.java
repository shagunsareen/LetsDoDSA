package dsa.with.shagun.scaler.advance.Hashing.session2;

public class PermutationsOfAInB {
    public static void main(String[] args) {
        String A = "abc";
        String B = "abcbacabc";
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {

        //Step1 : Get frequency of pattern to be matched since it's a one time activity
        int[] freqA = new int[26]; //size is 26 since chars at max can be 26 so we don't have to take hashmap .We should take hashmap for large values
        int[] freqB = new int[26];

        for (int i = 0; i < A.length(); i++) {
            freqA[A.charAt(i) - 'a']++;  // storing freq of each char in A
        }

        //Step2 : Get frequency of first substring of B
        for (int i = 0; i < A.length(); i++) {
            freqB[B.charAt(i) - 'a']++; // storing freq of each char of 1st substring of B
        }

        int count = 0;
        //Step3 : Compare pattern A with first substring of B to check if it has freq of all chars as same
        if (compare(freqA, freqB)) {
            count++;
        }

        //Step4 : From first substring freq get frequency of all later substrings
        int j = 1;
        int k = A.length() - 1; // consider the length of the pattern to be matched

        while (j < B.length() - k) {
            freqB[B.charAt(j - 1) - 'a']--;
            freqB[B.charAt(j + k) - 'a']++;
            j++;
            if (compare(freqA, freqB)) {
                count++;
            }
        }
        return count;
    }

    public static boolean compare(int[] freqA, int[] freqB) {
        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) {
                return false;
            }
        }
        return true;
    }
}
