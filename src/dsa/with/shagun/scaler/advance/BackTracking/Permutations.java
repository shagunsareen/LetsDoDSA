package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;

public class Permutations {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        //parameter required are - input array, start index and temp placehoder
        permute(A, 0);
        return res;
    }

    private void permute(ArrayList<Integer> A, int start){
        // BASE condition
        if(start==A.size()){
            res.add(new ArrayList<>(A));
            return;
        }

        //lets iterate and get element from next position to index position
        for(int j=start; j<A.size(); j++){

            //DO step
            swap(start, j, A);

            //Recursion call for next index elements - solving subproblem
            permute(A, start+1);

            //UNDO step - restore original condition
            swap(j, start, A);
        }
    }

    //swapping list elements
    private void swap(int src, int dest, ArrayList<Integer> A){
        int temp = A.get(src);
        A.set(src, A.get(dest));
        A.set(dest, temp);
    }
}
