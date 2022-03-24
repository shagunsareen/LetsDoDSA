package dsa.with.shagun.questions.pepcoding.TwoDArrays;

import java.util.Scanner;

public class ShellRotate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int shell = scn.nextInt();
        int rotations = scn.nextInt();

        shellRotate(arr, shell, rotations);
        display(arr);
    }

    private static void shellRotate(int[][] arr, int s, int rotations) {
        int[] oneD = createOneDFromShell(arr, s);
        rotateOneDArray(oneD, rotations);
        createShellFromOneD(arr, s, oneD);
    }


    private static int[] createOneDFromShell(int[][] arr, int shell) {
        int minr = shell - 1;
        int minc = shell - 1;
        int maxr = arr.length - shell;
        int maxc = arr[0].length - shell;

        int size = 2 * (maxr - minr + maxc - minc);
        int[] oneD = new int[size];

        //left wall
        int idx = 0;
        for (int i = minr; i <= maxr; i++) {
            oneD[idx] = arr[i][minc];
            idx++;
        }

        //bottom wall
        for (int i = minc + 1; i <= maxc; i++) {
            oneD[idx] = arr[maxr][i];
            idx++;
        }

        //right wall
        for (int i = maxr - 1; i >= minr; i--) {
            oneD[idx] = arr[i][maxc];
            idx++;
        }

        //top wall
        for (int i = maxc - 1; i >= minc; i--) {
            oneD[idx] = arr[minr][i];
            idx++;
        }
        return oneD;
    }

    private static void rotateOneDArray(int[] arr, int rotations) {
        rotations = rotations % arr.length;
        if (rotations < 0) {
            rotations = rotations + arr.length;
        }
        reverse(arr, 0, arr.length - rotations - 1);
        reverse(arr, arr.length - rotations, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    private static void createShellFromOneD(int[][] arr, int shell, int[] oneD) {
        int minr = shell - 1;
        int minc = shell - 1;
        int maxr = arr.length - shell;
        int maxc = arr[0].length - shell;

        //left wall
        int idx = 0;
        for (int i = minr; i <= maxr; i++) {
            arr[i][minc] = oneD[idx];
            idx++;
        }

        //bottom wall
        for (int i = minc + 1; i <= maxc; i++) {
            arr[maxr][i] = oneD[idx];
            idx++;
        }

        //right wall
        for (int i = maxr - 1; i >= minr; i--) {
            arr[i][maxc] = oneD[idx];
            idx++;
        }

        //top wall
        for (int i = maxc - 1; i >= minc; i--) {
            arr[minr][i] = oneD[idx];
            idx++;
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
