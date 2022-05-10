package dsa.with.shagun.leetcode.RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    //Time Complexity: Recursion depth is k and at each level, we have 9 digits to choose from O(k * 9^k)
    //Space Complexity: Ignoring the result array, we used ArrayList of size k to store intermediate state O(k)
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        solve(k, n, 0, ans, subList,1);
        return ans;
    }

    private void solve(int k, int n, int sumSoFar, List<List<Integer>> ans, List<Integer> subList, int start) {
        if (sumSoFar == n && k == 0) {
            ans.add(new ArrayList<>(subList));
            return;
        }

        if (sumSoFar > n) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            subList.add(i);
            solve(k - 1, n, sumSoFar + i, ans, subList, i+1);
            subList.remove(subList.size()-1);
        }
    }
}
