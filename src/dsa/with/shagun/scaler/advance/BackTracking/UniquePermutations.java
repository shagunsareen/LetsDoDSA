package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UniquePermutations {

    //Approach 1 : using freqMap
    /*
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        //create frequency array
        HashMap<Integer,Integer> freqMap = new HashMap<>();

        ArrayList<Integer> curr = new ArrayList<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0; i<A.size(); i++){
            freqMap.put(A.get(i), freqMap.getOrDefault(A.get(i), 0) + 1);
            //System.out.println(A.get(i) + "- freq : "+ freqMap.get(A.get(i)));
        }

        permute(A, freqMap, curr, res);
        return res;
    }

    private void permute(ArrayList<Integer> A, HashMap<Integer,Integer> freqMap, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        //BASE CONDITION
        if(curr.size()==A.size()){
            res.add(new ArrayList<>(curr));
        }

        // since unique no. of elements will be between 0 to 10 let's see how many permutations we can have for elements in freqMap
        for(int freqKey : freqMap.keySet()){

            if(freqMap.get(freqKey) > 0){
                //DO
                freqMap.put(freqKey, freqMap.get(freqKey)-1); // decrement freq of the element
                curr.add(freqKey); // add the element to curr permutation

                //System.out.println(freqKey+ " - "+freqMap.get(freqKey));

                //RECURSION
                permute(A, freqMap, curr,res);

                //UNDO
                freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) + 1);
                curr.remove(curr.size()-1);

                //System.out.println(freqKey+ " - "+freqMap.get(freqKey));
            }
        }
    }*/

    //Approach 2
    /*ArrayList<ArrayList<Integer>> res = new ArrayList();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        //parameter required are - input array, start index
        permute(A, 0);
        return res;
    }

    private void permute(ArrayList<Integer> A, int start){
        // BASE condition
        if(start==A.size()){
            //unique combinations
            if(!res.contains(A)){
                res.add(new ArrayList<>(A));
                return;
            }
        }

        //lets iterate and get element from next position to index position
        for(int j=start; j<A.size(); j++){

            //DO step
            swap(start, j, A);

            //Recursion call for next index elements - solving subproblem
            permute(A, start+1);

            //UNDO step - restore original condition
            swap(j, start, A);
        }*/


    //Approach 3 -- same logic as that of permutation with visited array
    ArrayList<ArrayList<Integer>> res;

    //Approach 3
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        res = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> currList = new ArrayList<>();
        int n = A.size();
        //HashSet<Integer> set = new HashSet<>(); can't use set because we can have duplicates
        boolean[] visited = new boolean[n];
        permute(res, currList, A, n, visited);
        return res;
    }

    private void permute(ArrayList<ArrayList<Integer>> res,
                         ArrayList<Integer> currList,
                         ArrayList<Integer> input, int n,
                         boolean[] visited) {
        if (currList.size() == n) {
            res.add(new ArrayList<>(currList));
            return;
        }

        //add the current element in the list and check if this is already used don't generate permutations for this again
        for (int i = 0; i < n; i++) { //this for loop is for the number of places we have to fill
            if (!visited[i]) { //if we have not used the digit already then use it
                currList.add(input.get(i));
                visited[i] = true;

                permute(res, currList, input, n, visited);

                currList.remove(currList.size() - 1);
                visited[i] = false;

                //skip duplicate elements to avoid generating same permutations
                while (i < n - 1 && input.get(i) == input.get(i + 1)) i++;
            }
        }
    }

    //swapping list elements
    private void swap(int src, int dest, ArrayList<Integer> A) {
        int temp = A.get(src);
        A.set(src, A.get(dest));
        A.set(dest, temp);
    }
}
