package dsa.with.shagun.scaler.advance.StringPattern;

public class RabinKarp2 {

    public static void main(String[] args) {
        System.out.println(solve("acbac", "ac"));
    }

    public static int solve(String A, String B) {
        //Step1 : Get hashcode of pattern to be matched i.e String 1
        long hash1 = 0;
        long hash2 = 0;
        int p = 31;
        int k = B.length();
        long mod = 1000 * 1000 * 1000 + 7;
        int count = 0;

        long[] pow = new long[A.length()];

        pow[0] = 1;
        for (int i = 1; i < A.length(); i++) {
            pow[i] = (pow[i - 1] * p) % mod;
        }

        //Step1 :Hash of B string
        for (int i = 0; i < k; i++) {
            long power = pow[i] % mod;
            hash1 = (hash1 + ((B.charAt(i) - 'a' + 1) * power % mod)) % mod;
        }

        //Step2 : Get hashcode of first subtring of String 2
        for (int j = 0; j < k; j++) {
            long power = pow[j] % mod;
            hash2 = (hash2 + ((A.charAt(j) - 'a' + 1) * power % mod)) % mod;  //ROLLING HASH
        }

        //Step3 : Compare string 1 with substring1 of string 2
        if (hash1 == hash2) {
            count++;
        }

        //Step4 : Now that we have hash of first substring we will use this to get hashcode of all other substrings and cmopare strings to increment count
        int i = 1;
        int j = B.length();

        while (j < A.length()) {
            long previousEle = (A.charAt(i - 1) - 'a' + 1) * pow[i - 1] % mod;
            long nextEle = (A.charAt(j) - 'a' + 1) * pow[j] % mod;
            hash2 = (((hash2 - previousEle) + nextEle + mod) % mod);

            //check if hashcode of substring and string1 is same then increment count
            if ((hash1 * pow[i]) % mod == hash2) {
                count++;
            }

            i++;
            j++;
        }

        return count;
    }


}
