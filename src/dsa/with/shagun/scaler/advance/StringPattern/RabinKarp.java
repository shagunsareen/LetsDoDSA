package dsa.with.shagun.scaler.advance.StringPattern;

/* Given two string A and B of length N and M respectively consisting of lowercase letters.
   Find the number of occurrences of B in A.
 */
public class RabinKarp {
    public static void main(String[] args) {
        //System.out.println(solve("acbac", "ac"));
        System.out.println(solve("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ""));
    }

    //my solution which was failing for long aaaaa test case
    public static int solve(String A, String B) {

        //Approach 1 : Check length of B , suppose it's 'P', then compare with every substring of length 'P' of A string.
        // Increment count wherever both strings match.
        // TC : O(N*P) where P is length of pattern to be matched and N is no. of times we are comparing substrings with B

        //Approach 2: We should not compare every substring as comparing strings is expensive as compared to comparing integers
        //Integer comparison takes O(1) whereas string comparison takes O(N). Hence we are converting every substring to hashcode and then we will compare hashcodes
        // Here we will use "RABIN KARP ALGO" to get hashcode of strings

        //Step1 : Get hashcode of pattern to be matched i.e String 1
        long hash1 = 0;
        long hash2 = 0;
        int p = 26;
        int k = B.length();
        long mod = 1000 * 1000 * 1000 + 7;
        int count = 0;

        for (int i = 0; i < k; i++) {
            long power = (long) (Math.pow(p, k - i - 1) % mod);
            hash1 = (hash1 + ((B.charAt(i) - 'a' + 1) * (power))) % mod;
        }

        //Step2 : Get hashcode of first subtring of String 2
        for (int j = 0; j < k; j++) {
            long power = (long) (Math.pow(p, k - j - 1) % mod);
            hash2 = (hash2 + ((A.charAt(j) - 'a' + 1) * (power))) % mod;  //ROLLING HASH
        }

        //Step3 : Compare string 1 with substring1 of string 2
        if (hash1 == hash2) {
            count++;
        }

        //Step4 : Now that we have hash of first substring we will use this to get hashcode of all other substrings and cmopare strings to increment count
        int i = 1;
        int j = B.length();

        while (j < A.length()) {
            long previousEle = (long) ((A.charAt(i - 1) - 'a' + 1) * (Math.pow(p, k - 1) % mod));
            long nextEle = (long) ((A.charAt(j) - 'a' + 1) * (Math.pow(p, 0) % mod));
            hash2 = (((hash2 - previousEle) * p + nextEle) % mod);

            //check if hashcode of substring and string1 is same then increment count
            if (hash1 == hash2) {
                count++;
            }

            i++;
            j++;
        }

        return count;
    }
}
