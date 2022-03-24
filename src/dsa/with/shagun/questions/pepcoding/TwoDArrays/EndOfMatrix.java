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
            dir = (dir + arr[r][c]) % 4;
            if (dir == 0) {
                c++;
            } else if (dir == 1) {
                r++;
            } else if (dir == 2) {
                c--;
            } else if (dir == 3) {
                r--;
            }

            if (c < 0) {
                c++;
                break;
            } else if (r < 0) {
                r++;
                break;
            } else if (c > arr[0].length -1) {
                c--;
                break;
            } else if (r > arr.length-1) {
                r--;
                break;
            }
        }
        System.out.println(r);
        System.out.println(c);
    }
}
