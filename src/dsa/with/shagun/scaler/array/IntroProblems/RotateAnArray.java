package dsa.with.shagun.scaler.array.IntroProblems;

public class RotateAnArray {
    public int[] solve(int[] A, int B) {
        //Rotating B times means moving last B elements to start , which can be achieved by reversing array & correcting it's order
        int n = A.length;
        B = B%n;
        //Step1 : reverse entire array
        A = reverse(A, 0, n -1);
        //Step2 : reverse from 0 to B-1
        A = reverse(A, 0, B-1);
        //Step3 : reverse from B to N-1
        A = reverse(A, B, n -1);

        return A;
    }

    private int[] reverse(int[]A, int B, int C){  // TC : O(N), SC : O(1)
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
    }

    //TC : O(N+N+N) = O(3N) = O(N)
    //SC : O(1)
}
