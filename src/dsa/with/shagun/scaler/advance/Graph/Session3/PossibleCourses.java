package dsa.with.shagun.scaler.advance.Graph.Session3;

import java.util.ArrayList;
import java.util.List;

public class PossibleCourses {

    public int solve(int A, int[] B, int[] C) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        //there are N courses so we need N lists for N nodes
        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //add the neighbours in the list
        for (int i = 0; i < B.length; i++) {
            adjacencyList.get(B[i]).add(C[i]);
        }

        //now that we have nodes info in the list lets check if this is visited or not
        int[] visited = new int[A + 1];

        //we can have connected components differently , so we will have to apply dfs multiple times
        for (int i = 1; i <= A; i++) {
            if (visited[i] != 1) {
                if (dfs(i, adjacencyList, visited)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    //check if there is a cycle in the graph or not , if cycle is present then all courses can't be complete
    private boolean dfs(int node, List<List<Integer>> adjacencyList, int[] visited) {
        visited[node] = 1;

        for (int adjacentNode : adjacencyList.get(node)) {
            if (visited[adjacentNode] != 1) {
                if (dfs(adjacentNode, adjacencyList, visited)) {
                    return true;
                }
            } else if (visited[node] == 1) {
                //cycle is detected
                return true;
            }
        }
        visited[node] = 2; //mark this as unvisited for the current iteration so that if we have one iteration as 1->2->4 and other 1->5->6
        //then it should not count it as a cycle since 4 we have reached from different iterations
        return false;
    }
}
