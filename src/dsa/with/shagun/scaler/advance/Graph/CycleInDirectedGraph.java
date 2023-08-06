package dsa.with.shagun.scaler.advance.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleInDirectedGraph {
    boolean isCycle = false;

    public int solve(int A, int[][] B) {

        //For DFS, we need adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0; i<=A; i++){
            //every node will have 1 list consisting of it's neighbours
            adjacencyList.add(new ArrayList());
        }

        for(int i=0; i<B.length; i++){
            //add the neighbours for each node
            adjacencyList.get(B[i][0]).add(B[i][1]);
        }

        //we need visited array
        int[] visited = new int[A+1];
        Arrays.fill(visited, 0);

        for(int i=1; i<adjacencyList.size();i++){
            if(visited[i]==0){
                isCycle = dfs(i, adjacencyList, visited);
                if(isCycle) break;
            }
        }
        return isCycle ? 1 : 0;
    }

    private boolean dfs(int node, List<List<Integer>> adjacencyList , int[] visited){

        //mark current node as visited
        visited[node] = 1;

        //check for neighbours and process them
        for(int i=0; i<adjacencyList.get(node).size(); i++){
            int neigh = adjacencyList.get(node).get(i);

            //if neighbour node is not visited then perform dfs
            if(visited[neigh] == 0){
                dfs(neigh, adjacencyList, visited);
            }else if(visited[neigh] == 1){
                // means already neighbour node was in processing and current node is also processing hence and we reach neighbouring node again meaning cycle is present
                isCycle = true;
            }
        }

        //mark node as complete once all it's neighbours are processed and no more processing is required
        visited[node] = 2;
        return isCycle;
    }
}
