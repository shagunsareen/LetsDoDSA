package dsa.with.shagun.scaler.advance.StringPattern;

public class CyclicPermutations {
    public static void main(String[] args) {
        System.out.println(solve("1001", "0011"));
        System.out.println(solve("111", "111"));
    }

    public static int solve(String A, String B) {

        //We will try to apply The Longest Prefix which is also suffix to find how many times pattern occurs in text
        StringBuilder str = new StringBuilder();
        str.append(A);
        str.append("$");
        str.append(B + B);

        //Create LPS array for this
        char[] ch = str.toString().toCharArray();
        int[] lps = new int[str.length()];

        lps[0] = 0;
        for (int i = 1; i < str.length(); i++) {
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
        int res = 0;
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == A.length()) {
                //&& i > 2 * A.length()) {
                res++;
            }
        }

        if ((A.equals(B))) {
            return --res;
        }
        return res;
    }
}
