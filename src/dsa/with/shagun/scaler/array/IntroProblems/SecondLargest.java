package dsa.with.shagun.scaler.array.IntroProblems;

public class SecondLargest {
    public int solve(int[] A) {
        if(A.length <= 1){
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){
            if(A[i] > max){
                secMax = max;
                max = A[i];
            }else if(A[i] < max){
                secMax = Math.max(secMax, A[i]);
            }
        }

        if(secMax==Integer.MIN_VALUE){
            return -1;
        }

        return secMax;
    }
}
