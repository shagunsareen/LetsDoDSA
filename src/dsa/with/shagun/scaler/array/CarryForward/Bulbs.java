package dsa.with.shagun.scaler.array.CarryForward;

public class Bulbs {
    public int bulbs(int[] A) {

        // Approach 1: check every bulb if it's OFF go and toggle rest of the bulbs
        //TC : O(n2) to toggle bulb for every off bulb

        //Approach 2 : Maintain toggle count. We toggle only when state = 0 i.e. OFF
        // If toggle count is even then state of element remains same else it changes

        int count = 0;
        int state = 0;
        for(int i=0; i<A.length; i++){

            if(count%2==0){ // state remains same
                state = A[i];
            }else{
                state = 1-A[i]; // toggle the state of the element as per toggle count
            }

            //check if the state is ON or OFF
            if(state == 0){
                count++;
            }
        }

        return count;
    }
}
