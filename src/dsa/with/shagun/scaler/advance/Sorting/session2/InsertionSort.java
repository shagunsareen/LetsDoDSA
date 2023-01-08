package dsa.with.shagun.scaler.advance.Sorting.session2;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{10, 3, 6, 8, 2, 5})));
    }

    public static int[] insertionSort(int[] A) {  // TC : O(n^2) ,SC : O(1)
        // We have to insert every element at right position


        for (int i = 1; i < A.length; i++) {  //pick each element and put it correct position
            int inx = i;
            for (int j = i - 1; j >= 0; j--) {  //for elements on left of current element
                if (A[j] > A[inx]) {
                    //move greater ele to right side
                    swap(j, inx, A);
                    inx = j;
                } else {
                    break;
                }
            }
        }
        return A;
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
