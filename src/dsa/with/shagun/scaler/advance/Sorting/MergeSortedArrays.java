package dsa.with.shagun.scaler.advance.Sorting;

public class MergeSortedArrays {
    public static void main(String[] args) {
        //solve(new int[]{-4, 3}, new int[]{-2, -2});
        solve(new int[]{-4, -3, 0}, new int[]{2});
    }

    public static int[] solve(final int[] A, final int[] B) {

        //Approach 1 : Create new array, insert all elements of A and then of B, sort the array TC : O((n+m)log(n+m)), SC: O((n+m)log(n+m))

        //Approach 2 : Two pointer approach should not require sort function hence , TC reduced to O(n+m), SC: O(1) as we are not using any extra space.
        // In question it was asked to return new array so we will not count it as extra space

        int[] C = new int[A.length + B.length];
        int aPtr = 0;
        int bPtr = 0;
        int cPtr = 0;

        while (aPtr < A.length && bPtr < B.length) { // till time both arrays have some data compare and insert min element to C
            if (A[aPtr] < B[bPtr]) {
                C[cPtr] = A[aPtr]; // insert smaller element in C
                aPtr++; // since smaller element is inserted
            } else {
                C[cPtr] = B[bPtr];
                bPtr++;
            }
            cPtr++; // anyways in each iteration we are inserting data to C array hence ,everytime increment count
        }


        //it can be a scenario when either elements of one of array are all inserted but second array still has some elements, then insert 2nd array elements
        while (aPtr < A.length) {
            C[cPtr] = A[aPtr];
            aPtr++;
            cPtr++;
        }

        while (bPtr < B.length) {
            C[cPtr] = B[bPtr];
            bPtr++;
            cPtr++;
        }
        return C;
    }
}
