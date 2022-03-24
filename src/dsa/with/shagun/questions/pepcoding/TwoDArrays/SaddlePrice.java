package dsa.with.shagun.questions.pepcoding.TwoDArrays;

import java.util.Scanner;

public class SaddlePrice {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int svj = 0;
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] < arr[i][svj]) {
                    svj = j;
                }
                //this will return column index of smallest value in a row
            }

            //traverse column to get the max value in that column
            boolean flag = true;
            for(int k =0; k<arr.length; k++){
                if(arr[k][svj] > arr[i][svj]){
                    flag = false;
                }
            }

            if(flag){
                System.out.println(arr[i][svj]);
                return;
            }
        }

        System.out.println("Invalid input");
    }
}
