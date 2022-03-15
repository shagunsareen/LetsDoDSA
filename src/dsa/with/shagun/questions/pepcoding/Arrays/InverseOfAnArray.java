package dsa.with.shagun.questions.pepcoding.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InverseOfAnArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static int[] inverse(int[] a) {
        int newIndex =0;
        int[] newArray = new int[a.length];
        for (int i = 0; i <= a.length - 1; i++) {
            newIndex = a[i];
            newArray[newIndex] = i;
        }
        return newArray;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }
}
