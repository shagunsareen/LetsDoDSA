package dsa.with.shagun.questions.pepcoding.Arrays;

import java.util.Scanner;

public class DiffOfTwoArrays {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scn.nextInt();
        }

        int[] diff = new int[n2];
        int borrow = 0;
        int digit = 0;
        int borrowVal = 10;

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;

        while (k >= 0) {
            digit = arr2[j] + borrow;
            int a1v = i >= 0 ? arr1[i] : 0;

            if (digit < a1v) {
                digit = digit + borrowVal - a1v;
                borrow = -1;
            } else {
                digit = digit - a1v;
                borrow = 0;
            }

            diff[k] = digit;
            i--;
            j--;
            k--;
        }

        int index = 0;
        while (index < diff.length) {
            if (diff[index] == 0) {
                index++;
            } else {
                break;
            }
        }

        for (int l = index; l < diff.length; l++) {
            System.out.println(diff[l]);
        }
    }
}
