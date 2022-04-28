package dsa.with.shagun.leetcode.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) { //TC : O(m*n logm*n),SC : O(m*n)
        int m = heights.length;
        int n = heights[0].length;

        int[][] efforts = new int[m][n]; //To store efforts to move from one location to another
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);  // default value stored in efforts array
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // this will check efforts value and which return min effort
        efforts[0][0] = 0; //because first node will have zero effort

        pq.offer(new int[]{0, 0, 0}); // this is for first node

        //start BFS loop

        while (!pq.isEmpty()) {
            int[] head = pq.poll();
            int x = head[1];
            int y = head[2];
            int currentEffort = head[0];
            if (x == (m - 1) && y == (n - 1)) { // if it has reached end cell
                return currentEffort;
            }

            //Go in all directions and insert effort in pq
            int[] dir = new int[]{0, 1, 0, -1, 0};
            for (int k = 0; k < 4; k++) {
                int newX = x + dir[k];
                int newY = y + dir[k + 1];

                // Now we have new direction check if it is inside boundary
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));
                    if (newEffort < efforts[newX][newY]) {
                        efforts[newX][newY] = newEffort;
                        pq.offer(new int[]{newEffort, newX, newY});
                    }
                }
            }
        }
        return 0;
    }
}
