package dsa.with.shagun.scaler.advance.Sorting.session3;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    //TC : Best case : O(Nlogn), as O(N) + O(N/2) +O(N/2); Worst case : O(n^n) as TC(N) + TC(N-1), Average case  : O(Nlogn)
    public static void main(String[] args) {
        quickSort(new int[]{10, 3, 8, 6, 14, 7, 4, 12, 7, 1}, 0, 9);
    }

    public static void quickSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int index = rearrange(arr, s, e); //index is sorted
        quickSort(arr, s, index - 1); // left subarray
        quickSort(arr, index + 1, e); // right subarray
    }

    public static int rearrange(int[] A, int s, int e) {

        //PICK RANDOM ELEMENT and make it as reference since if we pick first element always as reference it might be that all elements are smaller than that and we end up iterating n-1 everytime
        // To reduce time complexity , we should pick randomelement everytime, sort it to move it to correct location, then sort it's left and right subarray
        int randomNum = ThreadLocalRandom.current().nextInt(s, e + 1);
        swap(randomNum, s, A);
        int p1 = s + 1;
        int p2 = e;
        int eleToSort = A[s]; // this is the element to sort

        while (p1 <= p2) {
            if (A[p1] < eleToSort) {  // i.e. smaller elements are on left of array we should keep them as is
                p1++;
            } else if (A[p2] > eleToSort) { // here A[p1] > eleToSort hence move this ele to right end of array
                p2--;
            } else { // if p2 ele on right < eleToSort then swap it with p1 ele on left > eleToSort
                swap(p1, p2, A);
                p1++;
                p2--;
            }
        }
        swap(s, p1 - 1, A);
        return p1 - 1; // index where sorted element is placed post swap
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
