package dsa.with.shagun.questions.pepcoding.RecursionBackTracking;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println(power(scn.nextInt(), scn.nextInt()));
    }

    public static int power(int x, int n) {
        if(n==0){
            return 1;
        }
        return x * power(x,n-1);
    }
}
