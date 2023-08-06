package dsa.with.shagun.scaler.array.PrefixSum;

public class InPlacePrefixSum {
    public int[] solve(int[] A) {
        int prefixSum = 0;

        for(int i=0; i<A.length; i++){
            prefixSum = prefixSum + A[i];
            A[i] = prefixSum;
        }

        return A;
    }
}
