package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class BubbleSort {  // In each iteration one element would be sorted. And total iterations would be n-1. TC : o(n2), SC : O(1)
    public static void bubbleSort(int[] arr) {
        //write your code here
        for (int itr = 1; itr < arr.length; itr++) {
            for (int i = 0; i < arr.length - itr; i++) {
                if (isSmaller(arr, i + 1, i)) {
                    swap(arr, i + 1, i);
                }
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        return arr[i] < arr[j];
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr);
        print(arr);
    }
}
