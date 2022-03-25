package dsa.with.shagun.leetcode.TwoDArray;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int cost = 0;
        int n = costs.length;

        for (int i = 0; i < n / 2; i++) {
            cost += costs[i][0];
        }
        for (int i = n / 2; i < n; i++) {
            cost += costs[i][1];
        }
        return cost;
    }
}
