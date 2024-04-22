package dsa.with.shagun.leetcode.PFD24.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPathInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end){
            return true;
        }

        //make adjacency list
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjacencyMap.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            adjacencyMap.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(start, end, adjacencyMap, visited);
    }

    private boolean dfs(int start, int end, Map<Integer, List<Integer>> graph, boolean[] visited){
        if(start == end){
            return true;
        }

        visited[start] = true; //mark current node as visited

        //call dfs for adjacent nodes to find the path
        for(Integer neighbor : graph.getOrDefault(start, new ArrayList<>()))
        {
            if(!visited[neighbor])
            { //check if neighbour is not present in the visited array we can iterate on it.
                if(dfs(neighbor, end, graph, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
