package dsa.with.shagun.questions.pepcoding.GettingStarted;

import java.util.Scanner;

public class PrimeFactorisation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        for(int k = 2; k*k <= num; k++){
            while(num % k == 0){
                num = num / k;
                System.out.print(k + " ");
            }
        }

        if(num!=1){
            System.out.print(num);
        }
    }
}
