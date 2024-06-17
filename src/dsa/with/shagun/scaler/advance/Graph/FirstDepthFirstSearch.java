package dsa.with.shagun.scaler.advance.Graph;

import java.util.ArrayList;
import java.util.List;

public class FirstDepthFirstSearch {
    public int solve(int[] A, final int B, final int C) {
        if (B == C)
            return 1;

        //we have to traverse the graph but before that we have to create an adjacency matrix
        //since nodes are from 1 to N lets discard 0th index entry in the A array
        //node goes from Ai to i+1 hence put Ai in adjacency list and create a list for the adjacent nodes

        List<List<Integer>> adjacencyList = new ArrayList<>();
        int n = A.length;

        //since B and C lie in  1 to N (inclusive) hence we have to create empty list to avoid array out of bound exception
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //add the nodes from Ai to i+1
        for (int i = 1; i < n; i++) {
            adjacencyList.get(A[i]).add(i + 1);
        }

        //now we have the graph , now we can traverse it using dfs
        return dfs(C, B, adjacencyList, n) ? 1 : 0;
    }

    private boolean dfs(int source, int destination, List<List<Integer>> adjacencyList, int size) {
        //check if the source has reached destination or NOT
        if (source == destination) {
            return true;
        }

        //get the neighbouring nodes
        List<Integer> adjacentNodesList = adjacencyList.get(source);
        for (int adjacentNodes : adjacentNodesList) {
            if (dfs(adjacentNodes, destination, adjacencyList, size)) {
                return true;
            }
        }
        return false;
    }
}