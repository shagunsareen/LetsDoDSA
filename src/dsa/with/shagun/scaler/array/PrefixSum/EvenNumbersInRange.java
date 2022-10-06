package dsa.with.shagun.scaler.array.PrefixSum;

public class EvenNumbersInRange {
    public static void main(String[] args) {
        int[] A = {6, 3, 3, 6, 7, 8, 7, 3, 7};
        int[][] B = {{2, 6}, {4, 7}, {6, 7}};
        solve(A,B);
    }

    public static int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] result = new int[B.length];

        //let's construct evenCount array that will hold count of even numbers till that index
        int[] evenCount = new int[n];
        int count = 0;

        for(int i = 0; i<n; i++){  // TC : O(N)
            if (A[i] % 2 == 0) { // even number check
                count++;
            }
            evenCount[i] = count;
        }

        for(int j=0; j<B.length; j++){ // TC: O(B.length)
            int l = B[j][0];
            int r = B[j][1];

            if(l==0){
                result[j] = evenCount[r];
            }else{
                result[j] = evenCount[r] - evenCount[l-1];
            }
        }

        return result;
        //TC : O(N + B.length), SC : O(B.length)
    }
}
