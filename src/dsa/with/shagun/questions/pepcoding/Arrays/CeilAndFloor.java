package dsa.with.shagun.questions.pepcoding.Arrays;

import java.util.Scanner;

public class CeilAndFloor {
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
        int ceil = 0;
        int floor = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data < arr1[mid]) {
                high = mid - 1;
                ceil = arr1[mid];
            } else if (data > arr1[mid]) {
                low = mid + 1;
                floor = arr1[mid];
            } else {
                ceil = arr1[mid];
                floor = arr1[mid];
                break;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}
