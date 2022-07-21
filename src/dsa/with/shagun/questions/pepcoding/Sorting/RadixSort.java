package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class RadixSort {  // TC : b*O(n+k) i.e. b times we are calling count sort and count sort complexity is O(n+k) but here k =10 hence it is b*O(n)
    //SC : O(n+k) as array we are initialising only once
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        int exp = 1;
        while (exp <= max) {  //suppose max digit in arr is 987 then exp will be 100 and if in next run exp is 1000 we should come out of the loop
            countSort(arr, exp);
            exp = exp * 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        int[] ans = new int[arr.length]; //this will store sorted array

        int[] freqArr = new int[10]; // this arr is used to store frequency of all unique integers in input array.

        for (int i = 0; i < arr.length; i++) {
            int fi = arr[i] / exp % 10;
            freqArr[fi]++;    //incrementing count of element present in input array to index in freqArr ex : for ele 3 index would be 0 since it is minimum hence how we will get index of freq arr is (ele value - min)
        }

        //prefix sum array to get index where elements have to be stored in sorted order
        for (int j = 1; j < freqArr.length; j++) {
            freqArr[j] = freqArr[j] + freqArr[j - 1];  // here we are adding count of prev ele with count of current ele to get index where curr ele should be stored from right
        }

        for (int k = arr.length - 1; k >= 0; k--) {
            int val = arr[k];
            int idx = freqArr[val / exp % 10] - 1;  // since sum would give ex 15 index ele has to be stored actually at 14th because 0th index arr we have always
            ans[idx] = val;
            freqArr[val / exp % 10]--;  // reduce count
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
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
        radixSort(arr);
        print(arr);
    }
}
