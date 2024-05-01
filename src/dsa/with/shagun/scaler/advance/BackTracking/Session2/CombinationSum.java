package dsa.with.shagun.scaler.advance.BackTracking.Session2;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
    ArrayList<ArrayList<Integer>> resList;

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        //To get the combinations we will have to store it in resultant list
        resList = new ArrayList<>();
        Collections.sort(A);
        generateCombinationSum(resList, new ArrayList<Integer>(), B, A, 0);
        return resList;
    }

    private void generateCombinationSum(ArrayList<ArrayList<Integer>> resList, ArrayList<Integer> currList,
                                        int target, ArrayList<Integer> input, int index){
        if(target < 0){
            return;
        }
        //check if the target is met
        if(target == 0){
            //add curr combo to result
            if(!resList.contains(currList)){
                resList.add(new ArrayList<Integer>(currList));
                return;
            }
        }

        //select each element multiple times
        for(int i=index; i<input.size(); i++){
            currList.add(input.get(i)); //add the current element
            generateCombinationSum(resList, currList, target-input.get(i), input, i);
            currList.remove(currList.size() - 1); //remove last element added
        }
    }
}
