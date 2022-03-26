package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PrintDecInc {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        pdi(scn.nextInt());
    }

    public static void pdi(int n) {
        if(n==0){
            return;
        }
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }
}
