package dsa.with.shagun.scaler.array;

public class GoodPair {
    public int solve(int[] A, int B) {

        int n = A.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){  // considering given contraint i!=j, start j from i+1;
                if(A[i] + A[j] == B){
                    return 1;
                }
            }
        }
        return 0;
        // TC : O(N*N) since we have two nested loops
        // SC : O(1) since we are not using any extra space
    }
}
