package dsa.with.shagun.questions.pepcoding.Functions;

import java.util.Scanner;

public class AnyBaseMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {
        int product = 0;
        int power = 1;
        while (n2 > 0) {
            int d2 = n2 % 10;
            n2 = n2 / 10;
            int prod1 = getProductWithSingleDigit(b, n1, d2);
            product = getSum(b, product, prod1 * power);
            power = power * 10;
        }
        return product;
    }

    public static int getProductWithSingleDigit(int b, int n1, int d2) {
        int prod = 0;
        int carry = 0;
        int power = 1;
        while (n1 > 0 || carry > 0) {
            int d1 = n1 % 10;
            n1 = n1 / 10;

            int d = d1 * d2 + carry;

            carry = d / b;
            d = d % b;

            prod = prod + d * power;
            power = power * 10;
        }
        return prod;
    }

    public static int getSum(int b, int n1, int n2) {
        int carry = 0;
        int sum = 0;
        int power = 0;
        while (n1 > 0 || n2 > 0 || carry > 0) {
            int rem1 = n1 % 10;
            int rem2 = n2 % 10;

            int sumOfRem = rem1 + rem2 + carry;
            carry = sumOfRem / b;
            sum = (int) (sum + (sumOfRem % b) * Math.pow(10, power));
            power++;
            n1 = n1 / 10;
            n2 = n2 / 10;
        }
        return sum;
    }

}
