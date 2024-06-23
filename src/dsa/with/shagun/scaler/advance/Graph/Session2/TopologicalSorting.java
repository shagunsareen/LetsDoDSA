package dsa.with.shagun.scaler.advance.Graph.Session2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSorting {
    public int[] solve(int A, int[][] B) {
        //Step 1 : get the indegree of all the nodes
        //Step 2 : pick the node with 0 indegree to start with , push that node to the queue,
        //Step 3 : Pop the nodes from the queue and reduce indgree of neighbours by 1. If indegree of any neighbour becomes 0, push it to the queue.
        //do it till the queue is empty
        //Step 4 : if no. of nodes in ordering == no. of nodes in total then topological sorting is possible

        int[] indegree = new int[A+1];
        int[] res = new int[A];
        List<List<Integer>> adjacencyList = new ArrayList<>();

        //we will have lists as the number of nodes
        for(int i=0; i<=A; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int i=0; i<B.length; i++){
            adjacencyList.get(B[i][0]).add(B[i][1]);
            indegree[B[i][1]]++; //this stores indegree of destination node since node is coming from B[i][0] to B[i][1]
        }

        Queue<Integer> queue = new PriorityQueue<>();
        //now check which nodes indegree is 0
        for(int i=1; i<indegree.length; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }

        //if there is no node with 0 indegree then return empty array
        if(queue.isEmpty())
            return new int[]{};

        int index = 0;
        //if there is something in the queue lets process it
        while(!queue.isEmpty()){
            int node = queue.poll();
            res[index] = node; //first node to get printed
            index++;

            //get the neighbours, reduce the indegree and push if indegree reaches 0
            List<Integer> adjList = adjacencyList.get(node);
            for(int neighbour : adjList){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        return res;
    }

}
