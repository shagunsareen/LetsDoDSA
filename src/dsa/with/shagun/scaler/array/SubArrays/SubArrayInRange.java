package dsa.with.shagun.scaler.array.SubArrays;

import java.util.Arrays;

public class SubArrayInRange {

    public int[] solve(int[] A, int B, int C) { //TC : O(N) ,SC : O(N)
        int[] subArray = new int[C-B+1];
        int subArrayIndex = 0;
        for(int i=B; i<=C; i++){
            subArray[subArrayIndex] = A[i];
            subArrayIndex++;
        }

        return subArray;

        // return Arrays.copyOfRange(A, B, C + 1); //TC : O(N) ,SC : O(N)

        /*
        Arrays.copyRangeOf() uses System.arraycopy() which uses native code (could use memcpy for example - depending on JIT implementation) under the hood.
        The "magic" behind copying with System.arraycopy() is making one call to copy a block of memory instead of making n distinct calls.
        That means that using Arrays.copyOfRange() will definitely be more efficient comparing to any other solution you'll choose to implement by yourself.
        From big-O perspective, the complexity will be O(n*k) where n is the number of items to copy and k is the size (in bits) of each item. Space complexity is the same.
        */
    }
}
