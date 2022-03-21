package dsa.with.shagun.questions.pepcoding.TwoDArrays;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r1 = scn.nextInt();
        int c1 = scn.nextInt();

        int[][] arr = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int r2 = scn.nextInt();
        int c2 = scn.nextInt();

        int[][] arr2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                arr2[i][j] = scn.nextInt();
            }
        }

        if(c1!=r2){
            System.out.println("Invalid input");
            return;
        }

        for(int i = 0; i < r1; i++){
            for (int j =0; j< c2; j++){
                int product = 0 ;
                for(int k =0; k< c1; k++){
                    product = product + arr[i][k]*arr2[k][j];
                }
                System.out.print(product + " ");
            }
            System.out.println();
        }
    }
}
