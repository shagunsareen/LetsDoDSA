package dsa.with.shagun.questions.pepcoding.Arrays;

import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }

        int data = scn.nextInt();
        int low = 0;
        int high = arr1.length - 1;
        int fi = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data < arr1[mid]) {
                high = mid - 1;
            } else if (data > arr1[mid]) {
                low = mid + 1;
            } else {
                fi = mid;
                high = mid - 1;
            }
        }

        System.out.println(fi);
        low = 0;
        high = arr1.length - 1;
        int li = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data < arr1[mid]) {
                high = mid - 1;
            } else if (data > arr1[mid]) {
                low = mid + 1;
            } else {
                li = mid;
                low = mid + 1;
            }
        }
        System.out.println(li);
    }
}
