package dsa.with.shagun.scaler.advance.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
};

public class CloneGraph {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if(node == null) return node;
            return dfs(node);
        }

        private UndirectedGraphNode dfs(UndirectedGraphNode node){
            //check if this key is already present that means the cloned node is also present in the map
            //if present then just return the cloned node and no need to create new node
            if(map.containsKey(node)){
                return map.get(node);
            }

            //if the node is not in the map then we will insert it in the map now
            UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
            map.put(node, clonedNode);

            //now put all the neighbours of the current node so that the cloned node also has same neighbours
            for(UndirectedGraphNode neighbourNode : node.neighbors){
                clonedNode.neighbors.add(dfs(neighbourNode));
            }
            return clonedNode;
        }
}
