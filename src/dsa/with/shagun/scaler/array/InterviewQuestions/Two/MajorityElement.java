package dsa.with.shagun.scaler.array.InterviewQuestions.Two;

public class MajorityElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {

        //Idea 1 : Brute force : for every element check freq TC :O(n2), SC:O(1)

        //Idea 2 : Sort and check freq : TC :O(nlogn), SC :O(1)
        //Idea 3 : Freq Map and check freq : TC : O(n), SC :O(n)


        //Idea 4 : Boyers Moore Voting Algo, TC :O(n), SC :O(1)


        //Step1 : check majority element ,
        // ++ count if next element is same element,
        // --count if count!=0 && next ele is diff ele
        // count = 1 and make curr ele as majority ele if count=0 and next ele is diff ele

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

            if(count > (A.length/2)){
                return majorityEle;
            }
        }

        return -1;
    }
}
