package dsa.with.shagun.scaler.array.IntroProblems;

public class ArrayMinMax {
    public int solve(int[] A) {

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return (int)(max+min);

        //TC : O(N), SC:O(1)
    }
}
