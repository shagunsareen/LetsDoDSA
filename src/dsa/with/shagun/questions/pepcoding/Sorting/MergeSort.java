package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class MergeSort { //TC : O(nlogn) , SC: O(1)
    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if(lo == hi){
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }

        int mid = (lo + hi)/2;
        int[] firstHalf = mergeSort(arr,lo,mid);
        int[] secondHalf = mergeSort(arr,mid+1,hi);

        return mergeTwoSortedArrays(firstHalf,secondHalf);
    }

    //used for merging two sorted arrays
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        print(a);
        System.out.print("right array -> ");
        print(b);
        return MergeSortedArrays.mergeTwoSortedArrays(a, b);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] sa = mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);
    }
}
