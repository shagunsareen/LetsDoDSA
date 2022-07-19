package dsa.with.shagun.questions.pepcoding.Sorting;

import java.util.Scanner;

public class PartitionArray { //TC :O(N) ,SC :O(1)
    public static void partition(int[] arr, int pivot){
        //write your code here
        //0 to j-1 <= pivot
        // j to i-1 > pivot
        // i to end --> unknown
        // since we need to iterate over every element hence i is required.
        // Since when smaller element is present we need to move it to left region to move it to left region we need some index to move it to that point. Hence, we need j
        // we keep greater element there only since we will swap when we get smaller element than pivot which will anyways make smaller ele on left and bigger ele on right
        int i =0;
        int j=0;

        while(i<arr.length){
            if(arr[i]>pivot){
                i++;
            }else{
                swap(arr,i,j);
                i++;
                j++;
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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partition(arr,pivot);
        print(arr);
    }
}
