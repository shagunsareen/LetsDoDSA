package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr) { // TC: o(n2) ,SC :O(1)
        //write your code here
        for (int itr = 1; itr < arr.length; itr++) {
            int i = itr; // since the index of element to be picked is same as iteration index
            for (int j = i - 1; j >= 0; j--) {
                if (isGreater(arr, j, j + 1)) {
                    swap(arr, j, j + 1);
                }
                else{
                    break;
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

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        return arr[i] < arr[j];
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        insertionSort(arr);
        print(arr);
    }
}
