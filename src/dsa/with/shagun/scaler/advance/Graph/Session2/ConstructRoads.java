package dsa.with.shagun.scaler.advance.Graph.Session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructRoads {
    //Consider the country as bipartite graph and then just get the set of cities and see the max roads that can be
    //between 2 cities
    public int solve(int A, int[][] B) {

        //City is bipartite , given are n-1 roads, if we know how many elements are in each set of a city we can calculate total nodes possible from set 1 to set 2
        //to divide the country into 2 sets we will have to color it with 2 colors
        // one set will become with color 0 and anoother set will become with elements with color 1
        //then we can iterate on how many nodes are in set one and set two and we can check max. nodes possible from there

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            adjacencyList.get(B[i][0]).add(B[i][1]);
            adjacencyList.get(B[i][1]).add(B[i][0]);  //since this is undirected graph hence we have to put edge from both ends
        }

        int[] colored = new int[A + 1];
        Arrays.fill(colored, -1);

        //color the 2 sets of cities
        for (int i = 1; i <= A; i++) {
            if (colored[i] == -1) { //node is not colored yet
                dfsToColor(i, 0, adjacencyList, colored);
            }
        }

        //get the count of nodes in set 1 and set 2
        int set1Count = 0;
        int set2Count = 0;
        for (int i : colored) {
            if (i == 0) {
                set1Count++;
            } else if (i == 1) {
                set2Count++;
            }
        }

        long m = 1000000007;
        long totalRoads = ((set1Count % m) * (set2Count % m)) % m;
        return (int) (totalRoads - (A - 1));
    }

    private void dfsToColor(int node, int color, List<List<Integer>> adjacencyList, int[] colored) {
        //color the current road
        colored[node] = color;

        //check the neighbouring roads and color those if not colored already
        for (int adjacentRoad : adjacencyList.get(node)) {
            if (colored[adjacentRoad] == -1) {
                dfsToColor(adjacentRoad, 1 - color, adjacencyList, colored);
            }
        }
    }
}

