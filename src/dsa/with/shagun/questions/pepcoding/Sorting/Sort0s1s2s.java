package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class Sort0s1s2s { // TC :
    public static void sort012(int[] arr) {
        int i = 0; // j to i-1 -->1s area
        int j = 0; // 0 to j-1 -->0s area
        int k = arr.length - 1; // k+1 to end -->2s area
        while (i <= k) {
            if(arr[i]==0){
                swap(arr, i, j);
                i++;
                j++;
            }else if(arr[i] == 1){
                i++;
            }else{
                swap(arr,i,k); // because if it is 2 then definitely it can be placed where k is because 2s region should be at the end
                k--; //this will increase ks region everytime we get 2
                // Note : here we didn't alter is position since we are not aware if it would be 1 or 0 at ith place
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        sort012(arr);
        print(arr);
    }

}
