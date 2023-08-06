package dsa.with.shagun.scaler.advance.Trees.session3;

import java.util.ArrayList;

public class BSTWithOneChild {
    public String solve(ArrayList<Integer> A) {
        if(isBST(A)){
            return "YES";
        }
        return "NO";
    }

    private boolean isBST(ArrayList<Integer> A){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i=0; i<A.size()-1; i++){
            int root = A.get(i);  // let's consider this as root node
            int next = A.get(i+1); // next element in the tree

            if(next < root){
                max = root;  // max range for left subtree element would be root
            }else{
                min = root;  //min range for right subtree element would be root
            }

            if(next < min || next > max){
                return false;
            }
        }

        return  true;
    }
}
