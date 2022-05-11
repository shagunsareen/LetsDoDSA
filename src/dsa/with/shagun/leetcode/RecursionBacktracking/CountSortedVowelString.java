package dsa.with.shagun.leetcode.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelString {
    /* Approach 1 : using backtracking TC : O(5^N) because we need to make string of length N and at each level we have 5 options to select char. Hence this is quite time consuming

    List<String> list;
    char[] ch = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
        list = new ArrayList<>();
        solve(n, 0, new StringBuilder());
        return list.size();
    }

    private void solve(int n, int startIndex, StringBuilder sb) {
        //Base condition
        if (n == 0) {
            list.add(sb.toString());
            return;
        }

        for (int i = startIndex; i < 5; i++) {
            sb.append(ch[i]); // pick one element
            solve(n-1, i, sb);  // recursive function to get other elements
            sb.deleteCharAt(sb.length()-1); //Backtracking step
        }
    }*/

    //Approach 2: Dynamic Programming  , TC : O(nk) because for loop will run for n times for k elements, SC : O(k)
    public static int countVowelStrings(int n) {
        int[] dp = new int[] {0, 1, 1, 1, 1, 1};
        for (int i = 1; i <= n; ++i)
            for (int k = 1; k <= 5; ++k)
                dp[k] += dp[k - 1];
        return dp[5];
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(3));
    }

}
