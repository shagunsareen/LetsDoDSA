package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class LastIndexOfOccurrenceInArray { //TC: O(n) SC:O(1)
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        System.out.println(lastIndex(arr, arr.length - 1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        //this is base condition i.e. exit condition
        if (idx < 0) {
            return -1;
        }
        //check if the target is at current index if yes return that index else continue further search
        if (arr[idx] == x) {
            return idx;
        } else {
            return lastIndex(arr, idx - 1, x);
        }
    }
}
