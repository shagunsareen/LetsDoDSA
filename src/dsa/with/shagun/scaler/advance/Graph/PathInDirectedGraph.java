package dsa.with.shagun.scaler.advance.Graph;

import java.util.ArrayList;
import java.util.List;

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {

        //For DFS,we first need to have an adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0; i<=A; i++){
            //every node will have 1 list corresponding to it's neighbours
            adjacencyList.add(new ArrayList<>());
        }

        //now fill the adjacencyList with neighbours for each node
        for(int i=0; i<B.length; i++){
            adjacencyList.get(B[i][0]).add(B[i][1]);
        }

        int[] visited = new int[A+1];

        //once we have adjacency list now we can start DFS
        dfs(1,adjacencyList, visited, A);
        return (visited[A] == 1) ? 1:0;
    }

    private void dfs(int node, List<List<Integer>> adjacencyList, int[] visited, int A){

        visited[node] = 1;

        //traverse all neighbours of current node
        for(int i=0; i<adjacencyList.get(node).size(); i++){
            int neigh = adjacencyList.get(node).get(i);
            if(visited[neigh] != 1){
                dfs(neigh, adjacencyList, visited,A);
            }
        }
    }
}
