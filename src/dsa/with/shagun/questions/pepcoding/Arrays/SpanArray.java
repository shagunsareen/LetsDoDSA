package dsa.with.shagun.questions.pepcoding.Arrays;

import java.util.Scanner;

public class SpanArray {
    public static void main(String[] args) throws Exception {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i =0;i<nums.length;i++){
            nums[i] =scn.nextInt();
        }
        int max=nums[0];
        int min=nums[0];
        for(int j=1;j<nums.length;j++){
            if(max<nums[j]){
                max=nums[j];
            }
            if(min>nums[j]){
                min=nums[j];
            }
        }
        System.out.println(max - min);
    }
}
