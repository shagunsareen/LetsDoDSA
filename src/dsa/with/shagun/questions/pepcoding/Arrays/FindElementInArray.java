package dsa.with.shagun.questions.pepcoding.Arrays;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scn.nextInt();
        }
        int find = scn.nextInt();
        int index = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == find) {
                index = j;
            }
        }
        System.out.println(index);
    }
}
