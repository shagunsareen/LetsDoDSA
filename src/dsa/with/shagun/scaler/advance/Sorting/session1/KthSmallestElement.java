package dsa.with.shagun.scaler.advance.Sorting.session1;

import sun.net.TelnetInputStream;

public class KthSmallestElement {
    public static void main(String[] args) {
        System.out.println(kthsmallest(new int[]{2, 1, 4, 3, 2}, 3));
    }

    public static int kthsmallest(final int[] A, int B) {

        //Selection sort : take min and swap with leftmost indexes not sorted yet.
        //loop will run for B no. of times as we want to find Bth smallest index
        for (int i = 0; i < B; i++) {
            int min = A[i];
            int minIndex = i;
            // find min element
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIndex = j;
                }
            }
            if (minIndex > 0) {
                //swap the min element with leftmost indexes
                swap(A, minIndex, i);
            }
        }
        return A[B - 1];
    }

    private static void swap(int[] A, int minIndex, int indexToHoldMinVal) {
        int temp = A[minIndex];
        A[minIndex] = A[indexToHoldMinVal];
        A[indexToHoldMinVal] = temp;
    }
}
