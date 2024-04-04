package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsWithDuplicates {
    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        res = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        Collections.sort(A); // Sort the input list to ensure lexicographical order
        getSubsetsWithDup(A, currList, res, 0);
        return res;
    }

    private void getSubsetsWithDup(ArrayList<Integer> inputList,
                                   ArrayList<Integer> currList,
                                   ArrayList<ArrayList<Integer>> res,
                                   int index){
        //these are valid subsets
        res.add(new ArrayList<>(currList)); // Add the current subset to the result in each recursive call

        for(int i=index; i<inputList.size(); i++){
            if(i > index && inputList.get(i).equals(inputList.get(i-1))){
                continue; //skipping duplicate elements
            }
            int currEle = inputList.get(i);
            currList.add(currEle);// Add the current element in the subset
            getSubsetsWithDup(inputList, currList, res, i+1);// Recursively generate subsets starting from the next index
            currList.remove(currList.size() - 1);// Remove the last element to backtrack and explore other possibilities
        }
    }
}
