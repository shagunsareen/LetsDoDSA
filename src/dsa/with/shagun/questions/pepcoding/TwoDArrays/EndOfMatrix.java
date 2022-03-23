package dsa.with.shagun.questions.pepcoding.TwoDArrays;

import java.util.Scanner;

public class EndOfMatrix {
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

        int dir = 0;
        int r = 0;
        int c = 0;

        while (true) {
            dir = dir + arr[r][c];
            if (dir == 0) {
                c++;
            }
            if (dir == 1) {
                r++;
            }
            if (dir == 2) {
                c--;
            }
            if (dir == 3) {
                r--;
            }

            if (c < 0) {
                c++;
                break;
            }
            if (r < 0) {
                r++;
                break;
            }
            if (c > arr[0].length) {
                c--;
                break;
            }
            if (r > arr.length) {
                r--;
                break;
            }
        }
        System.out.println(r);
        System.out.println(c);

    }
}
