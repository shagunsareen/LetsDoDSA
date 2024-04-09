package dsa.with.shagun.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfSquarefulArrays {
    int count = 0;
    //since this can have duplicates we will use logic similar to unique permutations
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if(n==1){
            return 0;
        }

        //we can use single element multiple times so we need to have frequency of elements
        Map<Integer, Integer> freqMap = new HashMap<>();

        //storing elements and their frequency
        for(int i=0; i<n; i++){
            freqMap.put(A.get(i), freqMap.getOrDefault(A.get(i), 0) + 1);
        }

        ArrayList<Integer> currList = new ArrayList<>();

        isSquareful(0, A.size(), currList, freqMap);

        return count;
    }

    private void isSquareful(int index, int inputListSize, ArrayList<Integer> currList, Map<Integer, Integer> freqMap){

        //Base condition
        if(currList.size()==inputListSize){
            //all elements are traversed
            count++;
            return;
        }

        for(int freqKey : freqMap.keySet()){
            //for every key lets see the frequency and then select the element

            if(freqMap.get(freqKey) > 0){
                if(index == 0){
                    //we can select the element - DO
                    freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) - 1);  //decrement the count
                    currList.add(freqKey);

                    isSquareful(index+1, inputListSize, currList, freqMap);

                    //we can unselect the element - UNDO
                    freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) + 1);  //increment the count
                    currList.remove(currList.size() - 1); //remove the last element
                }else{
                    //check if the sum equals sqrt
                    int sum = freqKey + currList.get(index - 1); //since index > 0 so we add curr key and prev ele
                    int sqrt = (int) Math.sqrt(sum);

                    if(sum == sqrt*sqrt){ // then go forward
                        freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) - 1);  //decrement the count
                        currList.add(freqKey);

                        isSquareful(index+1, inputListSize, currList, freqMap);

                        //we can unselect the element - UNDO
                        freqMap.put(freqKey, freqMap.getOrDefault(freqKey, 0) + 1);  //increment the count
                        currList.remove(currList.size() - 1); //remove the last element
                    }
                }
            }
        }
    }
}
