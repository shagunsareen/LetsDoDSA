package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class CountSort {  //TC : O(n+k) +O(n+k) = 2*O(n+k) ~ O(n) , SC : O(n+k) here n is ele og input arr and k of freq array
    public static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1; // Since no. of unique elements in input array would be highest element - smallest elem +1
        int[] freqArr = new int[range]; // this arr is used to store frequency of all unique integers in input array.

        for (int i = 0; i < arr.length; i++) {
            int fi = arr[i] - min;
            freqArr[fi]++;    //incrementing count of element present in input array to index in freqArr ex : for ele 3 index would be 0 since it is minimum hence how we will get index of freq arr is (ele value - min)
        }

        //prefix sum array to get index where elements have to be stored in sorted order
        for (int j = 1; j < freqArr.length; j++) {
            freqArr[j] = freqArr[j] + freqArr[j - 1];  // here we are adding count of prev ele with count of current ele to get index where curr ele should be stored from right
        }

        int[] ans = new int[arr.length]; //this will store sorted array

        for (int k = arr.length - 1; k >= 0; k--) {
            int val = arr[k];
            int pos = freqArr[val - min]; //since now freqarray contains index where we can store ele first ,so this returns postition
            int idx = pos - 1;  // since sum would give ex 15 index ele has to be stored actually at 14th because 0th index arr we have always
            ans[idx] = val;
            freqArr[val - min]--;  // reduce count
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }
}
