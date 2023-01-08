package dsa.with.shagun.scaler.advance.Sorting.session2;

public class MergeSort {  // TC : O(nlogn) , SC : O(1)
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(mergeSort(new int[]{3, 10, 6, 8, 15, 2, 12, 18, 17}, 0, 8)));
        mergeSort(new int[]{3, 10, 6, 8, 15, 2, 12, 18, 17}, 0, 8);
    }

    public static void mergeSort(int[] A, int s, int e) {
        //base condition
        if (s == e) { // when after dividing we reach single element then return that element
            return;
        }

        int mid = (s + e) / 2;

        mergeSort(A, s, mid); //left subarray
        mergeSort(A, mid + 1, e);  // right subarray
        merge(A, s, mid, mid + 1, e);
    }

    public static void merge(int[] arr, int ls, int le, int rs, int re) {
        int n = le - ls + 1;
        int m = re - rs + 1;

        int[] leftArr = new int[n];
        int[] rightArr = new int[m];

        for (int i = 0; i < n; i++) {
            leftArr[i] = arr[ls + i];
        }

        for (int j = 0; j < m; j++) {
            rightArr[j] = arr[rs + j];
        }

        int lPtr = 0;
        int rPtr = 0;
        int mergedPtr = ls;
        while (lPtr < n && rPtr < m) {
            if (leftArr[lPtr] < rightArr[rPtr]) {
                arr[mergedPtr] = leftArr[lPtr]; // insert smaller element at start position
                lPtr++; // since smaller element is inserted
            } else {
                arr[mergedPtr] = rightArr[rPtr]; // insert smaller element at start position
                rPtr++;
            }
            mergedPtr++;
        }


        while (lPtr < n) {
            arr[mergedPtr] = leftArr[lPtr];
            lPtr++;
            mergedPtr++;
        }

        while (rPtr < m) {
            arr[mergedPtr] = rightArr[rPtr];
            rPtr++;
            mergedPtr++;
        }
    }
}
