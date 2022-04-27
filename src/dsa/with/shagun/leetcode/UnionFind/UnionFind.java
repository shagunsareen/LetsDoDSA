package dsa.with.shagun.leetcode.UnionFind;

public class UnionFind {
    private int[] parent;

    public UnionFind(int n){
        parent = new int[n];
        for(int i=0; i<n;i++){
            //each element is pointing to itself
            parent[i] = i;
        }
    }

    public int getAbsoluteParent(int i){
        if(parent[i]==i){
            return i;
        }
        parent[i] = getAbsoluteParent(parent[i]);
        return parent[i];
    }

    public void unify(int i, int j){
        int absoluteParentI = getAbsoluteParent(i);
        int absoluteParentJ = getAbsoluteParent(j);
        if(absoluteParentI!=absoluteParentJ){
            parent[absoluteParentJ] = absoluteParentI;
        }
    }

}
