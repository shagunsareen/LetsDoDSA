package dsa.with.shagun.scaler.array;

public class ReverseArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int i = n-1;

        for(int k = 0; k<=n-1; k++){
            B[k] = A[i];
            i--;
        }
        return B;
        //TC : O(N)
        //SC :O(N) because we are using extra array
    }

    // If we don't have to use extra array and use same array then we can have two pointers
    // ptr1 = 0 , ptr2 = arr.length - 1, swap elements at ptr1 & ptr2 , run loop till ptr1<ptr2
    // In that case TC : O(N/2) because we swap 2 elements at a time, SC : O(1)
}
