package dsa.with.shagun.scaler.advance.Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInUndirectedGraph {
    public int solve(int A, int[][] B) {
        //To find a cycle we have to traverse the entire graph and to traverse we need adjacencyList
        List<List<Integer>> adjacencyList = new ArrayList<>();

        //let's create adjacency list first
        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //now lets insert neighbouring nodes to the adjacency list
        for (int[] ints : B) {
            adjacencyList.get(ints[0]).add(ints[1]);
        }

        int[] visited = new int[A + 1]; //if A=5 we have to mark visited[5] as 1
        //now we have all the information lets traverse the graph to check whether the cycle is present or not

        //since there can be different connected components we have to apply dfs for every node
        for (int i = 1; i < adjacencyList.size(); i++) {
            //we don't have to run dfs for every node since there will be nodes which will get visited as part of previous traversals
            //check if node is already visited or not
            if (visited[i] != 1) {
                if (dfs(i, -1, visited, adjacencyList)) {
                    return 1; // cycle exists
                }
            }
        }
        return 0; //cycle doesn't exist
    }

    private boolean dfs(int node, int parent, int[] visited, List<List<Integer>> adjacencyList) {
        visited[node] = 1; //mark the node as visited
        //get the adjacent nodes for the current node
        for (int adjacentNode : adjacencyList.get(node)) {
            if (visited[adjacentNode] != 1) {
                //if the node is not visited then call dfs traversal
                if (dfs(adjacentNode, node, visited, adjacencyList))
                    return true;
            } else if (adjacentNode != parent) {
                //here it will come only if node is already visited meaning it was already in process
                //but we have to check whether the visited node is not the parent or the previous node
                return true;
            }
        }
        return false;
    }
}
