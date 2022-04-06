package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class FirstIndexOfOccurrenceInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        System.out.println(firstIndex(arr, 0, x));
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        //this is base condition i.e. exit condition
        if (idx == arr.length) {
            return -1;
        }
        //check if the target is at current index is yes return that index else continue further search
        if (arr[idx] == x) {
            return idx;
        } else {
            return firstIndex(arr, idx + 1, x);
        }
    }
}
