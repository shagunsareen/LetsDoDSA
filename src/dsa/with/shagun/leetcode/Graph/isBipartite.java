package dsa.with.shagun.leetcode.Graph;

public class isBipartite {
    boolean[] vis;
    int[] col;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        vis = new boolean[n];
        col = new int[n];

        for (int i = 0; i < n; i++) {
            if(!vis[i] && !bipartite(graph, i, 0)){
                return false;
            }
        }
        return true;
    }

    private boolean bipartite(int[][] graph, int i, int color) {
        vis[i] = true;
        col[i] = color;

        //traverse child nodes
        for(int child : graph[i]){ //graph[i] has all children nodes
            if(!vis[child]){ // if child node is not visited
                if(!bipartite(graph,child,color^1)){  //here we are performing XOR operation
                    return false;
                }
            }else if(col[i] == col[child]){
                return false;
            }
        }
        return true;
    }
}
