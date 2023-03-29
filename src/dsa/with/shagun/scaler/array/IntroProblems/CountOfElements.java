package dsa.with.shagun.scaler.array.IntroProblems;

public class CountOfElements {
        public int solve(int[] A) {
            int n = A.length;
            int max = Integer.MIN_VALUE;

            //Get the max element in the array.
            for (int i = 0; i < n; i++) {    // This will take O(N)
                if (A[i] > max) {
                    max = A[i];
                }
            }

            //Get count of elements not equal to max element because for max element there would be no greater element
            int count = 0;
            for (int i = 0; i < n; i++) {
                // This will take O(N)
                if (A[i] != max) {
                    count++;
                }
            }

            return count;
            //TC : O(N+N) = O(2N) = O(N)
            //SC : O(1)
        }
}
