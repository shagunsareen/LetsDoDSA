package dsa.with.shagun.scaler.array;

public class ReverseArrayInRange {
    public int[] solve(int[] A, int B, int C) {

        //Here we can use two pointer approach as we can modify existing array
        int start = B;
        int end = C;

        while(start < end){ // since for start = end there won't be reverse required and for start>end numbers are already reversed till then
            int temp = A[end];
            A[end]=A[start];
            A[start]=temp;
            start++;
            end--;
        }

        return A;

        //TC : O(N) since worst case scenario can be to cover the whole scenario
        //SC : O(1)
    }
}
