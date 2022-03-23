package dsa.with.shagun.leetcode.String;

import java.util.Arrays;

public class SmallestString {
    public static void main(String[] args) {
        System.out.println(getSmallestString(5, 73));
    }

    public static String getSmallestString(int n, int k) {
        char[] ans = new char[n];

        //This is one way
        Arrays.fill(ans, 'a');
        k = k-n;

        while (k>0){
            ans[--n] += Math.min(25,k);
            k -= Math.min(25,k);
        }


        //This is another way
        /*for (int i = 0; i < n; i++) {
            ans[i] = 'a';
        }
        k = k - n;

        int j = n - 1;
        while (k > 0) {
            if (k > 25) {
                ans[j] = 'z';
                k = k - 25;
            } else {
                ans[j] = (char)('a' + k);
                k = 0;
            }
            j--;
        }*/

        return String.valueOf(ans);

    }
}
