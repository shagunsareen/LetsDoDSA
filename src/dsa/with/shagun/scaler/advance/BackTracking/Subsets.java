package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;

public class Subsets {
    ArrayList<ArrayList<Integer>> res ;

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        int n = A.size();

        //resultant list
        res = new ArrayList<>();

        //sort as we need elements in increasing order
        Collections.sort(A);

        ArrayList<Integer> curr = new ArrayList<>();

        getSubset(A, n, 0, curr);

        //Sorting ArrayList of ArrayList in Non - Decreasing order
        Comparator com = new ComImpl();
        Collections.sort(res, com);
        return res;
    }

    class ComImpl implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
            for(int i = 0; i < a.size() && i < b.size(); i++){
                if(a.get(i) < b.get(i)){
                    return -1;
                }
                if(a.get(i) > b.get(i)){
                    return 1;
                }
            }
            if(a.size() > b.size()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    private void getSubset(ArrayList<Integer> inputList, int N , int index, ArrayList<Integer> currList){
        //Base condition
        if(index == N){
            // as this is also one subset hence add it in the list
            res.add(new ArrayList<>(currList));
            return;
        }

        //Take the element and add it in the list
        currList.add(inputList.get(index));
        getSubset(inputList, N, index+1, currList);

        //Remove the element from the list
        currList.remove(inputList.get(index));
        getSubset(inputList, N, index+1, currList);
    }
}
