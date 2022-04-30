package dsa.with.shagun.leetcode.Graph;

import java.util.*;

public class EvaluateDivision {
    class Solution {
        class Node {
            String dest;
            double val;

            public Node(String dest, double value) {
                this.dest = dest;
                this.val = value;
            }
        }

        Map<String, List<Node>> graph;

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            graph = new HashMap<>();

            //Build graph as no. of equations given we have to make graph using their values
            for (int i = 0; i < values.length; i++) {
                String src = equations.get(i).get(0);
                String dest = equations.get(i).get(1);  // get src and destination from equations
                graph.putIfAbsent(src, new ArrayList<>());  // check if we have values list for src and dest
                graph.putIfAbsent(dest, new ArrayList<>());
                graph.get(src).add(new Node(dest, values[i])); // add values from src to dest
                graph.get(dest).add(new Node(src, 1/values[i])); // add values from des to src
            }

            //perform DFS over queries to find answers
            int n = queries.size();

            double[] ans = new double[n];  // Ans array to return values of queries

            for (int i = 0; i < n; i++) {  // for all queries perform dfs
                ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet());
            }
            return ans;
        }

        private double dfs(String src, String dest, Set<String> set) {
            if (!graph.containsKey(src) || !graph.containsKey(dest)) { // if src or dest is not present then return -1.0
                return -1.0;
            }
            if (src.equals(dest)) { // If src or dest is equal then return 1.0
                return 1.0;
            }
            set.add(src);  // make src as visited

            //Traverse child nodes
            for (Node child : graph.get(src)) {
                if (!set.contains(child.dest)) { // if child is not visited then further do dfs
                    double ans = dfs(child.dest, dest, set);
                    if (ans != -1.0) {
                        return ans * child.val;
                    }
                }
            }
            return -1.0;
        }
    }
}
