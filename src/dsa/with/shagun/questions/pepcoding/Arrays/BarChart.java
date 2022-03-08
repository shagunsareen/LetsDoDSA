package dsa.with.shagun.questions.pepcoding.Arrays;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        /*int sp = 0;
        int st = 0;
        for (int k = 0; k < nums.length; k++) {
            sp=max-nums[k];
            st=nums[k];
            for (int m = 1; m <= sp; m++) {
                System.out.println(" ");
            }
            for (int q = 1; q <= st; q++) {
                System.out.println("*");
            }
            System.out.print("");
        }*/
        for (int j = max; j > 0; j--) {
            for (int k = 0; k < nums.length; k++) {
              if(nums[k]>=j){
                  System.out.print("*\t");
              }else{
                  System.out.print("\t");
              }
            }
            System.out.println("");
        }
    }
}
