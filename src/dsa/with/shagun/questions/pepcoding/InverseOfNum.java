package dsa.with.shagun.questions.pepcoding;

import java.util.Scanner;

public class InverseOfNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int originalPosition = 1;
        int inverse = 0;
        while(n!=0){
            int originalDigit = n % 10;
            int invPosition = originalDigit;
            int invDigit = originalPosition;

            int sum = (int) (invDigit * Math.pow(10, invPosition-1));
            inverse = sum + inverse;
            originalPosition++;
            n = n / 10;
        }
        System.out.println(inverse);
    }
}
