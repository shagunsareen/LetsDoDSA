package dsa.with.shagun.leetcode.PriorityQueue;

import java.util.Objects;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix {
    //SC : O(k)
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        kWeakestRows(arr, 3);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        // TC: m*log(k) where m is each row to keep k elements
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{soldiersCount(mat[i]), i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (k > 0)
            ans[--k] = Objects.requireNonNull(pq.poll())[1];

        return ans;
    }

    // TC : O(log(n)) But to traverse each row to get the count multiply it by num of rows i.e. m*log(n)
    private static int soldiersCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
