package dsa.with.shagun.scaler.array.InterviewQuestions.Two;

public class BoyersMooresAlgo {
    public int repeatedNumber(int[] A) {
        //Base cases
        if(A.length < 2){
            return A[0];
        }

        int count = 1;
        int majorityEle = A[0]; //assume

        for(int i=1; i<A.length; i++){
            if(A[i]==majorityEle){ //same next ele
                count++;
            }else{            // diff next ele
                if(count==0){
                    majorityEle = A[i];
                    count = 1;
                }else{
                    count--;
                }
            }
        }


        // check if majority ele frequency is > n/2
        if(count != 0){
            count = 0;
            for(int i=0; i<A.length; i++){
                if(A[i]==majorityEle){
                    count++;
                }
            }

            if(count > (A.length/3)){
                return majorityEle;
            }
        }

        return -1;
    }
}
