package dsa.with.shagun.questions.pepcoding;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        while(num!=0){
            int rev = num%10;
            num = num/10;
            System.out.println(rev);
        }

    }
}
