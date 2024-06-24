package dsa.with.shagun.scaler.advance.Graph.Session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
    public int solve(int A, int[][] B) {
        //a graph is a bipartite graph when it is divided into 2 sections and both sections nodes are not connected among themselves
        // also bipartite graph can be colored in exactly 2 colors, so we will check if we can color a graph in exactly 2 colors or not

        //Create adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0; i<A; i++){
            adjacencyList.add(new ArrayList<>());
        }

        //put the nodes in the list of every node
        for(int i=0; i<B.length; i++){
            adjacencyList.get(B[i][0]).add(B[i][1]);
            adjacencyList.get(B[i][1]).add(B[i][0]);
        }

        int[] visited = new int[A]; //this will be visited as well as the array to tell which color is put in this

        //put an initial value to the array
        Arrays.fill(visited, -1);

        //run for each node as start because there can be connected components
        for(int i=0; i<A; i++){
            if(visited[i] == -1){
                //it is not visited and not marked then process it
                if(!isBipartite(i, 0, adjacencyList, visited)){
                    return 0; // all nodes have been colored differently then graph is bipartite
                }
            }
        }
        return 1;
    }

    private boolean isBipartite(int node, int color, List<List<Integer>> adjacencyList, int[] visited){
        //color the current node
        visited[node] = color;

        //check for neighbours and color them if not visited
        for(int adjacentNode : adjacencyList.get(node)){

            //before checking if the node is visited check if the color is same as that of node
            if(visited[adjacentNode] == visited[node]){
                return false;
            }

            //not visited
            if(visited[adjacentNode] == -1){
                //color the neighbouring nodes
                if(!isBipartite(adjacentNode, 1 - color, adjacencyList, visited)){
                    return false;
                }
            }
        }
        return true;
    }
}
