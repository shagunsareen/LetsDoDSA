package dsa.with.shagun.leetcode.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {

        // adjacency map
        for (int[] time : times) {
            // check if any entry exists for the current node in adj map. If not first create hashmap then insert src, destination nodes and values
            adj.putIfAbsent(time[0], new HashMap<>()); // This will insert currNode and create hashmap as value
            adj.get(time[0]).put(time[1], time[2]);   //Insert destination node and time required to travel to the dest from src
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); //to get shortest distance node
        pq.add(new int[]{k, 0}); //to initialise root node with distance zero

        boolean[] visited = new boolean[n + 1]; // to track whether elements are visited or not
        int res = 0;

        while (!pq.isEmpty()) {
            int[] rv = pq.remove();
            int currNode = rv[0];
            int time = rv[1];

            if (visited[currNode]) {  // skip if currentNode is already visited
                continue;
            }
            visited[currNode] = true; // mark currentNode as visited
            res = time;
            n--;
            if (n == 0) return res;


            // traverse child nodes
            if (adj.containsKey(currNode)) {
                for (int child : adj.get(currNode).keySet()) {
                    pq.add(new int[]{child, adj.get(currNode).get(child)}); //add child node to priority queue
                }
            }
        }
        return -1;
    }
}
