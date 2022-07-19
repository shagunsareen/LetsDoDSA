package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class QuickSelect {  //TC: O(nlogn) n for partitioning, log n for recursion, SC: O(1)
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);  // this will take extreme right ele as pivot and bring smaller ele to left of pivot and greater ele to right of pivot
        if (k > pi) {
            return quickSelect(arr, pi + 1, hi, k);
        } else if (k < pi) {
            return quickSelect(arr, lo, pi - 1, k);
        } else {
            return arr[pi];
        }
    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo;
        int j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int k = scn.nextInt();
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}
