package dsa.with.shagun.questions.pepcoding.TwoDArrays;

import java.util.Scanner;

public class SpiralDisplay {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int te = r * c;
        int count = 0;
        while (count < te) {
            //left wall
            for (int i = minr; i <= maxr && count<te; i++) {
                System.out.println(arr[i][minc]);
                count++;
            }
            minc++;

            //bottom wall
            for (int i = minc; i <= maxc && count<te; i++) {
                System.out.println(arr[maxr][i]);
                count++;
            }
            maxr--;

            //right wall
            for (int i = maxr; i >= minr && count<te; i--) {
                System.out.println(arr[i][maxc]);
                count++;
            }
            maxc--;

            //top wall
            for (int i = maxc; i >= minc && count<te; i--) {
                System.out.println(arr[minr][i]);
                count++;
            }
            minr++;
        }
    }
}
