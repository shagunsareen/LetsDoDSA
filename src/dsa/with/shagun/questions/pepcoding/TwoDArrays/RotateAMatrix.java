package dsa.with.shagun.questions.pepcoding.TwoDArrays;

import java.util.Scanner;

public class RotateAMatrix {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        rotate(arr);
        display(arr);
    }

    public static void rotate(int[][] arr) {

        //Rotate by diagonal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //Rotate by middle column
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr[0].length)/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr[0].length-j-1];
                arr[i][arr[0].length-j-1] = temp;
            }
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
