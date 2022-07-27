package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class SortDates {
    public static void sortDates(String[] arr) {
        countSort(arr, (int) Math.pow(10,6), 100, 32);
        countSort(arr, (int) Math.pow(10,4), 100, 13);
        countSort(arr, (int) Math.pow(10,0), 10000, 2501);
    }

    public static void countSort(String[] arr,int div, int mod, int range) {
        String[] ans = new String[arr.length]; //this will store sorted array

        int[] freqArr = new int[range]; // this arr is used to store frequency of all unique integers in input array.

        for (int i = 0; i < arr.length; i++) {
            int fi = Integer.parseInt(arr[i],10) / div % mod;
            freqArr[fi]++;    //incrementing count of element present in input array to index in freqArr ex : for ele 3 index would be 0 since it is minimum hence how we will get index of freq arr is (ele value - min)
        }

        //prefix sum array to get index where elements have to be stored in sorted order
        for (int j = 1; j < freqArr.length; j++) {
            freqArr[j] = freqArr[j] + freqArr[j - 1];  // here we are adding count of prev ele with count of current ele to get index where curr ele should be stored from right
        }

        for (int k = arr.length - 1; k >= 0; k--) {
            int idx = freqArr[Integer.parseInt(arr[k],10) / div % mod] - 1;  // since sum would give ex 15 index ele has to be stored actually at 14th because 0th index arr we have always
            ans[idx] = arr[k];
            freqArr[Integer.parseInt(arr[k],10) / div % mod]--;  // reduce count
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }
}
